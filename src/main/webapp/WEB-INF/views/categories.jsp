<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 27.01.18
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class=“container mt-5”>
    <c:forEach var="c" items="${categories}">
        <a href="<c:url value="/category/get/${c.id}"/>"><h1>${c.name}</h1></a>
    </c:forEach>
</div>

</body>
</html>
