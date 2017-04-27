<%-- 
    Document   : descrizione
    Created on : 27-apr-2017, 14.58.06
    Author     : Pisano Daniele
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<div id="sidebar">
    <!--barra ricerca-->
        <form action="servlet.java" method="post">
            <div id="ricerca">
                <input type="text" name="cerca" value="Cerca.." id="cerca">
                <button type="submit" id="pulsanteRicerca">
                    <img src="../Asset/lente.png" alt="lente">
                </button>
            </div>
        </form>
    <!--elenco persone-->
        <ul>
            <li id="persone">
                <h2>Persone</h2>
                <ul>
                    <li><a href="bacheca.html"><img id="fotoPersona1" src="../Asset/images.jpg" alt="foto">Pinco Pallino</a></li>
                    <li><a href="bacheca.html"><img id="fotoPersona2" src="../Asset/images.jpg" alt="foto">Riccardo Rossi</a></li>
                    <li><a href="bacheca.html"><img id="fotoPersona3" src="../Asset/images.jpg" alt="foto">Mario Bianchi</a></li>
                </ul>           
            </li>
            <li id="gruppi">
                <h2>Gruppi</h2>
                <form action="servlet.java" method="post">
                    <div id="aggiungiGruppi">
                        <button type="submit" id="pulsanteAggiungiGruppi">
                            <img src="../Asset/add.jpg" alt="aggiungi gruppi">
                        </button>
                    </div>
                </form>
                <ul>
                    <li><a id="starTrek" href="bacheca.html"><img id="immagineGruppo1" src="../Asset/StarTrek.png" alt="foto">Star Trek</a></li>
                    <li><a id="starWars" href="bacheca.html"><img id="immagineGruppo2" src="../Asset/StarWars.jpg" alt="foto">Star Wars</a></li>
                </ul>           
            </li>
        </ul>
</div>     

