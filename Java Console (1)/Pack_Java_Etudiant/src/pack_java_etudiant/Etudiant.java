/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pack_java_etudiant;

public class Etudiant {
    String NumEt, NomEt, PrnEt, AdrEt;
 
// fonction d'interface
void InterfaceEtudiant(){
    System.out.print("\n\n\t\t\t\t Gestion des etudiant\n\n");
    System.out.print("\n\t Numéro etudiant     : ");
    NumEt = lecture();
    System.out.print("\n\t Nom etudiant        :");
    NomEt = lecture();
    System.out.print("\n\t Prenom etudiant     :");
    PrnEt = lecture();
    System.out.print("\n\t Adresse etudiant    :");
    AdrEt = lecture();
    System.out.print("\n\n\n\n\n");  
}

// fonction de lecture
private String lecture(){
    int c; // code aski
    String st = ""; // evry input added to st
    try{
    while((c = System.in.read())!='\n'){
        st = st + (char)c; //st+= (char)c;  
    }
    }catch(java.io.IOException ex){
        ex.toString();
    }
    
    return st;
}






    public static void main(String[] args) {
       Etudiant et = new Etudiant();
       et.InterfaceEtudiant();
    }
    
}
