package bdd.ui;

import bdd.Persona;

public class LoginPersonas extends javax.swing.JFrame {

    /**
     * Creates new form LoginPersonas
     */
    public LoginPersonas() {
        initComponents();
    }
    
    public void mostrarError(String mensaje) {
        var f = new ErrorDialog(this, true, mensaje);
        f.setVisible(true);
    }
    
    public Persona logearPersona() {
        if (String.valueOf(Contraseña.getPassword()).isEmpty()) {
            mostrarError("El campo Contraseña no puede estar vacío");
            return null;
        }
        
        if (Cedula.getText().trim().isEmpty()) {
            mostrarError("El campo Cédula no puede estar vacío");
            return null;
        }/* else {
            poner algo para ver que la cedula sea un int
        }*/
        String password = String.valueOf(Contraseña.getPassword());
        var userId = Integer.parseInt(Cedula.getText());
        
        //HACER QUE LOGE Y TRAIGA LA PERSONA
        
        return null;
    };
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Cedula = new javax.swing.JTextField();
        Contraseña = new javax.swing.JPasswordField();
        BottonLogin = new javax.swing.JButton();
        BotonContraseña = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Iniciar Sesión");

        jLabel2.setText("Cedula");

        jLabel4.setText("Contraseña");

        Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseñaActionPerformed(evt);
            }
        });

        BottonLogin.setText("Hecho");
        BottonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottonLoginActionPerformed(evt);
            }
        });

        BotonContraseña.setText("Olvidé mi contraseña.");
        BotonContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonContraseñaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Cedula)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Contraseña, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BotonContraseña)
                                .addGap(98, 98, 98)
                                .addComponent(BottonLogin)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonContraseña)
                    .addComponent(BottonLogin))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContraseñaActionPerformed

    private void BotonContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonContraseñaActionPerformed
        // TODO add your handling code here:
        var frameContra = new ContraseñaOlvidada();
        frameContra.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_BotonContraseñaActionPerformed

    private void BottonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottonLoginActionPerformed
        // TODO add your handling code here:
        Persona p = logearPersona();
        if (p != null) {
            var frameAplicacionS = new SelectAplicacion();
            frameAplicacionS.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_BottonLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonContraseña;
    private javax.swing.JButton BottonLogin;
    private javax.swing.JTextField Cedula;
    private javax.swing.JPasswordField Contraseña;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
