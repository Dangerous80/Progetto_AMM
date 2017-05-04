<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<!--inseriamo le meta-informazioni della pagina-->
    <head>
        <title>NerdBook - Join the Herd</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Social Network per Nerd">
        <link rel="shortcut icon" type="image/x-icon" href="Asset/nerdLogo.jpg">
        <meta name="author" content="Daniele Pisano">
        <meta name="keywords" content="Nerd Star Wars world of warcraft scacchi dungeons and dragons software programmazione computer tecnologia giochi di ruolo film fantascienza serie tv fumetti videogiochi">
        <meta http-equiv="refresh" content="30">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>

    <body>
        <div id="pageProfilo">
            <!--verifichiamo che l'accesso alla pagina del profilo sia fatto da un utente autenticato-->
                <c:choose>
                    <c:when test="${accessoNonAutorizzato == true }">
                        <!--testata, la testata conterrà header, navbar ed il div di logout-->
                        <div id="header">
                            <!--inseriamo il titolo della pagina nell'header-->
                            <jsp:include page="header.jsp"/>                
                            <!--inseriamo una barra di navigazione che contenga i link alle altre pagine html che devono essere raggiunte-->
                            <c:set var="page" value="profilo" scope="request"/>
                            <jsp:include page="nav.jsp"/>
                        </div>
                        <div id="accessoNegato">
                            <div id='utenteNonAutorizzato'>
                                <p><strong>UTENTE NON AUTORIZZATO</strong></p>
                                <a id='goToLogin' href="login.jsp">Effettua l'accesso dalla Login</a>
                            </div>
                        </div>    
                    </c:when>
                    <c:otherwise>
                        <!--testata, la testata conterrà header, navbar ed il div di logout-->
                        <div id="header">
                            <!--inseriamo il titolo della pagina nell'header-->
                            <jsp:include page="header.jsp"/>                
                            <!--inseriamo una barra di navigazione che contenga i link alle altre pagine html che devono essere raggiunte-->
                            <c:set var="page" value="profilo" scope="request"/>
                            <jsp:include page="nav.jsp"/>
                            <!--inseriamo i dati utente per il logout-->
                            <div id="logout">
                                <img title="fotoProfiloUtente" alt="Foto Profilo" src="${nerd.urlFotoProfilo}">
                                <p id="name">${nerd.nome}</p>
                                <div id="pulsanteLogout">
                                    <a id="linkLogout" href="Login?logout=1">Logout</a>
                                </div>   
                            </div>
                        </div>   
                        <!--sidebar, inseriamo gli elementi per la ricerca di persone e Gruppi-->
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
                                            <c:if test="${not status.last}">
                                                <li><a href="Bacheca?group=${gruppo.id}"><img class="fotoGruppo" src="${gruppo.urlImmagineGruppo}" alt="Immagine Gruppo">${gruppo.nomeGruppo}</a></li>
                                            </c:if>
                                        </c:forEach>
                                    </ul>           
                                </li>
                            </ul>
                        </div>    
                        <!--contenuto, inseriamo la form per l'inserimento/modifica del profilo utente-->
                        <div id="contenutoProfilo">
                            <img title="fotoProfiloUtente" alt="Foto Profilo" src="${nerd.urlFotoProfilo}">
                            <div id="inputUtente">
                                <form action="Profilo" method="post">
                                    <label id="nome" for="nomeUtente">Nome</label>
                                    <input type="text" name="nomeUtente" id="nomeUtente" value="${nerd.nome}">                        
                                    <label id="cognome" for="cognomeUtente">Cognome</label>
                                    <input type="text" name="cognomeUtente" id="cognomeUtente" value="${nerd.cognome}">
                                    <label id="data" for="dataNascita">Nato il</label>
                                    <input type="date" name="dataNascita" id="dataNascita" value="${nerd.dataNascita}"> 
                                    <label id="frase" for="frasePresentazione">Frase di presentazione</label>
                                    <textarea rows="1" cols="35" name="frasePresentazione" id="frasePresentazione" >${nerd.frasePresentazione}</textarea>                        
                                    <label id="foto" for="fotoProfilo">Foto Profilo</label>
                                    <input type="url" name="fotoProfilo" id="fotoProfilo" value="${nerd.urlFotoProfilo}">                        
                                    <label id="password" for="pswdUtente">Password</label>
                                    <input type="password" name="pswdUtente" id="pswdUtente" value="${nerd.password}">                        
                                    <label id="conferma" for="pswdConferma">Conferma Password</label>
                                    <input type="password" name="pswdConferma" id="pswdConferma" value="${nerd.password}">
                                    <div id="pulsanteInvio">
                                        <button type="submit" name="pulsanteAggiornaDati" value="ok">Aggiorna</button>
                                    </div>
                                </form>
                            </div>
                            <c:if test="${aggiornamento == true}">
                                <div id="riepilogoAggiornamento"> 
                                    <p id="riepilogo"><strong>Riepilogo Aggiornamento</strong></p>
                                    <p><strong>Nome: </strong>${nome}</p>
                                    <p><strong>Cognome: </strong>${cognome}</p>
                                    <p><strong>Data di nascita: </strong>${data}</p>
                                    <p><strong>Frase di Presentazione: </strong>${frase}</p>
                                    <p><strong>Foto del profilo: </strong>${foto}</p>
                                    <p><strong>Password di accesso: </strong>${password}</p>
                                </div>
                            </c:if>    
                        </div>
                    </c:otherwise>
                </c:choose>
                <!--Validator CSS-->
                <div> 
                    <p>
                        <a id="icoCss" href="http://jigsaw.w3.org/css-validator/check/referer">
                            <img style="border:0;width:88px;height:31px" src="http://jigsaw.w3.org/css-validator/images/vcss-blue" alt="CSS Valido!" />
                        </a>
                    </p>
                </div>    
            </div>
        </div>
    </body>
</html>
