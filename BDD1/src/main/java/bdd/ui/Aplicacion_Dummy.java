/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bdd.ui;

/**
 *
 * @author Nicolas
 */
public class Aplicacion_Dummy extends javax.swing.JFrame {

    /**
     * Creates new form Aplicacion_Dummy
     */
    public Aplicacion_Dummy() {
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

        Fritar = new javax.swing.JButton();
        Hervir = new javax.swing.JButton();
        Hornear = new javax.swing.JButton();
        Servir = new javax.swing.JButton();
        Cobrar = new javax.swing.JButton();
        Reponer = new javax.swing.JButton();
        Batir = new javax.swing.JButton();
        Echar = new javax.swing.JButton();
        Lavar = new javax.swing.JButton();
        Vigilar = new javax.swing.JButton();
        Putear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fritar.setText("Fritar");

        Hervir.setText("Hervir");

        Hornear.setText("Hornear");

        Servir.setText("Servir");

        Cobrar.setText("Cobrar");

        Reponer.setText("Reponer");

        Batir.setText("Batir");

        Echar.setText("Echar");

        Lavar.setText("Lavar");

        Vigilar.setText("Vigilar");

        Putear.setText("Putear");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Fritar)
                    .addComponent(Hervir)
                    .addComponent(Hornear)
                    .addComponent(Servir)
                    .addComponent(Reponer)
                    .addComponent(Cobrar))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Batir)
                    .addComponent(Putear)
                    .addComponent(Echar)
                    .addComponent(Lavar)
                    .addComponent(Vigilar))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fritar)
                    .addComponent(Batir))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Hervir)
                    .addComponent(Echar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Hornear)
                    .addComponent(Lavar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Servir)
                    .addComponent(Vigilar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cobrar)
                    .addComponent(Putear))
                .addGap(18, 18, 18)
                .addComponent(Reponer)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Aplicacion_Dummy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplicacion_Dummy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplicacion_Dummy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplicacion_Dummy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplicacion_Dummy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Batir;
    private javax.swing.JButton Cobrar;
    private javax.swing.JButton Echar;
    private javax.swing.JButton Fritar;
    private javax.swing.JButton Hervir;
    private javax.swing.JButton Hornear;
    private javax.swing.JButton Lavar;
    private javax.swing.JButton Putear;
    private javax.swing.JButton Reponer;
    private javax.swing.JButton Servir;
    private javax.swing.JButton Vigilar;
    // End of variables declaration//GEN-END:variables
}
