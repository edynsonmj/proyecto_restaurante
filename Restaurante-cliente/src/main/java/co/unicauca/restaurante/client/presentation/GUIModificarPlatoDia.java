package co.unicauca.restaurante.client.presentation;

import co.unicauca.restaurante.client.domain.clienteService;
import co.unicauca.restaurante.commons.domain.PlatoDia;
import co.unicauca.restaurante.commons.infra.Utilities;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo Gonzalez
 */
public class GUIModificarPlatoDia extends javax.swing.JFrame {
    
    clienteService servicioRestaurante;
    DefaultListModel modelListEspecial;
    /**
     * Creates new form GUIModificarPlato
     * @param servicioRestaurante
     */
    public GUIModificarPlatoDia(clienteService servicioRestaurante) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.btnActualizar.setEnabled(false);
        this.modelListEspecial=new DefaultListModel();
        this.jListaPlato.setModel(modelListEspecial);
        this.servicioRestaurante=servicioRestaurante;
        
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

        jLabelCodigo = new javax.swing.JLabel();
        jLabelTipo = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        txtID = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListaPlato = new javax.swing.JList<>();
        jlValor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCodigo.setBackground(new java.awt.Color(153, 0, 0));
        jLabelCodigo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabelCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCodigo.setText("Codigo del plato");
        jLabelCodigo.setOpaque(true);
        getContentPane().add(jLabelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabelTipo.setBackground(new java.awt.Color(153, 0, 0));
        jLabelTipo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabelTipo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTipo.setText("Seleccione que desea Modificar");
        jLabelTipo.setOpaque(true);
        getContentPane().add(jLabelTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Nombre", "Descripcion", "Entrada", "Principio", "Bebida", "Carne", "Precio" }));
        cbxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoItemStateChanged(evt);
            }
        });
        getContentPane().add(cbxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 260, 40));
        cbxTipo.getAccessibleContext().setAccessibleName("");

        txtID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
        });
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 190, 40));

        txtValor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValorKeyReleased(evt);
            }
        });
        getContentPane().add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 190, 40));

        btnActualizar.setBackground(new java.awt.Color(204, 0, 0));
        btnActualizar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 160, 30));

        btnVolver.setBackground(new java.awt.Color(255, 255, 255));
        btnVolver.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setName(""); // NOI18N
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jListaPlato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jListaPlato.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListaPlato);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 800, 280));

        jlValor.setBackground(new java.awt.Color(153, 0, 0));
        jlValor.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jlValor.setForeground(new java.awt.Color(255, 255, 255));
        jlValor.setText("Modificación");
        jlValor.setOpaque(true);
        getContentPane().add(jlValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 770, -1));

        jLabel2.setBackground(new java.awt.Color(153, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MODIFICAR PLATO DEL DIA");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
         setVisible(false);
        GUIMenuModificar ins = new GUIMenuModificar (servicioRestaurante);
        ins.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    /**
     * al ser pulsado, valida los datos, y envia la solicitud
     * @param evt 
     */
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        boolean respuesta = false;
        int id =Integer.parseInt(txtID.getText());
        String valor = this.txtValor.getText();
        String atributo=null;
        if(this.cbxTipo.getSelectedIndex()==1){
            atributo = "PDIA_NOMBRE";
        }else if(this.cbxTipo.getSelectedIndex()==2){
            atributo = "PDIA_DESCRIPCION";
        }else if(this.cbxTipo.getSelectedIndex()==3){
            atributo = "PDIA_ENTRADA";
        }else if(this.cbxTipo.getSelectedIndex()==4){
            atributo = "PDIA_PRINCIPIO";
        }else if(this.cbxTipo.getSelectedIndex()==5){
            atributo = "PDIA_BEBIDA";
        }else if(this.cbxTipo.getSelectedIndex()==6){
            atributo = "PDIA_CARNE";
        }else if(this.cbxTipo.getSelectedIndex()==7){
            atributo = "PDIA_PRECIO";
        }
        
        if(atributo.equals("PDIA_PRECIO")){
            if(!Utilities.isNumeric(valor)){
                JOptionPane.showMessageDialog(null, "el precio debe contener valores numericos, VERIFIQUE");
                return;
            }
        }
        try {
            respuesta = servicioRestaurante.updatePlatoDia(id, atributo, valor);
            if(!respuesta){
                JOptionPane.showMessageDialog(null, "verifique los datos, ITEM NO ENCONTRADO");
            }
            this.listar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ha fallado el servicio, intentelo de nuevo");
            Logger.getLogger(GUIModificarPlatoDia.class.getName()).log(Level.SEVERE, null, ex);
            //mostrar mensaje
        }
        
        //DESABILITAR AL FINAL
        this.txtID.setText(null);
        this.cbxTipo.setSelectedIndex(0);
        this.txtValor.setText(null);
        this.btnActualizar.setEnabled(false);
    }//GEN-LAST:event_btnActualizarActionPerformed

    /**
     * lista en la interfaz una base de datos
     * @throws Exception 
     */
    private void listar() throws Exception{
        int resId=1;
        List<PlatoDia> lista = servicioRestaurante.listarMenuDia(resId);
        modelListEspecial.clear();

        for (PlatoDia lse : lista) {
            modelListEspecial.addElement("ID: " + lse.getId() 
                    + " NOMBRE: " + lse.getNombre()
                    + " DESCRIPCION: " + lse.getDescripcion() 
                    + " PRECIO: " + lse.getPrecio() 
                    + " ENTRADA: "+lse.getEntrada() 
                    + " PRINCIPIO: "+lse.getPrincipio()
                    + " CARNE: "+lse.getCarne()
                    + " BEBIDA: "+lse.getBebida()
                    + " DIA: "+lse.getDiaSemana());
        }
    }
    /**
     * valida que se ingresen solo caracteres del 0 al 9 (numeros)
     * @param evt 
     */
    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_txtIDKeyTyped

    /**
     * se despliega al momento de digitar en la caja de texto, y verifica si estan llenos los parametros
     * @param evt 
     */
    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased
        habilitarBtnActualizar();
    }//GEN-LAST:event_txtIDKeyReleased

    /**
     * se activa al momento de ingresar caracteres a la caja de texto
     * @param evt 
     */
    private void txtValorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyReleased
        // TODO add your handling code here:
        habilitarBtnActualizar();
    }//GEN-LAST:event_txtValorKeyReleased

    /**
     * se activa al momento de cambiar el estado del combo box
     * @param evt 
     */
    private void cbxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoItemStateChanged
        habilitarBtnActualizar();
    }//GEN-LAST:event_cbxTipoItemStateChanged

    /**
     * verifica si ya es momento de activar el boton, solo cuando se han digitado y seleccionado los datos
     */
    private void habilitarBtnActualizar(){
        if(this.txtID.getText().isEmpty() 
                || this.txtValor.getText().isEmpty()
                || this.cbxTipo.getSelectedIndex()==0){
            this.btnActualizar.setEnabled(false);
        }else{
            this.btnActualizar.setEnabled(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JList<String> jListaPlato;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlValor;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
