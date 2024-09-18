Create Database Gestion_Evaluations


Create table Modules
(R�fMod varchar(20) Primary key,
 Module  VarChar(20),
 Formateur  VarChar(20),
 Vol_Horaire Int)
 
 Select * From Modules
  drop table Modules
 
Create table Etudiants
(MLeS varchar(20) Primary key,
 Nom  VarChar(20),
 Pr�nom  VarChar(20),
 DateNaissance datetime,
 Addresse  VarChar(20),
 Dipl�me VarChar(20),
 Montant_Formation Numeric)
 
  Select * From Etudiants
  drop table Etudiants
  
Create table Evaluations
(CodeEv varchar(20),
 MleS  VarChar(20),
 R�fMod  VarChar(20),
 Date_Eval DateTime,
 Note Numeric,
  Primary key (CodeEv, MleS, R�fMod),
  Foreign Key (MleS) References Etudiants (MleS),
  Foreign Key (R�fMod) References Modules (R�fMod))
 
  Select * From Evaluations
  drop table Evaluations
  
 INSERT Modules Values
 ('Mod1','Anglais','CHAOUCH',90)
 INSERT Modules Values
 ('Mod2','Francais','HANAFI',120)
  INSERT Modules Values
 ('Mod3','Math','ABDOU',180)
        
 INSERT Etudiants Values
 ('ST01','FERTOUT','Khalid','01/12/1986','Ksar','DTS',25000)
  INSERT Etudiants Values 
 ('ST02','BENAMI','Hamza','12/02/1992','Larache','DT',18000)
  INSERT Etudiants Values
 ('ST03','CHAKOUR','Fatima','15/07/1980','Ksar','DTS',30000)
  INSERT Etudiants Values
 ('ST04','ATLASSI','Hamid','25/01/2001','F�s','DQ',6000)
  INSERT Etudiants Values
 ('ST05','MOURAY','Najwa','14/06/1997','Larache','DTS',40000)
   INSERT Etudiants Values
 ('ST06','Mkima','Amal','10/06/1997','Larache','DTS',20000)
       

 INSERT Evaluations Values 
('Eval1','ST05','Mod2','05/12/2018',18)
INSERT Evaluations Values 
('Eval1','ST02','Mod2','05/12/2018',10)
INSERT Evaluations Values 
('Eval1','ST01','Mod2','05/12/2018',8)
INSERT Evaluations Values 
('Eval2','ST05','Mod1','24/05/2018',16)
INSERT Evaluations Values 
('Eval2','ST01','Mod1','24/05/2018',12)
INSERT Evaluations Values 
('Eval2','ST03','Mod1','24/05/2018',10)
INSERT Evaluations Values 
('Eval3','ST05','Mod3','02/06/2018',14)
INSERT Evaluations Values 
('Eval4','ST03','Mod3','02/08/2018',19)

/*Delete table data*/
/*Methode 1*/
Delete Evaluations
Delete Etudiants
Delete Modules
/*Methode 2*/
Truncate table Evaluations
Truncate table Etudiants
Truncate table Modules


/*
P4:
Cr�er la table Stagiaire de champ MleEtd, Nom, Dipl�me
*/
Create Table Stagiaires
 (MleEtd Varchar(20) Primary Key,
  Nom Varchar(20),
  Dipl�me varchar(20))

  drop Table Stagiaires
/*
ins�rer la valeur de champe de la table Etudiant dans la Table Stagiaire
Note : They Must have the same columns to add values to another
or select the columns u wanna add to match the existing ones

Syntax :
Insert Stagiaire
Select * From Etudiants
*/        
  Insert Stagiaires
  Select MleS, Nom, Dipl�me From Etudiants where Dipl�me = 'DTS'
  
  
  /*Edit a specefic Row*/
  UPDATE Etudiants Set Dipl�me = 'Master' where MleS='ST03'
  
 /*Change THE CASE OF Column Pr�nom and add 20% to Column Montant*/

 UPDATE Etudiants SET Pr�nom = UPPER(Pr�nom), Montant_Formation = Montant_Formation * 1.2
 
 /*Reverse it*/
  UPDATE Etudiants SET Pr�nom = LOWER(Pr�nom), Montant_Formation = Montant_Formation / 1.2
  
  /*Update Price to 24000 for thos who came from ksar*/
  UPDATE Etudiants SET Montant_Formation = 24000 WHERE Addresse = 'Ksar'
  
  /*Delete certain Etudiant
  but first must delete them in the relation with on tables*/
  DELETE From Evaluations where MleS='ST01'
  DELETE From Evaluations where MleS='ST03'
  DELETE From Etudiants where Addresse = 'Ksar'
  SELECT * From Etudiants
  
  /* Exercices 1 */
  
  /*Exemple 1
Pour afficher (MleS Nom Pr�nom Dipl�me Montant_Formation)*/
SELECT MleS, Nom, Pr�nom, Dipl�me, Montant_Formation From Etudiants

/*Exemple 2
Afficher MleS Nom prenom des etudiant et la list des module */
SELECT MleS, Nom, Pr�nom, Dipl�me, R�fMod, Module, Formateur, vol_Horaire from Etudiants, Modules

/*Exemple 3
Afficher tout les attribut de la table etudiant*/
SELECT * from Etudiants

/*Exemple 4
Pour obtEnir lr produit cartesiant de la table etudiant et la table modules*/
SELECT * from Etudiants, Modules

/*Exemple 5
Pour afficher  les etudiant il est exist on ksar ou Fes*/
SELECT * from Etudiants where Addresse = 'Ksar' or Addresse = 'F�s'

/*Exemple 6
Pour afficher  les etudiant il est exist on ksar  ayant dipl�me dts*/
SELECT * from Etudiants where Addresse = 'Ksar' and  dipl�me = 'DTS'

/*Exemple 7
Pour afficher  les etudiant il est exist on ksar  ayant dipl�me dts*/
SELECT MleS, R�fMod, Note from Evaluations where Note  >= 12 and Note <=18	

/*Exemple 8
Pour afficher  les etudiant il est not exist on Ksar*/
SELECT * from Etudiants where NOT Addresse = 'ksar'

/*Exemple 9
Afficher list des etudiant dont le dipl�me est DTS et la DateNaissance est superieure 1996 dans cas
ou la datenaissance inferieur 1993 est Selection les etudiants dont addresse est Larache*/
SELECT * from Etudiants where (Dipl�me = 'DTS' And year(DateNaissance) >= 1996) OR (year(DateNaissance) <= 1993 and Addresse = 'Larache')


/*Exercice 2*/
/* 1- Ajoute Frais de type reel a la table Etudiants */
ALTER TABLE Etudiants 
ADD Frais int;  

/*2*/
UPDATE Etudiants set Frais = 750 where MleS = 'ST01'
UPDATE Etudiants set Frais = 800 where MleS = 'ST02'
UPDATE Etudiants set Frais = 900 where MleS = 'ST03'

/*3*/
Select *, Remise = Frais *0.2, Montant_Payer = Frais - Frais * 0.2 From Etudiants where Addresse = 'Ksar'


/*Exercice 3*/
/*1*/
Select * from Etudiants where Dipl�me != 'DTS'

/*2*/
Select * from Etudiants where day(DateNaissance) = 25 and  month(DateNaissance) = 01


/*Exercice 4*/
/*1*/
Select * from Etudiants where Montant_Formation Between 20000 and 36000

/*2*/
Select * from Etudiants where Pr�nom Between 'E' and 'J'

/*3*/
Select * from Etudiants where Pr�nom Not Between 'E' and 'J'

/*4*/
SELECT * FROM Etudiants where Addresse IN ('Larache') OR Dipl�me IN ('DQ')

/*5*/
SELECT * FROM Evaluations where Note IN (12,14,16)

/*6*/
SELECT * FROM Etudiants where Addresse Not IN ('Ksar') AND Dopl�me Not In ('DQ')

/*7*/
SELECT * FROM Evaluations where Note Not IN (12,14,16)

/*8*/
SELECT * FROM Etudiants
WHERE Nom LIKE 'B%';

SELECT * FROM Etudiants
WHERE Nom LIKE '%OU%';


SELECT * FROM Etudiants
WHERE Nom LIKE '___A%';

/* Start with caractere beteween C and F */
SELECT * FROM Etudiants
WHERE Nom LIKE '[c-f]%';

/*9*/
/* NOT Start with caractere beteween C and F */
SELECT * FROM Etudiants
WHERE Nom Not LIKE '[c-f]%';


/* Afficher les adresse des etudiant nes pas �t� saisie*/
Select * From Etudiants where Frais is Null

/* Afficher les adresse des etudiant nes a �t� saisie*/
Select * From Etudiants where Frais is Not Null

/**/
Select MleS, Nom + ' ' + Pr�nom As Nom_Pr�nom, Year(DateNaissance) + 2 As Ann�e_Naissance From Etudiants

/**/
Select Nom, Pr�nom from Etudiants where ((Nom in ('BENAMI','MOURAY')) OR (Pr�nom Like '%am%'))

/**/
Select * from Etudiants where 
(Dipl�me != 'DQ' and Day(DateNaissance) = 15 and Nom Like('_HAK%') and DateNaissance Between '12/04/1980' and '18/10/1993')
or
(Dipl�me = 'DT' and Month(DateNaissance) = 12)


/*Orde by*/
Select * from Etudiants where Dipl�me = 'DTS'
Order by DateNaissance desc

Select * from Etudiants 
Order by Montant_Formation desc, nom asc, DateNaissance desc

Select Nom, Pr�nom, DateNaissace, Dipl�me from Etudiants
order by 1 desc, 3 asc, 4 desc, 2 asc

/*Afficher les list des dipl�me*/
/*Distinct*/
Select Distinct(Dipl�me) from Etudiants 


/*Count*/
Select count(*) as NombreEtudiant from Etudiants

Select count(*) as NombreNote from Evaluations where MleS = 'ST05'
Select * From Evaluations

Select  count(Distinct Dipl�me) As Dipl�me From Etudiants

/*Max*/
Select Max(Note) As MaximalNote From Evaluations where MleS = 'ST01'

/*Min*/
Select Min(Note) As MaximalNote From Evaluations

/*Sum*/
Select sum(Montant_Formation) as Total_Montants_DTS from Etudiants where Dipl�me = 'DTS'

/*Moy*/
Select Avg(Montant_Formation) as Moyenne_Montants from Etudiants


/*Min Max AVG*/
Select Min(Note) As NoteMinimale, Max(Note) As MaximalNote, Avg(Note) As AverageNote From Evaluations

Select Min(Note) As NoteMinimale, Max(Note) As MaximalNote, (Min(Note) + Max(Note))/2  As AverageNote From Evaluations


/*STDEV*/
Select * STDEV(Montant_Formation) as Ecart_Type from Etudiants

/*Group By*/
/*1*/
Select * from Etudiants

Select Dipl�me, AVG(Montant_Formation) as MF
From Etudiants Group By Dipl�me

/*2*/
Select Dipl�me, Addresse, count(*)as Effectif
From Etudiants Group By Dipl�me, Addresse

/*3*/
Select Addresse, count(*)as Effectif, Sum(Montant_Formation) as Somme
From Etudiants Group By Addresse Order by Addresse Desc

/*4*/
Select Addresse, count(*)as Effectif
From Etudiants Group By Addresse

Select Sum(Montant_Formation) As Total_Montant, Addresse
from Etudiants where Addresse = 'Larache' and Montant_Formation <= 28000
Group by Addresse

/*Having*/
SELECT Dipl�me FROM Etudiants
GROUP BY Dipl�me
HAVING COUNT(*) > 2

SELECT Dipl�me, count(*) as Effectif FROM Etudiants
GROUP BY Dipl�me
HAVING Dipl�me LIKE 'd%'
Order By Dipl�me Desc


SELECT * FROM Evaluations

SELECT MleS, AVG(Note) as Moyenne FROM Evaluations
GROUP BY MleS
HAVING  Avg(Note) > 14
Order By MleS Desc


/*Sub Query*/
/* Exemple 1 */
/* Step 1 */
Select Dipl�me from Etudiants where MleS ='ST03'
/* Step 2 */
Select * from Etudiants where Dipl�me ='ST03'

Select * from Etudiants where Dipl�me = 
(Select Dipl�me from Etudiants where MleS ='ST03')

/* Exemple 2 */
/* Step 1 */
Select Max(Montant_Formation) from Etudiants
/* Step 2 */
Select Avg(Montant_Formation) from Etudiants
/* Step 3 */
Select * from Etudiants 
where Montant_Formation >= 40000 or Montant_Formation >= 23500

Select * from Etudiants 
where Montant_Formation >= 
(Select Max(Montant_Formation) from Etudiants) or 
Montant_Formation >= (Select Avg(Montant_Formation) from Etudiants)


/*In / All / Any*/
/* In */
Select * from Etudiants where MleS in (Select MleS From Etudiants)
Order by Nom Desc

/* Any */
Select MleS, R�fMod, Note from Evaluations where Mles  = 
Any(Select MleS From Etudiants where PrenomPrenom like 'H%')

