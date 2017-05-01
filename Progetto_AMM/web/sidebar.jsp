<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div id="sidebar">
    <!--barra ricerca-->
        <form action="Profilo" method="post">
            <div id="ricerca">
                <input type="text" name="cerca" value="Cerca.." id="cerca">
                <button type="submit" id="pulsanteRicerca">
                    <img src="Asset/lente.png" alt="lente">
                </button>
            </div>
        </form>
    <!--elenco persone-->
        <ul>
            <li id="persone">
                <h2>Persone</h2>
                <ul>
                    <c:forEach var="nerd" items="${nerds}">
                        <li><a href="Bacheca?user=${nerd.id}"><img class="fotoPersona" src="${nerd.urlFotoProfilo}" alt="Foto Persona">${nerd.nome} ${nerd.cognome}</a></li>
                    </c:forEach>
                </ul>           
            </li>
            <li id="gruppi">
                <h2>Gruppi</h2>
                <form action="servlet.java" method="post">
                    <div id="aggiungiGruppi">
                        <button type="submit" id="pulsanteAggiungiGruppi">
                            <img src="Asset/add.jpg" alt="aggiungi gruppi">
                        </button>
                    </div>
                </form>
                <ul>
                    <c:forEach var="gruppo" items="${groups}">
                        <li><a href="Bacheca?user=${gruppo.id}"><img class="fotoGruppo" src="${gruppo.urlImmagineGruppo}" alt="Immagine Gruppo">${gruppo.nome}</a></li>
                    </c:forEach>
                </ul>           
            </li>
        </ul>
</div>     

