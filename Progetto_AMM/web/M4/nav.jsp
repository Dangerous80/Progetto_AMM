<%-- 
    Document   : descrizione
    Created on : 27-apr-2017, 14.58.06
    Author     : Pisano Daniele
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<nav id="linkPagine">
    <c:if test="${page=='bacheca'}">
        <ul>
            <li><a href="Profilo">Profilo</a></li>
            <li><a class="active" href="Bacheca">Bacheca</a></li>
        </ul>
    </c:if> 
    <c:if test="${page=='descrizione'}">
        <ul>
            <li><a href="Login">Login</a></li>
        </ul>
    </c:if> 
    <c:if test="${page=='login'}">
        <ul>
            <li><a href="descrizione.jsp">Descrizione</a></li>
        </ul> 
    </c:if>
    <c:if test="${page=='profilo'}">
        <ul>
            <li><a class="active" href="Profilo">Profilo</a></li>
            <li><a href="Bacheca">Bacheca</a></li>
        </ul>
    </c:if>
</nav>