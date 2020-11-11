DROP TABLE IF EXISTS reader;

CREATE TABLE reader (
  Id VARCHAR(10) NOT NULL UNIQUE,
  Name VARCHAR(255) NOT NULL,
  Login VARCHAR(20) NOT NULL,
  Password VARCHAR(20) CHECK(Length(Password)>7 and Length(Password)<17),
  PRIMARY KEY (Login)
);

DROP TABLE IF EXISTS book;

CREATE TABLE book (
  bcid      INTEGER NOT NULL AUTO_INCREMENT,
  author    VARCHAR(255) NOT NULL,
  title     VARCHAR(255) NOT NULL,
  access INT CHECK( Access>1 and Access<5 and NOT NULL),
  status INT CHECK(Status<2 and NOT NULL),
  reader VARCHAR(255) NULL,
  country VARCHAR(128) NOT NULL,
  city VARCHAR(128) NOT NULL,
  street VARCHAR(128) NOT NULL,
  house VARCHAR(5) NULL,
  PRIMARY KEY (bcid),
  FOREIGN KEY (Reader) REFERENCES reader(Id)
);

DROP TABLE IF EXISTS order_board;

CREATE TABLE order_board (
  Author VARCHAR(255) NOT NULL,
  Title VARCHAR(255) NOT NULL
);