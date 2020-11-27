DROP TABLE IF EXISTS reader;

CREATE TABLE reader (
  id VARCHAR(10) NOT NULL UNIQUE,
  name VARCHAR(255) NOT NULL,
  role VARCHAR(50) NOT NULL,
  login VARCHAR(20) NOT NULL,
  password VARCHAR(20) CHECK(Length(password)>7 and Length(password)<17),
  PRIMARY KEY (login)
);

DROP TABLE IF EXISTS book;

CREATE TABLE book (
  bcid      INTEGER NOT NULL AUTO_INCREMENT,
  author    VARCHAR(255) NOT NULL,
  title     VARCHAR(255) NOT NULL,
  access INT CHECK( access>1 and access<5 and NOT NULL),
  status INT CHECK(status<2 and NOT NULL),
  reader VARCHAR(255) NULL,
  country VARCHAR(128) NOT NULL,
  city VARCHAR(128) NOT NULL,
  street VARCHAR(128) NOT NULL,
  house VARCHAR(5) NULL,
  PRIMARY KEY (bcid),
  FOREIGN KEY (reader) REFERENCES reader(Id)
);

DROP TABLE IF EXISTS order_board;

CREATE TABLE order_board (
  Author VARCHAR(255) NOT NULL,
  Title VARCHAR(255) NOT NULL
);

