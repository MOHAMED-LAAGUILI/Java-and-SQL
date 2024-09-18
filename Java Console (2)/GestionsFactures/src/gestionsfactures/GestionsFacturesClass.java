
package gestionsfactures;

public class GestionsFacturesClass {


private float tht, ttc;
private String numf, df; 
void Interface_Facture(){
    
      System.out.print("\n\n\t\t\t\t Gestion des Factures\n\n");
    System.out.print("\n\t Numéro etudiant               : ");
    numf = lecture();
    System.out.print("\n\t Date de la facture            :");
    df = lecture();
    System.out.print("\n\t Total hors taxes              :");
    tht = Float.parseFloat(lecture());
    ttc = calculer(tht);
    System.out.print("\n\t Total hors taxes Comprises      : " + ttc+ "\n"); // + calculer(tht))
    
     
 }
float calculer(float ht){
    return ht + ht * 0.2f;
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


    public static void main(String[] args) {
       GestionsFacturesClass GFC = new GestionsFacturesClass();
        GFC.Interface_Facture();
    }
    
}
