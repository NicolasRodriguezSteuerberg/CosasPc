/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaz;

import javax.swing.JPanel;
import postgressql.ConexionSQL;

/**
 *
 * @author oracle
 */
public class ActualizarTitulo extends javax.swing.JPanel {

    ConexionSQL obxC = new ConexionSQL();
    
    JPanel pMenu;
    
    /**
     * Creates new form ModificarCampos
     */
    public ActualizarTitulo() {
        initComponents();
        eErrores.setVisible(false);
        eModificado.setVisible(false);
    }
    
    public void recogerPanelMenu(JPanel panel){
        pMenu = panel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eID = new javax.swing.JLabel();
        lID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lNuevoNombre = new javax.swing.JTextField();
        bVolver = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        eErrores = new javax.swing.JLabel();
        eModificado = new javax.swing.JLabel();

        eID.setText("Escribe el ID del libro a modificar");

        lID.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setText("Escribe el nuevo nombre");

        lNuevoNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        bVolver.setText("VOLVER");
        bVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverActionPerformed(evt);
            }
        });

        bModificar.setText("MODIFICAR");
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });

        eErrores.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        eErrores.setForeground(new java.awt.Color(255, 0, 0));
        eErrores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eErrores.setText("NO EXISTE ESE LIBRO");
        eErrores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        eModificado.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        eModificado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eModificado.setText("LIBRO MODIFICADO");
        eModificado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eID)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lNuevoNombre)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bVolver)
                        .addGap(46, 46, 46)
                        .addComponent(bModificar)
                        .addGap(65, 65, 65)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eModificado, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eID)
                    .addComponent(lID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lNuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(eErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(eModificado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bVolver)
                    .addComponent(bModificar))
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        eErrores.setVisible(false);
        eModificado.setVisible(false);
        if(lID.getText().equals("")){
            eErrores.setText("EL ID NO PUEDE SER VACIO");
            eErrores.setVisible(true);
        }
        else if(lNuevoNombre.getText().equals("")){
            eErrores.setText("EL NUEVO NOMBRE NO PUEDE SER VACIO");
            eErrores.setVisible(true);
        }
        else{
            obxC.actualizarNombre(Integer.parseInt(lID.getText()), lNuevoNombre.getText(), eErrores, eModificado);
        }
    }//GEN-LAST:event_bModificarActionPerformed

    private void bVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVolverActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        pMenu.setVisible(true);
    }//GEN-LAST:event_bVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bVolver;
    private javax.swing.JLabel eErrores;
    private javax.swing.JLabel eID;
    private javax.swing.JLabel eModificado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField lID;
    private javax.swing.JTextField lNuevoNombre;
    // End of variables declaration//GEN-END:variables
}
