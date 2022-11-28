
package bdd.ui;


import bdd.DatosPersonas;
import bdd.Persona;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;


public class CambiarContraseña extends javax.swing.JFrame {
    
    private final Persona usuario;
    private final DatosPersonas datosPersonas;
    
    public CambiarContraseña(Persona Usuario, DatosPersonas DatosPersonas) {
        
        initComponents();
        
        this.usuario = Usuario;
        this.datosPersonas = DatosPersonas;
    }
    
    public void mostrarError(String mensaje) {
        var f = new ErrorDialog(this, true, mensaje);
        f.setVisible(true);
    }
    
    public boolean CambiarContraseña() throws SQLException {
        if (String.valueOf(Contraseña_Anterior.getPassword()).isEmpty()) {
            mostrarError("El campo Contraseña anterior no puede estar vacío");
            return false;
        }
        if (String.valueOf(Contraseña_Nueva.getPassword()).isEmpty()) {
            mostrarError("El campo Contraseña nueva no puede estar vacío");
            return false;
        }
        
        String contrA = String.valueOf(Contraseña_Anterior.getPassword());
        String contrN = String.valueOf(Contraseña_Nueva.getPassword());
        
        if(BCrypt.checkpw(contrA, usuario.hashpwd)){
            usuario.setPassword(contrN);
            this.datosPersonas.updateOrCreate(usuario);
            return true;
        } else{
            mostrarError("La contraseña anterior es incorrecta");
            return false;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Boton = new javax.swing.JButton();
        L_ContraseñaNueva = new javax.swing.JLabel();
        L_contraseñaAnterior = new javax.swing.JLabel();
        L_Titulo = new javax.swing.JLabel();
        Contraseña_Nueva = new javax.swing.JPasswordField();
        Contraseña_Anterior = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Boton.setText("Cambiar contraseña");
        Boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActionPerformed(evt);
            }
        });

        L_ContraseñaNueva.setText("Contraseña nueva:");

        L_contraseñaAnterior.setText("Contraseña anterior:");

        L_Titulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        L_Titulo.setText("Cambiar contraseña:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(L_contraseñaAnterior)
                            .addComponent(L_Titulo)
                            .addComponent(L_ContraseñaNueva))
                        .addGap(0, 246, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Contraseña_Nueva)
                            .addComponent(Contraseña_Anterior))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Boton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L_Titulo)
                .addGap(18, 18, 18)
                .addComponent(L_contraseñaAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Contraseña_Anterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(L_ContraseñaNueva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Contraseña_Nueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Boton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonActionPerformed
        boolean exito = false;
        try {
            // TODO add your handling code here:
            exito = CambiarContraseña();
        } catch (SQLException ex) {
            Logger.getLogger(CambiarContraseña.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(exito){
            var frameAplicacionS = new SelectAplicacion(usuario, datosPersonas);
            frameAplicacionS.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_BotonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton;
    private javax.swing.JPasswordField Contraseña_Anterior;
    private javax.swing.JPasswordField Contraseña_Nueva;
    private javax.swing.JLabel L_ContraseñaNueva;
    private javax.swing.JLabel L_Titulo;
    private javax.swing.JLabel L_contraseñaAnterior;
    // End of variables declaration//GEN-END:variables
}
