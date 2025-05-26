
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel, Nabil, Tentin
 */
public class CustomerDetailsBill extends javax.swing.JFrame {

    static String idd;
    private static final Logger LOGGER = Logger.getLogger(CustomerDetailsBill.class.getName());

    /**
     * Creates new form CustomerDetailsBill
     */
    public CustomerDetailsBill() {
        initComponents();
        initializeDate();
        loadCustomerData();
    }
    
    /**
     * Initialize date field with current date
     */
    private void initializeDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date currentDate = new Date();
        txtdate.setText(dateFormat.format(currentDate));
    }

    /**
     * Load all customer data with checkout status
     */
    public void loadCustomerData() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection();
            if (con == null) {
                showErrorMessage("Failed to connect to database");
                return;
            }

            pst = con.prepareStatement("SELECT * FROM customer WHERE status = ?");
            pst.setString(1, "check out");
            rs = pst.executeQuery();
            
            populateTable(rs);
            
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database error while loading customer data", e);
            showErrorMessage("Error loading customer data: " + e.getMessage());
        } finally {
            closeResources(rs, pst, con);
        }
    }
    
    /**
     * Search customer data by checkout date
     */
    private void searchByDate() {
        String searchDate = txtdate.getText().trim();
        if (searchDate.isEmpty()) {
            showErrorMessage("Please enter a date to search");
            return;
        }
        
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection();
            if (con == null) {
                showErrorMessage("Failed to connect to database");
                return;
            }

            pst = con.prepareStatement("SELECT * FROM customer WHERE status = ? AND outdate = ?");
            pst.setString(1, "check out");
            pst.setString(2, searchDate);
            rs = pst.executeQuery();
            
            populateTable(rs);
            
            
            
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database error while searching by date", e);
            showErrorMessage("Error searching records: " + e.getMessage());
        } finally {
            closeResources(rs, pst, con);
        }
    }
    
    /**
     * Populate table with ResultSet data
     */
    private void populateTable(ResultSet rs) throws SQLException {
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0); // Clear existing data
        
        while (rs.next()) {
            Vector<String> rowData = new Vector<>();
            rowData.add(rs.getString("billid"));
            rowData.add(rs.getString("roomnumber"));
            rowData.add(rs.getString("name"));
            rowData.add(rs.getString("mobile"));
            rowData.add(rs.getString("nationality"));
            rowData.add(rs.getString("gender"));
            rowData.add(rs.getString("email"));
            rowData.add(rs.getString("address"));
            rowData.add(rs.getString("date"));
            rowData.add(rs.getString("outdate"));
            rowData.add(rs.getString("bed"));
            rowData.add(rs.getString("roomtype"));
            rowData.add(rs.getString("price"));
            rowData.add(rs.getString("days"));
            rowData.add(rs.getString("amount"));
            
            tableModel.addRow(rowData);
        }
    }
    
    /**
     * Close database resources
     */
    private void closeResources(ResultSet rs, PreparedStatement pst, Connection con) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error closing ResultSet", e);
        }
        
        try {
            if (pst != null) pst.close();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error closing PreparedStatement", e);
        }
        
        try {
            if (con != null && !con.isClosed()) con.close();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error closing Connection", e);
        }
    }
    
    /**
     * Show error message to user
     */
    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Show info message to user
     */
    private void showInfoMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Information", JOptionPane.INFORMATION_MESSAGE);
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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.lightGray);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("BiauKaiTC", 1, 36)); // NOI18N
        jLabel1.setText("Customer Details Bill");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 400, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel2.setText("Search by CheckOut Date ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 280, -1));

        txtdate.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        txtdate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 220, 30));

        jButton2.setBackground(new java.awt.Color(255, 0, 51));
        jButton2.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(240, 240, 240));
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 110, 30));

        jTable1.setFont(new java.awt.Font("BiauKaiTC", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Bill ID", "Room Number", "Name", "Mobile Number", "Nationality", "Gender", "Email", "Address", "Check in Date", "Ckeck out Date", "Bed", "Room Type", "Price", "Number of Days", "Total Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1140, 590));

        jLabel4.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Double Click on row to Open Bill");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, 340, 42));

        jButton3.setBackground(new java.awt.Color(255, 0, 51));
        jButton3.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(240, 240, 240));
        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 110, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/katsia-jazwinska-RIb19_YSUX0-unsplash.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            int selectedRow = jTable1.getSelectedRow();
            
            if (selectedRow >= 0) {
                Object billIdValue = tableModel.getValueAt(selectedRow, 0);
                if (billIdValue != null) {
                    idd = billIdValue.toString();
                    try {
                        new GenerateBill().setVisible(true);
                    } catch (Exception e) {
                        LOGGER.log(Level.SEVERE, "Error opening GenerateBill window", e);
                        showErrorMessage("Error opening bill: " + e.getMessage());
                    }
                } else {
                    showErrorMessage("Invalid bill ID selected");
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        searchByDate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        loadCustomerData();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerDetailsBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerDetailsBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerDetailsBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerDetailsBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerDetailsBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtdate;
    // End of variables declaration//GEN-END:variables
}
