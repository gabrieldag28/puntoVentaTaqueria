/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package almacen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego_Alonso
 */
public class frmBuscarProducto extends javax.swing.JFrame {
    
    Connection conexion;
    JTextField txtIdProducto;
    /**
     * Creates new form frmBuscarProducto
     */
    public frmBuscarProducto() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
          inicializaBaseDeDatos();
          llenaTablaProductos();
    }
 public frmBuscarProducto(JTextField txtIdProducto) {
        initComponents();
        inicializaBaseDeDatos();
        llenaTablaProductos();
        this.txtIdProducto=txtIdProducto;
    }
    
    
    public void inicializaBaseDeDatos(){
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conexion = DriverManager.
                    getConnection("jdbc:mysql://"
                    + "localhost/punto_venta","root","");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
        
    public void llenaTablaProductos(){
        try{            
            DefaultTableModel model = new DefaultTableModel();
            tableBuscarProducto.setModel(model);
            
            PreparedStatement consulta = conexion.prepareStatement(""
                    + "SELECT id_producto_almacen, nombre "
                    + " FROM producto_almacen WHERE status=1");                  
            ResultSet rs = consulta.executeQuery();
            
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();            
            for(int i = 1; i <= cantidadColumnas; i++){
                model.addColumn(rsMd.getColumnLabel(i));
            }
            
            
            while(rs.next()){
                Object[] fila = new Object[cantidadColumnas];
                for(int j=1; j <= cantidadColumnas; j++){
                    fila[j-1] = rs.getObject(j);
                }                
                
                model.addRow(fila);
            }
            
            
        }catch(Exception e){
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

        txtBuscaProducto2 = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBuscarProducto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscaProducto2.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        txtBuscaProducto2.setForeground(new java.awt.Color(0, 102, 204));
        txtBuscaProducto2.setText("              Productos");
        txtBuscaProducto2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaProducto2KeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscaProducto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 160, -1));

        btnSeleccionar.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        btnSeleccionar.setForeground(new java.awt.Color(0, 102, 204));
        btnSeleccionar.setText("Seleccionar Producto");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 170, -1));

        tableBuscarProducto.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tableBuscarProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableBuscarProducto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 232));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/fondo.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscaProducto2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaProducto2KeyReleased
        try{
            DefaultTableModel model = new DefaultTableModel();
            tableBuscarProducto.setModel(model);

            /*
            PreparedStatement consulta = conexion.prepareStatement(""
                + "SELECT * FROM usuarios WHERE status=1 AND nombre LIKE ?");
            consulta.setString( 1, "%"+txtBuscar.getText()+"%");
            */
            PreparedStatement consulta = conexion.prepareStatement(""
                + "SELECT id_producto, descripcion FROM producto WHERE status=1 AND nombre LIKE ?");
            consulta.setString( 1,"'"+txtBuscaProducto2.getText()+"'");
            ResultSet rs = consulta.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            for(int i = 1; i <= cantidadColumnas; i++){
                model.addColumn(rsMd.getColumnLabel(i));
            }

            while(rs.next()){
                Object[] fila = new Object[cantidadColumnas];
                for(int j=1; j <= cantidadColumnas; j++){
                    fila[j-1] = rs.getObject(j);
                }

                model.addRow(fila);
            }

        }catch(Exception e){
            e.printStackTrace();

        }             // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaProducto2KeyReleased

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int id = (int) tableBuscarProducto.getValueAt(tableBuscarProducto.getSelectedRow() , 0);
        txtIdProducto.setText(""+id);
        
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
            java.util.logging.Logger.getLogger(frmBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBuscarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableBuscarProducto;
    private javax.swing.JTextField txtBuscaProducto2;
    // End of variables declaration//GEN-END:variables
}
