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
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Новая книга</title>
    </head>
    <body>
    <header>
        <nav>
            <ul>
                <li><a href="/login">
                        Авторизация</a></li>
                <li><a href="/my-profile">Мой профиль</a></li>
                <li><a href="/">Библиотека</a></li>
                <li><a href="/find-book">Поиск книги</a></li>
                <li><a href="/order-board">Доска заказов</a></li>
                <li><a href="/sign-in">Выход</a></li>
            </ul>
        </nav>
    </header>
    <section>
        <form action="/add-new-book" method="POST">
            <div class="divAll">
                <label>Автор</label>
                <input type="text" name="author" required>
                <label>Название</label>
                <input type="text" name="name" required>
                <label>Страна</label>
                <input type="text" name="country" required>
                <label>Город</label>
                <input type="text" name="city" required>
                <label>Улица</label>
                <input type="text" name="street" required>
                <label>Дом</label>
                <input type="text" name="house">
                <label>Доступ</label>
                <input type="number" name="access" required>
            </div>
            <input type="submit" value="Добавить новую книгу">
        </form>
    </section>
</body>
</html>
