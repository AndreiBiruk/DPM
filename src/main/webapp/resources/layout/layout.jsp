<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <title><tiles:insertAttribute name="title" ignore="true" /></title>
    <link href="../../resources/css/bootstrap.css" rel="stylesheet">
    <script src="../../resources/js/jquery-2.0.3.min.js"></script>
    <script src="../../resources/js/bootstrap.min.js"></script>
</head>
<body>
    <div class = "row">
        <tiles:insertAttribute name = "header" ignore = "true"/>
    </div>
    <div class = "row">
        <tiles:insertAttribute name = "footer" ignore = "true"/>
    </div>
</body>