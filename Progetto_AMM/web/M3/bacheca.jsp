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
        <link rel="shortcut icon" type="image/x-icon" href="../Asset/nerdLogo.jpg">
        <meta name="author" content="Daniele Pisano">
        <meta name="keywords" content="Nerd Star Wars word of warcraft scacchi dungeons and dragons software programmazione computer tecnologia giochi di ruolo film fantascienza serie tv fumetti videogiochi">
        <meta http-equiv="refresh" content="30">
        <link href="../CSS/style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <div id="pageBacheca">
            
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
                        <a id="linkLogout" href="login.html">Logout</a>
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
                    <form action="servlet.java" method="post">
                        <div id="contenutoPost">
                            <div id="areaTesto">
                                <textarea name="testoPost" id="testoPost" rows="2" cols="40"></textarea><br>
                            </div>
                            <div id="areaUrl">
                                <input type="url" name="urlPost" value="" id="urlPost">
                            </div>    
                        </div>
                        <div id="tipoPost">
                            <input type="radio" name="tipoPost" value="imgType" id="tipoImmagine">
                            <label for="tipoImmagine">Immagine</label>
                            <input type="radio" name="tipoPost" value="linkType" id="tipoLink">
                            <label for="tipoLink">Link</label>
                            <div id='creaPost'>
                               <button type="submit" id="pulsanteCreaPost">Crea Post</button>
                            </div>
                        </div>    
                    </form>
                </div>
                <!--Inseriamo i post da visualizzare sulla Bacheca-->
                <div id="bacheca">
                    <!--lista dei post-->
                    <div id="posts">
                        <c:forEach var="post" items="${posts}">
                            <div class="post">
                                <c:if test="${post.postType == 'TEXT'}">
                                    <img title="fotoProfilo1" alt="Foto Profilo" src="${post.autore.urlFotoProfilo}">
                                    <p id="userName1">${post.autore.nome}</p>
                                    <p id="testoPost1">${post.testo}</p>
                                </c:if>
                                <c:if test="${post.postType == 'IMAGE'}">
                                    <img title="fotoProfilo2" alt="Foto Profilo" src="${post.autore.urlFotoProfilo}">
                                    <p id="userName2">${post.autore.nome}</p>
                                    <p id="testoPost2">${post.testo}</p>
                                    <img id="immagineAllegata" title="ImmaginePost2" alt="Immagine Post" src="${post.contenuto}">
                                </c:if>
                                <c:if test="${post.postType == 'URL'}">
                                    <img title="fotoProfilo3" alt="Foto Profilo" src="${post.autore.urlFotoProfilo}">
                                    <p id="userName3">${post.autore.nome}</p>
                                    <p id="testoPost3">${post.testo}</p>
                                    <a Id="allegato3" href="${post.contenuto}">Allegato</a>
                                </c:if>    
                            </div>
                        </c:forEach>
            </div>
            <!--Validator CSS-->
            <div> 
                <p>
                    <a id="icoCss" href="http://jigsaw.w3.org/css-validator/check/referer">
                       <img style="border:0;width:88px;height:31px"
                           src="http://jigsaw.w3.org/css-validator/images/vcss-blue"
                           alt="CSS Valido!" />
                    </a>
                </p>
            </div>
        </div>
    </body>
</html>
