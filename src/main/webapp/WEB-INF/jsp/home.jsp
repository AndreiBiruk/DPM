<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:forEach items="${books}" var = "book">
    <a href = "<c:url value="/book/${book.bookId}"/>">
        <div class = "col-lg-3 col-sm-6 col-md-4">
            <div class="panel panel-info">
                <div class="panel-heading"><h2>${book.name}</h2></div>
                <div class="panel-body">${book.description}</div>
            </div>
        </div>
    </a>
</c:forEach>