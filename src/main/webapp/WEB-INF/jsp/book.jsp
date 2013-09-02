<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<c:set var = "currentUser"><security:authentication property="principal.username"/></c:set>

<h2 class = "text-center">${name}</h2>
<c:if test="${not empty chapters}">
    <table class="table table-bordered table-striped">
        <tr>
            <th><spring:message code="book.chapter"/></th>
            <th><spring:message code="book.description"/></th>
            <c:if test="${name == currentUser}">
                <th><spring:message code="action" text="Action"/></th>
            </c:if>
        </tr>

        <c:forEach items="${chapters}" var="chapter">
            <tr>
                <td>
                    <a href = "<c:url value="/book/${book.bookId}"/>">${chapter.name}</a>
                </td>
                <td>${chapter.description}</td>
                <c:if test="${name == currentUser}">
                    <td><a href="<c:url value="/book/delete/${book.bookId}"/>"><spring:message code="delete"/></a></td>
                </c:if>
            </tr>
        </c:forEach>

    </table>
</c:if>
<a class = "btn btn-success" href = "<c:url value = "/book/${bookId}/createChapter"/>">
    <spring:message code="chapter.create"/>
</a>