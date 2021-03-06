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
        <div id="pageDescrizione">
            <!--testata, la testata conterrà header, navbar ed il div di logout-->
            <div id="header">
                <!--inseriamo il titolo della pagina nell'header-->
                <jsp:include page="header.jsp"/>                
                <!--inseriamo una barra di navigazione che contenga i link alle altre pagine html che devono essere raggiunte-->
                <c:set var="page" value="descrizione" scope="request"/>
                <jsp:include page="nav.jsp"/>
            <!--sommario-->
            <div id="sommario">
                <!--inseriamo il sommario con i link interni al documento-->
                <h1>Sommario</h1>
                <ul>
                    <li><a href="#socialNetwork">Cosa è un Social Network</a></li>
                    <li><a href="#descrizioneNerdbook">Cosa è NerdBook e a chi si rivolge</a>
                    <li><a href="#nerd">Chi sono i Nerd</a></li>
                    <li><a href="#costo">Quanto costa iscriversi a NerdBook</a>
                        <ul>
                            <li><a href="#account">Tipi di account di NerdBook</a></li>
                            <li><a href="#iscrizione">Come accedere a NerdBook</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!--contenuto-->  
            <div id="contenutoDescrizione">
                <!--Inseriamo la descrizione dei social network-->
                <a id="socialNetwork">
                    <h1>Cosa è un Social Network</h1>
                </a>
                    <p>Un social network è un gruppo di persone legate tra loro da legami sociali di vario tipo, come conoscenza casuale, rapporti di lavoro o vincoli familiari.
                       Negli ultimi anni, si usa il termine social network per indicare le versioni informatiche e virtuali di queste reti sociali, nate grazie allo sviluppo della rete Internet.
                       Il fenomenoo dei social network virtuali nasce negli Stati Uniti nei primi anni 2000 e si è inizialmente sviluppato attorno a tre grandi filoni tematici, quello professionale, quello dell'amicizia e ovviamente
                       quello delle relazioni amorose.
                       All'interno di un social network è consentito ad ogni utente di creare un profilo pubblico o semi-pubblico, definire una lista di contatti a cui inviare messaggi, scorrere la lista di amici dei propri contatti. 
                       Attraverso tutto questo il social network consente di gestire e rinsaldare online amicizie preesistenti o di estendere la propria rete di amici.
                       Per entrare a far parte di un social network occorre definire un proprio profilo personale, indicando tra le informazioni i propri interessi e le proprie passioni.
                       Una volta creato il proprio profilo è possibile invitare i propri amici a far parte del proprio network, i quali a loro volta possono fare lo stesso, 
                       in questo modo ci si trova ad allargare la cerchia di contatti con gli amici degli amici e così via.
                    </p>            
               
                <!--Inseriamo la descrizione di cosa è NerdBook-->
                <a id="descrizioneNerdbook">
                    <h1>Cosa è NerdBook e a chi si rivolge</h1>
                </a>
                    <p>NerdBook è un social network rivolto a tutti i Nerd o aspiranti tali che desiderano stringere amicizie, condividere passioni, materiale ed informazioni di comune interesse.</p>
                <!--Inseriamo la descrizione di chi sono i Nerd-->
                <a id="nerd">
                    <h2>Chi sono i Nerd</h2>
                </a>
                    <p>Un giorno in un liceo degli Stati Uniti, Bill Gates tenne un discorso rivolto a una giovane platea. Nel suo discorso parlò di 11 regole. Undici regole che non si imparano sui banchi di scuola.l'undicesima regola recita testualmente:</p>
                    <p><strong>"Siate gentili con i nerd e i secchioni. È molto probabile che un domani vi ritroviate a lavorare per uno di loro!"</strong></p>
                    <p>Il termine Nerd è un termine della lingua inglese con cui viene definito chi ha una certa predisposizione per la tecnologia ed è al contempo tendenzialmente solitario e con una più o meno ridotta propensione alla socializzazione.
                       Tale termine è nato come dispregiativo, ma in seguito è stato reclamato in alcuni ambiti per definire una sorta di orgoglio e di identità di gruppo.
                       Lo stereotipo vede queste persone interesate ad attività non popolari, in tali attività solitamente ricadono quelle di natura informatica e quelle riguardanti la scienza e la matematica.
                       I Nerd sono inoltre considerati poco interessati alle attività sportive e sociali e non hanno significativi contatti con l'altro sesso. Anche l'aspetto esteriore è rappresentato da un cliché ben definito, nella visione generale i Nerd indossano vestiti non alla moda,
                       spesso tipici di persone più in là con gli anni (come gilet o mocassini), occhiali spessissimi, visi colmi di brufoli e pustole, pettinature piatte come il riporto, e difetti nel modo di parlare. 
                       Un ulteriore stereotipo vede i Nerd ridicolizzati e sottoposti ad angherie (bullismo) da parte di chi è più popolare.
                       I Nerd hanno inoltre la reputazione di impegnarsi a fondo negli studi a cui sono interessati ed esprimono generalmente un interesse superiore alla norma per argomenti complessi e spesso eccellono in più materie. 
                       Argomenti che hanno a che fare con i computer e la tecnologia, i giochi di ruolo, i film di fantascienza, le serie tv, i fumetti, i videogiochi (generalmente ogni tipo di MMORPG che richieda varie ore di gioco) e la letteratura fantasy sono adesso tipicamente associati con i nerd.
                    </p>
                <!--Inseriamo la descrizione del costo di utilizzo di nerdBook-->
                <a id="costo">
                    <h2>Quanto costa iscriversi a NerdBook</h2>
                </a>
                    <p>L'iscrizione a NerdBook è completamente gratuita, priva di scadenza. Chiunque può crearsi gratuitamente un proprio profilo e comunicare ed interagire facilmente con altri membri della community in modo da condividere via web pensieri, foto, musica e altri interessi</p>
                <!--Inseriamo la descrizione dei tipi di account previsti-->
                <a id="account">
                    <h3>Tipi di account di NerdBook</h3>
                </a>
                    <p>Esistono solo due tipi di account, standard ed Adminisstrator.Non sono previsti account Pro o Premium pertanto non verrà richiesto nessun pagamento aggiuntivo alla creazione del profilo.</p>
                <!--Inseriamo la descrizione di come iscriversi-->
                <a id="iscrizione">
                    <h3>Come accedere a NerdBook</h3>
                </a>
                    <p>Per accedere a NerdBook clicca sul link "NerdBook Login" inserito nella barra di navigazione, inserisci Userid e password. Se non possiedi un profilo creane uno, potrai inserire una frase ed una foto nella tua bacheca personale.</p>
            </div>
        </div>
    </body>
</html>
