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
        <meta http-equiv="refresh" content="240">
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
                        <jsp:include page="sidebar.jsp"/>
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
                                    <div id="pulsanteCancellaUtente">
                                        <button type="submit" name="pulsanteCancellaUtente" value="ok">Cancella Utente</button>
                                    </div>
                                </form>
                            </div>
                            <c:if test="${warningData == true}">
                                <div id="dataNonValida"> 
                                    <p id="messaggioErroreData"><strong>Data Non Valida - inserire la data nel formato dd/mm/yyyy</strong></p>
                                    <form action="Profilo" method="post">
                                        <button type="submit" id="pulsanteReinserimentoData" name="pulsanteReinserimentoData">OK</button>
                                    </form>
                                </div>
                            </c:if>
                            <c:if test="${esitoCancellazione == true}">
                                <div id="cancellazioneUtente"> 
                                    <p id="messaggioCancellazioneUtente"><strong>Utente Cancellato</strong></p>
                                    <form action="Login?logout=1" method="post">
                                        <button type="submit" id="pulsanteTornaAllaLogin" name="pulsanteTornaAllaLogin">OK</button>
                                    </form>
                                </div>
                            </c:if> 
                            <c:if test="${esitoCancellazione == false}">
                                <div id="cancellazioneUtente"> 
                                    <p id="messaggioCancellazioneUtente"><strong>Utente Non Cancellato</strong></p>
                                    <form action="Profilo" method="post">
                                        <button type="submit" id="pulsanteTornaAlProfilo" name="pulsanteTornaAlProfilo">OK</button>
                                    </form>
                                </div>
                            </c:if>        
                            <c:if test="${aggiornamento == true}">
                                <div id="riepilogoAggiornamento"> 
                                    <p id="riepilogo"><strong>Riepilogo Aggiornamento</strong></p>
                                    <p><strong>Nome: </strong>${nome}</p>
                                    <p><strong>Cognome: </strong>${cognome}</p>
                                    <p><strong>Data di nascita: </strong>${data}</p>
                                    <p><strong>Frase di Presentazione: </strong>${frase}</p>
                                    <p><strong>Foto del profilo: </strong>${foto}</p>
                                    <p><strong>Password di accesso: </strong>${password}</p>
                                    <form action="Profilo" method="post">
                                        <button type="submit" id="pulsanteOk" name="pulsanteOk">OK</button>
                                    </form>
                                </div>
                            </c:if>    
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </body>
</html>
