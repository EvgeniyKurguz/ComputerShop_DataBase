<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Компьютерный магазин</title>
    <link rel="stylesheet" href="../static/style/style.css">

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

<div id="wrapper">
    <div class="user-icon"></div>
    <div class="pass-icon">
        <div align="center"><strong><em>
            <h1>Форма входа</h1></em></strong></div>
    </div>

    <form method="post" name="login-form"  action="">

        <div class="header">
            <h3 align="right"><span><em><strong> Вход в личный кабинет. </strong></em></span></h3>
            <input name="action" type="hidden" value="login"/>
            <div class="content">
                <div align="right"> Имя:
                    <input type="text" name="username"/>
                </div>
            </div>
            <p align="right"><span class="content">	Пароль:
              <input type="password" name="password"/>
          </span></p>
        </div>
        <div class="footer">
            <div align="right">
                <%--<a href=""  class="c">ВОЙТИ</a>--%>
                <button type="submit" class="c">ВОЙТИ</button>
                <%--<input type="submit" src="registration.jsp" value="РЕГИСТРАЦИЯ" />--%>
                <a href="registration"  class="c">РЕГИСТРАЦИЯ</a>
            </div>
        </div>
    </form>
</div>
<div class="gradient"></div>

</div>

</body>
</html>



