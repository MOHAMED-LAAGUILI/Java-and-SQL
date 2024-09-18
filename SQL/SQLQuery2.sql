 
 /* Create DataBase */
CREATE DATABASE GestionEtudiantNote

 /* Delete DataBase */
DROP DATABASE GestionEtudiant

/* Create Table */
CREATE TABLE Etudiant
(MLeEtd varchar(20) Primary key,
 Nom  VarChar(20),
 Prénom  VarChar(20),
 DateNaissance DateTime,
 Niveau VarChar(25) Constraint Niveau Default 'Bachelier',
 Addresse  VarChar(20),
 Téléphone  VarChar(20))
 
 /*Show Table Attribut*/ 
SELECT * FROM Etudiant

 /* Delete Table */
 DROP TABLE Etudiant


/* Creat new table and make a relation with the previous one*/
CREATE TABLE Note
( NumCtrl varchar(20) Not Null,
  MleEt varchar(20) Not Null,
  Note Float, Check (Note Between 0 And 20),
  Observation varchar(30) Null,
  Primary key (NumCtrl, MleEt),
  Foreign Key (MleEt) References Etudiant (MleEtd))
  
  SELECT * FROM Note
  
  /*ADD New Attribut to the table*/
  ALTER TABLE Etudiant ADD Nationalité varchar (20)
 
 /*Creat new table to show the diffrence*/
 CREATE TABLE Evaluation
( NumCtrl varchar(20) Not Null,
  MleEt varchar(20) Not Null,
  Note Numeric,
  Observation varchar(30) Null,
  Primary key (NumCtrl, MleEt),
  Foreign Key (MleEt) References Etudiant (MleEtd))
 
  SELECT * FROM Evaluation
 /* Convert data type of Attribut  to float*/
 ALTER TABLE Evaluation Alter Column Note Float
 
 /*Remove Attribut from table*/
 /*remove contraint default befor remove any attribut*/
 ALTER TABLE Etudiant Drop Column Addresse, Téléphone 
 
 /*Add values in all table columns*/
 INSERT Etudiant
 Values ('MIA001','Mohamed','Laaguili','01/04/2001',
         'Technicien Specialisé','Ksar el kebir',
         '+212689770809')
  INSERT Etudiant
 Values ('MIA002','Reda','Zekari','01/04/2001',
         'Technicien Specialisé','Ksar el kebir',
         '+2125646877')
         
        
 /*Add values in specifique columns in table*/
 INSERT into Etudiant (MleEtd, Nom, Prénom)
 Values('MIA003','Oussama','Tos')
