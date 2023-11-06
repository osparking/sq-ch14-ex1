DROP TABLE IF EXISTS account;
CREATE TABLE account(
  ID INT PRIMARY KEY auto_increment, 
  NAME VARCHAR(255), 
  amount numeric(20,0) DEFAULT 0 NOT NULL);