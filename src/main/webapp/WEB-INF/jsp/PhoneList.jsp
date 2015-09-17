<%--
  Created by IntelliJ IDEA.
  User: Alexander Kovalevsky
  Date: 29.09.15
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Phones</title>
</head>
<body>
    <div align="center">
      <h1>Phones List</h1>
      <h2><a href="phones/new">New Phone</a></h2>

      <table border="1">
        <th>No</th>
        <th>Phone ID</th>
        <th>Phone</th>
        <th>User ID</th>
        <th>Actions</th>

        <c:forEach var="phone" items="${phones}" varStatus="status">
          <tr>
            <td>${status.index + 1}</td>
            <td>${phone.phoneId}</td>
            <td>${phone.phone}</td>
            <td>${phone.user.userId}</td>
            <td>
              <a href="phones/edit?id=${phone.phoneId}">Edit</a>
              &nbsp;&nbsp;&nbsp;&nbsp;
              <a href="phones/delete?id=${phone.phoneId}">Delete</a>
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
</body>
</html>
