<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Изменить пользователя</title>
</head>
<body>
<h3>Пользователь</h3>
<table>
    <thead>
    <tr>
        <td>Логин</td>
        <td>Имя</td>
        <td>E-mail</td>
        <td>Дата рождения</td>
        <td>Действия</td>
    </tr>
    </thead>
    <tr>
        <td>${user.login}</td>
        <td><c:out value="${user.name}" escapeXml="true"/></td>
        <td><a href="mailto:${user.email}">${user.email}</a></td>
        <td><fmt:formatDate value="${user.birthDate}" pattern="dd-MM-yyyy"/></td>
    </tr>
</table>
</body>
</html>