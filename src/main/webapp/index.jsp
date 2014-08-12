<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<link rel="stylesheet" href="style/style.css" type="text/css">

<style type="text/css">
body,td,th {
	color: #000;
}
</style>
<head>
    <meta charset="utf-8">
    <title>Компьютерный магазин</title>
    <%--<script type="text/javascript" src="javaScript/script.js"></script>--%>

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

<span id="xy"></span><br/>

<div id="wrapper">
    <div class="user-icon"></div>
    <div class="pass-icon">
      <div align="center"><strong><em>
      <h1>Форма входа</h1></em></strong></div>
    </div>

    <form name="login-form" class="login-form" action="${pageContext.request.contextPath}/action"
          method="post" onSubmit="return validate(this)">

      <div class="header">
        <h3 align="right">   <span><em><strong> Введите ваши регистрационные данные для входа в ваш личный кабинет. </strong></em></span></h3>
        <div class="content">
          <div align="right">	Имя: 
            <input name="username" type="text" class="input username" value="Логин" onFocus="this.value=''"/>
          </div>
        </div>
          <p align="right"><span class="content">	Пароль: 
              <input name="password" type="password" class="input password" value="Пароль" onFocus="this.value=''"/>
          </span></p>
      </div>
      <div class="footer">
            <div align="right">	
              <input type="submit" name="submit" value="ВОЙТИ" class="button"/>
              <input type="submit" name="action" value="Регистрация" class="register"/>
            </div>
      </div>
    </form>
</div>
<div class="gradient"></div>
</body>
</html>
