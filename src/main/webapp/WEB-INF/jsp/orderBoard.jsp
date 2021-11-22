<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Доска заказов</title>
    </head>
    <body>
    <header>
        <nav>
            <ul>
                <li><a href="/my-profile">Мой профиль</a></li>
                <li><a href="/messages" class="CurrentPage">Сообщения</a></li>
                <li><a href="/">Библиотека</a></li>
                <li><a href="/find-book">Поиск книги</a></li>
                <li><a href="/order-board" class="CurrentPage">Доска заказов</a></li>
                <li><a href="/logout">Выход</a></li>
            </ul>
        </nav>
    </header>
    <section>
        <h1>Доска заказов</h1>
        <form form action="/order-board" method="POST">
            <label>Автор</label>
            <input type="text" name="author" maxlength="255" required>
            <label>Название</label>
            <input type="text" name="name" maxlength="255" required>
            <input type="submit" value="Добавить">
        </form>
        <table>
            <tr>
                <th class="OrderBoardTd">Автор</th>
                <th class="OrderBoardTd">Название</th>
                <th class="OrderBoardTd"></th>
            </tr>
            <c:forEach var="order_board" items="${order_boardList}">
                <tr>
                    <td>${order_board.author}</td>
                    <td>${order_board.name}</td>
                    <td><a href="/add-new-book">Добавить</a></td>
                </tr>
            </c:forEach>
        </table>
    </section>
</body>

</html>
