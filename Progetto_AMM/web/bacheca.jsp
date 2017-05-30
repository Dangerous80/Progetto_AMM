<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    
    <div id="pageBacheca">
        <!--verifichiamo che l'accesso alla pagina della bacheca sia fatto da un utente autenticato-->
                <c:choose>
                    <c:when test="${accessoNonAutorizzato == true }">
                        <!--testata, la testata conterrà header, navbar ed il div di logout-->
                        <div id="header">
                            <!--inseriamo il titolo della pagina nell'header-->
                            <jsp:include page="header.jsp"/>                
                            <!--inseriamo una barra di navigazione che contenga i link alle altre pagine html che devono essere raggiunte-->
                            <c:set var="page" value="bacheca" scope="request"/>
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
                            <c:set var="page" value="bacheca" scope="request"/>
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
                        <!--contenuto-->
                        <div id="contenutoBacheca">     
                            <!--inseriamo i dati dell'utente proprietario della bacheca-->
                            <div id="infoUtente">
                                <img title="fotoProfiloUtente" alt="Foto Profilo" src="${nerd.urlFotoProfilo}">
                                <p id="userName"><p>${nerd.nome}</p>
                                <p>:</p>
                                <p id="fraseBacheca">${nerd.frasePresentazione}</p>
                            </div>        
                            <!--inseriamo gli elementi per la definizione dei nuovi post-->
                            <div id="formNewPost">
                                <form action="Bacheca" method="post">
                                    <div id="contenutoPost">
                                        <div id="areaTesto">
                                            <textarea name="testoPost" id="testoPost" rows="2" cols="40"></textarea><br>
                                        </div>
                                        <div id="areaUrl">
                                            <input type="url" name="urlPost" value="" id="urlPost">
                                        </div>    
                                    </div>
                                    <div id="tipoPost">
                                        <input type="radio" name="tipoPost" value="immagine" id="tipoImmagine">
                                        <label for="tipoImmagine">Immagine</label>
                                        <input type="radio" name="tipoPost" value="url" id="tipoLink">
                                        <label for="tipoLink">Link</label>
                                        <div id='creaPost'>
                                            <c:if test="${bachecaUtente != null}">
                                                <input type="hidden" name="user" value="${bachecaUtente}"/>
                                            </c:if> 
                                            <c:if test="${bachecaGruppo != null}">
                                                <input type="hidden" name="group" value="${bachecaGruppo}"/>
                                            </c:if>
                                            <button type="submit" id="pulsanteCreaPost" name="pulsanteCreaPost" value="true">Crea Post</button>
                                        </div>
                                    </div>    
                                </form>
                                <!--riepilogo post inserito-->
                                <c:if test="${inserimento == true}">
                                <div id="riepilogoPost"> 
                                    <p id="riepilogo"><strong>Riepilogo Post</strong></p>
                                    <p id="testo"><strong>Testo: </strong>${testo}</p>
                                    <p id="url"><strong>Url: </strong>${url}</p>
                                    <p id="tipo"><strong>Tipo Post: </strong>${tipo}</p>
                                    <form action="Bacheca" method="post">
                                        <c:if test="${bachecaUtente != null}">
                                            <input type="hidden" name="user" value="${bachecaUtente}"/>
                                        </c:if> 
                                        <c:if test="${bachecaGruppo != null}">
                                            <input type="hidden" name="group" value="${bachecaGruppo}"/>
                                        </c:if>
                                            <input type="hidden" name="testo" value="${testo}"/>
                                            <input type="hidden" name="url" value="${url}"/>
                                            <input type="hidden" name="tipo" value="${tipo}"/>
                                        <button type="submit" id="pulsanteConferma" name="pulsanteConferma" value="true">Inserisci post</button>
                                    </form> 
                                </div>
                                </c:if>
                                <!--conferma inserimento post-->
                                <c:if test="${conferma == true}">
                                    <div id="confermaPost">
                                        <p><strong>Hai scritto nella bacheca di: </strong>${bacheca}</p>
                                        <form action="Bacheca" method="post">
                                            <c:if test="${bachecaUtente != null}">
                                                <input type="hidden" name="user" value="${bachecaUtente}"/>
                                            </c:if> 
                                            <c:if test="${bachecaGruppo != null}">
                                                <input type="hidden" name="group" value="${bachecaGruppo}"/>
                                            </c:if>
                                            <button type="submit" id="pulsanteOk" name="pulsanteOk" value="true">OK</button>
                                        </form>
                                    </div> 
                                </c:if>    
                            </div>    
                            <!--Inseriamo i post da visualizzare sulla Bacheca-->
                            <div id="bacheca">
                                <c:forEach var="post" items="${posts}">
                                    <div class="post">
                                        <!--post di tipo testuale-->
                                        <c:if test="${post.postType == 'TEXT'}">
                                            <img alt="Foto Autore" src="${post.autore.urlFotoProfilo}">
                                            <p class="userName">${post.autore.nome}</p>
                                            <p class="testoPost">${post.testo}</p>
                                        </c:if>
                                        <!--post di tipo testo più immagine-->    
                                        <c:if test="${post.postType == 'IMAGE'}">
                                            <img alt="Foto Autore" src="${post.autore.urlFotoProfilo}">
                                            <p class="userName">${post.autore.nome}</p>
                                            <p class="testoPost">${post.testo}</p>
                                            <img class="immagineAllegata" title="ImmaginePost" alt="Immagine Post" src="${post.contenuto}">
                                        </c:if>
                                        <!--post di tipo testo più allegato-->    
                                        <c:if test="${post.postType == 'URL'}">
                                            <img alt="Foto Autore" src="${post.autore.urlFotoProfilo}">
                                            <p class="userName">${post.autore.nome}</p>
                                            <p class="testoPost">${post.testo}</p>
                                            <a href="${post.contenuto}">${post.contenuto}</a>
                                        </c:if>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </c:otherwise>            
                </c:choose>
            </div>
        </div>
    </body>
</html>
