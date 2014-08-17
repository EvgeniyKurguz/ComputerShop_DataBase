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
<%--<%--%>
    <%--response.sendRedirect(request.getContextPath() + "/do/index");--%>
<%--%>--%>
<span id=""></span><br/>

<div id="wrapper">
    <div class="user-icon"></div>
    <div class="pass-icon">
        <div align="center"><strong><em>
            <h1>Форма входа</h1></em></strong></div>
    </div>

    <div style="float: right" >
        <h6 style="color:#f7f7f7">  Админ</h6>
    </div>
</div>
<div class="gradient"></div>



</body>
</html>



