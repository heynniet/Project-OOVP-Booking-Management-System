
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel, Nabil, Tentin
 */
public class GenerateBill extends javax.swing.JFrame {

    String id = CustomerDetailsBill.idd;
    String nm;
    String mobile;
    String email;
    String roomnumber;
    String bed;
    String type;
    String indate;
    String outdate;
    String price;
    String days;
    String amount;

    /**
     * Creates new form GenerateBill
     */
    public GenerateBill() {
        initComponents();
        connect();
        generateBillText();
    }
    
    /**
     * Generate bill text and display in textarea
     */
    private void generateBillText() {
        StringBuilder billText = new StringBuilder();
        billText.append("\t\t-: Booking :-\n");
        billText.append("**********************************************************************************\n");
        billText.append("Bill ID:- ").append(id != null ? id : "N/A").append("\n");
        billText.append("Customer Details:- \n");
        billText.append("Name:- ").append(nm != null ? nm : "N/A").append("\n");
        billText.append("Mobile Number:- ").append(mobile != null ? mobile : "N/A").append("\n");
        billText.append("Email:- ").append(email != null ? email : "N/A").append("\n");
        billText.append("**********************************************************************************\n");
        billText.append("Room Details:- \n");
        billText.append("Room Number:- ").append(roomnumber != null ? roomnumber : "N/A").append("\n");
        billText.append("Type:- ").append(type != null ? type : "N/A").append("\n");
        billText.append("Bed:- ").append(bed != null ? bed : "N/A").append("\n");
        billText.append("Price:- ").append(price != null ? price : "N/A").append("\n");
        billText.append("Check IN Date=").append(indate != null ? indate : "N/A")
                  .append("\t\tNumber of Days=").append(days != null ? days : "N/A").append("\n");
        billText.append("Check OUT Date=").append(outdate != null ? outdate : "N/A")
                  .append("\t\tTotal Amount=").append(amount != null ? amount : "N/A").append("\n");
        billText.append("**********************************************************************************\n");
        billText.append("\t\t").append("                    Thank You, Please Visit Again.");
        
        txtbill.setText(billText.toString());
    }

    /**
     * Connect to database and fetch customer details
     */
    public void connect() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            // Get connection using the DBConnection class
            con = DBConnection.getConnection();
            
            if (con != null) {
                pst = con.prepareStatement("SELECT * FROM customer WHERE billid = ?");
                pst.setString(1, id);
                rs = pst.executeQuery();
                
                if (rs.next()) {
                    email = rs.getString("email");
                    nm = rs.getString("name");
                    mobile = rs.getString("mobile");
                    roomnumber = rs.getString("roomnumber");
                    bed = rs.getString("bed");
                    type = rs.getString("roomtype");
                    indate = rs.getString("date");
                    outdate = rs.getString("outdate");
                    price = rs.getString("price");
                    days = rs.getString("days");
                    amount = rs.getString("amount");
                } else {
                    // Handle case when no record is found
                    System.out.println("No customer record found for Bill ID: " + id);
                    showErrorMessage("No customer record found for Bill ID: " + id);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GenerateBill.class.getName()).log(Level.SEVERE, "Database error", ex);
            showErrorMessage("Database connection error: " + ex.getMessage());
        } finally {
            // Close resources in finally block
            closeResources(rs, pst, con);
        }
    }
    
    /**
     * Close database resources
     */
    private void closeResources(ResultSet rs, PreparedStatement pst, Connection con) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            Logger.getLogger(GenerateBill.class.getName()).log(Level.WARNING, "Error closing ResultSet", e);
        }
        
        try {
            if (pst != null) pst.close();
        } catch (SQLException e) {
            Logger.getLogger(GenerateBill.class.getName()).log(Level.WARNING, "Error closing PreparedStatement", e);
        }
        
        try {
            if (con != null && !con.isClosed()) con.close();
        } catch (SQLException e) {
            Logger.getLogger(GenerateBill.class.getName()).log(Level.WARNING, "Error closing Connection", e);
        }
    }
    
    /**
     * Show error message to user
     */
    private void showErrorMessage(String message) {
        javax.swing.JOptionPane.showMessageDialog(this, message, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtbill = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbill.setEditable(false);
        txtbill.setColumns(20);
        txtbill.setFont(new java.awt.Font("BiauKaiTC", 1, 14)); // NOI18N
        txtbill.setRows(5);
        txtbill.setWrapStyleWord(true);
        txtbill.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtbillFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txtbill);
        txtbill.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 520, 370));

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 500, 120, 40));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 60, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/daniil-silantev-UIcBEy5TDTA-unsplash.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 700, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusLost

    private void txtbillFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbillFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbillFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            txtbill.print();
        } catch (PrinterException ex) {
            Logger.getLogger(GenerateBill.class.getName()).log(Level.SEVERE, "Print error", ex);
            showErrorMessage("Failed to print bill: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GenerateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerateBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtbill;
    // End of variables declaration//GEN-END:variables
}
