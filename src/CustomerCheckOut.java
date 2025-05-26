
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
public class CustomerCheckOut extends javax.swing.JFrame {

    int days = 0;
    double pri;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection con = null; // Initialize as null

    public CustomerCheckOut() {
        initComponents();
        // Initialize database connection
        try {
            con = DBConnection.getConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage());
            e.printStackTrace();
        }
        
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd ");
        Date d = new Date();
        txtoutdate.setText(date.format(d));
        s();
    }

    public void s() {
        int q, i;

        try {
            if (con == null) {
                con = DBConnection.getConnection();
            }
            
            pst = con.prepareStatement("Select * from customer where status=? OR status IS NULL");
            pst.setString(1, "NULL");
            rs = pst.executeQuery();
            ResultSetMetaData stData = (ResultSetMetaData) rs.getMetaData();
            q = stData.getColumnCount();
            DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
            RecordTable.setRowCount(0);
            
            while (rs.next()) {
                Vector columnData = new Vector();
                // Fix: Only add each column once, not in a loop
                columnData.add(rs.getString("name"));
                columnData.add(rs.getString("mobile"));
                columnData.add(rs.getString("email"));
                columnData.add(rs.getString("date"));
                columnData.add(rs.getString("nationality"));
                columnData.add(rs.getString("gender"));
                columnData.add(rs.getString("address"));
                columnData.add(rs.getString("roomnumber"));
                columnData.add(rs.getString("bed"));
                columnData.add(rs.getString("roomtype"));
                columnData.add(rs.getString("priceperday"));
                columnData.add(rs.getString("id"));
                
                RecordTable.addRow(columnData);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading customer data: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unexpected error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtroomnumber = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtoutdate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtmobile = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtdays = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtamount = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("BiauKaiTC", 1, 36)); // NOI18N
        jLabel1.setText("Customer Check Out");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 340, 70));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Room Number");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 28));

        txtroomnumber.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        txtroomnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtroomnumberActionPerformed(evt);
            }
        });
        getContentPane().add(txtroomnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 104, 30));

        jButton2.setBackground(new java.awt.Color(255, 0, 51));
        jButton2.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(240, 240, 240));
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, 30));

        jTable1.setFont(new java.awt.Font("BiauKaiTC", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Mobile Number", "Email ID", "Check IN Date", "Nationality", "Gender", "Address", "Room Number", "Bed", "Room Type", "Price Per Day"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 441, 1140, 330));

        jLabel3.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel3.setText("Customer Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 232, 43));

        txtname.setEditable(false);
        txtname.setBackground(new java.awt.Color(255, 255, 255));
        txtname.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 290, 40));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel4.setText("Check in Date");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 240, 36));

        txtdate.setEditable(false);
        txtdate.setBackground(new java.awt.Color(255, 255, 255));
        txtdate.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        getContentPane().add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 290, 43));

        jLabel5.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel5.setText("Check out Date(Today)");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 260, 36));

        txtoutdate.setEditable(false);
        txtoutdate.setBackground(new java.awt.Color(255, 255, 255));
        txtoutdate.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        getContentPane().add(txtoutdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 280, 40));

        jLabel6.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel6.setText("Customer Mobile Number");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 270, 36));

        txtmobile.setEditable(false);
        txtmobile.setBackground(new java.awt.Color(255, 255, 255));
        txtmobile.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        getContentPane().add(txtmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 280, 39));

        jLabel7.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Price Per Day");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 242, 40));

        txtdays.setEditable(false);
        txtdays.setBackground(new java.awt.Color(255, 255, 255));
        txtdays.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        getContentPane().add(txtdays, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 280, 38));

        jLabel8.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel8.setText("Number of Days");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 240, 40));

        txtprice.setEditable(false);
        txtprice.setBackground(new java.awt.Color(255, 255, 255));
        txtprice.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });
        getContentPane().add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 290, 38));

        jLabel9.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        jLabel9.setText("Total Amount to Collect From Customer");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 250, 380, 37));

        txtamount.setEditable(false);
        txtamount.setBackground(new java.awt.Color(255, 255, 255));
        txtamount.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        getContentPane().add(txtamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 290, 40));

        jLabel10.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel10.setText("Email");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 250, 36));

        txtemail.setEditable(false);
        txtemail.setBackground(new java.awt.Color(255, 255, 255));
        txtemail.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, 290, 40));

        jButton3.setBackground(new java.awt.Color(255, 0, 51));
        jButton3.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Check Out");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 350, 130, 30));

        jButton4.setBackground(new java.awt.Color(255, 0, 51));
        jButton4.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 390, 80, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/katsia-jazwinska-RIb19_YSUX0-unsplash.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtroomnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtroomnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtroomnumberActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtname.setText("");
        txtemail.setText("");
        txtmobile.setText("");
        txtprice.setText("");
        txtdate.setText("");
        txtdays.setText("");
        txtamount.setText("");

        try {
            if (con == null) {
                con = DBConnection.getConnection();
            }
            
            pst = con.prepareStatement("select name,mobile,email,date,priceperday from customer where roomnumber=? AND (status=? OR status IS NULL)");
            pst.setString(1, txtroomnumber.getText().trim());
            pst.setString(2, "NULL");
            rs = pst.executeQuery();
            
            if (rs.next()) {
                txtname.setText(rs.getString("name"));
                txtemail.setText(rs.getString("email"));
                txtmobile.setText(rs.getString("mobile"));
                txtdate.setText(rs.getString("date"));
                txtprice.setText(rs.getString("priceperday"));
                
                String f1 = rs.getString("date").trim();  // Date from the database (e.g., "2024/12/15")

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

                // Parse the date from the string
                LocalDate date1 = LocalDate.parse(f1, formatter);
                LocalDate date2 = LocalDate.now();
                // Calculate the difference in days
                long days = ChronoUnit.DAYS.between(date1, date2);

                System.out.println("Difference in days: " + days);
                
                if (days <= 0) {
                    txtdays.setText("1");
                    days = 1;
                } else {
                    txtdays.setText(String.valueOf(days));
                }
                
                double p = Double.parseDouble(rs.getString("priceperday"));
                double pri = days * p;
                txtamount.setText(String.valueOf(pri));
            } else {
                JOptionPane.showMessageDialog(this, "No customer found in this room or customer already checked out.");
            }
            
        } catch (SQLException ex) {
            txtdays.setText("");
            txtamount.setText("");
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            txtdays.setText("");
            txtamount.setText("");
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }                                        

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txtname.setText("");
        txtemail.setText("");
        txtmobile.setText("");
        txtdate.setText("");
        txtprice.setText("");
        txtdays.setText("");
        txtamount.setText("");
        txtroomnumber.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Close database connection before disposing
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
        int SelectedRows = jTable1.getSelectedRow();
        
        if (SelectedRows >= 0) {
            txtname.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
            txtmobile.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
            txtemail.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
            txtdate.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
            txtroomnumber.setText(RecordTable.getValueAt(SelectedRows, 7).toString());
            txtprice.setText(RecordTable.getValueAt(SelectedRows, 11).toString());

            String f1 = RecordTable.getValueAt(SelectedRows, 3).toString().trim();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

            // Parse the date from the string
            LocalDate date1 = LocalDate.parse(f1, formatter);
            LocalDate date2 = LocalDate.now();
            // Calculate the difference in days
            long days = ChronoUnit.DAYS.between(date1, date2);

            if (days <= 0) {
                txtdays.setText("1");
                days = 1;
            } else {
                txtdays.setText(String.valueOf(days));
            }
            
            double p = Double.parseDouble(RecordTable.getValueAt(SelectedRows, 11).toString().trim());
            double pri = days * p;
            txtamount.setText(String.valueOf(pri));
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (txtname.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter Room Number And Search it, Then Check Out Customer");
        } else {
            try {
                if (con == null) {
                    con = DBConnection.getConnection();
                }
                
                // Use transaction for data consistency
                con.setAutoCommit(false);
                
                // Update customer status to checked out
                pst = con.prepareStatement("update customer set status=? where roomnumber=? AND (status=? OR status IS NULL)");
                pst.setString(1, "check out");
                pst.setString(2, txtroomnumber.getText().trim());
                pst.setString(3, "NULL");
                int customerUpdated = pst.executeUpdate();
                pst.close();
                
                if (customerUpdated > 0) {
                    // Update customer with checkout details
                    pst = con.prepareStatement("update customer set amount=?,outdate=?,days=? where roomnumber=? AND date=?");
                    pst.setString(1, txtamount.getText());
                    pst.setString(2, txtoutdate.getText());
                    pst.setString(3, txtdays.getText());
                    pst.setString(4, txtroomnumber.getText().trim());
                    pst.setString(5, txtdate.getText());
                    pst.executeUpdate();
                    pst.close();
                    
                    // Update room status to available
                    pst = con.prepareStatement("update room set status=? where roomnumber=?");
                    pst.setString(1, "Not Booked");
                    pst.setString(2, txtroomnumber.getText().trim());
                    pst.executeUpdate();
                    pst.close();
                    
                    // Commit transaction
                    con.commit();
                    con.setAutoCommit(true);

                    String subject = "Your Checkout Details from Hotel";
                    String msg = "Dear Customer,\n\n"
                            + "Thank you for staying with us. Here are your checkout details:\n\n"
                            + "Room Number: " + txtroomnumber.getText() + "\n"
                            + "Amount to Pay: " + txtamount.getText() + "\n"
                            + "Checkout Date: " + txtoutdate.getText() + "\n"
                            + "Total Days Stayed: " + txtdays.getText() + "\n\n"
                            + "We hope you had a pleasant stay and look forward to welcoming you again.\n\n"
                            + "Best regards,\n"
                            + "The Hotel Team";

                    int yes = JOptionPane.showConfirmDialog(this, "Check out Successfully.\nDo you want to see & print bill?", "Checked out", JOptionPane.YES_NO_OPTION);
                    if (JOptionPane.YES_OPTION == yes) {
                        new CustomerDetailsBill().setVisible(true);
                    }
                    
                    // Refresh table and clear fields
                    s();
                    txtname.setText("");
                    txtemail.setText("");
                    txtmobile.setText("");
                    txtdate.setText("");
                    txtprice.setText("");
                    txtdays.setText("");
                    txtamount.setText("");
                    txtroomnumber.setText("");
                    
                } else {
                    con.rollback();
                    con.setAutoCommit(true);
                    JOptionPane.showMessageDialog(this, "Customer not found or already checked out.");
                }
                
            } catch (SQLException e) {
                try {
                    if (con != null) {
                        con.rollback();
                        con.setAutoCommit(true);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(this, "Database error during checkout: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Unexpected error during checkout: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerCheckOut().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtamount;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtdays;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtoutdate;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtroomnumber;
    // End of variables declaration//GEN-END:variables
}
