<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>productTableCreate</title>
    <script type='text/javascript' src='<c:url value="webjars/jquery/2.0.3/jquery.min.js"/>'></script>
    <script type='text/javascript' src='<c:url value="webjars/bootstrap/3.0.0/js/bootstrap.min.js"/>'></script>

    <link href="../static/css/bootstrap.css" rel="stylesheet" media="screen">

</head>
<body>

<h3>Добавление "Product"</h3>

<form method="post" class="bdrform_tabl" role="form">
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Наименование</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="name" name="name" value="" placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="maker" class="col-sm-2 control-label">Производитель</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="maker" name="maker" value="" placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="model" class="col-sm-2 control-label">Модель</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="model" name="model" value="" placeholder="">
        </div>
    </div>

    <option value="PRODUCT"></option>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn">Save</button>
        </div>
    </div>
</form>

</body>
</html>

