<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<link rel="stylesheet" href="style/style.css" type="text/css">

<head>
    <meta charset="UTF-8">
    <title>Компьютерный магазин</title>
    <%--<script type="text/javascript" src="javaScript/script.js"></script>--%>

    <script language="JavaScript" type="text/javascript">
        ns4 = (document.layers)? true:false
        ie4 = (document.all)? true:false

        function init() {
            if (ns4) {document.captureEvents(Event.MOUSEMOVE);}
            document.onmousemove=mousemove;
        }
        function mousemove(event) {

            var mouse_x = y = 0;
            if (document.attachEvent != null) {
                mouse_x = window.event.clientX;
                mouse_y = window.event.clientY;
            } else if (!document.attachEvent && document.addEventListener) {
                mouse_x = event.clientX;
                mouse_y = event.clientY;
            }
            status="x = " + mouse_x + ", y = " + mouse_y;
            document.getElementById('xy').innerHTML = "x = " + mouse_x + ", y = " + mouse_y;
        }
        init()
    </script>


    <script>
        function validate(form) {
            var reason = "";

            if (form.username.value == "" || /[^a-zA-z]/.test(form.username.value))
                reason += "Ошибка имени ";
            if (form.password.value == "" || /[^0-9]/.test(form.password.value))
                reason += "Ошибка пароля ";

            if (reason == "")
                return true;
            else {
                alert(reason);
                return false;
            }
        }
    </script>
</head>
<body>
<form method="post" onSubmit="return validate(this)">
    <h1 align="center">Войти</h1>
    <input name="username" type="text" placeholder="Логин"/>
    <input name="password" type="password" placeholder="Пароль"/>
    <input name="remember" type="checkbox" value="yes"/> Запомнить <br/>
    <input name="submit" value="Войти" type="submit"/>

    <hr style="background-color : #808080 ;"/>

    <h5><a href="">Забыли пароль?</a> |<a href="WEB-INF/registration.jsp" target="_blank"> Регистрация</a></h5>
</form>

</body>
</html>
