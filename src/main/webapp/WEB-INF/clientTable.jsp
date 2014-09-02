<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>client Table</title>

    <link rel="stylesheet" href="../static/style/style.css">

   </head>
<body>

<div id="navbar-header">

    <table class="table table-bordered table-hover table-condensed">
        <caption>ClientTable</caption>
        <thead>
        <tr>
            <th>Id</th>
            <th>first name</th>
            <th>last name</th>
            <th>birth</th>
            <th>phone</th>
            <th>attestation_number</th>
            <th>username</th>
            <th>password</th>
            <th>role</th>
            <th>city</th>
            <th>country</th>
            <%--<th>CheckBox</th>--%>
            <th>Update Button</th>
            <th>Delete Button</th>
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
                <td>${client.attestation_number}</td>
                <td>${client.username}</td>
                <td>${client.password}</td>
                <td>${client.role}</td>
                <td>${client.city}</td>
                <td>${client.country}</td>

                <%--<td>--%>
                    <%--<input type="checkbox" id="" value="${client.id}"/><label for=""></label>--%>
                <%--</td>--%>
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
            <%--<form method="post">--%>
                <%--<button type="submit" name="delete" value="${client.id}">Удалить отмеченных</button>--%>
            <%--</form>--%>
        </c:forEach>

        <hr>

        <form method="get" action="<c:url value=""/>">
            <button type="submit" class="Submit">Добавить запись о клиенте</button>
        </form>
        <button onClick='location.href=""' type="submit" class="btn">На
            главную
        </button>
        </tbody>
    </table>
    <hr>
</div>
</body>
</html>
