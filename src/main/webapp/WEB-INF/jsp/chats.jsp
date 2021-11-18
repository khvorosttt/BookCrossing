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
        <div id="chats">
            <table>
                <c:forEach var="chat" items="${chatList}">
                    <tr>
                        <td><a href="/messages/${chat.senderId}/${chat.recipientId}" type="submit">${chat.recipientId}</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="chat-page" class="hidden">
            <div class="chat-container">
                <div class="chat-header">
                    <h2>Spring WebSocket Chat Demo</h2>
                </div>
                <div class="connecting">
                    Connecting...
                </div>
                <ul id="messageArea">
                    <c:forEach var="message" items="${messageList}">
                        <li>${message.textMessage}</li>
                        </c:forEach>
                </ul>
                <form id="messageForm" name="messageForm" nameForm="messageForm">
                    <div class="form-group">
                        <div class="input-group clearfix">
                            <input type="text" id="message" placeholder="Type a message..." autocomplete="off" class="form-control"/>
                            <button type="submit" class="primary">Send</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
</body>
<script>
    var chats = document.querySelector('#chats');
    var chatPage = document.querySelector('#chat-page');
    var messageForm = document.querySelector('#messageForm');
    var messageInput = document.querySelector('#message');
    var messageArea = document.querySelector('#messageArea');
    var connectingElement = document.querySelector('.connecting');
    var stompClient = null;
    var username = null;
    usernameForm.addEventListener('submit', connect, true)
    messageForm.addEventListener('submit', sendMessage, true)
    var colors = [
        '#2196F3', '#32c787', '#00BCD4', '#ff5652',
        '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
    ];

    function connect(event) {
        chats.classList.add('hidden');
        chatPage.classList.remove('hidden');

        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    }
    event.preventDefault();
    }
    function onConnected() {
        // Subscribe to the Public Topic
        stompClient.subscribe('/topic/public', onMessageReceived);

        // Tell your username to the server
        stompClient.send("/app/chat.addUser",
                {},
                JSON.stringify({sender: username, type: 'JOIN'})
                )

        connectingElement.classList.add('hidden');
    }


    function onError(error) {
        connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
        connectingElement.style.color = 'red';
    }
</script>
</html>
