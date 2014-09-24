<%--suppress XmlPathReference --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <title>clientTable</title>
    <link rel="stylesheet" href="../static/style/style.css">
    <link rel="stylesheet" href="../static/css/docs.css">
    <link href="../static/css/bootstrap.css" rel="stylesheet"/>
    <link href="../static/css/bootstrap-responsive.css" rel="stylesheet"/>
    <link href="../static/js/google-code-prettify/prettify.css" rel="stylesheet"/>
</head>
<body>

<div id="mainBody" class="container">
    <header id="header">
        <div class="row">

            <div align="center">
                <div>
                    <h3>Client Table</h3>

                    <div class="row-fluid">

                        <div id="navbar-header">

                            <table>

                                <thead>
                                <tr>
                                        <th>first name</th>
                                        <th>last name</th>
                                        <th>birth</th>
                                        <th>phone</th>
                                        <th>attestationNumber</th>
                                        <th>email</th>
                                        <th>username</th>
                                        <th>password</th>
                                        <th>city</th>
                                        <th>country</th>
                                        <th>is blocked</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${clientList}" var="client">

                                    <tr>
                                        <td>${client.firstName}</td>
                                        <td>${client.lastName}</td>
                                        <td>${client.birth}</td>
                                        <td>${client.phone}</td>
                                        <td>${client.attestationNumber}</td>
                                        <td>${client.username}</td>
                                        <td>${client.password}</td>
                                        <td>${client.email}</td>
                                        <td>${client.city}</td>
                                        <td>${client.country}</td>
                                        <td>${client.blocked}</td>

                                        <td>
                                            <form method="get" action="<c:url value="/updateClient"/>">
                                                <button type="submit" name="id" value="${client.id}">Edit</button>
                                            </form>
                                        </td>
                                        <td>
                                            <form method="post">
                                                <button type="submit" name="delete" value="${client.id}">Delete</button>
                                            </form>
                                        </td>
                                    </tr>

                                </c:forEach>

                                <form method="get" action="<c:url value="/createClient"/>" style="float: right">
                                    <button type="submit" class="Submit">Добавить запись о клиенте</button>
                                </form>

                                <ul id="change" class="pagination">
                                    <li><a href="${pageName}?page=${pageNumber-1}&rows=${rowsCount}"
                                           form="back">&laquo;</a></li>
                                    <li>
                                        <c:forEach items="${paginationList}" var="pl">
                                    <li><a href="${pageName}?page=${pl.intValue()}&rows=${rowsCount}"
                                           name="page">${pl.intValue()}</a></li>
                                    </c:forEach>

                                    <li><a href="${pageName}?page=${pageNumber+1}&rows=${rowsCount}"
                                           form="next">&raquo;</a></li>
                                </ul>

                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>

        </div>

    </header>
</div>
</body>
</html>

