package bdd;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RegistroPersonas extends javax.swing.JFrame {
    
    private final Map<String, Pregunta> opcionesPreguntas = new HashMap<>();

    /**
     * Creates new form RegistroPersonas
     */
    public RegistroPersonas(List<Pregunta> preguntas) {        
        initComponents();
        
        preguntas.forEach(x -> { 
            opcionesPreguntas.put(x.getPregunta(), x);
            preguntasComboBox.addItem(x.getPregunta());
        });
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
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        BotonRegistro.setText("Regristrarme");
        BotonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegistroActionPerformed(evt);
            }
        });

        L_Nombre.setText("Nombre:");

        L_Apellido.setText("Apellido:");

        L_Direccion.setText("Direccion:");

        L_Ciudad.setText("Ciudad:");

        L_Departamento.setText("Departamento:");

        L_Titulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        L_Titulo.setText("Registro de Persona:");

        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Pregunta de seguridad:");

        jLabel2.setText("Respuesta:");

        jLabel3.setText("Contraseña:");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(L_Direccion)
                                    .addComponent(L_Ciudad)
                                    .addComponent(L_Titulo))
                                .addGap(85, 85, 85))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nombre)
                                    .addComponent(Ciudad)
                                    .addComponent(Departamento)
                                    .addComponent(Apellido)
                                    .addComponent(Direccion, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(L_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(L_Apellido))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(36, 36, 36)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(preguntasComboBox, 0, 180, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(BotonRegistro)
                            .addComponent(jPasswordField1))
                        .addGap(50, 50, 50))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(L_Direccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_Ciudad)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(L_Departamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonRegistro))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegistroActionPerformed
        // TODO add your handling code here:
        //Codigo al apretar el boton aca
    }//GEN-LAST:event_BotonRegistroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apellido;
    private javax.swing.JButton BotonRegistro;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox<String> preguntasComboBox;
    // End of variables declaration//GEN-END:variables
}
