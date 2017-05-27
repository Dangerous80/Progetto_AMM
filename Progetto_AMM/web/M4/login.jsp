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
        <meta http-equiv="refresh" content="30">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>

    <body>
        <div id="pageLogin">
            <!--testata, la testata conterrà header e navbar-->
            <div id="header">
                <!--inseriamo il titolo della pagina nell'header-->
                <jsp:include page="header.jsp"/>                
                <!--inseriamo una barra di navigazione che contenga i link alle altre pagine html che devono essere raggiunte-->
                <c:set var="page" value="login" scope="request"/>
                <jsp:include page="nav.jsp"/>
            </div>
            <!--contenuto, inseriamo la form per richiedere userid e password all'utente che vuole effettuare l'accesso-->
            <div id="contenutoLogin">
                <img src='Asset/nerd.jpg' alt='Logo NerdBook'>
                <h1>NerdBook</h1>
                <form action="Login" method="post">
                    <div id=inputDatiUtente>
                        <label for="username">Nome Utente</label>
                        <input type="text" name="username" id="username" value="">
                        <label for="password">Password</label>
                        <input type="password" name="password" id="password" value="">
                        <div id="pulsanteValidazione">
                            <button type="submit">Accedi</button>
                        </div>    
                    </div>
                </form>
                <!--inseriamo il test di verifica dei dati inseriti dall'utente e se non sono validi si inserisce il messaggio di errore-->
                <c:if test="${invalidData == true}">
                    <div id="invalidDataWarning">
                        <p id="frase1">Dati inseriti non validi</p>
                        <p id="frase2">Ripetere Login</p>
                    </div>
                </c:if>
            </div>
        </div>
   </body>
</html>
