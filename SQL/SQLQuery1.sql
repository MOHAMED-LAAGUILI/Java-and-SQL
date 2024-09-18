 
 /* Create DataBase */
CREATE DATABASE GestionEtudiant

 /* Delete DataBase */
DROP DATABASE GestionEtudiant

/* Create Table */
CREATE TABLE Etudiant
(MLEtd varchar(20) Primary key,
 Nom  VarChar(20),
 Prénom  VarChar(20),
 DateNaissance DateTime,
 Niveau VarChar(20),
 Addresse  VarChar(20),
 Téléphone  VarChar(20))
 
 /*Show Table Attribut*/
 SELECT * FROM Etudiant

 /* Delete Table */
 DROP TABLE Etudiant
