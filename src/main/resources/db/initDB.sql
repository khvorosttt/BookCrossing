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
  bcid INT NOT NULL UNIQUE,
  author VARCHAR(255) NOT NULL,
  title VARCHAR(255) NOT NULL,
  access INT NOT NULL,
  status INT NOT NULL,
  reader VARCHAR(10) NULL,
  country VARCHAR(128) NOT NULL,
  city VARCHAR(128) NOT NULL,
  street VARCHAR(128) NOT NULL,
  house VARCHAR(5) NULL,
  genre INT NOT NULL,
  tags VARCHAR(120),
  PRIMARY KEY (bcid)
);

DROP TABLE IF EXISTS order_board;

CREATE TABLE order_board (
  Author VARCHAR(255) NOT NULL,
  Title VARCHAR(255) NOT NULL,
  Reader VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS message;

CREATE TABLE message
(
    Id_message INT NOT NULL UNIQUE,
    chatId VARCHAR(22) NOT NULL,
    Id_sender VARCHAR(10) NOT NULL,
    Id_recipient VARCHAR(10) NOT NULL,
    date_time date NOT NULL,
    textMessage VARCHAR(500) NOT NULL,
    Is_read INT NOT NULL,
    PRIMARY KEY (Id_message)
);

DROP TABLE IF EXISTS comment;

CREATE TABLE comment
(
    Id_comment INT NOT NULL UNIQUE,
    Id_user VARCHAR(10) NOT NULL,
    Id_book INT NOT NULL,
    textComment VARCHAR(1000) NOT NULL,
    date_time date NOT NULL,
    PRIMARY KEY (Id_comment)
);
