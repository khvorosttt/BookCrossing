<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
        <title>${recipient.name}</title>
        <link rel="stylesheet" href="/css/main.css" />
    </head>
    <style><%@ include file='main.css'%></style>
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
        <input class="hidden" id="name" value="${sender.name}"/>
        <input class="hidden" id="senderId" value="${sender.id}"/>
        <input class="hidden" id="recipientId" value="${recipient.id}"/>
        <div id="chat-page">
            <div class="chat-container">
                <div class="chat-header">
                    <h2>${recipient.name}</h2>
                </div>
                <div class="connecting">
                    Connecting...
                </div>
                <ul id="messageArea">
                    <c:forEach var="message" items="${messageList}">
                        <li class="event-message" style="padding-left: 68px; color:black;"><p><b>${message.sender}</b></p><p>${message.textMessage}</p></li>
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

        <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
        <script>var usernamePage = document.querySelector('#username-page');
            var chatPage = document.querySelector('#chat-page');
            var usernameForm = document.querySelector('#usernameForm');
            var messageForm = document.querySelector('#messageForm');
            var messageInput = document.querySelector('#message');
            var messageArea = document.querySelector('#messageArea');
            var connectingElement = document.querySelector('.connecting');

            var stompClient = null;
            var username = document.querySelector('#name').value.trim();
            var senderId = document.querySelector('#senderId').value.trim();
            var recipientId = document.querySelector('#recipientId').value.trim();
            
            var colors = [
                '#2196F3', '#32c787', '#00BCD4', '#ff5652',
                '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
            ];

            function connect(event) {
                var socket = new SockJS('/ws');
                stompClient = Stomp.over(socket);
                stompClient.connect({}, onConnected, onError);

                event.preventDefault();
            }


            function onConnected() {
                // Subscribe to the Public Topic
                alert('/messages/'+senderId+'/'+recipientId);
                //var address='/messages/'+senderId+'/'+recipientId;
                //stompClient.subscribe(address, onMessageReceived);
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


            function sendMessage(event) {
                var messageContent = messageInput.value.trim();
                
                if (messageContent && stompClient) {
                    var chatMessage = {
                        sender: username,
                        chatId : senderId+"_"+recipientId,
                        id_sender : senderId,
                        id_recipient : recipientId,
                        textMessage : messageInput.value,
                        //type: 'CHAT'
                    };
                    //var address="/app/messages/"+senderId+"/"+recipientId+".sendMessage";
                    //stompClient.send(address.toString(), {}, JSON.stringify(chatMessage));
                    stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
                    messageInput.value = '';
                }
                event.preventDefault();
            }


            function onMessageReceived(payload) {
                var message = JSON.parse(payload.body);

                var messageElement = document.createElement('li');

                /*if (message.type === 'JOIN') {
                    messageElement.classList.add('event-message');
                    message.content = message.sender + ' joined!';
                } else if (message.type === 'LEAVE') {
                    messageElement.classList.add('event-message');
                    message.content = message.sender + ' left!';
                } else {*/
                    messageElement.classList.add('chat-message');

                    var usernameElement = document.createElement('span');
                    var usernameText = document.createTextNode(message.sender);
                    usernameElement.appendChild(usernameText);
                    messageElement.appendChild(usernameElement);
                //}

                var textElement = document.createElement('p');
                var messageText = document.createTextNode(message.textMessage);
                textElement.appendChild(messageText);

                messageElement.appendChild(textElement);

                messageArea.appendChild(messageElement);
                messageArea.scrollTop = messageArea.scrollHeight;
            }

            window.onload = connect;
            messageForm.addEventListener('submit', sendMessage, true)</script>

    </body>
</html>