<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<nav id="linkPagine">
    <c:if test="${page=='bacheca'}">
        <ul>
            <li><a href="profilo.jsp">Profilo</a></li>
            <li><a class="active" href="bacheca.jsp">Bacheca</a></li>
        </ul>
    </c:if> 
    <c:if test="${page=='descrizione'}">
        <ul>
            <li><a href="login.jsp">Login</a></li>
        </ul>
    </c:if> 
    <c:if test="${page=='login'}">
        <ul>
            <li><a href="descrizione.jsp">Descrizione</a></li>
            <li><a href="profilo.jsp">Profilo</a></li>
            <li><a href="bacheca.jsp">Bacheca</a></li>
        </ul> 
    </c:if>
    <c:if test="${page=='login'}">
        <ul>
            <li><a class="active" href="profilo.jsp">Profilo</a></li>
            <li><a href="bacheca.jsp">Bacheca</a></li>
        </ul>
    </c:if>
</nav>