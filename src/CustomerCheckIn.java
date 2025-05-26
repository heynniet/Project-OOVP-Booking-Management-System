
import java.sql.Connection;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
public class CustomerCheckIn extends javax.swing.JFrame {

    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private Connection con = null;
    private boolean isValidating = false;
    private boolean isInitializing = true;

    public CustomerCheckIn() {
        try {
            System.out.println("=== Starting CustomerCheckIn ===");
            
            isInitializing = true; // Set flag untuk mencegah event selama inisialisasi
            
            con = DBConnection.getConnection();
            System.out.println("Database connection established successfully");
            
            initComponents();
            
            SimpleDateFormat dat = new SimpleDateFormat("yyyy/MM/dd");
            txtdate.setText(dat.format(new Date()));
            itemChange();
            System.out.println("Room data loaded successfully");
            
            isInitializing = false; // Selesai inisialisasi
            System.out.println("CustomerCheckIn initialized successfully!");
            
        } catch (Exception e) {
            isInitializing = false;
            System.err.println("Error in CustomerCheckIn constructor: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Initialization error: " + e.getMessage());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtmob = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        combogender = new javax.swing.JComboBox<>();
        txtnat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtaddres = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        combobed = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        comboroomtype = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        comboroomnumber = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lblemail = new javax.swing.JLabel();
        h = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("BiauKaiTC", 1, 36)); // NOI18N
        jLabel1.setText("Customer Check In");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 350, 70));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 380, 35));

        jLabel3.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel3.setText("Mobile Number");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 291, 36));

        jLabel4.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel4.setText("Email");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 380, 37));

        jLabel5.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel5.setText("Gender");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 380, 27));

        jLabel6.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel6.setText("Nationality");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 390, 29));

        txtname.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        txtname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnameFocusLost(evt);
            }
        });
        txtname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnameKeyPressed(evt);
            }
        });
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 390, 42));

        txtmob.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        txtmob.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtmobFocusLost(evt);
            }
        });
        txtmob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmobKeyPressed(evt);
            }
        });
        getContentPane().add(txtmob, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 390, 40));

        txtemail.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        txtemail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtemailFocusLost(evt);
            }
        });
        txtemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtemailKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtemailKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtemailKeyTyped(evt);
            }
        });
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 390, 40));

        combogender.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        combogender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        combogender.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combogenderFocusLost(evt);
            }
        });
        combogender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combogenderActionPerformed(evt);
            }
        });
        combogender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combogenderKeyPressed(evt);
            }
        });
        getContentPane().add(combogender, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 390, 40));

        txtnat.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        txtnat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnatFocusLost(evt);
            }
        });
        txtnat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnatKeyPressed(evt);
            }
        });
        getContentPane().add(txtnat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 390, 39));

        jLabel8.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel8.setText("Address");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 550, 294, 34));

        txtaddres.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        txtaddres.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtaddresFocusLost(evt);
            }
        });
        txtaddres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtaddresMouseClicked(evt);
            }
        });
        txtaddres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaddresActionPerformed(evt);
            }
        });
        getContentPane().add(txtaddres, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 580, 390, 40));

        jLabel9.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel9.setText("Check IN Date (Today)");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 294, 40));

        txtdate.setEditable(false);
        txtdate.setBackground(new java.awt.Color(255, 255, 255));
        txtdate.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        txtdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdateActionPerformed(evt);
            }
        });
        getContentPane().add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 120, 350, 38));

        jLabel10.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel10.setText("Bed");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 257, 28));

        combobed.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        combobed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Double" }));
        combobed.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combobedItemStateChanged(evt);
            }
        });
        getContentPane().add(combobed, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 310, 350, 37));

        jLabel11.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel11.setText("Room Type");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 180, 257, 40));

        comboroomtype.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        comboroomtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "NON AC" }));
        comboroomtype.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboroomtypeItemStateChanged(evt);
            }
        });
        comboroomtype.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboroomtypeMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                comboroomtypeMouseReleased(evt);
            }
        });
        comboroomtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboroomtypeActionPerformed(evt);
            }
        });
        getContentPane().add(comboroomtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 350, 40));

        jLabel12.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel12.setText("Room Number");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 350, 340, 40));

        comboroomnumber.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        comboroomnumber.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboroomnumberItemStateChanged(evt);
            }
        });
        getContentPane().add(comboroomnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 350, 40));

        jLabel13.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jLabel13.setText("Price");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 450, 350, 30));

        txtprice.setEditable(false);
        txtprice.setFont(new java.awt.Font("BiauKaiTC", 1, 18)); // NOI18N
        getContentPane().add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 480, 350, 39));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 0, 50, -1));

        jButton2.setBackground(new java.awt.Color(255, 0, 51));
        jButton2.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Allote Room");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 550, -1, 30));

        jButton3.setBackground(new java.awt.Color(255, 0, 51));
        jButton3.setFont(new java.awt.Font("BiauKaiTC", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 590, 90, 30));

        lblemail.setFont(new java.awt.Font("BiauKaiTC", 0, 14)); // NOI18N
        lblemail.setForeground(new java.awt.Color(255, 0, 51));
        lblemail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 220, 10));

        h.setBackground(new java.awt.Color(102, 102, 102));
        h.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/katsia-jazwinska-RIb19_YSUX0-unsplash.png"))); // NOI18N
        getContentPane().add(h, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("Close button clicked");
        closeConnection();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.out.println("Clear button clicked");
        clearFields();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdateActionPerformed

    }//GEN-LAST:event_txtdateActionPerformed

    private void comboroomnumberItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboroomnumberItemStateChanged
        System.out.println("Room number changed");
        updatePriceFromRoomNumber();    }//GEN-LAST:event_comboroomnumberItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println("Allote Room button clicked");
        performCheckIn();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboroomtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboroomtypeActionPerformed
        System.out.println("Room type changed");
    }//GEN-LAST:event_comboroomtypeActionPerformed

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseReleased

    private void comboroomtypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboroomtypeItemStateChanged
    if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
        System.out.println("Selected Room Type: " + evt.getItem());
        itemChange(); // panggil method Anda
    }   
        itemChange();    }//GEN-LAST:event_comboroomtypeItemStateChanged

    private void comboroomtypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboroomtypeMouseClicked
    }//GEN-LAST:event_comboroomtypeMouseClicked

    private void comboroomtypeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboroomtypeMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_comboroomtypeMouseReleased

    private void combobedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobedItemStateChanged
    if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
        itemChange();
    }
    }//GEN-LAST:event_combobedItemStateChanged

    private void txtaddresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaddresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaddresActionPerformed

    private void txtaddresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtaddresMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_txtaddresMouseClicked

    private void txtnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnameFocusGained
              txtname.setBackground(java.awt.Color.WHITE);
    }//GEN-LAST:event_txtnameFocusGained

    private void txtmobFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmobFocusLost
        validateMobileNumber();
    }//GEN-LAST:event_txtmobFocusLost

    private void txtemailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtemailFocusLost
        validateEmail();
    }//GEN-LAST:event_txtemailFocusLost

    private void combogenderFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combogenderFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_combogenderFocusLost

    private void txtnatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnatFocusLost
        validateNationality();
    }//GEN-LAST:event_txtnatFocusLost

    private void txtaddresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtaddresFocusLost
        validateAddress();
    }//GEN-LAST:event_txtaddresFocusLost

    private void txtnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnameFocusLost
        validateName();
    }//GEN-LAST:event_txtnameFocusLost

    private void combogenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combogenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combogenderActionPerformed

    private void txtnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        txtmob.requestFocus(); // Fixed: move to mobile field
    }//GEN-LAST:event_txtnameKeyPressed

    private void txtmobKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmobKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        txtemail.requestFocus(); // Fixed: move to email field
    }//GEN-LAST:event_txtmobKeyPressed

    private void txtemailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        combogender.requestFocus(); // Fixed: move to gender field
    }//GEN-LAST:event_txtemailKeyPressed

    private void combogenderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combogenderKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        txtnat.requestFocus(); // Fixed: move to nationality field
    }//GEN-LAST:event_combogenderKeyPressed

    private void txtnatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnatKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        txtaddres.requestFocus(); // Fixed: move to address field

    }//GEN-LAST:event_txtnatKeyPressed

    private void txtemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailKeyTyped

    private void txtemailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyReleased
        validateEmail();
    }//GEN-LAST:event_txtemailKeyReleased

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combobed;
    private javax.swing.JComboBox<String> combogender;
    private javax.swing.JComboBox<String> comboroomnumber;
    private javax.swing.JComboBox<String> comboroomtype;
    private javax.swing.JLabel h;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblemail;
    private javax.swing.JTextField txtaddres;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtmob;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnat;
    private javax.swing.JTextField txtprice;
    // End of variables declaration//GEN-END:variables

    // Database methods
    private void itemChange() {
        if (isInitializing) return;
        
        try {
            String roomType = comboroomtype.getSelectedItem().toString();
            String bedType = combobed.getSelectedItem().toString();
            
            comboroomnumber.removeAllItems();
            
            String sql = "SELECT DISTINCT roomnumber FROM room WHERE status = 'Not Booked' AND roomtype = ? AND bed = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, roomType);
            pst.setString(2, bedType);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                comboroomnumber.addItem(rs.getString("roomnumber"));
            }
            
        } catch (Exception e) {
            System.err.println("Error in itemChange: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void updatePriceFromRoomNumber() {
        if (comboroomnumber.getSelectedItem() != null) {
            String roomNumber = comboroomnumber.getSelectedItem().toString();
            
            try {
                String sql = "SELECT price FROM room WHERE roomnumber = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, roomNumber);
                rs = pst.executeQuery();
                
                if (rs.next()) {
                    txtprice.setText(rs.getString("price"));
                }
                
            } catch (Exception e) {
                System.err.println("Error getting room price: " + e.getMessage());
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (pst != null) pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void performCheckIn() {
        // Validate all fields before submission
        if (!validateAllFieldsForSubmit()) {
            return;
        }
        
        if (comboroomnumber.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Please select a room number!");
            return;
        }
        
        try {
            // Check if email already exists
            String checkSql = "SELECT email FROM customer WHERE email = ?";
            pst = con.prepareStatement(checkSql);
            pst.setString(1, txtemail.getText().trim());
            rs = pst.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Customer with this email already exists!");
                return;
            }
            
            // Begin transaction
            con.setAutoCommit(false);
            
            // Insert customer data
            String insertCustomerSql = "INSERT INTO customer (name, mobile, nationality, gender, email, address, date, roomnumber, bed, roomtype, priceperday) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(insertCustomerSql);
            pst.setString(1, txtname.getText().trim());
            pst.setString(2, txtmob.getText().trim());
            pst.setString(3, txtnat.getText().trim());
            pst.setString(4, combogender.getSelectedItem().toString());
            pst.setString(5, txtemail.getText().trim());
            pst.setString(6, txtaddres.getText().trim());
            pst.setString(7, txtdate.getText().trim());
            pst.setString(8, comboroomnumber.getSelectedItem().toString());
            pst.setString(9, combobed.getSelectedItem().toString());
            pst.setString(10, comboroomtype.getSelectedItem().toString());
            pst.setString(11, txtprice.getText().trim());
            
            int customerResult = pst.executeUpdate();
            
            // Update room status to booked
            String updateRoomSql = "UPDATE room SET status = 'Booked' WHERE roomnumber = ?";
            pst = con.prepareStatement(updateRoomSql);
            pst.setString(1, comboroomnumber.getSelectedItem().toString());
            int roomResult = pst.executeUpdate();
            
            if (customerResult > 0 && roomResult > 0) {
                con.commit();
                JOptionPane.showMessageDialog(this, "Room allocated successfully!");
                clearFields();
                itemChange(); // Refresh room list
            } else {
                con.rollback();
                JOptionPane.showMessageDialog(this, "Failed to allocate room. Please try again.");
            }
            
        } catch (Exception e) {
            try {
                con.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            System.err.println("Error in performCheckIn: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error during check-in: " + e.getMessage());
        } finally {
            try {
                con.setAutoCommit(true);
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Validation methods
    private boolean validateAllFieldsForSubmit() {
        StringBuilder errors = new StringBuilder();
        boolean isValid = true;

        // Validate name
        if (txtname.getText().trim().isEmpty()) {
            txtname.setBackground(java.awt.Color.RED);
            errors.append("- Name must be filled\n");
            isValid = false;
        } else {
            txtname.setBackground(java.awt.Color.WHITE);
        }

        // Validate mobile number
        if (!isValidMobileNumber(txtmob.getText().trim())) {
            txtmob.setBackground(java.awt.Color.RED);
            errors.append("- Mobile number must be 10-15 digits\n");
            isValid = false;
        } else {
            txtmob.setBackground(java.awt.Color.WHITE);
        }

        // Validate email
        if (!isValidEmail(txtemail.getText().trim())) {
            txtemail.setBackground(java.awt.Color.RED);
            errors.append("- Email format is invalid\n");
            isValid = false;
        } else {
            txtemail.setBackground(java.awt.Color.WHITE);
        }

        // Validate nationality
        if (txtnat.getText().trim().isEmpty()) {
            txtnat.setBackground(java.awt.Color.RED);
            errors.append("- Nationality must be filled\n");
            isValid = false;
        } else {
            txtnat.setBackground(java.awt.Color.WHITE);
        }

        // Validate address
        if (txtaddres.getText().trim().isEmpty()) {
            txtaddres.setBackground(java.awt.Color.RED);
            errors.append("- Address must be filled\n");
            isValid = false;
        } else {
            txtaddres.setBackground(java.awt.Color.WHITE);
        }

        if (!isValid) {
            JOptionPane.showMessageDialog(this, "Please correct the following errors:\n" + errors.toString());
        }

        return isValid;
    }

    private void validateName() {
        if (txtname.getText().trim().isEmpty()) {
            txtname.setBackground(java.awt.Color.PINK);
        } else {
            txtname.setBackground(java.awt.Color.WHITE);
        }
    }

    private void validateMobileNumber() {
        String mobile = txtmob.getText().trim();
        if (isValidMobileNumber(mobile)) {
            txtmob.setBackground(java.awt.Color.WHITE);
        } else {
            txtmob.setBackground(java.awt.Color.PINK);
        }
    }

    private void validateEmail() {
        String email = txtemail.getText().trim();
        if (isValidEmail(email)) {
            txtemail.setBackground(java.awt.Color.WHITE);
            lblemail.setText("");
        } else {
            txtemail.setBackground(java.awt.Color.PINK);
            lblemail.setText("Invalid email format");
        }
    }

    private void validateNationality() {
        if (txtnat.getText().trim().isEmpty()) {
            txtnat.setBackground(java.awt.Color.PINK);
        } else {
            txtnat.setBackground(java.awt.Color.WHITE);
        }
    }

    private void validateAddress() {
        if (txtaddres.getText().trim().isEmpty()) {
            txtaddres.setBackground(java.awt.Color.PINK);
        } else {
            txtaddres.setBackground(java.awt.Color.WHITE);
        }
    }

    // Helper methods for validation
    private boolean isValidMobileNumber(String mobile) {
        if (mobile.isEmpty()) return false;
        return Pattern.matches("\\d{10,15}", mobile);
    }

    private boolean isValidEmail(String email) {
        if (email.isEmpty()) return false;
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.matches(emailRegex, email);
    }

    // Utility methods
    private void clearFields() {
        txtname.setText("");
        txtmob.setText("");
        txtemail.setText("");
        txtnat.setText("");
        txtaddres.setText("");
        txtprice.setText("");
        lblemail.setText("");
        
        // Reset background colors
        txtname.setBackground(java.awt.Color.WHITE);
        txtmob.setBackground(java.awt.Color.WHITE);
        txtemail.setBackground(java.awt.Color.WHITE);
        txtnat.setBackground(java.awt.Color.WHITE);
        txtaddres.setBackground(java.awt.Color.WHITE);
        
        // Reset combo boxes to first item
        combogender.setSelectedIndex(0);
        combobed.setSelectedIndex(0);
        comboroomtype.setSelectedIndex(0);
        
        // Refresh room list
        itemChange();
        
        // Set focus to name field
        txtname.requestFocus();
    }

    private void closeConnection() {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (con != null) con.close();
            System.out.println("Database connection closed successfully");
        } catch (SQLException e) {
            System.err.println("Error closing database connection: " + e.getMessage());
            e.printStackTrace();
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerCheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerCheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerCheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerCheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerCheckIn().setVisible(true);
            }
        });
    }
}