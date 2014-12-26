
package gui;

import entities.*;
import carlos.utils.*;

import client.ConexionBD;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TimeZone;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos
 */
public class VentanaAgenda extends javax.swing.JFrame {

    private ConexionBD con = null;
    private ResultSet res = null;

    /** Creates new form VentanaAgenda */
    public VentanaAgenda() {
        try {
            inicializarTimeZone();
            initComponents();
            con = new ConexionBD();
            botSiguiente.setEnabled(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Excepción " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    /** Para resolver el problema del timezone que se produce en Oracle
    */
    private void inicializarTimeZone() {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+1");
        TimeZone.setDefault(timeZone);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        botConsultar = new javax.swing.JButton();
        botAnadir = new javax.swing.JButton();
        botLimpiar = new javax.swing.JButton();
        inTextProvincia = new javax.swing.JTextField();
        labProvincia = new javax.swing.JLabel();
        inTextCodPostal = new javax.swing.JTextField();
        labCodigoPostal = new javax.swing.JLabel();
        labTelefono = new javax.swing.JLabel();
        inTextDireccion = new javax.swing.JTextField();
        labDireccion = new javax.swing.JLabel();
        inTextTelefono = new javax.swing.JTextField();
        botSiguiente = new javax.swing.JButton();
        inTextNombre = new javax.swing.JTextField();
        labNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botConsultar.setText("Consultar");
        botConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botConsultarActionPerformed(evt);
            }
        });

        botAnadir.setText("Añadir");
        botAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAnadirActionPerformed(evt);
            }
        });

        botLimpiar.setText("Limpiar");
        botLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botLimpiarActionPerformed(evt);
            }
        });

        labProvincia.setText("Provincia");

        labCodigoPostal.setText("CodigoPostal");

        labTelefono.setText("Telefono");

        labDireccion.setText("Direccion");

        botSiguiente.setText("Siguiente");
        botSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botSiguienteActionPerformed(evt);
            }
        });

        labNombre.setText("Nombre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(labNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labCodigoPostal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(botLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(botAnadir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botSiguiente)))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labProvincia)
                        .addComponent(labDireccion)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labTelefono)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(inTextTelefono)
                                .addComponent(inTextDireccion)
                                .addComponent(inTextProvincia)
                                .addComponent(inTextCodPostal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(78, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labNombre))
                .addGap(61, 61, 61)
                .addComponent(labCodigoPostal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botLimpiar)
                    .addComponent(botAnadir)
                    .addComponent(botConsultar)
                    .addComponent(botSiguiente))
                .addGap(65, 65, 65))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(inTextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labTelefono))
                    .addGap(18, 18, 18)
                    .addComponent(inTextCodPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labDireccion)
                        .addComponent(inTextDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labProvincia)
                        .addComponent(inTextProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(108, Short.MAX_VALUE)))
        );

        pack();
    }//GEN-END:initComponents

    private void botConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botConsultarActionPerformed
        // TODO add your handling code here:
        boolean regValido = false;
        String nombre = null;
        
        try {
            nombre = inTextNombre.getText().trim();
            if (Validator.validField(nombre)) {
                regValido = true;
            }
            if (regValido) {
                res = con.consultarPorNombre(nombre);
                if (res.next())
                    muestraDatos();
                else
                    muestraVacio();
            } else {
                JOptionPane.showMessageDialog(this, "No se puede realizar la consulta, la consulta se basa en el nombre y no lo puede dejar vacio", "Advertencia",
                                              JOptionPane.WARNING_MESSAGE); 
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Excepción SQL " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_botConsultarActionPerformed

    private void botAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAnadirActionPerformed
        // TODO add your handling code here:
        try {
            Contacto agenda = obtenerAgenda();
            if (agenda!=null)   {
                con.insertar(agenda);
                botSiguiente.setEnabled(false);
                JOptionPane.showMessageDialog(this, "El registro se ha añadido correctamente", "Añadir datos", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, complete el formulario adecuadamente", "Advertencia",
                                              JOptionPane.WARNING_MESSAGE); 
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Excepción SQL " + ex + "\nNo se ha añadido el registro", "Error",
                                          JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Excepción " + ex + "\nNo se ha añadido el registro", "Error",
                                          JOptionPane.ERROR_MESSAGE);
        }
  
    }//GEN-LAST:event_botAnadirActionPerformed
    
    /** método que obtiene los valores de los campos del formulario
     */
    private Contacto obtenerAgenda() throws Exception {
        String nombre = inTextNombre.getText().trim();
        String direccion = inTextDireccion.getText().trim();
        String provincia = inTextProvincia.getText().trim();
        String telefono = inTextTelefono.getText().trim();
        String codigoPostal = inTextCodPostal.getText().trim();
        boolean regValido = false;
        Contacto newContact=null;

        if (Validator.validField(nombre)) {
                if (Validator.validField(direccion)) {
                    if (Validator.validField(provincia)) {
                        if (Validator.validField(telefono)) {
                            if (Validator.validField(codigoPostal)) {
                                if (Validator.isPositiveInteger(codigoPostal)) {
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
            newContact.setCodigoPostal(Integer.parseInt(codigoPostal));
            newContact.setDireccion(direccion);
            newContact.setProvincia(provincia);
            newContact.setTelefono(telefono);
        }
        
        return  newContact;
    };
    
    /** borra los campos del formulario
    */
    private void muestraVacio() {
        inTextNombre.setText("");
        inTextCodPostal.setText("");
        inTextDireccion.setText("");
        inTextProvincia.setText("");
        inTextTelefono.setText("");
        botSiguiente.setEnabled(false);
    }
    
    private void muestraDatos() throws SQLException {
        inTextNombre.setText(res.getString("NOMBRE"));
        inTextTelefono.setText(res.getString("TELEFONO"));
        inTextDireccion.setText(res.getString("DIRECCION"));
        inTextCodPostal.setText(res.getString("CODPOSTAL"));
        inTextProvincia.setText(res.getString("PROVINCIA"));
        System.out.println(res.getString(1)+","+res.getString(2)+","+res.getString(3)+","+res.getString(4)+","+res.getString(5));
        if (res.next()) {
            botSiguiente.setEnabled(true);
        } else {
            botSiguiente.setEnabled(false);
        }
    }
    
    private void botLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botLimpiarActionPerformed
        // TODO add your handling code here:
        muestraVacio();
    }//GEN-LAST:event_botLimpiarActionPerformed

    private void botSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botSiguienteActionPerformed
        // TODO add your handling code here:
        try {
            muestraDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Excepción SQL " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botSiguienteActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                  ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                  ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                  ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                  ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botAnadir;
    private javax.swing.JButton botConsultar;
    private javax.swing.JButton botLimpiar;
    private javax.swing.JButton botSiguiente;
    private javax.swing.JTextField inTextCodPostal;
    private javax.swing.JTextField inTextDireccion;
    private javax.swing.JTextField inTextNombre;
    private javax.swing.JTextField inTextProvincia;
    private javax.swing.JTextField inTextTelefono;
    private javax.swing.JLabel labCodigoPostal;
    private javax.swing.JLabel labDireccion;
    private javax.swing.JLabel labNombre;
    private javax.swing.JLabel labProvincia;
    private javax.swing.JLabel labTelefono;
    // End of variables declaration//GEN-END:variables
    
}
