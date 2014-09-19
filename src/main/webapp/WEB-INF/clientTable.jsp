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

<div id="mainBody" class="container">
    <header id="header">
        <div class="row">


            <div align="center">
                <div>
                    <h3>Client Table</h3>

                    <div class="row-fluid">

                        <div id="navbar-header">

                            <table class="table table-bordered table-hover table-condensed">
                                <%--<caption>ClientTable</caption>--%>
                                <thead>
                                <tr>
                                    <%--<th>Id</th>--%>
                                    <th>first name</th>
                                    <th>last name</th>
                                    <th>birth</th>
                                    <th>phone</th>
                                    <th>email</th>
                                    <th>username</th>
                                    <th>password</th>
                                    <%--<th>role</th>--%>
                                    <th>city</th>
                                    <th>country</th>
                                    <%--<th>CheckBox</th>--%>
                                    <th>Edit Button</th>
                                    <th>Delete Button</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${clientList}" var="client">

                                    <tr>
                                        <td>${client.firstName}</td>
                                        <td>${client.lastName}</td>
                                        <td>${client.birth}</td>
                                        <td>${client.phone}</td>
                                        <td>${client.username}</td>
                                        <td>${client.password}</td>
                                        <td>${client.email}</td>
                                        <td>${client.city}</td>

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
                                    <%--<form method="post">--%>
                                    <%--<button type="submit" name="delete" value="${client.id}">Удалить отмеченных</button>--%>
                                    <%--</form>--%>
                                </c:forEach>

                                <hr>

                                <form method="get" action="<c:url value="/createClient"/>" style="float: right">
                                    <button type="submit" class="Submit">Добавить запись о клиенте</button>
                                </form>



                                </tbody>
                            </table>


                        </div>


                    </div>
                </div>
            </div>
            <!-- Footer ------------------------------------------------------ -->

            <!-- /container -->
        </div>

              <script type="text/javascript">
            $(function () {
                $('#gallery a').lightBox();
            });
        </script>

</body>
</html>
