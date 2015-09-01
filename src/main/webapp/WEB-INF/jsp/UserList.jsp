<%--
  Created by IntelliJ IDEA.
  User: Alexander Kovalevsky
  Date: 28.08.15
  Time: 17:09
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
    <title>Home</title>
</head>
<body>
    <div align="center">
      <h1>Users List</h1>
      <h2><a href="new">New User</a></h2>

      <table border="1">
        <th>No</th>
        <th>User ID</th>
        <th>Login</th>
        <th>First Name</th>
        <th>Second Name</th>
        <th>Actions</th>

        <c:forEach var="user" items="${userList}" varStatus="status">
          <tr>
            <td>${status.index + 1}</td>
            <td>${user.userId}</td>
            <td>${user.login}</td>
            <td>${user.first_name}</td>
            <td>${user.second_name}</td>
            <td>
              <a href="edit?id=${user.userId}">Edit</a>
              &nbsp;&nbsp;&nbsp;&nbsp;
              <a href="delete?id=${user.userId}">Delete</a>
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
</body>
</html>
