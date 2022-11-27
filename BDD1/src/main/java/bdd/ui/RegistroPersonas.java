package bdd.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import bdd.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroPersonas extends javax.swing.JFrame {

    private final List<Pregunta> opcionesPreguntas;
    private final List<RolNegocio> opcionesRolNegocio;
    private final List<Aplicativo> opcionesAplicativo;

    private final DatosPersonas datosPersonas;
    private final DatosPersonaPregunta datosPersonaPregunta;


    /**
     * Creates new form RegistroPersonas
     *
     * @param preguntas
     * @param roles
     * @param aplicativos
     */
    public RegistroPersonas(DatosPersonas datosPersonas, 
                            DatosPersonaPregunta datosPersonaPregunta,
                            List<Pregunta> preguntas, 
                            List<RolNegocio> roles,
                            List<Aplicativo> aplicativos) {
        initComponents();

        this.datosPersonas = datosPersonas;
        this.datosPersonaPregunta = datosPersonaPregunta;

        this.opcionesPreguntas = preguntas;
        this.opcionesRolNegocio = roles;
        this.opcionesAplicativo = aplicativos;

        opcionesPreguntas.forEach(x -> {
            preguntasComboBox.addItem(x.getPregunta());
        });

        // opcionesRolNegocio.forEach(x -> {
        //     rolComboBox.addItem(x.getDescripcionRolNeg());
        // });

        // opcionesAplicativo.forEach(x -> {
        //     AplicativosComboBox.addItem(x.getNombreApp());
        // });
    }
    
    public void mostrarError(String mensaje) {
        var f = new ErrorDialog(this, true, mensaje);
        f.setVisible(true);
    }

    public Persona registrarPersona() {
        if (preguntasComboBox.getSelectedIndex() == 0) {
            mostrarError("Seleccione una pregunta de seguridad");
            return null;
        }
        
        String nombre = Nombre.getText().trim();
        String apellido = Apellido.getText().trim();
        String direccion = Direccion.getText().trim();
        String ciudad = Ciudad.getText().trim();
        String departamento = Departamento.getText().trim();
        String respuesta = respuestaTextArea.getText().trim();
        String password = String.valueOf(Password.getPassword());
        
        if (nombre.isEmpty()) {
            mostrarError("El campo Nombre no puede estar vacío");
            return null;
        }
        
        if (apellido.isEmpty()) {
            mostrarError("El campo Apellido no puede estar vacío");
            return null;
        }
        
        if (direccion.isEmpty()) {
            mostrarError("El campo Direccion no puede estar vacío");
            return null;
        }
        
        if (ciudad.isEmpty()) {
            mostrarError("El campo Ciudad no puede estar vacío");
            return null;
        }
        
        if (departamento.isEmpty()) {
            mostrarError("El campo Departamento no puede estar vacío");
            return null;
        }
        
        if (respuesta.isEmpty()) {
            mostrarError("El campo Respuesta no puede estar vacío");
            return null;
        }
        
        if (password.isEmpty()) {
            mostrarError("El campo Contraseña no puede estar vacío");
            return null;
        }
        
        if (Cedula.getText().trim().isEmpty()) {
            mostrarError("El campo Cédula no puede estar vacío");
            return null;
        }
        
        Pregunta pregunta = opcionesPreguntas.get(preguntasComboBox.getSelectedIndex() - 1);
        
//        var rolNegocio = opcionesRolNegocio.get(rolComboBox.getSelectedIndex() - 1);
//        var aplicativo = opcionesAplicativo.get(AplicativosComboBox.getSelectedIndex() - 1);

        var userId = Integer.parseInt(Cedula.getText());
        
        try {
            if (datosPersonas.getById(userId) != null) {
                mostrarError("Usuario ya existe");
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }

        Persona persona = new Persona(
            userId, 
            nombre,
            apellido, 
            direccion,
            ciudad,
            departamento
        );
        
        persona.setPassword(password);

        try {
            datosPersonas.updateOrCreate(persona);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        var personaPregunta = new PersonaPregunta(
            userId, 
            pregunta.getPregId(), 
            respuesta
        );

        try {
            datosPersonaPregunta.create(personaPregunta);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return persona;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonRegistro = new javax.swing.JButton();
        Nombre = new javax.swing.JTextField();
        Apellido = new javax.swing.JTextField();
        Direccion = new javax.swing.JTextField();
        Ciudad = new javax.swing.JTextField();
        Departamento = new javax.swing.JTextField();
        L_Nombre = new javax.swing.JLabel();
        L_Apellido = new javax.swing.JLabel();
        L_Direccion = new javax.swing.JLabel();
        L_Ciudad = new javax.swing.JLabel();
        L_Departamento = new javax.swing.JLabel();
        L_Titulo = new javax.swing.JLabel();
        preguntasComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        respuestaTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        Cedula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rolComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        AplicativosComboBox = new javax.swing.JComboBox<>();
        BotonLogin = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        BotonRegistro.setText("Regristrarme");
        BotonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegistroActionPerformed(evt);
            }
        });

        Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreActionPerformed(evt);
            }
        });

        Ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CiudadActionPerformed(evt);
            }
        });

        Departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartamentoActionPerformed(evt);
            }
        });

        L_Nombre.setText("Nombre:");

        L_Apellido.setText("Apellido:");

        L_Direccion.setText("Direccion:");

        L_Ciudad.setText("Ciudad:");

        L_Departamento.setText("Departamento:");

        L_Titulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        L_Titulo.setText("Registro de Persona:");

        preguntasComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        preguntasComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preguntasComboBoxActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(respuestaTextArea);

        jLabel1.setText("Pregunta de seguridad:");

        jLabel2.setText("Respuesta:");

        jLabel3.setText("Contraseña:");

        jLabel4.setText("Cedula de Identidad");

        jLabel5.setText("Rol:");

        rolComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        jLabel6.setText("Aplicativo:");

        AplicativosComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        AplicativosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AplicativosComboBoxActionPerformed(evt);
            }
        });

        BotonLogin.setText("Logearme");
        BotonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLoginActionPerformed(evt);
            }
        });

        jLabel7.setText("Si queres logearte ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(L_Departamento)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(L_Direccion)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Direccion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cedula, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Apellido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(L_Ciudad, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(L_Nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_Apellido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(L_Titulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Nombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Departamento, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ciudad))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(preguntasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(AplicativosComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rolComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                                    .addComponent(jLabel6))
                                .addContainerGap(119, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BotonLogin)
                                    .addComponent(BotonRegistro)
                                    .addComponent(jLabel7))
                                .addGap(49, 49, 49))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(L_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_Nombre)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(preguntasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_Apellido)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(L_Direccion)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rolComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(L_Ciudad)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AplicativosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(L_Departamento)
                            .addComponent(jLabel3)
                            .addComponent(BotonLogin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 31, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonRegistro)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegistroActionPerformed
        Persona per;
        per = registrarPersona();
        if (per != null){
            //aca hay que ver si es admin tambien
            /* if (es Administrador de Seguridad){
                var framePermisos = new GestionIdentidadesPermisos();
                framePermisos.setVisible(true);
                this.setVisible(false);
            } else {
            */
            var frameAplicacionS = new SelectAplicacion( per ,datosPersonas);
            frameAplicacionS.setVisible(true);
            this.setVisible(false);
          //}
        }
    }//GEN-LAST:event_BotonRegistroActionPerformed

    private void CiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CiudadActionPerformed

    private void DepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DepartamentoActionPerformed

    private void AplicativosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AplicativosComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AplicativosComboBoxActionPerformed

    private void preguntasComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preguntasComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preguntasComboBoxActionPerformed

    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreActionPerformed

    private void BotonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLoginActionPerformed
        // TODO add your handling code here:
        var framelogin = new LoginPersonas(datosPersonas);
        framelogin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BotonLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apellido;
    private javax.swing.JComboBox<String> AplicativosComboBox;
    private javax.swing.JButton BotonLogin;
    private javax.swing.JButton BotonRegistro;
    private javax.swing.JTextField Cedula;
    private javax.swing.JTextField Ciudad;
    private javax.swing.JTextField Departamento;
    private javax.swing.JTextField Direccion;
    private javax.swing.JLabel L_Apellido;
    private javax.swing.JLabel L_Ciudad;
    private javax.swing.JLabel L_Departamento;
    private javax.swing.JLabel L_Direccion;
    private javax.swing.JLabel L_Nombre;
    private javax.swing.JLabel L_Titulo;
    private javax.swing.JTextField Nombre;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> preguntasComboBox;
    private javax.swing.JTextArea respuestaTextArea;
    private javax.swing.JComboBox<String> rolComboBox;
    // End of variables declaration//GEN-END:variables
}