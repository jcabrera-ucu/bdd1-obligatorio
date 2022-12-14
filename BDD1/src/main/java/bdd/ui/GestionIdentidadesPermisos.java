package bdd.ui;

import bdd.DatosPermiso;
import bdd.DatosSolicitudPermiso;
import bdd.Permiso;
import bdd.SolicitudPermiso;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;

public class GestionIdentidadesPermisos extends javax.swing.JFrame {

    private final DatosSolicitudPermiso datosSolicitudPermiso;
    private List<SolicitudPermiso> permisos;
    private final DatosPermiso datosPermisos;
    /**
     * Creates new form GestionIdentidadesPermisos
     */
    public GestionIdentidadesPermisos(DatosSolicitudPermiso datosSolicitudPermiso, DatosPermiso datosPermiso) {
        this.datosSolicitudPermiso = datosSolicitudPermiso;
        this.datosPermisos = datosPermiso;
       
        initComponents();
        actualizarTabla();
    }

    public void actualizarTabla(){
        try {
            this.permisos = datosSolicitudPermiso.getAll();

            DefaultTableModel model = new DefaultTableModel();
            model.setDataVector(
                    (Object[][]) permisos.stream()
                            .map((x) -> new String[]{
                        String.valueOf(x.permiso.userId),
                        x.nombres,
                        x.apellidos,
                        x.nombreapp,
                        x.descripcion_rol_neg,
                        x.permiso.fechaSolicitud != null ? x.permiso.fechaSolicitud.toString() : "",
                        x.permiso.fechaAutorizacion != null ? x.permiso.fechaAutorizacion.toString() : "",
                        x.permiso.estado
                    }).toArray(String[][]::new),
                    new String[]{
                        "CI",
                        "Nombre",
                        "Apellido",
                        "Aplicativo",
                        "Rol",
                        "Fecha Solicitud",
                        "Fecha Autorizacion",
                        "Estado",}
            );
            tabla.setModel(model);

        } catch (SQLException ex) {
            this.permisos = null;
            Logger.getLogger(GestionIdentidadesPermisos.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        BotonValidar = new javax.swing.JButton();
        BotonRechazar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Actualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario_id", "App_id", "Rol_neg_Id", "Fecha_Solicitud", "Fecha_Autorizacion", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        BotonValidar.setBackground(new java.awt.Color(204, 255, 204));
        BotonValidar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BotonValidar.setText("Validar");
        BotonValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonValidarActionPerformed(evt);
            }
        });

        BotonRechazar.setBackground(new java.awt.Color(255, 204, 204));
        BotonRechazar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BotonRechazar.setText("Rechazar");
        BotonRechazar.setToolTipText("");
        BotonRechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRechazarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Gestion de permisos de usuarios:");

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BotonValidar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotonRechazar))
                            .addComponent(Actualizar))
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonValidar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonRechazar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Actualizar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonValidarActionPerformed

        int column = 0;
        int row = tabla.getSelectedRow();
        Permiso permiso = permisos.get(row).permiso;
        permiso.autorizar();
        try {
            datosPermisos.update(permiso);
            actualizarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(GestionIdentidadesPermisos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_BotonValidarActionPerformed

    private void BotonRechazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRechazarActionPerformed
        // TODO add your handling code here:
          int column = 0;
        int row = tabla.getSelectedRow();
        Permiso permiso = permisos.get(row).permiso;
        permiso.denegar();
        try {
            datosPermisos.update(permiso);
            actualizarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(GestionIdentidadesPermisos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonRechazarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        // TODO add your handling code here:
        actualizarTabla();

    }//GEN-LAST:event_ActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton BotonRechazar;
    private javax.swing.JButton BotonValidar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
