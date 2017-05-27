<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--inseriamo le meta-informazioni della pagina-->
<head>
    <title>NerdBook - Join the Herd</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Social Network per Nerd">
    <link rel="shortcut icon" type="image/x-icon" href="Asset/nerdLogo.jpg">
    <meta name="author" content="Daniele Pisano">
    <meta name="keywords" content="Nerd Star Wars world of warcraft scacchi dungeons and dragons software programmazione computer tecnologia giochi di ruolo film fantascienza serie tv fumetti videogiochi">
    <meta http-equiv="refresh" content="240">
    <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    <script src="JS/jquery-3.2.1.min.js"></script>
    <script src="JS/javascript.js"></script>
</head>

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
                <c:forEach var="nerd" items="${listaUtenti}">
                    <li><a href="Bacheca?user=${nerd.id}"><img class="fotoPersona" src="${nerd.urlFotoProfilo}" alt="Foto Persona">${nerd.nome} ${nerd.cognome}</a></li>
                </c:forEach>
            </ul>           
        </li>
        <li id="gruppi">
            <h2>Gruppi</h2>
            <form action="Profilo" method="post">
                <div id="aggiungiGruppi">
                    <button type="submit" id="pulsanteAggiungiGruppi">
                        <img src="Asset/add.jpg" alt="aggiungi gruppi">
                    </button>
                </div>
            </form>
            <ul>
                <c:forEach var="gruppo" items="${listaGruppi}" varStatus="status">
                    <li><a href="Bacheca?group=${gruppo.id}"><img class="fotoGruppo" src="${gruppo.urlImmagineGruppo}" alt="Immagine Gruppo">${gruppo.nomeGruppo}</a></li>
                </c:forEach>
            </ul>           
        </li>
    </ul>
</div>
