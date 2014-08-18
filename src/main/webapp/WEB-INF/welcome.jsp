<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    response.sendRedirect(request.getContextPath() + "/login");
    response.sendRedirect(request.getContextPath() + "/registration");
%>
</body>
</html>
