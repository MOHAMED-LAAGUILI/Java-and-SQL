package PartageSommePackage;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Frame;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Event;
import javax.swing.JOptionPane;

public class PartageSommeClass extends Frame{
private Label LbTitre, LbDtPart, LbSomPart, LbNbPers, LbPartCh;
private TextField TxtDtPart, TxtSomPart, TxtNbPers, TxtPartCh;
private Button BtC, BtF;
private GridLayout GL;
private FlowLayout FL;
private Panel P;

void Initialiser(){
    LbTitre = new Label("Partage entre les personnes");
     LbDtPart =  new Label("Date de partage");
      LbSomPart =  new Label("Somme a partager");
       LbNbPers =  new Label("Nombre de personnes");
        LbPartCh =  new Label("La part de chacun");
    
    TxtDtPart = new TextField();
     TxtSomPart = new TextField();
      TxtNbPers = new TextField();
       TxtPartCh = new TextField();
       
    BtC = new Button("Calculer");
    BtF = new Button("Fermer");
    
    GL = new GridLayout(6,2,20,20);
    FL = new FlowLayout();
    FL = new FlowLayout(FlowLayout.CENTER, 20, 20); 
    P = new Panel();
    P.setBackground(Color.pink);
    
    P.setLayout(GL);
    this.setLayout(FL);
    P.add(new Label(""));
    P.add(LbTitre);
    
    P.add(LbDtPart);
    P.add(TxtDtPart);
    
    P.add(LbSomPart);
    P.add( TxtSomPart);
    
    P.add(LbNbPers);
    P.add(TxtNbPers);
    
    P.add(LbPartCh);
    P.add(TxtPartCh);
    
    P.add(BtC);
    P.add(BtF);
    
    this.add(P);
    this.setSize(800, 500);
    this.setTitle("Partage d'une somme");
    this.setVisible(true);
    this.setBackground(Color.PINK);

}
public PartageSommeClass(){
   Initialiser(); 
}

// exit form
public boolean handleEvent(Event Ev){
    if( Ev.id == Event.WINDOW_DESTROY)
        System.exit(0);
      return super.handleEvent(Ev);  
}

public boolean action(Event E, Object O){
    if(E.target == BtF){
        System.exit(0);
        return true;
    }else if(E.target == BtC){
        if(TxtSomPart.getText()!="" && TxtNbPers.getText()!=""){
            float Som = Float.parseFloat(TxtSomPart.getText());
            int NB = Integer.parseInt(TxtNbPers.getText());
            TxtPartCh.setText(String.valueOf(Calculer_Part(Som , NB)));
        }else{
            JOptionPane.showMessageDialog(this, "Il faut remplir les zone de text necessaire"," Erreur",JOptionPane.OK_OPTION);
        }
        
        return true;
    }else
    return super.action(E, O);
}
public float Calculer_Part(float Som, int NB){
    return Som / NB;
}
    public static void main(String[] args) {
      new PartageSommeClass();
        
    }
    
}
