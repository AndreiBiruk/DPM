<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

H4H4H4H4H4H4H4<br>
${name}<br>
<c:if test="${not empty books}">
    <table class="table table-bordered table-striped">
        <tr>
            <th><spring:message code="id"/></th>
            <th><spring:message code="book.name"/></th>
            <th><spring:message code="book.description"/></th>
        </tr>

        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.bookId}</td>
                <td>${book.name}</td>
                <td>${book.description}</td>
            </tr>
        </c:forEach>

    </table>
</c:if>
<a class = "btn btn-success" href = "<c:url value = "/createBook"/>">
    <spring:message code="book.create"/>
</a>