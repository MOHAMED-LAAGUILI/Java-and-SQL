package ResultatPackage;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class ResultatClass extends Frame {
    private Label lbt,lbne,lbnom,lbmoy,lbrf;
    private TextField txtnom,txtmoy,txtrf;
    Choice chne;
    private Button btf;
    String tabnom[]={"Zouili","Laaguili","Zekari","BAARI","ROSSI","TAIBI","SERRAFA","ZITOUNI",
        "BENCHELHA","EL ACH_HAB","EL GHAYAT","CHAHIDI","ES_ABBABY","SAHRAOUI","KHRIBECH","STITOU"};
    float tabmoy[]={15,9,14,7,18,12,9,13,12,17.45f,6.85f,11.5f,10.00f,8.00f,16.45f,10.50f};
    private GridLayout gr;
    private FlowLayout fl;
    Panel p;
   
    public boolean handleEvent(Event ev){
        if(ev.id==Event.WINDOW_DESTROY)
            System.exit(0);
        return super.handleEvent(ev);
    }
    public boolean action(Event e, Object ob){
        if(e.target==btf){
            System.exit(0);
            return true ;
        }
        else if(e.target==chne){
            afficher(chne.getSelectedIndex());
            return true;
        }else
            return super.action(e, ob);
    }
   public void afficher(int i){
      txtnom.setText(tabnom[i]);
      txtmoy.setText(String.valueOf(tabmoy[i]));
      if(tabmoy[i]>=10)
        txtrf.setText("Admi");
      else
        txtrf.setText("Ajourné");
   }
    void initialiser(){
        lbt=new Label("Résultat final");
        lbne=new Label("Numero étudiant  :");
        lbnom=new Label("Nom étudiant    :");
        lbmoy=new Label("Moyenne générale:");
        lbrf=new Label("Résultat final   :");
        chne=new Choice();
        chne.add("1");
        chne.add("2");
        chne.add("3");
        chne.add("4");
        chne.add("5");
        chne.add("6");
        chne.add("7");
        chne.add("8");
        chne.add("9");
        chne.add("10");
        chne.add("11");
        chne.add("12");
        chne.add("13");
        chne.add("14");
        chne.add("15");
        chne.add("16");
        txtnom=new TextField();
        txtmoy=new TextField();
        txtrf=new TextField();
        btf=new Button("Fermer");
        p= new Panel();
        gr= new GridLayout(6,2,20,20);
        fl= new FlowLayout(FlowLayout.CENTER,20,20);
        p.setLayout(gr);
        this.setLayout(fl);
        p.add(new Label(" "));
        p.add(lbt);
        p.add(lbne);
        p.add(chne);
        p.add(lbnom);
        p.add(txtnom);
        p.add(lbmoy);
        p.add(txtmoy);
        p.add(lbrf);
        p.add(txtrf);
        p.add(btf);
        this.add(p);
        this.setSize(800, 500);
        // this.resize(600, 400);
        p.setBackground(Color.PINK);
        this.setBackground(Color.PINK);
        this.setTitle("Gestion de la facturation");
        this.setVisible(true); 
    }
     public ResultatClass(){
        initialiser();
    }
    public static void main(String[] args) {
      new ResultatClass();
      
    }
    
}
