/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buscar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.sql.ConnectionEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FIMAZ
 */
public class frmBuscarCliente extends javax.swing.JFrame {
    private Connection conexion;

    /**
     * Creates new form frmBuscarCliente
     */
    public frmBuscarCliente() {
        initComponents();
        inicializaBaseDeDatos();
        llenarTablaUsuarios();
    }
    public void inicializaBaseDeDatos(){
        try{
        DriverManager.registerDriver(new com.mysql.jdbc.Driver()); // para cargar el driver en java
        conexion =DriverManager.getConnection("jdbc:mysql://" + "localhost/punto_venta","root","");// PARA CONECTARNOS CON LA BASE DE DATOS
        }catch (Exception ex){
            ex.printStackTrace();
        }
        
    }
    public void llenarTablaUsuarios(){
        try{
            DefaultTableModel model= new DefaultTableModel();
            tableClientes.setModel(model);
            PreparedStatement consulta = conexion.prepareStatement("" + "SELECT id_usuario, CONCAT (nombre,'',apellido_paterno,'',apellido_materno)"+"AS nombre FROM usuarios WHERE status =1");
            ResultSet rs= consulta.executeQuery();
            ResultSetMetaData rsMd =rs.getMetaData();
            int cantidadColumnas=rsMd.getColumnCount();
            for (int i=1; i<=cantidadColumnas; i ++){
                model.addColumn(rsMd.getColumnLabel(i));
                
            }
            while(rs.next()){
                Object[] fila = new Object[cantidadColumnas];
                for (int j=1; j <= cantidadColumnas; j++){
                    fila[j-1]= rs.getObject(j);
                }
                model.addRow(fila);
                }
            }catch (Exception e){
                e.printStackTrace();
                
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

        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableClientes);

        jLabel1.setText("Buscar Usuario");

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        btnSeleccionar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnSeleccionarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 158, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSeleccionar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        try{
        DefaultTableModel model= new DefaultTableModel();
        tableClientes.setModel(model);
        PreparedStatement consulta=conexion.prepareStatement("" + "SELECT id_usuario, CONCAT (nombre,'',apellido_paterno,'',apellido_materno)"+"AS nombre FROM usuarios WHERE status =1 AND MATCH (nombre,apellido_paterno,apellido_materno)AGAINST(?)");
        consulta.setString(1,"%" + txtNombre.getText() +"%");
        ResultSet rs= consulta.executeQuery();
            ResultSetMetaData rsMd =rs.getMetaData();
            int cantidadColumnas=rsMd.getColumnCount();
            for (int i=1; i<=cantidadColumnas; i ++){
                model.addColumn(rsMd.getColumnLabel(i));
                
            }
            while(rs.next()){
                Object[] fila = new Object[cantidadColumnas];
                for (int j=1; j <= cantidadColumnas; j++){
                    fila[j-1]= rs.getObject(j);
                }
                model.addRow(fila);
                }
            }catch (Exception e){
                e.printStackTrace();
            }    
    }//GEN-LAST:event_txtNombreKeyReleased

    private void btnSeleccionarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSeleccionarKeyReleased
        // no pasa nada ?????????????????????????????
    }//GEN-LAST:event_btnSeleccionarKeyReleased

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
     // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int id=(int) tableClientes.getValueAt(tableClientes.getSelectedRow(), 0);
        JOptionPane.showMessageDialog(null,""+ id);
        this.dispose();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

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
            java.util.logging.Logger.getLogger(frmBuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBuscarCliente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableClientes;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
