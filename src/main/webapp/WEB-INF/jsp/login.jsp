<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:if test="${param.error == true}">
    <div class = "alert alert-danger">
        <spring:message code="message.loginerror"/>
    </div>
</c:if>


<h3><spring:message code = "signin"/></h3>
<form action='/j_spring_security_check' method='POST'>
    <div class="form-group">
        <label for="username"><spring:message code="message.username"/></label>
        <input type="text" class="form-control" id="username" name = "j_username">
    </div>
    <div class="form-group">
        <label for="username"><spring:message code="message.password"/></label>
        <input type="password" class="form-control" id="password" name = "j_password">
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox" name="_spring_security_remember_me"><spring:message code="message.rememberme"/>
        </label>
    </div>
    <button type="submit" class="btn btn-primary"><spring:message code="signin"/></button>
</form>