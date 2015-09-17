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
    <title>Emails</title>
</head>
<body>
    <div align="center">
      <h1>Emails List</h1>
      <h2><a href="emails/new">New Email</a></h2>

      <table border="1">
        <th>No</th>
        <th>Email ID</th>
        <th>Email</th>
        <th>User ID</th>
        <th>Actions</th>

        <c:forEach var="email" items="${emails}" varStatus="status">
          <tr>
            <td>${status.index + 1}</td>
            <td>${email.emailId}</td>
            <td>${email.email}</td>
            <td>${email.user.userId}</td>
            <td>
              <a href="emails/edit?id=${email.emailId}">Edit</a>
              &nbsp;&nbsp;&nbsp;&nbsp;
              <a href="emails/delete?id=${email.emailId}">Delete</a>
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
</body>
</html>
