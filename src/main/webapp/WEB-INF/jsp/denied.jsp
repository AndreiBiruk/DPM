<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class = "alert alert-danger">
    <h2 class = "text-center">
        <i class = "icon-gears icon-large"></i>
        <i class = "icon-bug icon-large"></i>
        <spring:message code="access.denied.message"/>
        <i class = "icon-code icon-large"></i>
        <i class = "icon-frown icon-large"></i>
    </h2>
</div>