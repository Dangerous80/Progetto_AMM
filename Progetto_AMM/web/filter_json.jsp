<%-- 
    Document   : filter_json
    Created on : 30-mag-2017, 16.35.36
    Author     : en26062
--%>
<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="nerd" items="${listaUtenti}">
        <json:object>
            <json:property name="id" value="${nerd.id}"/>
            <json:property name="nome" value="${nerd.nome}"/>
            <json:property name="cognome" value="${nerd.cognome}"/>
            <json:property name="dataNascita" value="${nerd.dataNascita}"/>
            <json:property name="frasePresentazione" value="${nerd.frasePresentazione}"/>
            <json:property name="urlFotoProfilo" value="${nerd.urlFotoProfilo}"/>
            <json:property name="password" value="${nerd.password}"/>
            <json:property name="tipoUtente" value="${nerd.tipoUtente}"/>
        </json:object>
    </c:forEach>
</json:array>