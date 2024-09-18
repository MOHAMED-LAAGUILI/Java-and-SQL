package SommePackage;

import javax.swing.JOptionPane;

public class SommeForm extends javax.swing.JFrame {

    public SommeForm() {
        initComponents();
    
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btc = new javax.swing.JButton();
        btf = new javax.swing.JButton();
        txtpn = new javax.swing.JTextField();
        txtdn = new javax.swing.JTextField();
        txts = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Somme de deux nombres");
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel1.setText("Somme des nombres");
        jLabel1.setName("lbt"); // NOI18N

        jLabel2.setText("Premier nombre");
        jLabel2.setName("lbp"); // NOI18N

        jLabel3.setText("Deuxiéme nombre");
        jLabel3.setName("lbd"); // NOI18N

        jLabel4.setText("Somme");
        jLabel4.setName("lbs"); // NOI18N

        btc.setBackground(new java.awt.Color(51, 102, 255));
        btc.setText("Calculer");
        btc.setName("btc"); // NOI18N
        btc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcActionPerformed(evt);
            }
        });

        btf.setBackground(new java.awt.Color(51, 102, 255));
        btf.setText("Fermer");
        btf.setName("btf"); // NOI18N
        btf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btfActionPerformed(evt);
            }
        });

        txtpn.setName("txtp"); // NOI18N

        txtdn.setName("txtdn"); // NOI18N

        txts.setEditable(false);
        txts.setName("txts"); // NOI18N
        txts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdn, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpn, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txts, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btc)
                        .addGap(55, 55, 55)
                        .addComponent(btf)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtdn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btc)
                    .addComponent(btf))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public float CalculerSomme(float p, float d){
        return p + d;
    }
    private void btcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcActionPerformed
       
       if(txtpn.getText().compareTo("")!=0 && txtdn.getText().compareTo("")!=0){
       float t1 = Float.parseFloat(txtpn.getText());
       float t2 = Float.parseFloat(txtdn.getText());
       txts.setText(String.valueOf(CalculerSomme(t1,t2)));
       }else{
       JOptionPane.showMessageDialog(this,"il faut remplir les zone de text","Erreur de saisie", JOptionPane.ERROR_MESSAGE);
       txtpn.setText("");
       txtdn.setText("");
       txtpn.requestFocus();
       }
      
    }//GEN-LAST:event_btcActionPerformed

    private void txtsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsActionPerformed
        
    }//GEN-LAST:event_txtsActionPerformed

    private void btfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btfActionPerformed
System.exit(0);
    }//GEN-LAST:event_btfActionPerformed

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
            java.util.logging.Logger.getLogger(SommeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SommeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SommeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SommeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SommeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btc;
    private javax.swing.JButton btf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtdn;
    private javax.swing.JTextField txtpn;
    private javax.swing.JTextField txts;
    // End of variables declaration//GEN-END:variables
}
