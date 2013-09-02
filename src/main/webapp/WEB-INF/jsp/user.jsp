<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

H4H4H4H4H4H4H4<br>
${name}
<a class = "btn btn-success" href = "<c:url value = "/createBook"/>">
    <spring:message code="book.create"/>
</a>