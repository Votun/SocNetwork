DROP TABLE IF  EXISTS accounts ;
CREATE TABLE accounts(
acc_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(32),
    first_name VARCHAR(32),
    last_name VARCHAR(32),
    last_access TIMESTAMP);
DROP TABLE  IF  EXISTS accessTokens;
    CREATE TABLE accessTokens(
    acc_id INT NOT NULL,
    pswd VARCHAR(32));
