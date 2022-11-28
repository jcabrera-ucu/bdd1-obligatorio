
package bdd.ui;

import bdd.Aplicativo;
import bdd.DatosPermiso;
import bdd.DatosPersonaPregunta;
import bdd.DatosPersonas;
import bdd.Permiso;
import bdd.Persona;
import bdd.Pregunta;
import bdd.RolNegocio;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolas
 */
public class SelectAplicacion extends javax.swing.JFrame {
    private final Persona usuario;
    private final DatosPersonas datosPersonas;
    private final DatosPermiso datosPermiso;
    private final List<RolNegocio> opcionesRolNegocio;
    private final List<Aplicativo> opcionesAplicativo;

//    private final DatosPersonaPregunta datosPersonaPregunta;

    
    
    public SelectAplicacion(Persona Usuario, 
                            DatosPersonas DatosPersonas, 
                            DatosPermiso datosPermiso,
                            List<RolNegocio> roles,
                            List<Aplicativo> aplicativos) {
        initComponents();
        
        this.usuario = Usuario;
        this.datosPersonas = DatosPersonas;
        this.datosPermiso = datosPermiso;
        this.opcionesRolNegocio = roles;
        this.opcionesAplicativo = aplicativos;
        
        opcionesRolNegocio.forEach(x -> {
            rolesComboBox.addItem(x.getDescripcionRolNeg());
        });
        opcionesAplicativo.forEach(x -> {
            aplicativosComboBox.addItem(x.getNombreApp());
        });
    }
//    
//    public void mostrarError(String mensaje) {
//        var f = new ErrorDialog(this, true, mensaje);
//        f.setVisible(true);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        rolesComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        aplicativosComboBox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        CambiarContraseña = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Aplicativos");

        jLabel2.setText("Seleccione su Rol");

        jLabel3.setText("Seleccione que aplicativo desea abrir");

        jButton1.setText("Hecho");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        CambiarContraseña.setText("Cambiar contraseña");
        CambiarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarContraseñaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rolesComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aplicativosComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CambiarContraseña))
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 183, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rolesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aplicativosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CambiarContraseña)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //FALTA LA LOGICA PARA ELEGIR LA APLICACION

        var aplicativo = opcionesAplicativo.get(aplicativosComboBox.getSelectedIndex());  
        var rol = opcionesRolNegocio.get(rolesComboBox.getSelectedIndex());  
        
        try {
            datosPermiso.create(new Permiso(
                    usuario.userId,
                    rol.getRolNegId(),
                    aplicativo.getAppId()
            ));
        } catch (SQLException ex) {
            Logger.getLogger(SelectAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        var frameAplicacion = new Aplicacion_Dummy();
        frameAplicacion.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CambiarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarContraseñaActionPerformed
        var frameContraC = new CambiarContraseña(usuario, datosPersonas, datosPermiso, opcionesRolNegocio, opcionesAplicativo);
        frameContraC.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CambiarContraseñaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CambiarContraseña;
    private javax.swing.JComboBox<String> aplicativosComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> rolesComboBox;
    // End of variables declaration//GEN-END:variables
}
