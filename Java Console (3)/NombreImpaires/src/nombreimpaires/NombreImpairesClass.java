/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nombreimpaires;


public class NombreImpairesClass {


private int pn, dn;
 
void Interface_Nombres(){
    
     System.out.print("\n\n\t\t\t\t Nombres Impairs\n\n");
    System.out.print("\n\t Premier nombre           : ");
    pn =  Integer.parseInt(lecture());
    System.out.print("\n\t Deuxiéme nombre          :");
    dn =  Integer.parseInt(lecture());
    System.out.print("\n\t List des nombres impairs :\n");
    AfficherNombresImpairs(pn, dn);
 }
void AfficherNombresImpairs(int p, int d){

    for( int i =((p<d)?p:d); i<=((p>d)?p:d); i++){
        if(i % 2 == 1){
            System.out.print(i + "\t");
        }
    if(i % 8 == 0){
            System.out.print( "\n\t");
        }
    }
        
    
}
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
        NombreImpairesClass NIC = new NombreImpairesClass();
        NIC.Interface_Nombres();
    }
    
}
