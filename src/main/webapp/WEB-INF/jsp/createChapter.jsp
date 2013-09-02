<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h1 align="center">
    <spring:message code="chapter.create"/>
</h1>

<div class="span6 offset3">

    <form class="form-horizontal" id="createChapter" action="addChapter"
          method="POST"  >

        <div class="control-group">
            <label class="control-label" for="name"><spring:message code="book.chapter"/></label>
            <div class="controls">
                <input type="text" id="name" name="name" placeholder="<spring:message code="book.chapter"/>">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="content"><spring:message code="chapter.content"/></label>
            <div class="controls">
                <textarea class = "form-control" rows = "5" type="text" id="content" name="content" placeholder="<spring:message code="chapter.content"/>"></textarea>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <button type="submit" class="btn btn-primary"><spring:message code="registration.do" text="Continue" /></button>
            </div>
        </div>
    </form>
</div>
            