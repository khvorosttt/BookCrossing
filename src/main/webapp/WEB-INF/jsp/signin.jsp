<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html">
        <title>Вход в систему</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
<body>
    <form class="LogInForm" action="/sign-in" method="POST">
      <h1>Вход в систему</h1>
      <div class="divAll">
        <label class="LogInLabel">Логин</label>
        <input class="LogInInput" type="text" name="login" placeholder="Логин" required>
        <label class="LogInLabel">Пароль</label>
        <input class="LogInInput" type="password" name="pass" placeholder="Пароль" required>
        <button class="send" type="submit">Вход в систему</button>
        <a class="send" href="/login">Новый аккаунт</a>
      </div>
    </form>
  </body>

</html>
