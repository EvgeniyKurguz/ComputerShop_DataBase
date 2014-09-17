<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Страница регистрации</title>
    <link rel="stylesheet" href="../static/style/style.css">
</head>

<body>
<h1>Регистрация посетителей</h1>
<form action="index" method="post">
    Имя: <input type="text" name="firstName" size="10"><br>
    Фамилия: <input type="text" name="lastName" size="10"><br>
    Логин: <input type="text" name="user" size="10"><br>
    Пароль: <input type="password" name="password" size="10"><br>
    Email: <input type="email" name="email"><br>
    Адрес: <input type="text" name="address"><br>
    Телефон: <input type="text" name="phone"><br>
    <p>
    <table>
        <tr>
            <th><small>
                <input type="submit" name="save" value="Сохранить">
                    <a href="index" class="c" >Сохранить</a>
            </small>
            <th><small>
                <%--<input type="submit" name="cancel" value="Выйти">--%>
                    <a href="login" class="c">Выйти</a>
            </small>
    </table>
</form>
</body>
</html>