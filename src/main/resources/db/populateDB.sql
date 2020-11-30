INSERT INTO reader (id, name, login, password, role) VALUES ('0000000001', 'reader1', 'reader1@mail.com','12345678','user');
INSERT INTO reader (id, name, login, password, role) VALUES ('0000000002', 'reader2', 'reader2@mail.com','87654321', 'user');
INSERT INTO reader (id, name, login, password, role) VALUES ('0000000003', 'reader3', 'reader3@mail.com','13572468', 'user');
INSERT INTO reader (id, name, login, password, role) VALUES ('0000000004', 'reader4', 'reader4@mail.com','24681357', 'user');
INSERT INTO reader (id, name, login, password, role) VALUES ('0000000005', 'reader5', 'reader5@mail.com','q1w2e3r4t5y6u7i8', 'user');

INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House) VALUES (1,'Лермонтов М.Ю.', 'Герой нашего времени',2,1, 'Беларусь', 'Брест', 'Гоголя', '48');
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House) VALUES (2,'Тургенев И.С.', 'Отцы и дети',2,1, 'Беларусь', 'Брест', 'Гоголя', '48');
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House) VALUES (3,'Шекспир В.', 'Ромео и Джульетта',2,1, 'Беларусь', 'Брест', 'Гоголя', '48');
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House) VALUES (4,'Шекспир В.', 'Отелло',2,1, 'Беларусь', 'Брест', 'Гоголя', '48');
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House) VALUES (5,'Грин Д.', 'Виноваты звёзды',2,1, 'Беларусь', 'Брест', 'Гоголя', '48');
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House) VALUES (6,'Лермонтов М.Ю.', 'Мцыри',2,1, 'Беларусь', 'Брест', 'Гоголя', '48');
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House) VALUES (7,'Лермонтов М.Ю.', 'Княгиня Лиговская',2,1, 'Беларусь', 'Брест', 'Гоголя', '48');
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House) VALUES (8,'Тургенев И.С.', 'Записки охотника',2,1, 'Беларусь', 'Брест', 'Гоголя', '48');
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House) VALUES (9,'Тургенев И.С.', 'Ася',2,1, 'Беларусь', 'Брест', 'Гоголя', '48');
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House) VALUES (10,'Шамякин И.П.', 'Сердце на ладони',2,1, 'Беларусь', 'Брест', 'Гоголя', '48');
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House) VALUES (11,'Шолохов М.А.', 'Тихий Дон',2,1, 'Беларусь', 'Брест', 'Гоголя', '48');
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House) VALUES (12,'Шекспир В.', 'Гамлет',2,1, 'Беларусь', 'Брест', 'Гоголя', '48');
INSERT INTO book (bcid, Author, Title,Access, Status, Country, City, Street, House) VALUES (13,'Шекспир В.', 'Укрощение строптивой',2,1, 'Беларусь', 'Брест', 'Гоголя', '48');

INSERT INTO order_board (Author, Title) VALUES ('Кинг С.', 'Сияние');
INSERT INTO order_board (Author, Title) VALUES ('Достоевский Ф.М.', 'Преступление и наказание');
INSERT INTO order_board (Author, Title) VALUES ('Пушкин А.С.', 'Руслан и Людмила');
INSERT INTO order_board (Author, Title) VALUES ('Пушкин А.С.', 'Евгений Онегин');
INSERT INTO order_board (Author, Title) VALUES ('Толстой Л.Н.', 'Война и мир');
