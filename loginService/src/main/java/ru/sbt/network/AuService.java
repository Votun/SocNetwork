package ru.sbt.network;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.AccessException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import ru.sbt.network.dao.AccRepository;
import ru.sbt.network.dao.AccessVerificationDAO;
import ru.sbt.network.objects.Account;

import java.sql.Timestamp;
import java.util.Date;

public class AuService implements AuthenticationService {
    public static Timestamp getCurTime() {
        Date current = new Date();
        return new Timestamp(current.getTime());
    }

    public static void inTransaction(TransactionTemplate transactionTemplate, Runnable action) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                action.run();
            }
        });
    }

    @Override
    public Account login(String login, String password) throws AccessException {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        final AccRepository accRepository = ctx.getBean(AccRepository.class);
        final AccessVerificationDAO accessDenied = ctx.getBean(AccessVerificationDAO.class);
        Account potAcc = accRepository.findByLogin(login);
        boolean accessFlag = accessDenied.verify(potAcc.getID(), password);
        if (accessFlag) {
            accRepository.setOnline(potAcc.getID());
            potAcc.setOnline(true);
            return potAcc;
        } else {
            throw new AccessException("Incorrect login or password!");
        }
    }

    @Override
    public void logout(long id) {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        final AccRepository accRepository = ctx.getBean(AccRepository.class);
        Timestamp time = getCurTime();
        accRepository.setOffline(time, id);
    }
}
