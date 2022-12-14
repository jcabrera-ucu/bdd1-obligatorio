
package bdd.ui;

import bdd.Aplicativo;
import bdd.DatosPermiso;
import bdd.DatosPersonaPregunta;
import bdd.DatosPersonas;
import bdd.DatosPersonasYPermisos;
import bdd.DatosSolicitudPermiso;
import bdd.Menu;
import bdd.Persona;
import bdd.Pregunta;
import bdd.RolNegocio;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolas
 */
public class Aplicacion_Dummy extends javax.swing.JFrame {
    private final Persona persona;
    private final DatosPersonas datosPersonas;
    private final DatosPermiso datosPermiso;
    private final DatosPersonasYPermisos datosPersonasYPermisos;
    private final DatosSolicitudPermiso datosSolicitudesPermisos;
    private final List<RolNegocio> opcionesRolNegocio;
    private final List<Aplicativo> opcionesAplicativo;
    private List<Menu> menus;

    /**
     * Creates new form Aplicacion_Dummy
     */
    public Aplicacion_Dummy(Persona persona,
                            DatosPersonas datosPersonas, 
                            DatosPermiso datosPermiso,
                            DatosPersonasYPermisos datosPersonasYPermisos,
                            DatosSolicitudPermiso datosSolicitudesPermisos,
                            List<RolNegocio> roles,
                            List<Aplicativo> aplicativos) {
        initComponents();
        
        this.persona = persona;
        this.datosPersonas = datosPersonas;
        this.datosPermiso = datosPermiso;
        this.datosPersonasYPermisos = datosPersonasYPermisos;
        this.datosSolicitudesPermisos = datosSolicitudesPermisos;
        this.opcionesRolNegocio = roles;
        this.opcionesAplicativo = aplicativos;
        this.menus = new LinkedList<>();
        
        try {
            var permisos = datosPersonasYPermisos.getById(persona.userId);
            if (permisos.persona != null) {
                this.menus = permisos.menus;
                permisos.aplicativos.forEach(app -> {                    
                    switch (app.getAppId()) {
                        // FIXME: Esto no deber??a estar hardcodeado
                        case 1 -> facturacionButton.setEnabled(true);
                        case 2 -> inventarioButton.setEnabled(true);
                        case 3 -> menuButton.setEnabled(true);
                        case 4 -> gestionDePermisosButton.setEnabled(true);
                        default -> { }
                    }
                 });
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aplicacion_Dummy.class.getName()).log(Level.SEVERE, null, ex);
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        gestionDePermisosButton = new javax.swing.JButton();
        facturacionButton = new javax.swing.JButton();
        menuButton = new javax.swing.JButton();
        inventarioButton = new javax.swing.JButton();
        solicitarPermisosButton = new javax.swing.JButton();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gestionDePermisosButton.setText("Gesti??n de Permisos");
        gestionDePermisosButton.setEnabled(false);
        gestionDePermisosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionDePermisosButtonActionPerformed(evt);
            }
        });

        facturacionButton.setText("Facturaci??n");
        facturacionButton.setEnabled(false);
        facturacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturacionButtonActionPerformed(evt);
            }
        });

        menuButton.setText("Men??");
        menuButton.setEnabled(false);
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });

        inventarioButton.setText("Inventario");
        inventarioButton.setEnabled(false);
        inventarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventarioButtonActionPerformed(evt);
            }
        });

        solicitarPermisosButton.setText("Solicitar Permisos");
        solicitarPermisosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solicitarPermisosButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(facturacionButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gestionDePermisosButton, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addComponent(menuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inventarioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(solicitarPermisosButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gestionDePermisosButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(facturacionButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inventarioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(solicitarPermisosButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void solicitarPermisosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solicitarPermisosButtonActionPerformed
        var frameAplicacionS = new SelectAplicacion( 
            persona,
            datosPersonas, 
            datosPermiso,
            opcionesRolNegocio, 
            opcionesAplicativo
        );
        frameAplicacionS.setVisible(true);
    }//GEN-LAST:event_solicitarPermisosButtonActionPerformed

    private void gestionDePermisosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionDePermisosButtonActionPerformed
         var gestor = new GestionIdentidadesPermisos(
                datosSolicitudesPermisos, datosPermiso);
         gestor.setVisible(true);
    }//GEN-LAST:event_gestionDePermisosButtonActionPerformed

    private void inventarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventarioButtonActionPerformed
        
        var frame = new AplicativoTontito(menus.stream().filter(x -> x.appId == 2).distinct().toList());
        frame.setVisible(true);
    }//GEN-LAST:event_inventarioButtonActionPerformed

    private void facturacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturacionButtonActionPerformed
        var frame = new AplicativoTontito(menus.stream().filter(x -> x.appId == 1).distinct().toList());
        frame.setVisible(true);
    }//GEN-LAST:event_facturacionButtonActionPerformed

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        var frame = new AplicativoTontito(menus.stream().filter(x -> x.appId == 3).distinct().toList());
        frame.setVisible(true);
    }//GEN-LAST:event_menuButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton facturacionButton;
    private javax.swing.JButton gestionDePermisosButton;
    private javax.swing.JButton inventarioButton;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JButton menuButton;
    private javax.swing.JButton solicitarPermisosButton;
    // End of variables declaration//GEN-END:variables
}
