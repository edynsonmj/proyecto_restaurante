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
import co.unicauca.restaurante.commons.domain.Restaurante;
import co.unicauca.restaurante.commons.domain.PlatoDia;
import co.unicauca.restaurante.commons.domain.PlatoEspecial;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


/**
 *
 * @author Camilo Gonzalez
 */
public class GUIRegPlato extends javax.swing.JFrame {
     /**
     * Creates new form GUIRegPlato
     */
    IClienteAccess service;
    DefaultListModel modelListEspecial;
    public GUIRegPlato() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.modelListEspecial=new DefaultListModel();
        jListPlatoEspecial.setModel(modelListEspecial);
        this.service = Factory.getInstance().getClienteService();
        
        try {
            // TODO add your handling code here:
            listar();
        } catch (Exception ex) {
            Logger.getLogger(GUIListar.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabelTitulo = new javax.swing.JLabel();
        cboTipoPlato = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jLabelDescrip = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPlatoEspecial = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(817, 370));
        setPreferredSize(new java.awt.Dimension(700, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("REGISTRAR PLATO");
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        cboTipoPlato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Plato del Dia", "Plato Especial" }));
        cboTipoPlato.setToolTipText("Plato Especial");
        cboTipoPlato.setBorder(null);
        cboTipoPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoPlatoActionPerformed(evt);
            }
        });
        getContentPane().add(cboTipoPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 170, 40));

        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 160, 30));

        txtDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        getContentPane().add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 470, 50));

        btnRegistrar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar.setPreferredSize(new java.awt.Dimension(100, 200));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 210, 50));

        jLabelDescrip.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDescrip.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabelDescrip.setForeground(new java.awt.Color(153, 0, 0));
        jLabelDescrip.setText("Descripción:");
        jLabelDescrip.setOpaque(true);
        getContentPane().add(jLabelDescrip, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, -1));

        lblNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblNombre.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(153, 0, 0));
        lblNombre.setText("Nombre:");
        lblNombre.setOpaque(true);
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("Valor:");
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, -1, -1));

        txtValor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });
        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorKeyTyped(evt);
            }
        });
        getContentPane().add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 160, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Codigo:");
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));

        txtCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 110, 30));

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

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText(" Categoría del Plato:");
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jListPlatoEspecial.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListPlatoEspecial);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 240, 100));

        jLabel1.setBackground(new java.awt.Color(153, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 810, 70));

        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 800, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        GUIMenuAdmin ins = new GUIMenuAdmin();
        //ins.setExtendedState(MAXIMIZED_BOTH);
        ins.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cboTipoPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoPlatoActionPerformed
        if ((cboTipoPlato.getSelectedItem().toString().equalsIgnoreCase("Plato Especial")))
            {
                this.setVisible(false);
                GUIRegPlato frame = new GUIRegPlato();
                frame.setVisible(true);
            }
        if ((cboTipoPlato.getSelectedItem().toString().equalsIgnoreCase("Plato del Dia")))
           {
               this.setVisible(false);
               GUIRegPlatoD frame = new GUIRegPlatoD();
               frame.setVisible(true);
           }
        /*
        GUIPrincipal frame = new GUIPrincipal();
        GUIRegPlato frame2 = new GUIRegPlato();
        frame2.getContentPane().add(frame);        // TODO add your handling code here:*/
    }//GEN-LAST:event_cboTipoPlatoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtNombre.getText() != null && txtDescripcion.getText() != null && txtCodigo.getText() != null && txtValor.getText() != null) {
            clienteService servicioRestaurante = new clienteService(service);
            MenuEspecial menuEspecial = new MenuEspecial(1);
            PlatoEspecial platoEspecial = new PlatoEspecial(Integer.valueOf(txtCodigo.getText()), txtNombre.getText(), Integer.valueOf(txtValor.getText()), txtDescripcion.getText(), menuEspecial.getId());
            try {
                String platoE = servicioRestaurante.savePlatoEspecial(platoEspecial);
                if (platoE.equals(platoEspecial.getNombre())) {
                    JOptionPane.showMessageDialog(null, "plato agragado con exito");
                    txtCodigo.setText("");
                    txtNombre.setText("");
                    txtValor.setText("");
                    txtDescripcion.setText("");
                    listar();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "El plato ya esta registrado" + ex.getMessage());

            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();     // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void txtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume(); 
    }//GEN-LAST:event_txtValorKeyTyped
    public void listar() throws Exception{
        clienteService servicioRestaurante = new clienteService(service);
        int resId=1;
        List<PlatoEspecial> lsEspecial=servicioRestaurante.listarMenuEspecial(resId);
        modelListEspecial.clear();

        for (PlatoEspecial lse : lsEspecial) {
            modelListEspecial.addElement("ID: " + lse.getId() + " NOMBRE: " + lse.getNombre()
                    + " DESCRIPCION: " + lse.getDescripcion() + " PRECIO: " + lse.getPrecio());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cboTipoPlato;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelDescrip;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JList<String> jListPlatoEspecial;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
