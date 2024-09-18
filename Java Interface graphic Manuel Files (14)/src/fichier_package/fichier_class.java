package fichier_package;
import java.io.*;


public class fichier_class {
 FileWriter fw,fw1;
 FileReader fr;
  File f ;
 
 
 void EcritureFichier() throws IOException{
      f = new File("Fichier1.txt");
 
     String txt1 = "Hello !\n this is my first text i save";
     
     fw = new FileWriter(f);
      //
      fw.write(txt1);
      fw.close(); // fermer le fichier 
     
    
 }
 
 void LectureFichier() throws IOException{
     String message = "";
     int car;
     f = new File("Fichier1.txt");
     fr = new FileReader(f);
     while((car = fr.read()) != -1){
          message += (char)car;
      }
      System.out.print(message);
 }
    public static void main(String[] args) {
     fichier_class fc = new fichier_class();
     try {
         fc.EcritureFichier();
     } catch (IOException ex) {
     
     }
     try {
         fc.LectureFichier();
     } catch (IOException ex) {
          }
    }
}
