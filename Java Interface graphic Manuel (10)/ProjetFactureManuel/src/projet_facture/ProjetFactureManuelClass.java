package projet_facture;

// Libraries de component graphics
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Frame;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Event;

public class ProjetFactureManuelClass extends Frame {
   // DECLARATION DES OBJECTS
private Label LbTitre, LbNumFact, LbDtFact, LbTht, LbTtc; // label
private TextField txtnf, txtdtf, txttht, txtttc; // text box
private Button btc, btf; // button
private GridLayout gr; 
private FlowLayout FL;
private Panel P; // pannel to contain object in form

public ProjetFactureManuelClass(){
   Initialiser(); 
}

// exit form
public boolean handleEvent(Event Ev){
    if( Ev.id == Event.WINDOW_DESTROY)
        System.exit(0);
      return super.handleEvent(Ev);  
}

// click on any object in form
public boolean action(Event E, Object O){
    if(E.target== btf){
        System.exit(0);
        return true;
    }else if(E.target== btc){
        if(txttht.getText()!=""){
            float tht = Float.parseFloat(txttht.getText());
            txtttc.setText( String.valueOf(Calculer_Ttc(tht)) );
        }
        
        return true;
    }else
    return super.action(E, O);
}
public float Calculer_Ttc(float tht){
    return tht * 1.2f;
}
void Initialiser() {
    // Creation des Object label
    LbTitre = new Label("Traitement des factures ");
    LbNumFact = new Label("Numéro de la facture     :");
    LbDtFact = new Label("Date de la facture        :");
    LbTht = new Label("Total hors taxes             :");
    LbTtc = new Label("Total toutes taxes comprises :");
    
     // Creation des Object textbox
    txtnf = new TextField();
    txtdtf = new TextField();
    txttht = new TextField();
    txtttc = new TextField();
    
     // Creation des Object buttons
    btc = new Button("Calculer");
    btf = new Button("Fermer");
    
    gr = new GridLayout(6,2,20,20); // Line - Column - GapHorizontal - GapVertical
    FL = new FlowLayout(FlowLayout.CENTER, 20, 20); // Adjust Object Horizontal
    P = new Panel();
    
    P.setLayout(gr);
    this.setLayout(FL);
    P.add(new Label("")); // creat espace vide
    P.add(LbTitre);
    
    P.add(LbNumFact);
    P.add(txtnf);
    
    P.add(LbDtFact);
    P.add(txtdtf);
    
    P.add(LbTht);
    P.add(txttht);
    
    P.add(LbTtc);
    P.add(txtttc);
    
    P.add(btc);
    P.add(btf);
    
    this.add(P);
    this.setSize(800, 500);
    this.setTitle("Gestion des facturation");
    this.setVisible(true);
    
    txtttc.setEnabled(false);
}   
    public static void main(String[] args) {
    ProjetFactureManuelClass projetFactureManuelClass = new ProjetFactureManuelClass();
      
    }
    
}
