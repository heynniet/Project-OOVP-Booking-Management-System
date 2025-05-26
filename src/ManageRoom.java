
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel, Nabil, Tentin
 */
public class ManageRoom extends javax.swing.JFrame {

    private String selectedRoomNumber;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private Connection con = null;

    public ManageRoom() {
        initComponents();
        loadRoomData();
        jButton3.setVisible(false);
        
        // Test database connection
        if (!DBConnection.testConnection()) {
            JOptionPane.showMessageDialog(this, 
                "Database connection failed! Please check your database settings.", 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadRoomData() {
        try {
            con = DBConnection.getConnection();
            pst = con.prepareStatement("SELECT * FROM room ORDER BY roomnumber");
            rs = pst.executeQuery();
            
            DefaultTableModel recordTable = (DefaultTableModel) jTable1.getModel();
            recordTable.setRowCount(0); // Clear existing data
            
            while (rs.next()) {
                Vector<String> columnData = new Vector<>();
                columnData.add(rs.getString("roomnumber"));
                columnData.add(rs.getString("roomtype"));
                columnData.add(rs.getString("bed"));
                columnData.add(rs.getString("price"));
                columnData.add(rs.getString("status"));
                recordTable.addRow(columnData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageRoom.class.getName()).log(Level.SEVERE, "Error loading room data", ex);
            JOptionPane.showMessageDialog(this, 
                "Error loading room data: " + ex.getMessage(), 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            closeResources();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtno = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("BiauKaiTC", 1, 36)); // NOI18N
        jLabel1.setText("Manage Room");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 230, 50));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, 60, 40));

        jTable1.setFont(new java.awt.Font("BiauKaiTC", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Room Number", "Room Type", "Bed", "Pricce", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 1140, 440));

        jLabel2.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel2.setText("Room Number");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 396, 30));

        jLabel3.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel3.setText("Room Type");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 396, 32));

        txtno.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        getContentPane().add(txtno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 396, 40));

        jComboBox1.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "NON AC" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 396, 40));

        jLabel4.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel4.setText("Bed");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 396, 35));

        jComboBox2.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Double" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 396, 40));

        jLabel5.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel5.setText("Price");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 396, 33));

        txtprice.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });
        getContentPane().add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 400, 35));

        jButton2.setBackground(new java.awt.Color(255, 0, 51));
        jButton2.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(240, 240, 240));
        jButton2.setText("Add Room");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 120, 40));

        jLabel7.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("Double Click on rows for Update & Delete");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 290, 320, 32));

        jButton3.setBackground(new java.awt.Color(255, 0, 51));
        jButton3.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 120, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/katsia-jazwinska-RIb19_YSUX0-unsplash.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed

    }//GEN-LAST:event_txtpriceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          if (txtno.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Room Number is required!", "Input Error", JOptionPane.WARNING_MESSAGE);
            txtno.requestFocus();
            return;
        }
        
        if (txtprice.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Price is required!", "Input Error", JOptionPane.WARNING_MESSAGE);
            txtprice.requestFocus();
            return;
        }

        // Validate price format
        try {
            double price = Double.parseDouble(txtprice.getText().trim());
            if (price <= 0) {
                JOptionPane.showMessageDialog(this, "Price must be greater than 0!", "Invalid Price", JOptionPane.WARNING_MESSAGE);
                txtprice.requestFocus();
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price!", "Invalid Price", JOptionPane.WARNING_MESSAGE);
            txtprice.requestFocus();
            return;
        }

        try {
            con = DBConnection.getConnection();
            
            // Check if room number already exists
            pst = con.prepareStatement("SELECT * FROM room WHERE roomnumber = ?");
            pst.setString(1, txtno.getText().trim());
            rs = pst.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Room Number already exists!", "Duplicate Room", JOptionPane.WARNING_MESSAGE);
                txtno.requestFocus();
                return;
            }

            // Insert new room
            pst = con.prepareStatement("INSERT INTO room (roomnumber, roomtype, bed, price, status) VALUES (?, ?, ?, ?, ?)");
            pst.setString(1, txtno.getText().trim());
            pst.setString(2, (String) jComboBox1.getSelectedItem());
            pst.setString(3, (String) jComboBox2.getSelectedItem());
            pst.setString(4, txtprice.getText().trim());
            pst.setString(5, "Not Booked");
            
            int result = pst.executeUpdate();
            
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Room added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearForm();
                loadRoomData();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManageRoom.class.getName()).log(Level.SEVERE, "Error adding room", ex);
            JOptionPane.showMessageDialog(this, 
                "Error adding room: " + ex.getMessage(), 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            closeResources();
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row!", "No Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            String roomNumber = (String) model.getValueAt(selectedRow, 0);
            String status = (String) model.getValueAt(selectedRow, 4);
            
            String[] options = {"Update", "Delete", "Cancel"};
            int choice = JOptionPane.showOptionDialog(this,
                "What would you like to do with Room " + roomNumber + "?",
                "Room Action",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);
            
            if (choice == 0) { // Update
                if (status.equalsIgnoreCase("booked")) {
                    JOptionPane.showMessageDialog(this, "Sorry! Room is booked, cannot be updated.", "Room Booked", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                // Populate form for update
                selectedRoomNumber = roomNumber;
                txtno.setText((String) model.getValueAt(selectedRow, 0));
                jComboBox1.setSelectedItem((String) model.getValueAt(selectedRow, 1));
                jComboBox2.setSelectedItem((String) model.getValueAt(selectedRow, 2));
                txtprice.setText((String) model.getValueAt(selectedRow, 3));
                
                txtno.setEditable(false);
                jButton2.setVisible(false);
                jButton3.setVisible(true);
                
            } else if (choice == 1) { // Delete
                if (status.equalsIgnoreCase("booked")) {
                    JOptionPane.showMessageDialog(this, "Sorry! Room is booked, cannot be deleted.", "Room Booked", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to delete Room " + roomNumber + "?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
                
                if (confirm == JOptionPane.YES_OPTION) {
                    deleteRoom(roomNumber);
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

         if (txtprice.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Price is required!", "Input Error", JOptionPane.WARNING_MESSAGE);
            txtprice.requestFocus();
            return;
        }
        
        // Validate price format
        try {
            double price = Double.parseDouble(txtprice.getText().trim());
            if (price <= 0) {
                JOptionPane.showMessageDialog(this, "Price must be greater than 0!", "Invalid Price", JOptionPane.WARNING_MESSAGE);
                txtprice.requestFocus();
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price!", "Invalid Price", JOptionPane.WARNING_MESSAGE);
            txtprice.requestFocus();
            return;
        }

        updateRoom();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Update room information
     */
    private void updateRoom() {
        try {
            con = DBConnection.getConnection();
            pst = con.prepareStatement("UPDATE room SET price = ?, roomtype = ?, bed = ? WHERE roomnumber = ?");
            pst.setString(1, txtprice.getText().trim());
            pst.setString(2, (String) jComboBox1.getSelectedItem());
            pst.setString(3, (String) jComboBox2.getSelectedItem());
            pst.setString(4, selectedRoomNumber);
            
            int result = pst.executeUpdate();
            
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Room updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                resetFormToAddMode();
                loadRoomData();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ManageRoom.class.getName()).log(Level.SEVERE, "Error updating room", ex);
            JOptionPane.showMessageDialog(this, 
                "Error updating room: " + ex.getMessage(), 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            closeResources();
        }
    }
    
    /**
     * Delete room from database
     * @param roomNumber Room number to delete
     */
    private void deleteRoom(String roomNumber) {
        try {
            con = DBConnection.getConnection();
            pst = con.prepareStatement("DELETE FROM room WHERE roomnumber = ?");
            pst.setString(1, roomNumber);
            
            int result = pst.executeUpdate();
            
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Room deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadRoomData();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ManageRoom.class.getName()).log(Level.SEVERE, "Error deleting room", ex);
            JOptionPane.showMessageDialog(this, 
                "Error deleting room: " + ex.getMessage(), 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            closeResources();
        }
    }
    
    /**
     * Clear form fields
     */
    private void clearForm() {
        txtno.setText("");
        txtprice.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
    }
    
    /**
     * Reset form to Add mode
     */
    private void resetFormToAddMode() {
        clearForm();
        txtno.setEditable(true);
        jButton2.setVisible(true);
        jButton3.setVisible(false);
        selectedRoomNumber = null;
    }
    
    /**
     * Close database resources properly
     */
    private void closeResources() {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (pst != null && !pst.isClosed()) {
                pst.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageRoom.class.getName()).log(Level.WARNING, "Error closing database resources", ex);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ManageRoom.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ManageRoom().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txtprice;
    // End of variables declaration//GEN-END:variables
}
