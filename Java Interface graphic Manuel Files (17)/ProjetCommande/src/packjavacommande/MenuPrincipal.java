/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packjavacommande;

/**
 *
 * @author Abdel
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuGeneral
     */
    public MenuPrincipal() {
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

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        dsktopan = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnFich = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        smnclt = new javax.swing.JMenuItem();
        smnfrsNouv = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        smnQuit = new javax.swing.JMenuItem();
        mnop = new javax.swing.JMenu();
        smncmd = new javax.swing.JMenuItem();
        smnbliv = new javax.swing.JMenuItem();
        smnfact = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Les opérations d'achats ventes");
        setName("MenuPrincipal"); // NOI18N

        jDesktopPane1.setBackground(new java.awt.Color(255, 204, 255));

        javax.swing.GroupLayout dsktopanLayout = new javax.swing.GroupLayout(dsktopan);
        dsktopan.setLayout(dsktopanLayout);
        dsktopanLayout.setHorizontalGroup(
            dsktopanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1618, Short.MAX_VALUE)
        );
        dsktopanLayout.setVerticalGroup(
            dsktopanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );

        jDesktopPane1.setLayer(dsktopan, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dsktopan)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(dsktopan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 204, 255));

        mnFich.setText("Fichier");
        mnFich.add(jSeparator1);

        smnclt.setText("Client");
        smnclt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smncltActionPerformed(evt);
            }
        });
        mnFich.add(smnclt);

        smnfrsNouv.setText("Fournisseur");
        smnfrsNouv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smnfrsNouvActionPerformed(evt);
            }
        });
        mnFich.add(smnfrsNouv);
        mnFich.add(jSeparator2);

        smnQuit.setText("Quitter");
        smnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smnQuitActionPerformed(evt);
            }
        });
        mnFich.add(smnQuit);

        jMenuBar1.add(mnFich);

        mnop.setText("Opérations");

        smncmd.setText("Commande");
        smncmd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smncmdActionPerformed(evt);
            }
        });
        mnop.add(smncmd);

        smnbliv.setText("Bon livraison");
        mnop.add(smnbliv);

        smnfact.setText("Facture");
        mnop.add(smnfact);

        jMenuBar1.add(mnop);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void smncltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smncltActionPerformed
        FormClient fclt =new FormClient();
        dsktopan.add(fclt);
        fclt.setVisible(true);
    }//GEN-LAST:event_smncltActionPerformed

    private void smncmdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smncmdActionPerformed
    Commande cmd=new Commande();
    cmd.setVisible(true);
    }//GEN-LAST:event_smncmdActionPerformed

    private void smnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smnQuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_smnQuitActionPerformed

    private void smnfrsNouvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smnfrsNouvActionPerformed
        new NewJFrame().setVisible(true);
    }//GEN-LAST:event_smnfrsNouvActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dsktopan;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu mnFich;
    private javax.swing.JMenu mnop;
    private javax.swing.JMenuItem smnQuit;
    private javax.swing.JMenuItem smnbliv;
    private javax.swing.JMenuItem smnclt;
    private javax.swing.JMenuItem smncmd;
    private javax.swing.JMenuItem smnfact;
    private javax.swing.JMenuItem smnfrsNouv;
    // End of variables declaration//GEN-END:variables
}
