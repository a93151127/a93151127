<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students</title>
</head>
<body>
    <table border="1">
            <th>id</th>
            <th>r1</th>
            <th>r2</th>
            <th>r3</th>
            <th>r4</th>
            <th>r5</th>   
            <c:forEach items="${message}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.r1}</td>
                    <td>${student.r2}</td>
                    <td>${student.r3}</td>
                    <td>${student.r4}</td>
                    <td>${student.r5}</td>
                </tr>
            </c:forEach>                 
        </table>
</body>
</html>
