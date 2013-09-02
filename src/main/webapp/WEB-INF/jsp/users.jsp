<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h2><spring:message code="header.admin" text="Users" /></h2>

<table class="table table-bordered table-striped">
    <tr>
        <th><spring:message code="id" text="Id" /></th>
        <th><spring:message code="login" text="login" /></th>
        <th><spring:message code="password" text="Password" /></th>
        <th><spring:message code="email" text="E-Mail" /></th>
        <th><spring:message code="activation" text="Activation" /></th>
        <th><spring:message code="action" text="Action"/></th>
    </tr>
    <c:forEach items="${users}" var="user">
    <tr>
        <td>${user.idUser}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.email}</td>
        <td>
        <c:choose>
            <c:when test="${user.enabled}">
                <a href="/users/deactivate/${user.idUser}"><spring:message code="admin.activated" text="Activated"/></a>
            </c:when>
            <c:otherwise>
                <a href="/users/activate/${user.idUser}"><spring:message code="admin.deactivated" text="Deativated"/></a>
            </c:otherwise>
        </c:choose>
        </td>
        <td>
            <a href="/users/delete/${user.idUser}"><spring:message code="delete" text="Delete"/></a>
        </td>
    </tr>
    </c:forEach>
</table>




