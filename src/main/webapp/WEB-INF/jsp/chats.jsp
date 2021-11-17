<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html">
        <title>Диалоги</title>
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
        <table>
            <c:forEach var="chat" items="${chatList}">
                <tr>
                    <form><td>${chat.recipientId}</td></form>
                </tr>
            </c:forEach>
        </table>
    </section>
</body>
</html>
