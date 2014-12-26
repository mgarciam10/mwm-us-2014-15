
package gui;

import javax.swing.JRadioButton;

import carlos.utils.Validator;

import entities.Agenda;
import entities.Contacto;

import java.awt.*;

/**
 *
 * @author carlos
 */
public class AplicacionAgenda extends javax.swing.JFrame {

    private Agenda agenda;
    private static final String AMIGO = "Amigo";
    private static final String CONOCIDO = "Conocido";
    private static final String TRABAJO = "Trabajo";

    /** Creates new form Frame */
    public AplicacionAgenda() {
        initComponents();
        agenda = new Agenda();
        showMsg("Bienvenidos al Ejercicio Evaluable 2 del Modulo 01-06 de GUI");

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        bgTipoContacto = new javax.swing.ButtonGroup();
        inTextNombre = new javax.swing.JTextField();
        labNombre = new javax.swing.JLabel();
        labTelefono = new javax.swing.JLabel();
        inTextTelefono = new javax.swing.JTextField();
        labDireccion = new javax.swing.JLabel();
        inTextDireccion = new javax.swing.JTextField();
        labEmail = new javax.swing.JLabel();
        inTextEmail = new javax.swing.JTextField();
        labProvincia = new javax.swing.JLabel();
        inTextProvincia = new javax.swing.JTextField();
        botLimpiar = new javax.swing.JButton();
        botAnadir = new javax.swing.JButton();
        botConsultar = new javax.swing.JButton();
        labResult = new javax.swing.JLabel();
        rdAmigo = new javax.swing.JRadioButton();
        rdConocido = new javax.swing.JRadioButton();
        rdTrabajo = new javax.swing.JRadioButton();

        rdAmigo.setActionCommand("Amigo");
        rdConocido.setActionCommand("Conocido");
        rdTrabajo.setActionCommand("Trabajo");
        bgTipoContacto.add(rdAmigo);
        bgTipoContacto.add(rdConocido);
        bgTipoContacto.add(rdTrabajo);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labNombre.setText("Nombre");

        labTelefono.setText("Telefono");

        labDireccion.setText("Direccion");

        labEmail.setText("Email");

        labProvincia.setText("Provincia");

        botLimpiar.setText("Limpiar");
        botLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botLimpiarActionPerformed(evt);
            }
        });

        botAnadir.setText("Añadir");
        botAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAnadirActionPerformed(evt);
            }
        });

        botConsultar.setText("Consultar");
        botConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botConsultarActionPerformed(evt);
            }
        });

        rdAmigo.setSelected(true);
        rdAmigo.setText("Amigo");

        rdConocido.setText("Conocido");

        rdTrabajo.setText("Trabajo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inTextNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                            .addComponent(labProvincia)
                            .addComponent(labEmail)
                            .addComponent(labDireccion)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botLimpiar)
                                .addGap(18, 18, 18)
                                .addComponent(botAnadir)
                                .addGap(18, 18, 18)
                                .addComponent(botConsultar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labTelefono)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(rdAmigo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdConocido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdTrabajo))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inTextEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                                        .addComponent(inTextTelefono)
                                        .addComponent(inTextDireccion)
                                        .addComponent(inTextProvincia))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(labResult)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labNombre)
                    .addComponent(inTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdAmigo)
                    .addComponent(rdConocido)
                    .addComponent(rdTrabajo))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inTextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labTelefono))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labEmail)
                    .addComponent(inTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labDireccion)
                    .addComponent(inTextDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labProvincia)
                    .addComponent(inTextProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botLimpiar)
                    .addComponent(botAnadir)
                    .addComponent(botConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(labResult)
                .addGap(34, 34, 34))
        );

        pack();
    }//GEN-END:initComponents

    private void botAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAnadirActionPerformed
        // TODO add your handling code here:
        String nombre = inTextNombre.getText().trim();
        String email = inTextEmail.getText().trim();
        String direccion = inTextDireccion.getText().trim();
        String provincia = inTextProvincia.getText().trim();
        String telefono = inTextTelefono.getText().trim();
        String tipoContacto = bgTipoContacto.getSelection().getActionCommand();
        boolean regValido = false;
        Contacto newContact;

        if (Validator.validField(nombre)) {
            if (Validator.validField(email)) {
                if (Validator.validField(direccion)) {
                    if (Validator.validField(provincia)) {
                        if (Validator.validField(telefono)) {
                            if (Validator.validField(tipoContacto)) {
                                regValido = true;
                            }
                        }
                    }
                }
            }
        }
        if (regValido) {
            newContact = new Contacto();
            newContact.setNombre(nombre);
            newContact.setEmail(email);
            newContact.setDireccion(direccion);
            newContact.setProvincia(provincia);
            newContact.setTelefono(telefono);
            newContact.setTipoContacto(tipoContacto);
            agenda.insertar(newContact);
            showMsg("Contacto Insertado con Exito");
            labResult.setForeground(Color.black);
        } else {
            showMsg("Contacto no insertado. Revisar los campos introducidos. No deben estar vacíos");
            labResult.setForeground(Color.red);
        }
    }//GEN-LAST:event_botAnadirActionPerformed

    private void botConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botConsultarActionPerformed
        // TODO add your handling code here:
        if (!agenda.getContactos().isEmpty()) {
            String nombre = inTextNombre.getText().trim();
            boolean regValido = false;
            Contacto contactFinded = null;
            String tipoAmigo;
            if (Validator.validField(nombre)) {
                regValido = true;
            }
            if (regValido) {
                contactFinded = agenda.consultarDatosContactos(nombre);
                if (contactFinded != null) {
                    inTextNombre.setText(contactFinded.getNombre());
                    inTextEmail.setText(contactFinded.getEmail());
                    inTextDireccion.setText(contactFinded.getDireccion());
                    inTextProvincia.setText(contactFinded.getProvincia());
                    inTextTelefono.setText(contactFinded.getTelefono());
                    switch (contactFinded.getTipoContacto()) {
                    case AMIGO:
                        rdAmigo.setSelected(true);
                        break;
                    case TRABAJO:
                        rdTrabajo.setSelected(true);
                        break;
                    case CONOCIDO:
                        rdConocido.setSelected(true);
                        break;
                    }
                    showMsg("Contacto Encontrado en la Agenda");
                    labResult.setForeground(Color.black);
                } else {
                    showMsg("Nombre introducido no se corresponde con ningun Contacto de la Agenda");
                    labResult.setForeground(Color.red);
                }
            } else {
                showMsg("No se puede realizar la consulta, la consulta se basa en el nombre y no lo puede dejar vacio");
                labResult.setForeground(Color.red);
            }
        }else{
            showMsg("Agenda vacia. Sin añadir algun contacto no se pude realizar su Consulta");
            labResult.setForeground(Color.red);
        }
        
    }//GEN-LAST:event_botConsultarActionPerformed

    private void botLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botLimpiarActionPerformed
        // TODO add your handling code here:
        inTextNombre.setText("");
        inTextEmail.setText("");
        inTextDireccion.setText("");
        inTextProvincia.setText("");
        inTextTelefono.setText("");
        rdAmigo.setSelected(true);
    }//GEN-LAST:event_botLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(AplicacionAgenda.class.getName()).log(java.util.logging.Level.SEVERE,
                                                                                     null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplicacionAgenda.class.getName()).log(java.util.logging.Level.SEVERE,
                                                                                     null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplicacionAgenda.class.getName()).log(java.util.logging.Level.SEVERE,
                                                                                     null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplicacionAgenda.class.getName()).log(java.util.logging.Level.SEVERE,
                                                                                     null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplicacionAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgTipoContacto;
    private javax.swing.JButton botAnadir;
    private javax.swing.JButton botConsultar;
    private javax.swing.JButton botLimpiar;
    private javax.swing.JTextField inTextDireccion;
    private javax.swing.JTextField inTextEmail;
    private javax.swing.JTextField inTextNombre;
    private javax.swing.JTextField inTextProvincia;
    private javax.swing.JTextField inTextTelefono;
    private javax.swing.JLabel labDireccion;
    private javax.swing.JLabel labEmail;
    private javax.swing.JLabel labNombre;
    private javax.swing.JLabel labProvincia;
    private javax.swing.JLabel labResult;
    private javax.swing.JLabel labTelefono;
    private javax.swing.JRadioButton rdAmigo;
    private javax.swing.JRadioButton rdConocido;
    private javax.swing.JRadioButton rdTrabajo;
    // End of variables declaration//GEN-END:variables

    private void showMsg(String resultMsg) {
        labResult.setText(resultMsg);
    }

}