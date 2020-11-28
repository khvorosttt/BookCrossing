DROP TABLE IF EXISTS reader;

CREATE TABLE reader (
  id VARCHAR(10) NOT NULL UNIQUE,
  name VARCHAR(255) NOT NULL,
  role VARCHAR(50) NOT NULL,
  login VARCHAR(20) NOT NULL,
  password VARCHAR(20) CHECK(Length(password)>7 and Length(password)<21),
  PRIMARY KEY (login)
);

DROP TABLE IF EXISTS book;

CREATE TABLE book (
  bcid INT NOT NULL,
  author VARCHAR(255) NOT NULL,
  title VARCHAR(255) NOT NULL,
  access INT NOT NULL,
  status INT NOT NULL,
  reader VARCHAR(255) NULL,
  country VARCHAR(128) NOT NULL,
  city VARCHAR(128) NOT NULL,
  street VARCHAR(128) NOT NULL,
  house VARCHAR(5) NULL,
  PRIMARY KEY (bcid)
);

DROP TABLE IF EXISTS order_board;

CREATE TABLE order_board (
  Author VARCHAR(255) NOT NULL,
  Title VARCHAR(255) NOT NULL
);

