<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html">
        <title>Новый аккаунт</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>

    <body>
        <form class="LogInForm" action="/login" method="POST">
            <h1>Новый аккаунт</h1>
            <div class="divAll">
                <label>Имя</label>
                <input class="LogInInput" type="text" name="name" tabindex="1" placeholder="Имя" required>
                <label class="LogInLabel">Логин</label>
                <input class="LogInInput" type="text" name="login" placeholder="Логин" required>
                <label class="LogInLabel">Пароль</label>
                <input class="LogInInput" type="password" name="pass" id="pass" placeholder="Пароль" required>
                <label class="LogInLabel">Повторите пароль</label>
                <input class="LogInInput" type="password" name="repeat_pass" id="repeat_pass" placeholder="Пароль" required>
                <input class="send" type="submit" value="Создать аккаунт"/>
                <p class="LogInP">Уже есть аккаунт? <a href="/sign-in">Войти в систему</a></p>
            </div>
        </form>
    </body>
    <script type="text/javascript">
        window.onload = function () {
            document.getElementById("pass").onchange = validatePassword;
            document.getElementById("repeat_pass").onchange = validatePassword;
        };
        function validatePassword() {
            var pass2 = document.getElementById("repeat_pass").value;
            var pass1 = document.getElementById("pass").value;
            if (pass1 !== pass2)
                document.getElementById("repeat_pass").setCustomValidity("Пароли не совпадают");
            else
                document.getElementById("repeat_pass").setCustomValidity('');
        }
    </script>
</html>