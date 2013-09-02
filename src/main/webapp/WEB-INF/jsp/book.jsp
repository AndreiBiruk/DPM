<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

${name}

<c:if test="${not empty chapters}">
    <table class="table table-bordered table-striped">
        <tr>
            <th><spring:message code="id"/></th>
            <th><spring:message code="book.name"/></th>
        </tr>
        <c:forEach items="${chapters}" var="chapter">
            <tr>
                <td>${chapter.id}</td>
                <td>${chapter.name}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<a class = "btn btn-success" href = "<c:url value = "/createChapter"/>">
    <spring:message code="chapter.create"/>
</a>