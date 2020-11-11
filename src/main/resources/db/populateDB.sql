INSERT INTO reader (Id, Name, Login, Password) VALUES ('0000000001', 'reader1', 'reader1@mail.com','12345678');
INSERT INTO reader (Id, Name, Login, Password) VALUES ('0000000002', 'reader2', 'reader2@mail.com','87654321');
INSERT INTO reader (Id, Name, Login, Password) VALUES ('0000000003', 'reader3', 'reader3@mail.com','13572468');
INSERT INTO reader (Id, Name, Login, Password) VALUES ('0000000004', 'reader4', 'reader4@mail.com','24681357');
INSERT INTO reader (Id, Name, Login, Password) VALUES ('0000000005', 'reader5', 'reader5@mail.com','q1w2e3r4t5y6u7i8');

INSERT INTO book (Author, Title,Access, Status, Reader, Country, City, Street, House) VALUES ('Лермонтов М.Ю.', 'Герой нашего времени',2,1, '0000000001', 'Беларусь', 'Брест', 'Гоголя', '48');
INSERT INTO book (Author, Title,Access, Status, Reader, Country, City, Street, House) VALUES ('Тургенев И.С.', 'Отцы и дети',2,1, '0000000002', 'Беларусь', 'Брест', 'Гоголя', '48');
INSERT INTO book (Author, Title,Access, Status, Country, City, Street, House) VALUES ('Шекспир В.', 'Ромео и Джульетта',2,1, 'Беларусь', 'Брест', 'Гоголя', '48');
INSERT INTO book (Author, Title,Access, Status, Reader, Country, City, Street, House) VALUES ('Шекспир В.', 'Отелло',2,1, '0000000004', 'Беларусь', 'Брест', 'Гоголя', '48');
INSERT INTO book (Author, Title,Access, Status, Reader, Country, City, Street, House) VALUES ('Грин Д.', 'Виноваты звёзды',2,1, '0000000003', 'Беларусь', 'Брест', 'Гоголя', '48');


INSERT INTO order_board (Author, Title) VALUES ('Кинг С.', 'Сияние');
INSERT INTO order_board (Author, Title) VALUES ('Достоевский Ф.М.', 'Преступление и наказание');
INSERT INTO order_board (Author, Title) VALUES ('Пушкин А.С.', 'Руслан и Людмила');
INSERT INTO order_board (Author, Title) VALUES ('Пушкин А.С.', 'Евгений Онегин');
INSERT INTO order_board (Author, Title) VALUES ('Толстой Л.Н.', 'Война и мир');