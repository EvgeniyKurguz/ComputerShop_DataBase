<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--&lt;%&ndash;http://programilla.com/blog/siteconstruction/231.html&ndash;%&gt; связные списки--%>
<%--http://www.cyberforum.ru/javascript/thread264088.html--%>
<%--http://www.cyberforum.ru/php-database/thread698480.html--%>

<html>
<head>
    <title>client Table</title>

    <link rel="stylesheet" href="../static/style/style.css">

</head>
<body>

<div id="navbar-header">

    <table class="table table-bordered table-hover table-condensed">
        <caption>Таблица "Клиенты"</caption>
        <thead>
        <tr>
            <th>Id</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Дата рождения</th>
            <th>Телефон</th>
            <th>Логин</th>
            <th>Пароль</th>
            <th>Город</th>
            <th>Страна</th>
        </tr>
        </thead>
        <tbody>
        <%--@elvariable id="clientList" type="com.epam.ys.web.entity.Client"--%>
        <c:forEach items="${clientList}" var="client">

            <tr>
                    <%--<input type="text" placeholder="${client.id}">--%>
                <td>${client.id}</td>
                <td>${client.firstName}</td>
                <td>${client.lastName}</td>
                <td>${client.birth}</td>
                <td>${client.phone}</td>
                <td>${client.username}</td>
                <td>${client.password}</td>
                <td>${client.city}</td>
                <td>${client.country}</td>

                <td>
                    <form method="get" action="<c:url value=""/>">
                        <button type="submit" name="update" value="${client.id}">Edit</button>
                    </form>
                </td>
                <td>
                    <form method="post">
                        <button type="submit" name="delete" value="${client.id}">Delete</button>
                    </form>
                </td>
            </tr>

        </c:forEach>

        <hr>

        <form method="get" value="createClient" style="float: right">

            <a href="createClient">Добавить запись о клиенте</a>
        </form>

        <ul id="change" class="pagination">
            <li><a href="${pageName}?page=${pageNumber-1}&rows=${rowsCount}"
                   form="back">&laquo;</a></li>
            <li>
                <c:forEach items="${paginationList}" var="pl">
            <li><a href="${pageName}?page=${pl.intValue()}&rows=${rowsCount}"
                   name="page">${pl.intValue()}</a></li>
            </c:forEach>
            </li>
            <li><a href="${pageName}?page=${pageNumber+1}&rows=${rowsCount}"
                   form="next">&raquo;</a></li>
        </ul>
        </button>
        </tbody>
    </table>
    <hr>
</div>
</body>
</html>
