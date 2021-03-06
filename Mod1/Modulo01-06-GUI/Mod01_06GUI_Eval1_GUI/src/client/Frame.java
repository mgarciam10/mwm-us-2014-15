
package client;

import java.awt.Color;
import java.awt.event.KeyEvent;

/**
 *
 * @author carlos
 */
public class Frame extends javax.swing.JFrame {

    private final String WELLCOME="Bienvenido a la aplicacion Test GUI";
    private final String OVER_POS="Se encuentra sobre el boton +1";
    private final String CLICK_POS="Ha pulsado el boton +1";
    private final String OVER_NEG="Se encuentra sobre el boton -1";
    private final String CLICK_NEG="Ha pulsado el boton -1";
    private final String CLEAN="";
    private int contador=0;
    
    /** Creates new form Frame */
    public Frame() {
        initComponents();
        etiDisplay.setText(WELLCOME);
        botonContador.setText(Integer.toString(contador));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        botonUnoPositivo = new javax.swing.JButton();
        botonUnoNegativo = new javax.swing.JButton();
        cuadroTexto = new javax.swing.JTextField();
        etiDisplay = new javax.swing.JLabel();
        botonPrueba = new javax.swing.JButton();
        cuadroTextoPass = new javax.swing.JPasswordField();
        botonContador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonUnoPositivo.setText("+1");
        botonUnoPositivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonUnoPositivoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonUnoPositivoMouseEntered(evt);
            }
        });

        botonUnoNegativo.setText("-1");
        botonUnoNegativo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonUnoNegativoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonUnoNegativoMouseEntered(evt);
            }
        });

        cuadroTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cuadroTextoKeyPressed(evt);
            }
        });

        etiDisplay.setText("etiqueta");

        botonPrueba.setText("Boton de prueba");
        botonPrueba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonPruebaMouseClicked(evt);
            }
        });

        cuadroTextoPass.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        cuadroTextoPass.setText("pass");
        cuadroTextoPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cuadroTextoPassKeyPressed(evt);
            }
        });

        botonContador.setBackground(new java.awt.Color(0, 255, 0));
        botonContador.setText("contador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(botonUnoPositivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonUnoNegativo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiDisplay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cuadroTextoPass, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cuadroTexto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addComponent(botonPrueba))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonContador, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonUnoPositivo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonUnoNegativo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(botonContador, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(etiDisplay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cuadroTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 22, Short.MAX_VALUE)
                        .addComponent(cuadroTextoPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonPrueba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(36, 36, 36))))
        );

        pack();
    }//GEN-END:initComponents

    private void botonUnoPositivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonUnoPositivoMouseClicked
        contador++;
        etiDisplay.setText(CLICK_POS);
        botonContador.setText(Integer.toString(contador));
        botonContador.setBackground(new Color(0,255,0));
    }//GEN-LAST:event_botonUnoPositivoMouseClicked

    private void botonUnoNegativoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonUnoNegativoMouseClicked

        etiDisplay.setText(CLICK_NEG);
        if (contador<=0){
            botonContador.setText(Integer.toString(contador));
            botonContador.setBackground(new Color(255, 0, 0));
        } else {
            contador--;
            botonContador.setText(Integer.toString(contador));
        }
        
    }//GEN-LAST:event_botonUnoNegativoMouseClicked

    private void botonUnoPositivoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonUnoPositivoMouseEntered
        etiDisplay.setText(OVER_POS);
    }//GEN-LAST:event_botonUnoPositivoMouseEntered

    private void botonUnoNegativoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonUnoNegativoMouseEntered
        etiDisplay.setText(OVER_NEG);
    }//GEN-LAST:event_botonUnoNegativoMouseEntered

    private void cuadroTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cuadroTextoKeyPressed
        if( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            etiDisplay.setText(cuadroTexto.getText());
            cuadroTexto.setText(CLEAN);
        }
    }//GEN-LAST:event_cuadroTextoKeyPressed

    private void botonPruebaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonPruebaMouseClicked
        botonPrueba.setText(etiDisplay.getText());
    }//GEN-LAST:event_botonPruebaMouseClicked

    private void cuadroTextoPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cuadroTextoPassKeyPressed
        if( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            etiDisplay.setText(cuadroTextoPass.getText());
            cuadroTextoPass.setText(CLEAN);
        }
    }//GEN-LAST:event_cuadroTextoPassKeyPressed

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
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonContador;
    private javax.swing.JButton botonPrueba;
    private javax.swing.JButton botonUnoNegativo;
    private javax.swing.JButton botonUnoPositivo;
    private javax.swing.JTextField cuadroTexto;
    private javax.swing.JPasswordField cuadroTextoPass;
    private javax.swing.JLabel etiDisplay;
    // End of variables declaration//GEN-END:variables

}
