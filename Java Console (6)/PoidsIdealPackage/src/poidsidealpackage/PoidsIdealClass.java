
package poidsidealpackage;

public class PoidsIdealClass {
String NumP,NomP,PrnP,Morpho;
float TailleP,AgeP,PoiId,result;

void Interface_Poids_Ideal(){
    System.out.print("\n\n\t\t\t\tCalculer Poids Idéal\n\n");
    System.out.print("\n\t Numéro de personne     : ");
    NumP = lecture();
    System.out.print("\n\t Nom de personne         : ");
    NomP = lecture();
    System.out.print("\n\t Prénom de personne      : ");
    PrnP = lecture();
    System.out.print("\n\t Taille de personne (CM) : ");
    TailleP = Float.parseFloat(lecture());
    System.out.print("\t CM");
    System.out.print("\n\t Age de personne         : ");
    AgeP = Float.parseFloat(lecture());
    System.out.print("\n\t Morphologie             : ");
    Morpho = lecture();
    result = Calcule(Morpho, TailleP, AgeP);
    System.out.print("\n\t Poids idéal             : " + result +"\n\n");   
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
    float Calcule(String M, float T, float Age){
        float pd = 0f;
        switch(M.toUpperCase()){
            case "NORMAL":
                pd = (T - 100 + Age /10)*0.9f;
                break;
            case "GRACILE":
                pd = (T - 100 + Age /10)*0.9f*0.9f;
                break;
            case "LARGE":
                pd =  (T - 100 + Age /10)*0.9f*1.1f;
            default :
                System.out.print("\n\t Morphologie n'exist pas essayer ");
                break;
        }
        return pd;
    }
   
    public static void main(String[] args) {
      PoidsIdealClass PIC = new PoidsIdealClass();
      PIC.Interface_Poids_Ideal();
    }
    
}
