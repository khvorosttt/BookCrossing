<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html">
        <title>${book.name}</title>
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
        <div class="divAll">
            <a href="/">Возврат</a>
            <label>Автор: ${book.author}</label>
            <label>Название: ${book.name}</label>
            <label>Адрес: ${book.country}, г. ${book.city}, ул. ${book.street} ${book.house}</label>
            <label>Доступ: ${book.access}</label>
            <label>Статус: ${book.status}</label>
        </div>


        <form action="/book-${book.BCID}-info" method="POST">
            <input type="text" name="textComment" maxlength="1000" required>    
            <button class="send" type="submit">Комментировать</button>
        </form>
        <table>
            <tr>
                <th>Комментарии</th>
            </tr>
            <c:forEach var="comment" items="${commentList}">
                <tr>
                    <td>
                        ${comment.id_user} <br>${comment.textComment}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </section>
</body>

</html>