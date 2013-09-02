<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h1 align="center">
    <spring:message code="registration.registration" text="Registration" />
</h1>

<div class="span6 offset3">

    <form class="form-horizontal" id="registration" action="addBook"
          method="POST"  >

        <div class="control-group">
            <label class="control-label" for="username"><spring:message code="book.name"/></label>
            <div class="controls">
                <input type="text" id="username" name="username" placeholder="<spring:message code="book.name"/>">
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <button type="submit" class="btn btn-primary"><spring:message code="registration.do" text="Continue" /></button>
            </div>
        </div>
    </form>
</div>
            