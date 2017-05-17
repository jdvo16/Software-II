package Restaurant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class frmPedidos extends javax.swing.JFrame {

    static ResultSet rs;
    PreparedStatement ps;

    public frmPedidos() {
        initComponents();
        CargarPedidos();

    }

    public void CargarPedidos() {
        DefaultTableModel modelo = (DefaultTableModel) jTablePed.getModel();
        modelo.setRowCount(0);
        rs = Conexion.Consulta("select * from pedidos ORDER BY Numero_Mesa");
        try {
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getInt(3));
                modelo.addRow(v);
                jTablePed.setModel(modelo);
            }
        } catch (SQLException e) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePed = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnFin = new javax.swing.JButton();
        txtnm = new javax.swing.JTextField();
        txtcon = new javax.swing.JTextField();
        txtcod = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("PEDIDOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, -1, -1));

        jLabel2.setText("Numero de Mesa :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 110, 20));

        jLabel3.setText("Consumicion :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 100, 20));

        jLabel4.setText("Codigo de Consumicion :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, 20));

        jTablePed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Numero de Mesa", "Consumicion", "Codigo de Consumicion"
            }
        ));
        jScrollPane2.setViewportView(jTablePed);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 580, 199));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("PEDIDOS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, -1));

        btnFin.setText("FIN PEDIDO");
        btnFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinActionPerformed(evt);
            }
        });
        getContentPane().add(btnFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, -1, -1));
        getContentPane().add(txtnm, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 56, -1));
        getContentPane().add(txtcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 211, -1));
        getContentPane().add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 56, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        DefaultTableModel modelo = (DefaultTableModel) jTablePed.getModel();
        Object[] fila = new Object[3];
        fila[0] = txtnm.getText();
        fila[1] = txtcon.getText();
        fila[2] = txtcod.getText();
        modelo.addRow(fila);
        jTablePed.setModel(modelo);
       

        if (txtnm.getText().isEmpty() || txtcon.getText().isEmpty() || txtcod.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese los Datos");
            txtnm.setText("");
            txtcon.setText("");
            txtcod.setText("");
            txtnm.requestFocus();
       
        } else {
            try {
                Procedimientos.GuardarPedidos(txtnm.getText(), txtcon.getText(), txtcod.getText());
                txtnm.setText("");
                txtcon.setText("");
                txtcod.setText("");
                txtnm.requestFocus();
                JOptionPane.showMessageDialog(this, "Pedido Guardado Correctamente");
            } catch (SQLException e) {

            }

        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinActionPerformed
        dispose();
    }//GEN-LAST:event_btnFinActionPerformed

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
            java.util.logging.Logger.getLogger(frmPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnFin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePed;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtcon;
    private javax.swing.JTextField txtnm;
    // End of variables declaration//GEN-END:variables
}
