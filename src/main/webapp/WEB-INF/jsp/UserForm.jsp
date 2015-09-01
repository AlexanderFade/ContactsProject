<%--
  Created by IntelliJ IDEA.
  User: Alexander Kovalevsky
  Date: 29.08.15
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>New or Edit User</title>
</head>
<body>
<div align="center">
  <h1>New/Edit User</h1>
  <table>
    <form:form action="save" method="post" modelAttribute="user">
      <form:hidden path="userId"/>
      <tr>
        <td>Login:</td>
        <td><form:input path="login"/></td>
      </tr>
      <tr>
        <td>First name:</td>
        <td><form:input path="first_name"/></td>
      </tr>
      <tr>
        <td>Second name:</td>
        <td><form:input path="second_name"/></td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="Save">
        </td>
      </tr>
    </form:form>
  </table>
</div>

</body>
</html>
