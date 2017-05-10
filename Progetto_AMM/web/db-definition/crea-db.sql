/*Database Name: NERDBOOK
User Name: Dangerous80	
Password DarkSchneider*/

--Tabella NERD--
CREATE TABLE nerd(
id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
nome VARCHAR (256),
cognome VARCHAR (256),
dataNascita VARCHAR (10),
frasePresentazione VARCHAR (256),
urlFotoProfilo VARCHAR (256),
password VARCHAR (256),
tipoUtente INTEGER,
FOREIGN KEY (tipoUtente) REFERENCES nerdType(id)
);

--Tabella NERDTYPE--
CREATE TABLE nerdType(
id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
abilitazione VARCHAR (32)
);

--Tabella AMICIZIA--
CREATE TABLE amicizia(
follower INTEGER,
followed INTEGER,
FOREIGN KEY (follower) REFERENCES nerd(id),
FOREIGN KEY (followed) REFERENCES nerd(id),
PRIMARY KEY (follower,followed)
);

--Tabella GRUPPO--
CREATE TABLE gruppo(
id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
creatoreGruppo INTEGER,
FOREIGN KEY (creatoreGruppo) REFERENCES nerd(id),
nomeGruppo VARCHAR(256),
urlImmagineGruppo VARCHAR (256)
);

--Tabella ISCRIZIONEGRUPPO--
CREATE TABLE iscrizioneGruppo(
idIscritto INTEGER,
idGruppo INTEGER,
FOREIGN KEY (idIscritto) REFERENCES nerd(id),
FOREIGN KEY (idGruppo) REFERENCES gruppo(id),
PRIMARY KEY (idIscritto,idGruppo)
);

--Tabella POST--
CREATE TABLE post(
id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
autore INTEGER,
FOREIGN KEY (autore) REFERENCES nerd(id),
testo VARCHAR (1024),
contenuto VARCHAR (1024),
tipoPost INTEGER,
FOREIGN KEY (tipoPost) REFERENCES postType(id),
userReciver INTEGER,
FOREIGN KEY (userReciver) REFERENCES nerd(id),
groupReciver INTEGER,
FOREIGN KEY (groupReciver) REFERENCES gruppo(id)
);

--Tabella POSTTYPE--
CREATE TABLE postType(
id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
tipo VARCHAR (32)
);

--Popoliamo ora le tabelle--

--Popoliamo la tabella nerdType--
INSERT INTO nerdType(id, abilitazione)
VALUES(default,
       'ADMIN'
);

INSERT INTO nerdType(id, abilitazione)
VALUES(default,
       'USER'
);

--Popoliamo la tabella nerd con i dati inseriti nella factory--
INSERT INTO nerd(id, nome, cognome, dataNascita, frasePresentazione, urlFotoProfilo, password, tipoUtente)
VALUES(default,
       'Mario',
       'Rossi',
       '10/11/1992',
       'Che la forza sia con te',
       'http://localhost:8080/Progetto_AMM/Asset/Yoda.jpg',
       '12345',
       1
);

INSERT INTO nerd(id, nome, cognome, dataNascita, frasePresentazione, urlFotoProfilo, password, tipoUtente)
VALUES(default,
       'Luca',
       'Viale',
       '15/12/1996',
       'Welcome to my jungle',
       'http://localhost:8080/Progetto_AMM/Asset/Luke.jpg',
       '12345',
       2
);

INSERT INTO nerd(id, nome, cognome, dataNascita, frasePresentazione, urlFotoProfilo, password, tipoUtente)
VALUES(default,
       'Francesco',
       'Marras',
       '15/08/1991',
       'Mantenete la curvatura',
       'http://localhost:8080/Progetto_AMM/Asset/kirk.jpg',
       '12345',
       2
);

INSERT INTO nerd(id, nome, cognome, dataNascita, frasePresentazione, urlFotoProfilo, password, tipoUtente)
VALUES(default,
       'Gianluca',
       'Ghidoli',
       '15/12/1989',
       'Lunga vita e prosperit�',
       'http://localhost:8080/Progetto_AMM/Asset/spock.jpg',
       '12345',
       2
);

INSERT INTO nerd(id, nome, cognome, dataNascita, frasePresentazione, urlFotoProfilo, password, tipoUtente)
VALUES(default,
       'Elenia',
       'Loche',
       '15/10/1996',
       'Ciao a tutti',
       'http://localhost:8080/Progetto_AMM/Asset/Leila.jpg',
       '12345',
       2
);

INSERT INTO nerd(id, nome, cognome, dataNascita, frasePresentazione, urlFotoProfilo, password, tipoUtente)
VALUES(default,
       'Marco',
       'Zuddas',
       '11/07/1981',
       'Viva i draghi',
       'http://localhost:8080/Progetto_AMM/Asset/artorias.jpg',
       '12345',
       2
);

--Popoliamo la tabella amicizia--
INSERT INTO amicizia(follower,followed)
VALUES(1,2),
      (2,1),
      (1,5),
      (2,5),
      (5,1),
      (5,2),
      (3,4),
      (4,3);

--Popoliamo la tabella gruppo con i dati inseriti nella factory-- 
INSERT INTO gruppo(id, creatoreGruppo, nomeGruppo,urlImmagineGruppo)
VALUES(default,
       1,
       'Star Wars',
       'http://localhost:8080/Progetto_AMM/Asset/StarWars.jpg'
);

INSERT INTO gruppo(id, creatoreGruppo, nomeGruppo,urlImmagineGruppo)
VALUES(default,
       3,
       'Star Trek',
       'http://localhost:8080/Progetto_AMM/Asset/StarTrek.png'
);

INSERT INTO gruppo(id, creatoreGruppo, nomeGruppo,urlImmagineGruppo)
VALUES(default,
       6,
       'D&D',
       'http://localhost:8080/Progetto_AMM/Asset/dungeons&dragons.jpg'
);


--Popoliamo la tabella iscrizioneGruppo--
INSERT INTO iscrizioneGruppo(idIscritto,idGruppo)
VALUES(1,1),
      (2,1),
      (5,1),
      (3,2),
      (4,2),
      (6,3);


--Popoliamo la tabella postType--
INSERT INTO postType(id, tipo)
VALUES(default,
       'TEXT'
);

INSERT INTO postType(id, tipo)
VALUES(default,
       'IMAGE'
);

INSERT INTO postType(id, tipo)
VALUES(default,
       'URL'
);


--Popoliamo la tabella post con i dati inseriti nella factory--
--Post 1 con immagine da Luke a Yoda--
INSERT INTO post(id, autore, testo, contenuto, tipoPost, userReciver, groupReciver)
VALUES(default,
       2,
       'Ti mando l immagine promessa di Star Wars',
       'http://localhost:8080/Progetto_AMM/Asset/StarWarsImg.jpg',
       2,
       1,
       null
);

--Post 2 testo da Yoda al gruppo Star Wars--
INSERT INTO post(id, autore, testo, contenuto, tipoPost, userReciver, groupReciver)
VALUES(default,
       1,
       'Che la forza sia con voi',
       null,
       1,
       null,
       1
);

--Post 3 con immagine da Spock a Kirk--
INSERT INTO post(id, autore, testo, contenuto, tipoPost, userReciver, groupReciver)
VALUES(default,
       4,
       'Ti mando l immagine promessa di Star Trek',
       'http://localhost:8080/Progetto_AMM/Asset/StarTrekImg.jpg',
       2,
       3,
       null
);

--Post 4 con URL da Kirk al gruppo Star Trek--
INSERT INTO post(id, autore, testo, contenuto, tipoPost, userReciver, groupReciver)
VALUES(default,
       3,
       'Mantenete sempre la barra di curvatura',
       'https://gaetaniumberto.files.wordpress.com/2014/05/star-trek-warp_h_partb.jpg',
       3,
       null,
       2
);

--Post 5 testuale da Leila a gruppo D&G--
INSERT INTO post(id, autore, testo, contenuto, tipoPost, userReciver, groupReciver)
VALUES(default,
       5,
       'Uscite un pochino di casa',
       null,
       1,
       null,
       3
);


--Post 6 con Url da Spock a Kirk--
INSERT INTO post(id, autore, testo, contenuto, tipoPost, userReciver, groupReciver)
VALUES(default,
       4,
       'Ti mando l url di cui tiparlavo',
       'http://www.stic.it/',
       3,
       3,
       null
);

-Post 7 con immagine da Spock a Kirk--
INSERT INTO post(id, autore, testo, contenuto, tipoPost, userReciver, groupReciver)
VALUES(default,
       4,
       'guarda che bella locandina',
       'http://localhost:8080/Progetto_AMM/Asset/StarTrekOriginal.jpg',
       2,
       3,
       null
);

--Post 8 con immagine da Yoda a Luke--
INSERT INTO post(id, autore, testo, contenuto, tipoPost, userReciver, groupReciver)
VALUES(default,
       1,
       'Questa immagine la avevo gi�',
       'http://localhost:8080/Progetto_AMM/Asset/StarWarsImg.jpg',
       2,
       2,
       null
);

--Post 9 testuale da spoke alla sua bacheca--
INSERT INTO post(id, autore, testo, contenuto, tipoPost, userReciver, groupReciver)
VALUES(default,
       4,
       'Seguo il colinar',
       null,
       1,
       4,
       null
);











