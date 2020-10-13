/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.client.presentation;

import co.unicauca.restaurante.client.access.Factory;
import co.unicauca.restaurante.client.access.IClienteAccess;
import co.unicauca.restaurante.client.domain.clienteService;
import co.unicauca.restaurante.commons.domain.DiaEnum;
import co.unicauca.restaurante.commons.domain.MenuDia;
import co.unicauca.restaurante.commons.domain.MenuEspecial;
import co.unicauca.restaurante.commons.domain.PlatoDia;
import co.unicauca.restaurante.commons.domain.PlatoEspecial;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo Gonzalez
 */
public class GUIRegPlatoD extends javax.swing.JFrame {

    /**
     * Creates new form GUIRegPlato
     */
    public GUIRegPlatoD() {
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

        jLabelTitulo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        lblDescripcion = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblBebida = new javax.swing.JLabel();
        txtBebida = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtValor = new javax.swing.JTextField();
        txtEntrada = new javax.swing.JTextField();
        txtPrincipio = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        lblEntrada = new javax.swing.JLabel();
        lblPrincipio = new javax.swing.JLabel();
        lblMenu = new javax.swing.JLabel();
        cboMenu = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        txtCarne = new javax.swing.JTextField();
        lblBebida1 = new javax.swing.JLabel();
        lblDia = new javax.swing.JLabel();
        cboDia = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 450));
        setPreferredSize(new java.awt.Dimension(817, 370));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("REGISTRAR PLATO DIA");
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 160, 30));

        txtDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 240, 50));

        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar.setPreferredSize(new java.awt.Dimension(100, 200));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, 140, 50));

        lblDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(153, 0, 0));
        lblDescripcion.setText("Descripción:");
        lblDescripcion.setOpaque(true);
        getContentPane().add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, -1, -1));

        lblNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblNombre.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(153, 0, 0));
        lblNombre.setText("Nombre:");
        lblNombre.setOpaque(true);
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));

        lblBebida.setBackground(new java.awt.Color(255, 255, 255));
        lblBebida.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblBebida.setForeground(new java.awt.Color(153, 0, 0));
        lblBebida.setText("Bebida:");
        lblBebida.setOpaque(true);
        getContentPane().add(lblBebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        txtBebida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtBebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 160, 30));

        lblCodigo.setBackground(new java.awt.Color(255, 255, 255));
        lblCodigo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblCodigo.setForeground(new java.awt.Color(153, 0, 0));
        lblCodigo.setText("Codigo:");
        lblCodigo.setOpaque(true);
        getContentPane().add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        txtCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 110, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jButton2.setText("Volver");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 20));

        txtValor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });
        getContentPane().add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 140, 30));

        txtEntrada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 160, 30));

        txtPrincipio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtPrincipio, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 160, 30));

        lblValor.setBackground(new java.awt.Color(255, 255, 255));
        lblValor.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblValor.setForeground(new java.awt.Color(153, 0, 0));
        lblValor.setText("Valor:");
        lblValor.setOpaque(true);
        getContentPane().add(lblValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, -1, -1));

        lblEntrada.setBackground(new java.awt.Color(255, 255, 255));
        lblEntrada.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEntrada.setForeground(new java.awt.Color(153, 0, 0));
        lblEntrada.setText("Entrada:");
        lblEntrada.setOpaque(true);
        getContentPane().add(lblEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, -1, -1));

        lblPrincipio.setBackground(new java.awt.Color(255, 255, 255));
        lblPrincipio.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblPrincipio.setForeground(new java.awt.Color(153, 0, 0));
        lblPrincipio.setText("Principio");
        lblPrincipio.setOpaque(true);
        getContentPane().add(lblPrincipio, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, -1));

        lblMenu.setBackground(new java.awt.Color(255, 255, 255));
        lblMenu.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblMenu.setForeground(new java.awt.Color(153, 0, 0));
        lblMenu.setText("Menú:");
        lblMenu.setOpaque(true);
        getContentPane().add(lblMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        cboMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Plato del Dia", "Plato Especial" }));
        cboMenu.setBorder(null);
        cboMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMenuActionPerformed(evt);
            }
        });
        getContentPane().add(cboMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 180, 30));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 270, 100));

        txtCarne.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtCarne, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 160, 30));

        lblBebida1.setBackground(new java.awt.Color(255, 255, 255));
        lblBebida1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblBebida1.setForeground(new java.awt.Color(153, 0, 0));
        lblBebida1.setText("Carne:");
        lblBebida1.setOpaque(true);
        getContentPane().add(lblBebida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        lblDia.setBackground(new java.awt.Color(255, 255, 255));
        lblDia.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblDia.setForeground(new java.awt.Color(153, 0, 0));
        lblDia.setText("Dia:");
        lblDia.setOpaque(true);
        getContentPane().add(lblDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        cboDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));
        cboDia.setBorder(null);
        cboDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDiaActionPerformed(evt);
            }
        });
        getContentPane().add(cboDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 180, 30));

        jLabel2.setBackground(new java.awt.Color(153, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 870, 70));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Camilo Gonzalez\\Documents\\Proyecto_Restaurante\\Proyecto_Restaurante\\proyecto_restaurante\\Restaurante-cliente\\src\\main\\java\\resources\\background.jpg")); // NOI18N
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 800, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        GUIRegPlato ins = new GUIRegPlato();
        //ins.setExtendedState(MAXIMIZED_BOTH);
        ins.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cboMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMenuActionPerformed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtNombre.getText()!=null && txtDescripcion.getText()!=null && txtCodigo.getText()!=null && txtValor.getText()!=null 
            && txtBebida.getText()!=null && txtPrincipio.getText()!=null && txtEntrada.getText()!=null && txtCarne.getText()!=null
            && !((cboDia.getSelectedItem().toString()).equalsIgnoreCase("Seleccione"))) {
            IClienteAccess service = Factory.getInstance().getClienteService();
            clienteService servicioRestaurante = new clienteService(service);
            MenuDia menuDia = new MenuDia(11);
            PlatoDia platoDia = new PlatoDia(Integer.valueOf(txtCodigo.getText()),txtNombre.getText(),Integer.valueOf(txtValor.getText()),txtDescripcion.getText()
                                             , DiaEnum.valueOf(cboDia.getSelectedItem().toString()),txtEntrada.getText(),txtPrincipio.getText(),txtCarne.getText()
                                             , txtBebida.getText(),11);
            try{
                String platoE = servicioRestaurante.savePlatoDia(platoDia);
                JOptionPane.showMessageDialog(null, "plato agragado con exito");
                txtCodigo.setText("");
                txtNombre.setText("");
                txtValor.setText("");
                txtDescripcion.setText("");
                txtBebida.setText("");
                txtPrincipio.setText("");
                txtEntrada.setText("");
                txtCarne.setText("");
            }catch(Exception ex){
                System.out.println("atencion no se save si agrego");
        }
        }// TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void cboDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboDiaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cboDia;
    private javax.swing.JComboBox<String> cboMenu;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBebida;
    private javax.swing.JLabel lblBebida1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblEntrada;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrincipio;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTextField txtBebida;
    private javax.swing.JTextField txtCarne;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrincipio;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
