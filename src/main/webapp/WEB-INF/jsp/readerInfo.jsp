<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html">
        <title>${reader.name}</title>
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


    <h1>Мой профиль: ${reader.name}</h1>
    <nav>
        <div>
            <a href="/">Добавить книгу</a>
        </div>
    </nav>
    <table>
        <tr>
            <th class="MyProfileTh">BCID</th>
            <th class="MyProfileTh">Автор</th>
            <th class="MyProfileTh">Название</th>
            <th class="MyProfileTh"></th>
        </tr>
        <c:forEach var="book" items="${bookList}">
            <tr>
                <td class="MyProfileTd">${book.BCID}</td>
                <td class="MyProfileTd">${book.author}</td>
                <td class="MyProfileTd">${book.name}</td>
                <td class="MyProfileTd">
                    <a href="/book-${book.BCID}-info"><span class="MyProfileSpan">
                            Просмотреть</span></a>
                    <a href="/edit-${book.BCID}">
                        <span class="MyProfileSpan">Редактировать</span></a>
                </td>
            </tr>

        </c:forEach>
    </table>
</body>

</html> 
