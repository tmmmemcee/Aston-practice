<%--
  Created by IntelliJ IDEA.
  User: tmcnamara
  Date: 2/8/21
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="./includes/header.jsp"%>

<div class="container blueBackground">
    <div class="col-sm-6">
        <img src="${pageContex.servletContext.contextPath}/static/images/aston-technologies-logo.svg" alt="">
    </div>
    <br/>
    <div class="col-sm-4">
        <form action="<c:out value='/login.do'/>" method="POST">
            <c:if test="${not empty param.err}">
                <div class="msg-container error">
                    <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
                </div>
            </c:if>
            <c:if test="${not empty param.out}">
                <div class="msg-container out">
                    You've logged out successfully.
                </div>
            </c:if>
            <c:if test="${not empty param.time}">
                <div class="msg-container time">
                    You've logged out due to inactivity.
                </div>
            </c:if>

            <span class="text-white">Username:</span>
            <input type="text" name="username" value="" />
            <br><br>
            <span class="text-white">Password:</span>
            <input type="password" name="password" value="" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br/><br/>
            <input value="Login" name="submit" type="submit" class="btn btn-default" />

        </form>
    </div>
</div>
