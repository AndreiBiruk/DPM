<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <c:set var = "title"><tiles:insertAttribute name="title" ignore="true"/></c:set>
    <title><spring:message code = "${title}"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<spring:theme code="stylesheet"/>" type="text/css"/>
    <link rel="stylesheet" href="../../resources/css/font-awesome.min.css" type="text/css"/>
    <script src="../../resources/js/jquery-2.0.3.min.js"></script>
    <script src="../../resources/js/bootstrap.min.js"></script>
</head>
<body>
    <div class = "container">
        <div class = "row">
            <tiles:insertAttribute name = "header" ignore = "true"/>
        </div>
        <div class = "row">
            <tiles:insertAttribute name = "body" ignore = "true"/>
        </div>
        <div class = "row">
            <tiles:insertAttribute name = "footer" ignore = "true"/>
        </div>
    </div>
</body>
