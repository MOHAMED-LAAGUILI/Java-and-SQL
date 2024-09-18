
package TrancheAgepackage;


public class TrancheAgeClass {
    
    public String NomP,PrnP,Tranche, Res;
    public float AgeP;
    
    
void Interface_Tranche(){
    System.out.print("\t\t\t\t Tranche d'age");
    System.out.print("\n\t Nom de personne    :");
    NomP = lecture();
    System.out.print("\n\t Prénom de personne :");
    PrnP = lecture();
    System.out.print("\n\t Age de personne    :");
    AgeP = Float.parseFloat(lecture());
    System.out.print("\n\t Tranche d'age      :" + Result(AgeP) + "\n\n\n");
}

String Result(float Age){
    String Result = "";
if(Age > 0 && Age < 18){
    //System.out.print("\n\t Enfants");
    Result = "Enfants";
}else if(Age >= 18 && Age <= 27){
    //System.out.print("\n\t Jeune");
    Result = "Jeune";
} else if(Age >= 28 && Age <= 60){
    //System.out.print("\n\t Personne Active");
    Result = "Personne Active";
}else if(Age > 60){
    //System.out.print("\n\t Personne Agées");
    Result = "Personne Agées";
}else{
    System.out.print("\n\t Invalid Age");
}
        return Result;
}

private String lecture(){
    int c;
    String st = "";
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
     TrancheAgeClass TAC = new TrancheAgeClass();
     TAC.Interface_Tranche();
    } 
}
