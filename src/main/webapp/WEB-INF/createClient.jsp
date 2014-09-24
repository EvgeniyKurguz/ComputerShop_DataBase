<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>clientTableCreate</title>
    <script type='text/javascript' src='<c:url value="webjars/jquery/2.0.3/jquery.min.js"/>'></script>
    <script type='text/javascript' src='<c:url value="webjars/bootstrap/3.0.0/js/bootstrap.min.js"/>'></script>

    <link href="../static/css/bootstrap.css" rel="stylesheet" media="screen">

</head>
<body>

<h3>Добавление клиента</h3>

<form method="post" class="bdrform_tabl" role="form">
    <div class="form-group">
        <label for="firstName" class="col-sm-2 control-label">First Name</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="firstName" name="firstName" value="" placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="lastName" class="col-sm-2 control-label">Last Name</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="lastName" name="lastName" value="" placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="birth" class="col-sm-2 control-label">Birth</label>

        <div class="col-sm-10">
            <input type="date" class="form-control" id="birth" name="birth" value="" placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="phone" class="col-sm-2 control-label">Phone</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="phone" name="phone" value="" placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="attestationNumber" class="col-sm-2 control-label">Attestation_Number</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="attestationNumber" name="attestationNumber" value="" placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="email" name="email" value="${emailRegexError}" placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="username" class="col-sm-2 control-label">Username</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="username" name="username" value="" placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">Password</label>

        <div class="col-sm-10">
            <input type="password" class="form-control" id="password" name="password" value="" placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="city" class="col-sm-2 control-label">City</label>

        <div class="col-sm-10">

            <select name="city" id="city" class="fld">
                <option value="1">Astana</option>
                <option value="2">Moscow</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="country" class="col-sm-2 control-label">Country</label>

        <div class="col-sm-10">
            <select name="country" id="country" class="fld">
                <option value="1">Kazakhstan</option>
                <option value="2">Russia</option>
            </select>
        </div>
    </div>
    <div class="col-sm-10">
        <input type="text" style="display: none" class="form-control" id="" name="account" value="0" placeholder="">
    </div>
    <option value="CLIENT"></option>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn">Save</button>
        </div>
    </div>
</form>

</body>
</html>

