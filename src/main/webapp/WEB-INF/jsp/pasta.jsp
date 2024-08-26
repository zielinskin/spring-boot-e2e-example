<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Pastas</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Sauce Type</th>
                    <th>Meat Type</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${pastas}" var="item">
                    <tr>
                        <td>${item.id()}</td>
                        <td>${item.name()}</td>
                        <td>${item.sauceType()}</td>
                        <td>${item.meatType()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>