/*

1-- System.out.println(i);  

2-- un constructeur est un bloc de codes similaireà la méthode.
Il est appelé lorsqu’une instance de la classe
est créée. Au moment de l’appel du constructeur, la mémoire
de l’objet est allouée dans la mémoire. C’est un type spécial
de méthode qui est utilisé pour initialiser l’objet.

3-- Le Java Development Kit (JDK) désigne un ensemble de bibliothèques
logicielles de base du langage de programmation orientée object Java,
ainsi que les outils avec lesquels le code Java peut être compilé, transformé 
en bytecode destiné à la machine virtuelle Java JVM.

 */
package officepackage;
public class OfficeClass {
    String NumBil, DateBil, Classe,TypeTrain,Des;
    float Pap = 0;

     private String Lecture(){
        int c;
        String st="";
        try{
        while((c=System.in.read())!='\n')
            st+=(char)c;
        }catch(java.io.IOException ex){
           ex.toString();
        } 
        return st;
    }
     
    void InterfaceOffice(){
        System.out.print("\n\n\t\t\t Office national des chemins de fer");
        System.out.print("\n\n\t Numéro billet : ");
        NumBil = Lecture();
        System.out.print("\n\t Date billet   : ");
        DateBil = Lecture();
        System.out.print("\n\t Classe        : ");
        Classe = Lecture();
        System.out.print("\n\t Type de train : ");
        TypeTrain = Lecture();
        System.out.print("\n\t Destination   : ");
        Des = Lecture();
        Pap = Calcul(Classe, TypeTrain, Des);
        System.out.print("\n\t Prix à payer  : " + Pap );
         }
    
  
    
        float Calcul(String Clas, String TypeT, String Dest){
            float prix = 0f;
            if(Clas.compareTo("Première")==0){
                if(TypeT.toUpperCase().compareTo("TNR")==0){
                    if(Dest.toUpperCase().compareTo("CASA")==0){
                       prix = 60f; 
                    }else if(Dest.toUpperCase().compareTo("RABAT")==0){
                        prix = 25f;
                    }else if(Dest.toUpperCase().compareTo("FES")==0){
                        prix = 115f;
                    }
                }else if(TypeT.toUpperCase().compareTo("TAS")==0){
                    if(Dest.toUpperCase().compareTo("CASA")==0){
                       prix = 50f; 
                    }else if(Dest.toUpperCase().compareTo("RABAT")==0){
                        prix = 20.50f;
                    }else if(Dest.toUpperCase().compareTo("FES")==0){
                        prix = 98f;
                    }
                }
            }else if(Clas.compareTo("Deuxième")==0){
                  if(TypeT.toUpperCase().compareTo("TNR")==0){
                    if(Dest.toUpperCase().compareTo("CASA")==0){
                       prix = 45f; 
                    }else if(Dest.toUpperCase().compareTo("RABAT")==0){
                        prix = 17f;
                    }else if(Dest.toUpperCase().compareTo("FES")==0){
                        prix = 75f;
                    }
                }else if(TypeT.toUpperCase().compareTo("TAS")==0){
                    if(Dest.toUpperCase().compareTo("CASA")==0){
                       prix = 38f; 
                    }else if(Dest.toUpperCase().compareTo("RABAT")==0){
                        prix = 14.50f;
                    }else if(Dest.toUpperCase().compareTo("FES")==0){
                        prix = 65f;
                    }
                }
            }
            return prix;
        }
    
    
    
     
    public static void main(String[] args) {
        OfficeClass OC = new OfficeClass();
        OC.InterfaceOffice();
    }
      
}
