
package packimpotsocietemap;

import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

public class ImpotSocieteMap extends javax.swing.JFrame {
    java.util.SortedMap<Object,societe> sm;
    societe imp;
    int cle;
    int genererCle(){
        cle=1;
        if(!sm.isEmpty()){
            java.util.Set st=sm.keySet();
            Iterator it = st.iterator();
            while(it.hasNext()){
                imp=(societe)sm.get(it.next());
                cle++;
            }
        }
        return cle;
     }
     public boolean rechercherCle(){
             boolean bl = false;
        java.util.Set st=sm.keySet();
        Iterator it = st.iterator();
        while(it.hasNext()){
            imp=(societe)sm.get(it.next());
            if(imp.np.compareTo(cmbnum.getSelectedItem().toString()) == 0){
                break;
            }
        }
        return bl;
     }
    private void ajouter(){
        societe soc=new societe();
        soc.np = cmbnum.getSelectedItem().toString();
        soc.rs = txtrs.getText();
        soc.rec = Float.parseFloat(txtrec.getText());
        soc.dep = Float.parseFloat(txtdep.getText());
        soc.ben = Float.parseFloat(txtben.getText());
        soc.is = Float.parseFloat(txtis.getText());
        txt.setText(String.valueOf(genererCle()));
        int clef=genererCle();
        sm.put(clef,soc);
    }
    
    void rechercher(){
        java.util.Set st=sm.keySet();
        Iterator it = st.iterator();
        while(it.hasNext()){
            int cl=(int)it.next();
            imp=(societe)sm.get(cl);
            if(imp.np.compareTo(cmbnum.getSelectedItem().toString()) == 0){
                txtrs.setText(imp.rs);
                txtrec.setText( String.valueOf(imp.rec) );
                txtdep.setText( String.valueOf(imp.dep));
                txtben.setText(String.valueOf(imp.ben));
                txtis.setText(String.valueOf(imp.is)); 
                break;
            }
        }
    }
    
    void lister(){
        
        ((DefaultTableModel)tableimp.getModel()).setRowCount(0);
        java.util.Set st=sm.keySet();
        Iterator it = st.iterator();
        while(it.hasNext()){
           imp=new societe();
           imp=(societe)sm.get(it.next());
           ((DefaultTableModel) tableimp.getModel()).addRow(new Object[]{imp.np,imp.rs,imp.rec,imp.dep,imp.ben,imp.is});
        }
    }
    void modifier(){
        boolean bl=false;
        imp=new societe();
        java.util.Set st=sm.keySet();
        Iterator it = st.iterator();
        while(it.hasNext()){
            int cl=(int)it.next();
            imp=(societe)sm.get(cl);
            if(imp.np.compareTo(cmbnum.getSelectedItem().toString()) == 0){
                imp.rs = txtrs.getText();
                imp.rec = Float.parseFloat(txtrec.getText());
                imp.dep = Float.parseFloat(txtdep.getText());
                imp.ben = Float.parseFloat(txtben.getText());
                imp.is = Float.parseFloat(txtis.getText());
                sm.replace(cl,imp);
                bl=true;
                break;
            }
        }
        //if(bl==true)
            //sm.add(imp); 
    }
    void supprimer(){
        imp=new societe();
        java.util.Set st=sm.keySet();
        Iterator it = st.iterator();
        while(it.hasNext()){
            int cl=(int)it.next();
            imp=(societe)sm.get(cl);
            if(imp.np.compareTo(cmbnum.getSelectedItem().toString()) == 0){
               sm.remove(cl);
               break;
            }
        }
    }
    private float calculer_benifice(float r,float d){
        return r-d;
    }
    private float calculer_impot(float bn){
        float ips;
        if(bn<=300000)
            ips=bn*0.1f;
        else if(bn<=1000000)
            ips=bn*0.2f;
        else
            ips=bn*0.31f;
        return ips;
    }
    private void nouveau(){
        cmbnum.setSelectedIndex(-1);
        txtrs.setText("");
        txtrec.setText(null);
        txtdep.setText(null);
        txtben.setText(null);
        txtis.setText(null);
        cmbnum.requestFocus();
        /*DefaultTableModel dt = (DefaultTableModel) tablepop.getModel();
        dt.setRowCount(0);*/
        ((DefaultTableModel) tableimp.getModel()).setRowCount(0);  
    }
    boolean estNumerique(String st){
        boolean bl=true;
        for (int i=0;i<st.length();i++ ){ 
            if (Character.isDigit(st.charAt(i))||st.charAt(i)=='.') {  } 
            else { 
                bl= false; 
                break;
            }
        }
        return bl;
    }
    public ImpotSocieteMap() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableimp = new javax.swing.JTable();
        btf = new javax.swing.JButton();
        cmbnum = new javax.swing.JComboBox<>();
        btr = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtrs = new javax.swing.JTextField();
        bts = new javax.swing.JButton();
        txtben = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtrec = new javax.swing.JTextField();
        btm = new javax.swing.JButton();
        txtdep = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtis = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btl = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        bta = new javax.swing.JButton();
        txt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel7.setText("Montant de l'impôt       :");

        tableimp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Numéro patente", "Raison social", "Recettes", "Dépeses", "Bénéfice", "Montant de l'IS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Long.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableimp);

        btf.setText("Fermer");
        btf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btfActionPerformed(evt);
            }
        });

        cmbnum.setEditable(true);

        btr.setText("Rechercher");
        btr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btrActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Information sur la société");

        bts.setText("Supprimer");
        bts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsActionPerformed(evt);
            }
        });

        jLabel2.setText("Numéro patente             :");

        txtrec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrecActionPerformed(evt);
            }
        });

        btm.setText("Modifier");
        btm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmActionPerformed(evt);
            }
        });

        txtdep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdepKeyPressed(evt);
            }
        });

        jLabel3.setText(" Raison social                  :");

        jLabel4.setText("Recettes                        :");

        btn.setText("Nouveau");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        jLabel5.setText("Dépenses                      :");

        btl.setText("Lister");
        btl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlActionPerformed(evt);
            }
        });

        jLabel6.setText("Bénéfice                        :");

        bta.setText("Ajouter");
        bta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(32, 32, 32))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(33, 33, 33)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtdep, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtben, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtrs)
                                    .addComponent(txtrec)
                                    .addComponent(cmbnum, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtis, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bts, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtrs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtrec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtdep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtben, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btr, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bts, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btfActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btfActionPerformed

    private void btrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btrActionPerformed
        rechercher();
    }//GEN-LAST:event_btrActionPerformed

    private void btsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsActionPerformed
        int rep=javax.swing.JOptionPane.showConfirmDialog(this,"Êtes-vous sûr de supprimer cette société", "Suppression d'une sociéte", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE);
        if (rep==javax.swing.JOptionPane.OK_OPTION)
        supprimer();
    }//GEN-LAST:event_btsActionPerformed

    private void txtrecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrecActionPerformed

    private void btmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmActionPerformed
        modifier();
    }//GEN-LAST:event_btmActionPerformed

    private void txtdepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdepKeyPressed
        if(evt.getKeyCode()==10){
            if(estNumerique(txtrec.getText())==true){
                if(estNumerique(txtdep.getText())){
                    float rt = Float.parseFloat(txtrec.getText());
                    float dc = Float.parseFloat(txtdep.getText());
                    txtben.setText(String.valueOf(calculer_benifice(rt,dc)));
                    txtis.setText(String.valueOf(calculer_impot(rt-dc)));
                }
                else{
                    javax.swing.JOptionPane.showMessageDialog(this, "Entrer une valeur numérique","Erreur de saisie",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    txtdep.setText(null);
                    txtdep.requestFocus();
                }
            }
            else{
                javax.swing.JOptionPane.showMessageDialog(this, "Entrer une valeur numérique","Erreur de saisie",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                txtrec.setText(null);
                txtrec.requestFocus();
            }
        }
    }//GEN-LAST:event_txtdepKeyPressed

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        nouveau();
    }//GEN-LAST:event_btnActionPerformed

    private void btlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlActionPerformed
        lister();
    }//GEN-LAST:event_btlActionPerformed

    private void btaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaActionPerformed
        if(rechercherCle() == false){
        ajouter();    
        }else
            JOptionPane(this,"","",);
        
    }//GEN-LAST:event_btaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        sm=new java.util.TreeMap<>();
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImpotSocieteMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImpotSocieteMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImpotSocieteMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImpotSocieteMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImpotSocieteMap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bta;
    private javax.swing.JButton btf;
    private javax.swing.JButton btl;
    private javax.swing.JButton btm;
    private javax.swing.JButton btn;
    private javax.swing.JButton btr;
    private javax.swing.JButton bts;
    private javax.swing.JComboBox<String> cmbnum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableimp;
    private javax.swing.JTextField txt;
    private javax.swing.JTextField txtben;
    private javax.swing.JTextField txtdep;
    private javax.swing.JTextField txtis;
    private javax.swing.JTextField txtrec;
    private javax.swing.JTextField txtrs;
    // End of variables declaration//GEN-END:variables
}
class societe implements Comparable<Object>{
    String np,rs;
    float rec,dep,ben,is;
    @Override
    public int compareTo(Object ob) {
        return this.np.compareTo(((societe)ob).np);
            
    }
}