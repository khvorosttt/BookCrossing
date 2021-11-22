<%-- 
    Document   : addNewBook
    Created on : 24.09.2020, 23:16:45
    Author     : Lenovo
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Новая книга</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
    <header>
        <nav>
            <ul>                
                <li><a href="/my-profile">Мой профиль</a></li>
                <li><a href="/messages">Сообщения</a></li>
                <li><a href="/">Библиотека</a></li>
                <li><a href="/find-book">Поиск книги</a></li>
                <li><a href="/order-board">Доска заказов</a></li>
                <li><a href="/logout">Выход</a></li>
            </ul>
        </nav>
    </header>
    <section>
        <form action="/add-new-book" method="POST">
            <div class="divAll">
                <label>Автор</label>
                <input type="text" name="author" maxlength="255" required>
                <label>Название</label>
                <input type="text" name="name" maxlength="255" required>
                <label>Страна</label>
                <input type="text" name="country" maxlength="128" required>
                <label>Город</label>
                <input type="text" name="city" maxlength="128" required>
                <label>Улица</label>
                <input type="text" name="street" maxlength="128" required>
                <label>Дом</label>
                <input type="text" name="house" maxlength="5">
                <label>Доступ</label>
                <input type="number" name="access" min="2" max="4" required>
            </div>
            <input type="submit" value="Добавить новую книгу">
        </form>
    </section>
</body>
</html>
