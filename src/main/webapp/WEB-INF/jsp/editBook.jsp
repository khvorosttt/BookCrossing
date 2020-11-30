<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html">
        <title>Редактировать</title>
    </head>
    <style><%@ include file='style.css'%></style>
    <body>
    <header>
        <nav>
            <ul>
                <li><a href="/my-profile">Мой профиль</a></li>
                <li><a href="/">Библиотека</a></li>
                <li><a href="/find-book">Поиск книги</a></li>
                <li><a href="/order-board">Доска заказов</a></li>
                <li><a href="/logout">Выйти</a></li>
            </ul>
        </nav>
    </header>
    <section>
        <h1>Редактировать книгу</h1>
        <a href="/delete-${book.BCID}-from-profile"><span class="MyProfileSpan">
                            Удалить из полки</span></a>
        <a href="/delete-${book.BCID}-from-library"><span class="MyProfileSpan">
                            Удалить из библиотеки</span></a>
        <form action="/edit-${book.BCID}" method="POST">
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
                <button class="send" type="submit">Сохранить</button>
            </div>
        </form>
    </section>
</body>

</html>

