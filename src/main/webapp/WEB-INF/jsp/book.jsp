<%-- 
    Document   : book
    Created on : 24.09.2020, 20:38:46
    Author     : Lenovo
--%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html">
        <title>Библиотека</title>
    </head>
    <style><%@ include file='style.css'%></style>
    <body>
    <header>
        <nav>
            <ul><sec:authorize access="isAnonymous()">
                    <li><a href="/login">
                            Авторизация</a></li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li><a href="/my-profile">Мой профиль</a></li>
                </sec:authorize>
                    <li><a href="/" class="CurrentPage">Библиотека</a></li>
                    <li><a href="/find-book">Поиск книги</a></li>
                    <li><a href="/order-board">Доска заказов</a></li>
                    <sec:authorize access="isAuthenticated()">
                    <li><a href="/logout">Выйти</a></li>
                    </sec:authorize>
            </ul>
        </nav>
    </header>
    <section>
        <h1>Библиотека</h1>
        <a href="/add-new-book">Добавить новую книгу</a>
        <table>
            <tr>
                <th>BCID</th>
                <th>Автор</th>
                <th>Название</th>
                <th>Читатель</th>
                <th>Доступ</th>
                <th>Статус</th>
                <th></th>
            </tr>
            <c:forEach var="book" items="${bookList}">
                <tr>
                    <td>${book.BCID}</td>
                    <td>${book.author}</td>
                    <td>${book.name}</td>
                    <td>${book.reader}</td>
                    <td>${book.access}</td>
                    <td>${book.status}</td>
                    <td><sec:authorize access="isAuthenticated()">
                            <form action="/edit-${book.BCID}" method="POST">
                                <a href="/add-${book.BCID}">Добавить</a>
                            </form>
                        </sec:authorize>
                        <a href="/book-${book.BCID}-info">Просмотреть</a></td></td>
                </tr>
            </c:forEach>
        </table>
    </section>
</body>
</html>