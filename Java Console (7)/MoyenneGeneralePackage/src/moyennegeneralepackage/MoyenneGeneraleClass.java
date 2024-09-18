/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moyennegeneralepackage;


public class MoyenneGeneraleClass {
    
    private String NumE, NomE, PrnE, Mention;
    private float Moyenne = 0;
    
void InterfaceEtudiant(){
    System.out.print("\t\t\t\t Evaluation des etudiant");

      System.out.print("\t\t\n Numéro etudiant           :");
       NumE = lecture();
        System.out.print("\t\t\n Nom etudiant            :");
         NomE = lecture();
          System.out.println("\t\t\n Prénom etudiant     :");
           PrnE = lecture();
            System.out.println("\t\t\n Moyenne générale  :");
             Moyenne = Float.parseFloat(lecture())  ;
             
              System.out.println("\t\t\n Mention         : " + Mention(Moyenne));
}
    
    
    private String lecture(){
    int c; // code aski
    String st = ""; // evry input added to st
    
    try{
    while((c = System.in.read())!='\n'){
        st+= (char)c;  
    }
    }catch(java.io.IOException ex){
        ex.toString();
    }             
    return st;
}
    
    String Mention(float Moy){
        String Ment = "";
        if( Moy < 10 && Moy >= 0){
            Ment = "Non Admis";
        }else if ( Moy < 12 && Moy >= 10){
            Ment = "Passable";
        }else if (  Moy < 14 && Moy >= 12 ){
            Ment = "Mention";
        }else if (  Moy < 16 && Moy >= 14 ){
            Ment = "bien";
        }else if (  Moy < 18 && Moy >= 16 ){
            Ment = "Tres aBien";
        }else if (  Moy >= 18 && Moy <= 20 ){
            Ment = "Excelent";
        }
        else{
            System.out.println("Invalid Moyenne");
        }
        return Ment;
    }
    public static void main(String[] args) {
        MoyenneGeneraleClass MGC = new MoyenneGeneraleClass ();
        MGC.InterfaceEtudiant();
    }
    
}
