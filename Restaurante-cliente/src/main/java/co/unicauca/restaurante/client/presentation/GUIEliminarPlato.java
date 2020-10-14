/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurante.client.presentation;

import co.unicauca.restaurante.client.domain.clienteService;
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
 * @author Jhonny Rosero
 */
public class GUIEliminarPlato extends javax.swing.JFrame {
    clienteService servicioRestaurante;
    DefaultListModel modelListEspecial;
    DefaultListModel modelListDia;
    /**
     * Creates new form GUIEliminarPlato
     * @param servicioRestaurante
     */
    public GUIEliminarPlato(clienteService servicioRestaurante) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.modelListEspecial=new DefaultListModel();
        this.modelListDia=new DefaultListModel();
        jListPlatoEspecial.setModel(modelListEspecial);
        jListPlatoDia.setModel(modelListDia);
        this.servicioRestaurante = servicioRestaurante;
        
        try {
            // TODO add your handling code here:
            listarMenuDia();
            listarMenuEspecial();
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

        jButton1 = new javax.swing.JButton();
        jScrollPanePlatoDia = new javax.swing.JScrollPane();
        jListPlatoDia = new javax.swing.JList<>();
        jScrollPanePlatoEspecial = new javax.swing.JScrollPane();
        jListPlatoEspecial = new javax.swing.JList<>();
        jLabelPlatoEspecial = new javax.swing.JLabel();
        jButtonEliminarPlatoEspecial = new javax.swing.JButton();
        jLabelPlatoDia = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();
        jTextFieldEliminarPlaEsp = new javax.swing.JTextField();
        jButtonEliminarPlatoDia = new javax.swing.JButton();
        jTextFieldEliminarPlaDia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 450));
        setPreferredSize(new java.awt.Dimension(817, 370));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jListPlatoDia.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPanePlatoDia.setViewportView(jListPlatoDia);

        getContentPane().add(jScrollPanePlatoDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 330, 210));

        jListPlatoEspecial.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPanePlatoEspecial.setViewportView(jListPlatoEspecial);

        getContentPane().add(jScrollPanePlatoEspecial, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 330, 210));

        jLabelPlatoEspecial.setBackground(new java.awt.Color(153, 0, 0));
        jLabelPlatoEspecial.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabelPlatoEspecial.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPlatoEspecial.setText("Platos Especiales");
        jLabelPlatoEspecial.setOpaque(true);
        getContentPane().add(jLabelPlatoEspecial, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, -1));

        jButtonEliminarPlatoEspecial.setBackground(new java.awt.Color(153, 0, 0));
        jButtonEliminarPlatoEspecial.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jButtonEliminarPlatoEspecial.setText("Eliminar");
        jButtonEliminarPlatoEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarPlatoEspecialActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminarPlatoEspecial, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, 160, 30));

        jLabelPlatoDia.setBackground(new java.awt.Color(153, 0, 0));
        jLabelPlatoDia.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabelPlatoDia.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPlatoDia.setText("Platos del dia");
        jLabelPlatoDia.setOpaque(true);
        getContentPane().add(jLabelPlatoDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        jLabel1.setBackground(new java.awt.Color(153, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ELIMINAR PLATO");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 60));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, 410));

        jTextFieldEliminarPlaEsp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEliminarPlaEspKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldEliminarPlaEsp, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 240, 30));

        jButtonEliminarPlatoDia.setBackground(new java.awt.Color(153, 0, 0));
        jButtonEliminarPlatoDia.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jButtonEliminarPlatoDia.setText("Eliminar");
        jButtonEliminarPlatoDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarPlatoDiaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminarPlatoDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 160, 30));

        jTextFieldEliminarPlaDia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEliminarPlaDiaKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldEliminarPlaDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 240, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEliminarPlatoEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarPlatoEspecialActionPerformed
        // TODO add your handling code here:
        //se captura el id del plato a eliminar
        if (!(jTextFieldEliminarPlaEsp.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "No digito ningun id");
            jTextFieldEliminarPlaEsp.setText(null);
        } else {
            int idPlaE = Integer.parseInt(jTextFieldEliminarPlaEsp.getText());
            //se ejecuta la funcionalidad eliminar plato especial
            try {
                String resultado;
                resultado = servicioRestaurante.deletePlatoEspecial(idPlaE);
                if ("FALLO".equals(resultado)) {
                    JOptionPane.showMessageDialog(null, "El id del plato es incorrecto");
                    jTextFieldEliminarPlaEsp.setText(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Plato eliminado con exito");
                    jTextFieldEliminarPlaEsp.setText(null);
                    listarMenuEspecial();
                }
            } catch (Exception ex) {
                Logger.getLogger(GUIEliminarPlato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonEliminarPlatoEspecialActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        GUIMenuAdmin ins = new GUIMenuAdmin(servicioRestaurante);
        //ins.setExtendedState(MAXIMIZED_BOTH);
        ins.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldEliminarPlaEspKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEliminarPlaEspKeyTyped
        //valida que lo que se ingrese sean numeros
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_jTextFieldEliminarPlaEspKeyTyped

    private void jButtonEliminarPlatoDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarPlatoDiaActionPerformed
        // TODO add your handling code here:
        //se captura el id del plato a eliminar
        //int idPlaD = Integer.parseInt(jTextFieldEliminarPlaDia.getText());
        if (!(jTextFieldEliminarPlaDia.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "No digito ningun id");
            jTextFieldEliminarPlaDia.setText(null);
        } else {
            //se ejecuta la funcionalidad eliminar plato especial
            int idPlaD = Integer.parseInt(jTextFieldEliminarPlaDia.getText());
            try {
                String resultado;
                resultado = servicioRestaurante.deletePlatoDia(idPlaD);
                if ("FALLO".equals(resultado)) {
                    JOptionPane.showMessageDialog(null, "El id del plato es incorrecto");
                    jTextFieldEliminarPlaDia.setText(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Plato eliminado con exito");
                    jTextFieldEliminarPlaDia.setText(null);
                    listarMenuDia();
                }
            } catch (Exception ex) {
                Logger.getLogger(GUIEliminarPlato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonEliminarPlatoDiaActionPerformed

    private void jTextFieldEliminarPlaDiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEliminarPlaDiaKeyTyped
        // TODO add your handling code here:
        //valida que lo que se ingrese sean numeros
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_jTextFieldEliminarPlaDiaKeyTyped
    
    private void listarMenuEspecial()throws Exception{
        int resId=1;
        List<PlatoEspecial> lsEspecial=servicioRestaurante.listarMenuEspecial(resId);
        modelListEspecial.clear();
        for (PlatoEspecial lse : lsEspecial) {
            modelListEspecial.addElement("ID: " + lse.getId() + " NOMBRE: " + lse.getNombre()
                    + " DESCRIPCION: " + lse.getDescripcion() + " PRECIO: " + lse.getPrecio());
        }
    }
    private void listarMenuDia() throws Exception{
        int resId=1;
        List<PlatoDia> lsDia=servicioRestaurante.listarMenuDia(resId);
        modelListDia.clear();
        for (PlatoDia ls : lsDia) {
            modelListDia.addElement("ID: " + ls.getId() + " NOMBRE: " + ls.getNombre()
                    + " DIA SEMANA: " + ls.getDiaSemana().name() + " DESCRIPCION: " + ls.getDescripcion()
                    + " PRECIO: " + ls.getPrecio() + " ENTRADA: " + ls.getEntrada()
                    + " PRINCIPIO" + ls.getPrincipio() + " CARNE: " + ls.getCarne() + " BEBIDA: " + ls.getBebida());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonEliminarPlatoDia;
    private javax.swing.JButton jButtonEliminarPlatoEspecial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelPlatoDia;
    private javax.swing.JLabel jLabelPlatoEspecial;
    private javax.swing.JList<String> jListPlatoDia;
    private javax.swing.JList<String> jListPlatoEspecial;
    private javax.swing.JScrollPane jScrollPanePlatoDia;
    private javax.swing.JScrollPane jScrollPanePlatoEspecial;
    private javax.swing.JTextField jTextFieldEliminarPlaDia;
    private javax.swing.JTextField jTextFieldEliminarPlaEsp;
    // End of variables declaration//GEN-END:variables
}
