INSERT INTO reader (id, name, login, password, role) VALUES ('0000000001', 'reader1', 'reader1@mail.com','12345678','user');
INSERT INTO reader (id, name, login, password, role) VALUES ('0000000002', 'reader2', 'reader2@mail.com','87654321', 'user');
INSERT INTO reader (id, name, login, password, role) VALUES ('0000000003', 'reader3', 'reader3@mail.com','13572468', 'user');
INSERT INTO reader (id, name, login, password, role) VALUES ('0000000004', 'reader4', 'reader4@mail.com','24681357', 'user');
INSERT INTO reader (id, name, login, password, role) VALUES ('0000000005', 'reader5', 'reader5@mail.com','q1w2e3r4t5y6u7i8', 'user');

INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House, genre) VALUES (1,'Лермонтов М.Ю.', 'Герой нашего времени',2,1, 'Беларусь', 'Брест', 'Гоголя', '48', 1);
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House, genre) VALUES (2,'Тургенев И.С.', 'Отцы и дети',2,1, 'Беларусь', 'Брест', 'Гоголя', '48', 1);
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House, genre) VALUES (3,'Шекспир В.', 'Ромео и Джульетта',2,1, 'Беларусь', 'Брест', 'Гоголя', '48', 1);
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House, genre) VALUES (4,'Шекспир В.', 'Отелло',2,1, 'Беларусь', 'Брест', 'Гоголя', '48', 1);
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House, genre) VALUES (5,'Грин Д.', 'Виноваты звёзды',2,1, 'Беларусь', 'Брест', 'Гоголя', '48', 1);
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House, genre) VALUES (6,'Лермонтов М.Ю.', 'Мцыри',2,1, 'Беларусь', 'Брест', 'Гоголя', '48', 1);
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House, genre) VALUES (7,'Лермонтов М.Ю.', 'Княгиня Лиговская',2,1, 'Беларусь', 'Брест', 'Гоголя', '48', 1);
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House, genre) VALUES (8,'Тургенев И.С.', 'Записки охотника',2,1, 'Беларусь', 'Брест', 'Гоголя', '48', 1);
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House, genre) VALUES (9,'Тургенев И.С.', 'Ася',2,1, 'Беларусь', 'Брест', 'Гоголя', '48', 1);
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House, genre) VALUES (10,'Шамякин И.П.', 'Сердце на ладони',2,1, 'Беларусь', 'Брест', 'Гоголя', '48', 1);
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House, genre) VALUES (11,'Шолохов М.А.', 'Тихий Дон',2,1, 'Беларусь', 'Брест', 'Гоголя', '48', 1);
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House, genre) VALUES (12,'Шекспир В.', 'Гамлет',2,1, 'Беларусь', 'Брест', 'Гоголя', '48', 1);
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House, genre) VALUES (13,'Шекспир В.', 'Укрощение строптивой',2,1, 'Беларусь', 'Брест', 'Гоголя', '48', 1);

INSERT INTO order_board (Author, Title, Reader) VALUES ('Кинг С.', 'Сияние', '0000000001');
INSERT INTO order_board (Author, Title, Reader) VALUES ('Достоевский Ф.М.', 'Преступление и наказание', '0000000001');
INSERT INTO order_board (Author, Title, Reader) VALUES ('Пушкин А.С.', 'Руслан и Людмила', '0000000001');
INSERT INTO order_board (Author, Title, Reader) VALUES ('Пушкин А.С.', 'Евгений Онегин', '0000000001');
INSERT INTO order_board (Author, Title, Reader) VALUES ('Толстой Л.Н.', 'Война и мир', '0000000001');

INSERT INTO comment (Id_comment, Id_user, Id_book, textComment, date_time) VALUES (1, '0000000002', 1, 'Классная книга',CURRENT_DATE);

INSERT INTO chatRoom (Id, chatId, senderId, recipientId) VALUES (1, '0000000001_0000000002', '0000000001', '0000000002');
INSERT INTO chatRoom (Id, chatId, senderId, recipientId) VALUES (2, '0000000002_0000000001', '0000000002', '0000000001');

INSERT INTO message (Id_message, chatId, Id_sender, Id_recipient,sender, recipient, date_time, textMessage, Is_read) VALUES (1, '0000000001_0000000002','0000000001','0000000002','reader1', 'reader2',CURRENT_DATE,'Привет!', 0);