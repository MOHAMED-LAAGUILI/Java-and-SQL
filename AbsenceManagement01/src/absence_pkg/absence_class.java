package absence_pkg;

import static java.awt.Color.*;
import java.awt.event.*;
/*import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;*/
import java.io.*;
/*import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;*/
import java.util.*;
import java.util.logging.*;
/*import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;*/
import javax.swing.*;
import javax.swing.table.*;
/*import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;*/

public class absence_class extends javax.swing.JFrame {
    public absence_class() {
        initComponents();
        tbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent ev){
                  tableau_click(ev);
            }
            });
    }
    public void tableau_click(MouseEvent ev){
        AfficherLigne();
    }

    File folder, file;
    RandomAccessFile raf, rafn;
    StringTokenizer stoken;
    String user = "admin";
    String pass = "*****";
    boolean bl;
    
public void Remplir()throws IOException{
        String str = "";
        javax.swing.DefaultComboBoxModel cmbmodel = new javax.swing.DefaultComboBoxModel();
            raf = new RandomAccessFile("D:\\MyFolder\\MyFile.don", "rw");
            while((str=raf.readLine())!=null){
                if(str.trim().compareTo("")!=0){
                    stoken=new StringTokenizer(str.trim(),"\t");
                    cmbmodel.addElement(stoken.nextToken());
                }
            } 
            raf.close();
        cmb1.setModel(cmbmodel);
    }
     
public void Nouveau(){
    cmb1.setSelectedIndex(-1);
    txt2.setText("");
    txt4.setText("");
    txt5.setText("");
    cmb1.requestFocus();
    if((cmb6.getSelectedItem().toString()).compareTo("Present")!=0 
                    && (txt7.getText()).compareTo("-----")!=0
                    && (txt8.getText()).compareTo("-----")!=0
                    && (txt9.getText()).compareTo("-----")!=0
                    && (txt10.getText()).compareTo("-----")!=0){
        txt7.setText("");
        txt8.setText("");
        txt9.setText("");
        txt10.setText("");
    }
}

public void Enregistrer() throws FileNotFoundException, IOException, NullPointerException, java.lang.NullPointerException,java.util.NoSuchElementException{
    folder = new File("D:\\MyFolder");
    if(!folder.exists()){
        folder.mkdir();
    }
    file = new File(folder,"MyFile.don");
    String ligne = "";
    ligne = cmb1.getSelectedItem().toString() + '\t' + txt2.getText() + '\t' + 
            cmb3.getSelectedItem().toString() + '\t' + txt4.getText() + '\t' + 
            txt5.getText() + '\t' + cmb6.getSelectedItem().toString() + '\t' + 
            txt7.getText() + '\t' + txt8.getText() + '\t' + txt9.getText() + 
            '\t' + txt10.getText() + '\n' ; 
    if(ligne.compareTo("")!=0){
        raf = new RandomAccessFile(file,"rw");
        raf.seek(raf.length());
        raf.writeBytes(ligne);
        raf.close();
    }
}

public void Lister() throws IOException,NoSuchElementException{
    ((DefaultTableModel) tbl.getModel()).setRowCount(0);
    raf = new RandomAccessFile("D:\\MyFolder\\MyFile.don","rw");
    String str = "";
    while((str=raf.readLine())!=null){
                if(str.trim().compareTo("")!=0){
                    stoken = new StringTokenizer(str.trim(),"\t");
                    ((DefaultTableModel) tbl.getModel()).addRow(new Object[]
                    {String.valueOf(stoken.nextToken()),
                     String.valueOf(stoken.nextToken()),
                     String.valueOf(stoken.nextToken()),
                     String.valueOf(stoken.nextToken()),
                     String.valueOf(stoken.nextToken()),
                     String.valueOf(stoken.nextToken()),
                     String.valueOf(stoken.nextToken()),
                     String.valueOf(stoken.nextToken()),
                     String.valueOf(stoken.nextToken()),
                     String.valueOf(stoken.nextToken())});
                }
            }
    raf.close();
}

public boolean Rechercher() throws FileNotFoundException, IOException{
    boolean bool =false;
        String str = "",s = "";
            raf = new RandomAccessFile("D:\\MyFolder\\MyFile.don", "rw");
            while((str=raf.readLine())!=null){
                if(str.trim().compareTo("")!=0){
                    stoken=new StringTokenizer(str,"\t");
                    s = String.valueOf(stoken.nextToken());
                    if(s.trim().compareTo(cmb1.getSelectedItem().toString())==0){
                        txt2.setText(stoken.nextToken());
                        cmb3.setSelectedItem(stoken.nextToken());
                        txt4.setText(stoken.nextToken());
                        txt5.setText(stoken.nextToken());
                        cmb6.setSelectedItem(stoken.nextToken());
                        if(cmb6.getSelectedItem().toString().equals("Present")){
                            txt7.disable();
                            txt7.setText("-----");
                            txt8.disable();
                            txt8.setText("-----");
                            txt9.disable();
                            txt9.setText("-----");
                            txt10.disable();
                            txt10.setText("-----");
                        }else{
                            txt7.enable();
                            txt8.enable();
                            txt9.enable(); 
                            txt10.enable();
                            txt7.setText(stoken.nextToken());
                            txt8.setText(stoken.nextToken());
                            txt9.setText(stoken.nextToken());
                            txt10.setText(stoken.nextToken());
                        }
                        bool = true;
                        break;
                    }
                }    
            }
            raf.close();
            return bool;
    }

public void Modifier(String chemin,String idmodif) throws IOException{
      String fichtemp = "D:\\MyFolder\\MyFileTemp.don";
      File ancFich = new File(chemin);
      File nouvFich = new File(fichtemp);
      String id = "";
      String lignecourante;
      String ligne = cmb1.getSelectedItem().toString() + '\t' + txt2.getText() + '\t' + 
            cmb3.getSelectedItem().toString() + '\t' + txt4.getText() + '\t' + 
            txt5.getText() + '\t' + cmb6.getSelectedItem().toString() + '\t' + 
            txt7.getText() + '\t' + txt8.getText() + '\t' + txt9.getText() + 
            '\t' + txt10.getText() + '\n' ; 
          rafn=new java.io.RandomAccessFile(fichtemp,"rw");
          raf=new java.io.RandomAccessFile(chemin,"rw");
          while((lignecourante=raf.readLine())!=null){
              if(lignecourante.trim().compareTo("")!=0){
                    stoken=new StringTokenizer(lignecourante,"\t");
                    id=String.valueOf(stoken.nextToken());
                    if(id.trim().compareTo(idmodif)!=0){
                        rafn.writeBytes(lignecourante+"\n");
                    }
                    else 
                        rafn.writeBytes(ligne);
              }
          }
          raf.close();
          rafn.close();
          ancFich.delete();
          File fich=new File(chemin);
          nouvFich.renameTo(fich);

  }
  public void Supprimer(String chemin,String idsuppr) throws IOException{
      String fichtemp="D:\\MyFolder\\MyFileTemp.don";
      File ancFich=new File(chemin);
      File nouvFich=new File(fichtemp);
      String id = "";
      String lignecourante = "";
          rafn=new java.io.RandomAccessFile(fichtemp,"rw");
          raf=new java.io.RandomAccessFile(chemin,"rw");
          while((lignecourante=raf.readLine())!=null){
              if(lignecourante.trim().compareTo("")!=0){
                    stoken=new StringTokenizer(lignecourante,"\t");
                    id=String.valueOf(stoken.nextToken());
                    if(id.trim().compareTo(idsuppr)!=0){
                        rafn.writeBytes(lignecourante+"\n");
                    }
              }
          }
          raf.close();
          rafn.close();
          ancFich.delete();
          File fich=new File(chemin);
          nouvFich.renameTo(fich);
  }

    
  public void AfficherLigne(){
        cmb1.setSelectedItem(tbl.getValueAt(tbl.getSelectedRow(), 0).toString());
        txt2.setText(tbl.getValueAt(tbl.getSelectedRow(), 1).toString());
        cmb3.setSelectedItem(tbl.getValueAt(tbl.getSelectedRow(), 2).toString());
        txt4.setText(tbl.getValueAt(tbl.getSelectedRow(), 3).toString());
        txt5.setText(tbl.getValueAt(tbl.getSelectedRow(), 4).toString());
        cmb6.setSelectedItem(tbl.getValueAt(tbl.getSelectedRow(), 5).toString());
        txt7.setText(tbl.getValueAt(tbl.getSelectedRow(), 6).toString());
        txt8.setText(tbl.getValueAt(tbl.getSelectedRow(), 7).toString());
        txt9.setText(tbl.getValueAt(tbl.getSelectedRow(), 8).toString());
        txt10.setText(tbl.getValueAt(tbl.getSelectedRow(), 9).toString());
    }
   public boolean RechercherCle()throws IOException{
        String str,s;
        bl = false;
         folder=new File("D:\\MyFolder");
        if(!folder.exists())
            folder.mkdir();
                raf = new RandomAccessFile("D:\\MyFolder\\MyFile.don", "rw");
                while((str=raf.readLine())!=null){
                    if(str.trim().compareTo("")!=0){
                        stoken=new StringTokenizer(str,"\t");
                        s=String.valueOf(stoken.nextToken());
                        if(s.trim().compareTo(cmb1.getSelectedItem().toString())==0){
                            bl=true;
                            break; 
                        }else{
                            bl = false;
                        }  
                    }
                }
            raf.close();
        return bl;
    }
  
 
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        dsktopan = new javax.swing.JDesktopPane();
        FormAbsence = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt10 = new javax.swing.JTextArea();
        txt8 = new javax.swing.JTextField();
        txt7 = new javax.swing.JTextField();
        cmb6 = new javax.swing.JComboBox<>();
        txt4 = new javax.swing.JTextField();
        txt2 = new javax.swing.JTextField();
        cmb1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btn = new javax.swing.JButton();
        bte = new javax.swing.JButton();
        btr = new javax.swing.JButton();
        btm = new javax.swing.JButton();
        bts = new javax.swing.JButton();
        btf = new javax.swing.JButton();
        txt5 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cmb3 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        txt9 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Admin = new javax.swing.JInternalFrame();
        txtuser = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnlogin = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        txtpass = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnFich = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();

        jMenu1.setText("jMenu1");

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        dsktopan.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                dsktopanMouseWheelMoved(evt);
            }
        });

        FormAbsence.setBackground(new java.awt.Color(255, 255, 255));
        FormAbsence.setBorder(null);
        FormAbsence.setTitle("Form d'absence");
        FormAbsence.setToolTipText("Absence Form");
        FormAbsence.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FormAbsence.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        FormAbsence.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/absentism.png"))); // NOI18N
        FormAbsence.setInheritsPopupMenu(true);
        FormAbsence.setName(""); // NOI18N
        FormAbsence.setOpaque(true);
        try {
            FormAbsence.setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        FormAbsence.setVisible(true);
        FormAbsence.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                FormAbsenceInternalFrameOpened(evt);
            }
        });
        FormAbsence.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt10.setColumns(20);
        txt10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt10.setRows(5);
        jScrollPane2.setViewportView(txt10);

        FormAbsence.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 260, 340, 150));

        txt8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        FormAbsence.getContentPane().add(txt8, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 180, 340, -1));

        txt7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        FormAbsence.getContentPane().add(txt7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 340, -1));

        cmb6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmb6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Absent", "Present" }));
        cmb6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb6ItemStateChanged(evt);
            }
        });
        cmb6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmb6MouseClicked(evt);
            }
        });
        FormAbsence.getContentPane().add(cmb6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 100, 340, -1));

        txt4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        FormAbsence.getContentPane().add(txt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 260, -1));

        txt2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        FormAbsence.getContentPane().add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 260, -1));

        cmb1.setEditable(true);
        cmb1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmb1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmb1MouseEntered(evt);
            }
        });
        cmb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb1ActionPerformed(evt);
            }
        });
        FormAbsence.getContentPane().add(cmb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 260, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel10.setText("Nom / Prénom");
        FormAbsence.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 230, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel11.setText("Filière");
        FormAbsence.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 230, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel12.setText("Situation");
        FormAbsence.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 150, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel13.setText("Date D'absence");
        FormAbsence.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 160, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel14.setText("Heure D'absence");
        FormAbsence.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 230, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel15.setText("Justification d'absence");
        FormAbsence.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 230, -1));

        btn.setBackground(java.awt.SystemColor.activeCaptionText);
        btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn.setForeground(new java.awt.Color(255, 255, 255));
        btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/Nouveau.png"))); // NOI18N
        btn.setText("ADD");
        btn.setSelected(true);
        btn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/Nouveau.png"))); // NOI18N
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        FormAbsence.getContentPane().add(btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 100, 52));

        bte.setBackground(new java.awt.Color(0, 0, 0));
        bte.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bte.setForeground(new java.awt.Color(255, 255, 255));
        bte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/Enregistrer.png"))); // NOI18N
        bte.setText("SAVE");
        bte.setSelected(true);
        bte.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/Enregistrer.png"))); // NOI18N
        bte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteActionPerformed(evt);
            }
        });
        FormAbsence.getContentPane().add(bte, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 100, 52));

        btr.setBackground(new java.awt.Color(0, 0, 0));
        btr.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btr.setForeground(new java.awt.Color(255, 255, 255));
        btr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/Rechercher.png"))); // NOI18N
        btr.setText("SEARCH");
        btr.setSelected(true);
        btr.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/Rechercher.png"))); // NOI18N
        btr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btrActionPerformed(evt);
            }
        });
        FormAbsence.getContentPane().add(btr, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 120, 52));

        btm.setBackground(new java.awt.Color(0, 0, 0));
        btm.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btm.setForeground(new java.awt.Color(255, 255, 255));
        btm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/Modifier.png"))); // NOI18N
        btm.setText("EDIT");
        btm.setSelected(true);
        btm.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/Modifier.png"))); // NOI18N
        btm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmActionPerformed(evt);
            }
        });
        FormAbsence.getContentPane().add(btm, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 100, 52));

        bts.setBackground(new java.awt.Color(0, 0, 0));
        bts.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bts.setForeground(new java.awt.Color(255, 255, 255));
        bts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/Supprimer.png"))); // NOI18N
        bts.setText("DELETE");
        bts.setSelected(true);
        bts.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/Supprimer.png"))); // NOI18N
        bts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsActionPerformed(evt);
            }
        });
        FormAbsence.getContentPane().add(bts, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 110, 52));

        btf.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btf.setForeground(new java.awt.Color(255, 51, 51));
        btf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/Fermer.png"))); // NOI18N
        btf.setSelected(true);
        btf.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/Fermer.png"))); // NOI18N
        btf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btfActionPerformed(evt);
            }
        });
        FormAbsence.getContentPane().add(btf, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 0, 32, 36));

        txt5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        FormAbsence.getContentPane().add(txt5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 260, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel16.setText("Matière");
        FormAbsence.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 230, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel17.setText("Personne concernée");
        FormAbsence.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 230, -1));

        cmb3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmb3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Etudiant", "Professeur", "Autre" }));
        FormAbsence.getContentPane().add(cmb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 260, -1));

        tbl.setAutoCreateRowSorter(true);
        tbl.setBackground(new java.awt.Color(204, 204, 204));
        tbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N° Ref", "Nom/Prénom", "Person", "Fillier", "Matier", "Situation", "Date", "Heure", "N.Heure", "Justification"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl.setCellSelectionEnabled(true);
        tbl.setName("tbl"); // NOI18N
        tbl.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbl);

        FormAbsence.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 1220, 180));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel18.setText("Nombre d'Heure D'absence");
        FormAbsence.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 270, -1));

        txt9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        FormAbsence.getContentPane().add(txt9, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, 340, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        jLabel19.setText("*");
        FormAbsence.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 100, 17, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 51, 51));
        jLabel29.setText("*");
        FormAbsence.getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 17, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 51, 51));
        jLabel30.setText("*");
        FormAbsence.getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 17, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 51, 51));
        jLabel32.setText("*");
        FormAbsence.getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 17, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel20.setText("N° Référence");
        FormAbsence.getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 220, -1));

        jLabel23.setBackground(java.awt.SystemColor.window);
        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/dazzle-task-management.gif"))); // NOI18N
        jLabel23.setLabelFor(FormAbsence);
        jLabel23.setFocusable(false);
        FormAbsence.getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 310, 220));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/urban-time-management.png"))); // NOI18N
        FormAbsence.getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 240, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/BG.jpg"))); // NOI18N
        FormAbsence.getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 610, 330));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/BG.jpg"))); // NOI18N
        FormAbsence.getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 610, 330));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/BG.jpg"))); // NOI18N
        FormAbsence.getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 330));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/BG.jpg"))); // NOI18N
        FormAbsence.getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 610, 330));

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Absence Management Systeme");
        jLabel2.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        Admin.setBackground(new java.awt.Color(255, 255, 255));
        Admin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Admin.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        Admin.setTitle("Admin Form");
        Admin.setToolTipText("Administrateur Access");
        Admin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Admin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Admin.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/unauthorized-person.png"))); // NOI18N
        Admin.setInheritsPopupMenu(true);
        Admin.setOpaque(true);
        try {
            Admin.setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        Admin.setVisible(true);
        Admin.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                AdminInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                AdminInternalFrameOpened(evt);
            }
        });

        txtuser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtuser.setToolTipText("Username");
        txtuser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel26.setText("Password");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel27.setText("Username");

        btnlogin.setBackground(new java.awt.Color(0, 0, 0));
        btnlogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnlogin.setForeground(new java.awt.Color(255, 255, 255));
        btnlogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/Login.png"))); // NOI18N
        btnlogin.setText("  LOGIN");
        btnlogin.setBorder(null);
        btnlogin.setMargin(new java.awt.Insets(5, 10, 5, 10));
        btnlogin.setSelected(true);
        btnlogin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/Login.png"))); // NOI18N
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        btn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/id-card.png"))); // NOI18N
        btn1.setFocusPainted(false);
        btn1.setFocusable(false);
        btn1.setSelected(true);
        btn1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/id-card.png"))); // NOI18N
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/reset-password.png"))); // NOI18N
        btn2.setFocusPainted(false);
        btn2.setFocusable(false);
        btn2.setSelected(true);
        btn2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/reset-password.png"))); // NOI18N
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        txtpass.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtpass.setToolTipText("Username");
        txtpass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel33.setText("       Administrateur");

        javax.swing.GroupLayout AdminLayout = new javax.swing.GroupLayout(Admin.getContentPane());
        Admin.getContentPane().setLayout(AdminLayout);
        AdminLayout.setHorizontalGroup(
            AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(AdminLayout.createSequentialGroup()
                        .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn2))
                    .addGroup(AdminLayout.createSequentialGroup()
                        .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(AdminLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
            .addGroup(AdminLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AdminLayout.setVerticalGroup(
            AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel33)
                .addGap(26, 26, 26)
                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27))
                    .addComponent(btn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26))
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        dsktopan.setLayer(FormAbsence, javax.swing.JLayeredPane.POPUP_LAYER);
        dsktopan.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dsktopan.setLayer(Admin, javax.swing.JLayeredPane.POPUP_LAYER);

        javax.swing.GroupLayout dsktopanLayout = new javax.swing.GroupLayout(dsktopan);
        dsktopan.setLayout(dsktopanLayout);
        dsktopanLayout.setHorizontalGroup(
            dsktopanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dsktopanLayout.createSequentialGroup()
                .addGroup(dsktopanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dsktopanLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(Admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(FormAbsence, javax.swing.GroupLayout.PREFERRED_SIZE, 1220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dsktopanLayout.createSequentialGroup()
                        .addGap(526, 526, 526)
                        .addComponent(jLabel2)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        dsktopanLayout.setVerticalGroup(
            dsktopanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dsktopanLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dsktopanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FormAbsence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dsktopanLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(Admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 204, 255));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        mnFich.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absence_pkg/icons8-ok-48.png"))); // NOI18N
        mnFich.setText("GUEST");
        mnFich.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        mnFich.add(jSeparator1);
        mnFich.add(jSeparator2);

        jMenuBar1.add(mnFich);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dsktopan)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dsktopan)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
 FormAbsence.setVisible(false);
 Admin.setVisible(true);
    }//GEN-LAST:event_formWindowOpened

    private void FormAbsenceInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_FormAbsenceInternalFrameOpened
try {
            Lister();
            Remplir();
                    } catch (IOException | java.lang.NullPointerException ex) {
                         Logger.getLogger(absence_class.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_FormAbsenceInternalFrameOpened

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
       Nouveau();
    }//GEN-LAST:event_btnActionPerformed

    private void bteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteActionPerformed
        try{
            
            if(RechercherCle()==false){
                if((cmb1.getSelectedItem().toString()).compareTo("")!=0 
                    && (txt2.getText()).compareTo("")!=0
                    && (cmb3.getSelectedItem().toString()).compareTo("")!=0 
                    && (txt4.getText()).compareTo("")!=0
                    && (txt5.getText()).compareTo("")!=0
                    && (cmb6.getSelectedItem().toString()).compareTo("")!=0 
                    && (txt7.getText()).compareTo("")!=0
                    && (txt8.getText()).compareTo("")!=0
                    && (txt9.getText()).compareTo("")!=0
                    && (txt10.getText()).compareTo("")!=0){
                Enregistrer();
                JOptionPane.showMessageDialog(this, "L'absence a ete enregistrée");
                Lister();
                Nouveau();
                Remplir();  
                }else{
                    JOptionPane.showMessageDialog(this,"Il faut remplir tous les zones de text");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Cette N° Reference est déja existe");
                cmb1.setSelectedItem("");
                cmb1.requestFocus();
            }
        }catch(IOException |java.lang.NullPointerException e){
         Logger.getLogger(absence_class.class.getName()).log(Level.SEVERE, null, e);
           }
    }//GEN-LAST:event_bteActionPerformed

    private void btrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btrActionPerformed
        try {
            if(RechercherCle()==true){
                Rechercher();
            }else{JOptionPane.showMessageDialog(this, "Ce numero n'existe pas dans les fichier");}
        } catch (IOException ex) {
             Logger.getLogger(absence_class.class.getName()).log(Level.SEVERE, null, ex);
         
             }
    }//GEN-LAST:event_btrActionPerformed

    private void btmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmActionPerformed
       try {
        if(RechercherCle()==true){
        int rep=JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de modifier cet enregistrement?", "Modification", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep==JOptionPane.YES_OPTION){
             Modifier("D:\\MyFolder\\MyFile.don",cmb1.getSelectedItem().toString());
             JOptionPane.showMessageDialog(this, "l'enregistrement est bien modifié");
             Lister(); Remplir();}
        }else{JOptionPane.showMessageDialog(this, "Ce numero n'existe pas dans la fichier pour modification ou la zone est vide");}
            }catch(IOException |NullPointerException e){}
        
    }//GEN-LAST:event_btmActionPerformed

    private void btsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsActionPerformed
         try {
        if(RechercherCle()==true){ 
        int rep=JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de supprimer cet enregistrement?", "Suppression", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep==JOptionPane.YES_OPTION)
            Supprimer("D:\\MyFolder\\MyFile.don",cmb1.getSelectedItem().toString());
            JOptionPane.showMessageDialog(this, "l'enregistrement est bien supprimé");
            Lister();
            Remplir();
        }else{JOptionPane.showMessageDialog(this, "Ce numero n'existe pas dans la fichier pour suppression ou la zone est vide");}
        }catch(IOException |NullPointerException e){
                 Logger.getLogger(absence_class.class.getName()).log(Level.SEVERE, null, e);}
    }//GEN-LAST:event_btsActionPerformed

    private void btfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btfActionPerformed
        FormAbsence.hide();
        Admin.show();
        txtuser.setText("");
        txtpass.setText("");
        txtuser.setBackground(white);
        txtpass.setBackground(white);
    }//GEN-LAST:event_btfActionPerformed

    private void cmb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb1MouseClicked
        try {
            Remplir();
                    } catch (IOException | java.lang.NullPointerException ex) {
                         Logger.getLogger(absence_class.class.getName()).log(Level.SEVERE, null, ex);
      
        }
    }//GEN-LAST:event_cmb1MouseClicked

    private void cmb6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb6MouseClicked

    }//GEN-LAST:event_cmb6MouseClicked

    private void cmb6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb6ItemStateChanged
        if(cmb6.getSelectedItem().toString().compareTo("Present")==0){
            txt7.disable();
            txt7.setText("----");
            txt8.disable();
            txt8.setText("----");
            txt9.disable();
            txt9.setText("----");
            txt10.disable();
            txt10.setText("----");
        }else if(cmb6.getSelectedItem().toString().compareTo("Absent")==0) {
            txt7.enable();
            txt7.setText("");
            txt8.enable();
            txt8.setText("");
            txt9.enable();
            txt9.setText("");
            txt10.enable();
            txt10.setText("");
        }
    }//GEN-LAST:event_cmb6ItemStateChanged

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
    if(txtuser.getText().compareTo(user)==0 && txtpass.getText().compareTo(pass)==0){
            txtuser.setBackground(green);
            txtpass.setBackground(green);
            JOptionPane.showMessageDialog(Admin, "Bienvenue Administrateur");
            Admin.hide();
            mnFich.setVisible(true);
            FormAbsence.show();
            mnFich.setText("LAAGUILI MOHAMED (Admin)");
            try {
            Remplir();
                    } catch (IOException | java.lang.NullPointerException ex) {
                         Logger.getLogger(absence_class.class.getName()).log(Level.SEVERE, null, ex);
      
        }
        }else{
            JOptionPane.showMessageDialog(Admin, "Password ou Username invalid");
            txtuser.setBackground(red);
            txtpass.setBackground(red);}
    }//GEN-LAST:event_btnloginActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
if(txtpass.getText().compareTo(pass)==0){
            JOptionPane.showMessageDialog(Admin, "Checked, password correct");
            txtpass.setBackground(green);
        }else{
            JOptionPane.showMessageDialog(Admin, "Checked, password invalid");
            txtpass.setBackground(red);
        }       
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
         if(txtuser.getText().compareTo(user)==0){
            JOptionPane.showMessageDialog(Admin, "Checked, username correct");
            txtuser.setBackground(green);
        }else{
            JOptionPane.showMessageDialog(Admin, "Checked, username invalid");
            txtuser.setBackground(red);
        }
    }//GEN-LAST:event_btn1ActionPerformed

    private void cmb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb1ActionPerformed
      
    }//GEN-LAST:event_cmb1ActionPerformed

    private void cmb1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb1MouseEntered
        try {
            Remplir();
                    } catch (IOException | java.lang.NullPointerException ex) {
        }
    }//GEN-LAST:event_cmb1MouseEntered

    private void AdminInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_AdminInternalFrameOpened
       mnFich.setVisible(false);
    }//GEN-LAST:event_AdminInternalFrameOpened

    private void AdminInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_AdminInternalFrameActivated
        mnFich.setVisible(false);
    }//GEN-LAST:event_AdminInternalFrameActivated

    private void dsktopanMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_dsktopanMouseWheelMoved
         mnFich.setVisible(false);
    }//GEN-LAST:event_dsktopanMouseWheelMoved

    private void tblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseEntered
        try {
            Lister();
        } catch (IOException ex) {
            Logger.getLogger(absence_class.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchElementException ex) {
            Logger.getLogger(absence_class.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblMouseEntered

    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(absence_class.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
        java.awt.EventQueue.invokeLater(() -> {
            new absence_class().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame Admin;
    private javax.swing.JInternalFrame FormAbsence;
    private javax.swing.JButton bte;
    private javax.swing.JButton btf;
    private javax.swing.JButton btm;
    private javax.swing.JButton btn;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton btr;
    private javax.swing.JButton bts;
    private javax.swing.JComboBox<String> cmb1;
    private javax.swing.JComboBox<String> cmb3;
    private javax.swing.JComboBox<String> cmb6;
    private javax.swing.JDesktopPane dsktopan;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JMenu mnFich;
    private javax.swing.JTable tbl;
    private javax.swing.JTextArea txt10;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt4;
    private javax.swing.JTextField txt5;
    private javax.swing.JTextField txt7;
    private javax.swing.JTextField txt8;
    private javax.swing.JTextField txt9;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
