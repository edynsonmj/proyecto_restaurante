/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.client.presentation;

/**
 *
 * @author Camilo Gonzalez
 */
public class GUIMenuAdmin extends javax.swing.JFrame {

    /**
     * Creates new form GUIMenuAdmin
     */
    public GUIMenuAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonRegistrar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonListar = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 450));
        setPreferredSize(new java.awt.Dimension(817, 370));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRegistrar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        jButtonRegistrar.setForeground(new java.awt.Color(153, 0, 0));
        jButtonRegistrar.setText("REGISTRAR UN MENÚ");
        jButtonRegistrar.setToolTipText("");
        jButtonRegistrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRegistrar.setBorderPainted(false);
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 310, 110));

        jButtonModificar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonModificar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        jButtonModificar.setForeground(new java.awt.Color(153, 0, 0));
        jButtonModificar.setText("MODIFICAR UN PLATO");
        jButtonModificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButtonModificar.setBorderPainted(false);
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 310, 110));

        jButtonEliminar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(153, 0, 0));
        jButtonEliminar.setText("ELIMINAR UN PLATO");
        jButtonEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButtonEliminar.setBorderPainted(false);
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 310, 110));

        jButtonListar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonListar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        jButtonListar.setForeground(new java.awt.Color(153, 0, 0));
        jButtonListar.setText("LISTAR MENÚ");
        jButtonListar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButtonListar.setBorderPainted(false);
        jButtonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 310, 110));

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jLabel2.setBackground(new java.awt.Color(153, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MENÚ DE ADMINISTRADOR");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        GUIMenuModificar ins = new GUIMenuModificar();
        //ins.setExtendedState(MAXIMIZED_BOTH);
        ins.setVisible(true);
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        GUIRegPlato ins = new GUIRegPlato();
        //ins.setExtendedState(MAXIMIZED_BOTH);
        ins.setVisible(true);
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        GUIEliminarPlato ins = new GUIEliminarPlato();
        //ins.setExtendedState(MAXIMIZED_BOTH);
        ins.setVisible(true);

    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        GUIListar ins = new GUIListar();
        //ins.setExtendedState(MAXIMIZED_BOTH);
        ins.setVisible(true);
    }//GEN-LAST:event_jButtonListarActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        GUILogin ins = new GUILogin();
        //ins.setExtendedState(MAXIMIZED_BOTH);
        ins.setVisible(true);
    }//GEN-LAST:event_jButtonVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonListar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
