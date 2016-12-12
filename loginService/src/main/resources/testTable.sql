

DROP TABLE  IF  EXISTS accessTokens;
    CREATE TABLE accessTokens(
    acc_id INT NOT NULL,
    pswd VARCHAR(32));
    Insert into accessTokens(acc_id, pswd)
    values(1, '12345');
