
package billetvoyagepackage;

public class BilletVoyageClass {
String NumB,DtB,Des;
float Mtp;

void Interface_Billet_Voyage(){
    System.out.print("\n\n\t\t\t\t Billet de voyage\n\n");
    System.out.print("\n\t Numéro Billet    : ");
    NumB = lecture();
    System.out.print("\n\t Date de Billet   : ");
    DtB = lecture();
    System.out.print("\n\t Destination      : ");
    Des = lecture();
    System.out.print("\n\t Montant a payer    : " + Montant(Des) + "\n"); // + calculer(tht))  
 }



float Montant(String D){
    float mt = 0f;
    switch (D.toUpperCase()) {
        case "TANGER":
            mt = 35.00f;
            break;
        case "RABAT":
            mt = 70.00f;
            break;
        case "CASA":
            mt = 120.00f;
            break;
        default:
            System.out.print("\n\t Invalid Destination");
            break;
    }
    return mt;
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
        BilletVoyageClass BV = new BilletVoyageClass();
        BV.Interface_Billet_Voyage();
    }
    
}
