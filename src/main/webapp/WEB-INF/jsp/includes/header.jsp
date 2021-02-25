<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <!--- JQUERY -->
        <c:url value="/webjars/jquery/2.1.4/jquery.min.js" var="jquery" />
            <script src="${jquery}"></script>

        <!--- BOOTSTRAP--->
        <c:url value="/webjars/bootstrap/3.3.4/js/bootstrap.min.js" var="bootstrapJS" />
            <script src="${bootstrapJS}"></script>
        <c:url value="/webjars/bootstrap/3.3.4/css/bootstrap.min.css" var="bootstrapCSS" />
            <link href="${bootstrapCSS}" rel="stylesheet" media="screen">

        <!-- CUSTOM JS -->
        <c:url value="/static/js/common.js" var="common" />
            <script src="${common}"></script>
        <!--- CUSTOM CSS -->
        <c:url value="/static/css/astonengineer.css" var="bootstrapCUSTOM" />
            <link href="${bootstrapCUSTOM}" rel="stylesheet" media="screen">
        <title>Aston Tchnologies HR Application</title>

    </head>
    <body>



    <!--FOOTER-->

    </body>
</html>