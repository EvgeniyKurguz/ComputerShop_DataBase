<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>UpdateClient</title>

    <%--<script type='text/javascript' src='<c:url value="../static/js/bootstrap.min.js"/>'></script>--%>

    <%--<link href="../static/css/bootstrap.min.css" rel="stylesheet" media="screen">--%>

</head>
<body>


<h1>Редактирование данных о клиенте</h1>


<form method="post" class="bdrform_tabl" role="form">

    <div class="form-group">
        <label for="firstName" class="col-sm-2 control-label">FirstName</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="firstName" name="firstName" value="${client.firstName}"
                   placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="lastName" class="col-sm-2 control-label">lastName</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="lastName" name="lastName" value="${client.lastName}"
                   placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="birth" class="col-sm-2 control-label">Birth</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="birth" name="birth" value="${client.birth}"
                   placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="phone" class="col-sm-2 control-label">Phone</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="phone" name="phone" value="${client.phone}"
                   placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="attestationNumber" class="col-sm-2 control-label">Attestation_number</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="attestationNumber" name="attestationNumber"
                   value="${client.attestationNumber}"
                   placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">email</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="email" name="email"
                   value="${client.email}" placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="username" class="col-sm-2 control-label">username</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="username" name="username"
                   value="${client.username}" placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">password</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="password" name="password" value="${client.password}"
                   placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="city" class="col-sm-2 control-label">city</label>

        <div class="col-sm-10">
            <select name="city" id="city" class="fld">
                <option value="Astana">Astana</option>
                <option value="Moscow">Moscow</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="country" class="col-sm-2 control-label">country</label>

        <div class="col-sm-10">
            <select name="country" id="country" class="fld">
                <option value="Kazakhstan">Kazakhstan</option>
                <option value="Russia">Russia</option>
            </select>
        </div>
    </div>

    <option value="CLIENT"></option>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <form method="post">
                <button type="submit" name="id" value="${client.id}">Save</button>
            </form>
        </div>
    </div>
</form>

<%--</form>--%>

</body>
</html>
