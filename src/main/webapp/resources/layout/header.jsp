<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<nav class="navbar navbar-default">
    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value="/home"/>">
                <i class = "icon icon-apple"></i>
                <i class = "icon icon-android"></i>
                <]:{)
                <i class = "icon icon-windows"></i>
                <i class = "icon icon-linux"></i>
            </a>
        </div>
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <li class = "btn-group">
                <security:authorize  access="isAnonymous()">
                    <a class = "btn btn-link" href="<c:url value="/registration"/>">
                        <i class="icon-book icon-large"></i>
                        <spring:message code="signup"/>
                    </a>
                    <a class = "btn btn-link" href="<c:url value="/login"/>">
                        <i class="icon-signin icon-large"></i>
                        <spring:message code="signin"/>
                    </a>
                </security:authorize>
            </li>
            <li class = "btn-group">
                <security:authorize  access="isAuthenticated()">
                    <a class = "btn btn-link" href="/users">
                        <i class="icon-user icon-large"></i>
                        <security:authentication property="principal.username"/>
                    </a>
                    <a class = "btn btn-link" href="<c:url value="/j_spring_security_logout"/>">
                        <i class="icon-signout icon-large"></i>
                        <spring:message code="signout"/>
                    </a>
                </security:authorize>
            </li>
            <li class="btn-group">
                <a class="btn btn-link dropdown-toggle" data-toggle="dropdown">
                    <i class="icon-gear icon-large"></i>
                    <spring:message code="settings"/>
                    <i class="icon-caret-down"></i>
                </a>
                <ul class="dropdown-menu">
                    <li class="dropdown-header"><spring:message code="language"/></li>
                    <li><a href="?language=en">English</a></li>
                    <li><a href="?language=ru">Русский</a></li>
                    <li class="divider"></li>
                    <li class="dropdown-header"><spring:message code="theme"/></li>
                    <li><a href="?theme=light"><spring:message code="light"/></a></li>
                    <li><a href="?theme=dark"><spring:message code="dark"/></a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
