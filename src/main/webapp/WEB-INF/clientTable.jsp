<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <title>clientTable</title>
    <link rel="stylesheet" href="../static/style/style.css">

</head>
<body>
<!-- Navbar
  ================================================== -->

<!-- ======================================================================================================================== -->
<div id="mainBody" class="container">
    <header id="header">
        <div class="row">

            <div align="center">
                <div>
                    <h3>Client Table</h3>

                    <div class="row-fluid">

                        <div id="navbar-header">

                            <table >
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
                                        <td>${client.firstname}</td>
                                        <td>${client.lastName}</td>
                                        <td>${client.birth}</td>
                                        <td>${client.phone}</td>
                                        <td>${client.username}</td>
                                        <td>${client.password}</td>
                                        <td>${client.email}</td>
                                        <td>${client.city}</td>
                                        <td>${client.country}</td>

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

                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
            <!-- Footer ------------------------------------------------------ -->

            <!-- /container -->
        </div>


        <!-- Le javascript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
        <script src="../static/js/jquery.js"></script>
        <script src="../static/js/google-code-prettify/prettify.js"></script>
        <script src="../static/js/application.js"></script>
        <script src="../static/js/bootstrap-transition.js"></script>
        <script src="../static/js/bootstrap-modal.js"></script>
        <script src="../static/js/bootstrap-scrollspy.js"></script>
        <script src="../static/js/bootstrap-alert.js"></script>
        <script src="../static/js/bootstrap-dropdown.js"></script>
        <script src="../static/js/bootstrap-tab.js"></script>
        <script src="../static/js/bootstrap-tooltip.js"></script>
        <script src="../static/js/bootstrap-popover.js"></script>
        <script src="../static/js/bootstrap-button.js"></script>
        <script src="../static/js/bootstrap-collapse.js"></script>
        <script src="../static/js/bootstrap-carousel.js"></script>
        <script src="../static/js/bootstrap-typeahead.js"></script>
        <script src="../static/js/bootstrap-affix.js"></script>
        <script src="../static/js/jquery.lightbox-0.5.js"></script>
        <script src="../static/js/bootsshoptgl.js"></script>
        <script type="text/javascript">
            $(function () {
                $('#gallery a').lightBox();
            });
        </script>
    </header>
</div>
</body>
</html>

