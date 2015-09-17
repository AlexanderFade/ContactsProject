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
      <h2>Enjoy</h2>

      <table border="1">
        <th>No</th>
        <th>User ID</th>
        <th>Login</th>
        <th>First Name</th>
        <th>Second Name</th>
        <th colspan="3">Actions</th>
        <th>Phone ID</th>
        <th>Phone Numb.</th>
        <th colspan="3">Actions</th>
        <th>Email ID</th>
        <th>Email</th>
        <th colspan="3">Actions</th>

        <c:forEach var="user" items="${userList}" varStatus="status">

          <c:if test="${(!empty user.phones) and (!empty user.emails)}">
            <c:forEach var="phone" items="${user.phones}">
              <c:forEach var="email" items="${user.emails}">
                <tr>
                  <td>${status.index + 1}</td>
                  <td>${user.userId}</td>
                  <td>${user.login}</td>
                  <td>${user.first_name}</td>
                  <td>${user.second_name}</td>
                  <td><a href="edit?id=${user.userId}">Edit</a></td>
                  <td><a href="delete?id=${user.userId}">Delete</a></td>
                  <td><a href="new">New</a></td>

                  <td>${phone.phoneId}</td>
                  <td>${phone.phone}</td>
                  <td><a href="phones/edit?phoneId=${phone.phoneId}">Edit</a></td>
                  <td><a href="phones/delete?phoneId=${phone.phoneId}">Delete</a></td>
                  <td><a href="phones/new">New</a></td>

                  <td>${email.emailId}</td>
                  <td>${email.email}</td>
                  <td><a href="emails/edit?emailId=${email.emailId}">Edit</a></td>
                  <td><a href="emails/delete?emailId=${email.emailId}">Delete</a></td>
                  <td><a href="emails/new">New</a></td>
                </tr>
              </c:forEach>
            </c:forEach>
          </c:if>

          <c:if test="${(!empty user.phones) and (empty user.emails)}">
            <c:forEach var="phone" items="${user.phones}">
              <tr>
                <td>${status.index + 1}</td>
                <td>${user.userId}</td>
                <td>${user.login}</td>
                <td>${user.first_name}</td>
                <td>${user.second_name}</td>
                <td><a href="edit?id=${user.userId}">Edit</a></td>
                <td><a href="delete?id=${user.userId}">Delete</a></td>
                <td><a href="new">New</a></td>

                <td>${phone.phoneId}</td>
                <td>${phone.phone}</td>
                <td><a href="phones/edit?phoneId=${phone.phoneId}">Edit</a></td>
                <td><a href="phones/delete?phoneId=${phone.phoneId}">Delete</a></td>
                <td><a href="phones/new">New</a></td>

                <td>N/A</td>
                <td>N/A</td>
                <td><a href="emails/edit?emailId=${email.emailId}">Edit</a></td>
                <td><a href="emails/delete?emailId=${email.emailId}">Delete</a></td>
                <td><a href="emails/new">New</a></td>
              </tr>
            </c:forEach>
          </c:if>

          <c:if test="${(empty user.phones) and (!empty user.emails)}">
            <c:forEach var="email" items="${user.emails}">
              <tr>
                <td>${status.index + 1}</td>
                <td>${user.userId}</td>
                <td>${user.login}</td>
                <td>${user.first_name}</td>
                <td>${user.second_name}</td>
                <td><a href="edit?id=${user.userId}">Edit</a></td>
                <td><a href="delete?id=${user.userId}">Delete</a></td>
                <td><a href="new">New</a></td>

                <td>N/A</td>
                <td>N/A</td>
                <td><a href="phones/edit?phoneId=${phone.phoneId}">Edit</a></td>
                <td><a href="phones/delete?phoneId=${phone.phoneId}">Delete</a></td>
                <td><a href="phones/new">New</a></td>

                <td>${email.emailId}</td>
                <td>${email.email}</td>
                <td><a href="emails/edit?emailId=${email.emailId}">Edit</a></td>
                <td><a href="emails/delete?emailId=${email.emailId}">Delete</a></td>
                <td><a href="emails/new">New</a></td>
              </tr>
            </c:forEach>
          </c:if>

          <c:if test="${(empty user.phones) and (empty user.emails)}">
            <tr>
              <td>${status.index + 1}</td>
              <td>${user.userId}</td>
              <td>${user.login}</td>
              <td>${user.first_name}</td>
              <td>${user.second_name}</td>
              <td><a href="edit?id=${user.userId}">Edit</a></td>
              <td><a href="delete?id=${user.userId}">Delete</a></td>
              <td><a href="new">New</a></td>

              <td>N/A</td>
              <td>N/A</td>
              <td><a href="phones/edit?phoneId=${phone.phoneId}">Edit</a></td>
              <td><a href="phones/delete?phoneId=${phone.phoneId}">Delete</a></td>
              <td><a href="phones/new">New</a></td>

              <td>N/A</td>
              <td>N/A</td>
              <td><a href="emails/edit?emailId=${email.emailId}">Edit</a></td>
              <td><a href="emails/delete?emailId=${email.emailId}">Delete</a></td>
              <td><a href="emails/new">New</a></td>
            </tr>
          </c:if>

        </c:forEach>

      </table>

          <%--<tr>--%>
            <%--<td>${status.index + 1}</td>--%>
            <%--<td>${user.userId}</td>--%>
            <%--<td>${user.login}</td>--%>
            <%--<td>${user.first_name}</td>--%>
            <%--<td>${user.second_name}</td>--%>
            <%--<td>--%>
              <%--<a href="edit?id=${user.userId}">Edit</a>--%>
              <%--<%--&nbsp;&nbsp;&nbsp;&nbsp;--%>
              <%--<%--<a href="delete?id=${user.userId}">Delete</a>--%>
            <%--</td>--%>
            <%--<td><a href="delete?id=${user.userId}">Delete</a></td>--%>
            <%--<td><a href="new">New</a></td>--%>

            <%--<c:if test="${(!empty user.phones) and (!empty user.emails)}">--%>
              <%--<c:forEach items="${user.phones}" var="phone">--%>
                <%--<td>${phone.phoneId}</td>--%>
                <%--<td>${phone.phone}</td>--%>
                <%--<td><a href="edit?id=${phone.phoneId}">Edit</a></td>--%>
                <%--<td><a href="delete?id=${phone.phoneId}">Delete</a></td>--%>
                <%--<td><a href="new">New</a></td>--%>
              <%--</c:forEach>--%>
              <%--<c:forEach items="${user.emails}" var="emails">--%>
                <%--<td>${email.emailId}</td>--%>
                <%--<td>${email.email}</td>--%>
                <%--<td><a href="edit?id=${email.emailId}">Edit</a></td>--%>
                <%--<td><a href="delete?id=${email.email}">Delete</a></td>--%>
                <%--<td><a href="new">New</a></td>--%>
              <%--</c:forEach>--%>
            <%--</c:if>--%>
            <%--<c:if test="${(!empty user.phones) and (empty user.emails)}">--%>
              <%--<c:forEach items="${user.phones}" var="phone">--%>
                <%--<td>${phone.phoneId}</td>--%>
                <%--<td>${phone.phone}</td>--%>
                <%--<td><a href="edit?id=${phone.phoneId}">Edit</a></td>--%>
                <%--<td><a href="delete?id=${phone.phoneId}">Delete</a></td>--%>
                <%--<td><a href="new">New</a></td>--%>
              <%--</c:forEach>--%>
              <%--<td>N/A</td>--%>
              <%--<td>N/A</td>--%>
              <%--<td><a href="edit?id=${email.emailId}">Edit</a></td>--%>
              <%--<td><a href="delete?id=${email.email}">Delete</a></td>--%>
              <%--<td><a href="new">New</a></td>--%>
            <%--</c:if>--%>
            <%--<c:if test="${(empty user.phones) and (empty user.emails)}">--%>
              <%--<td>N/A</td>--%>
              <%--<td>N/A</td>--%>
              <%--<td><a href="edit?id=${phone.phoneId}">Edit</a></td>--%>
              <%--<td><a href="delete?id=${phone.phoneId}">Delete</a></td>--%>
              <%--<td><a href="new">New</a></td>--%>

              <%--<td>N/A</td>--%>
              <%--<td>N/A</td>--%>
              <%--<td><a href="edit?id=${email.emailId}">Edit</a></td>--%>
              <%--<td><a href="delete?id=${email.email}">Delete</a></td>--%>
              <%--<td><a href="new">New</a></td>--%>
            <%--</c:if>--%>
          <%--</tr>--%>

        <%--</c:forEach>--%>
      <%--</table>--%>
    </div>
</body>
</html>
