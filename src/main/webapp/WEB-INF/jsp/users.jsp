<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<h1>Счастье и радость!</h1>

<table>
    <c:forEach items="${users}" var="user">
    <tr>
        <td>${user.idUser}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
    </tr>
    </c:forEach>
</table>
