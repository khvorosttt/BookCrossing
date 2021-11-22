<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html">
        <title>Поиск книги</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
    <header>
        <nav>
            <ul>
                <li><a href="/my-profile">Мой профиль</a></li>
                <li><a href="/messages">Сообщения</a></li>
                <li><a href="/">Библиотека</a></li>
                <li><a href="/find-book" class="CurrentPage">Поиск книги</a></li>
                <li><a href="/order-board">Доска заказов</a></li>
                <li><a href="/logout">Выход</a></li>
            </ul>
        </nav>
    </header>
    <section>
        <form action="/find-book" method="POST">
            <label>Автор</label>
            <input type="text" name="author">
            <label>Название</label>
            <input type="text" name="name">
            <input type="submit" value="Поиск">
        </form>
        <table>
            <tr>
                <th>BCID</th>
                <th>Автор</th>
                <th>Название</th>
                <th></th>
            </tr>
            <c:forEach var="book" items="${bookList}">
                <tr>
                    <td>${book.BCID}</td>
                    <td>${book.author}</td>
                    <td>${book.name}</td>
                    <td><a href="/edit-${book.BCID}">Добавить</a>
                        <a href="/book-${book.BCID}-info">Просмотреть</a></td>
                </tr>
            </c:forEach>
        </table>
    </section>
</body>

</html>