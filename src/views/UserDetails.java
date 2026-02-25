/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import config.config;

/**
 *
 * @author Administrator
 */
public class UserDetails extends javax.swing.JFrame {

    private int userId;

    public UserDetails(int userId) {
        this.userId = userId;
        initComponents();
        setLocationRelativeTo(null);
        loadUser();
    }

    private void loadUser() {
        try (java.sql.Connection conn = config.connectDB();
             java.sql.PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM tbl_user WHERE user_id = ?")) {
            ps.setInt(1, userId);
            java.sql.ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String fname  = rs.getString("user_fname");
                String lname  = rs.getString("user_lname");
                String email  = rs.getString("user_email");
                String uname  = rs.getString("username");
                String type   = rs.getString("type");
                String status = rs.getString("user_status");

                // ID is a non-editable JLabel — shown only
                lblValId.setText(String.valueOf(userId));

                lblFullName.setText(fname + " " + lname);
                lblRoleBadge.setText("  " + type.toUpperCase() + "  ");

                // Avatar first letter
                lblAvatar.setText(fname.substring(0, 1).toUpperCase());
                if ("admin".equalsIgnoreCase(type)) {
                    lblAvatar.setBackground(new java.awt.Color(0, 77, 128));
                } else {
                    lblAvatar.setBackground(new java.awt.Color(0, 160, 80));
                }

                // Editable fields
                lblValFname.setText(fname);
                lblValLname.setText(lname);
                lblValEmail.setText(email);
                lblValUname.setText(uname);
                // Password never pre-filled
                txtPassword1.setText("");
                lblValType.setSelectedItem(type);
                lblValStatus1.setSelectedItem(status);
            }
        } catch (java.sql.SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error loading user: " + ex.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblFullName = new javax.swing.JLabel();
        lblRoleBadge = new javax.swing.JLabel();
        lblAvatar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblValStatus1 = new javax.swing.JComboBox<>();
        lblValType = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        lblValUname = new javax.swing.JTextField();
        lblValEmail = new javax.swing.JTextField();
        lblValFname = new javax.swing.JTextField();
        lblValLname = new javax.swing.JTextField();
        lblValId = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        saveUser = new javax.swing.JButton();
        btnBackToList = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPassword1 = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFullName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFullName.setText("Full Name");
        jPanel2.add(lblFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        lblRoleBadge.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblRoleBadge.setText("type");
        jPanel2.add(lblRoleBadge, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        lblAvatar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAvatar.setText("A");
        jPanel2.add(lblAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 240, 260));

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblValStatus1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));
        jPanel3.add(lblValStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 386, 150, 30));

        lblValType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User", " " }));
        jPanel3.add(lblValType, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 386, 150, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Status");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, -1, -1));
        jPanel3.add(lblValUname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 380, 40));
        jPanel3.add(lblValEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 380, 40));
        jPanel3.add(lblValFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 380, 40));
        jPanel3.add(lblValLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 380, 40));
        jPanel3.add(lblValId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 360, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Role:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        saveUser.setText("SAVE");
        saveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveUserActionPerformed(evt);
            }
        });
        jPanel3.add(saveUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 160, 40));

        btnBackToList.setText("Back to User List");
        btnBackToList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToListActionPerformed(evt);
            }
        });
        jPanel3.add(btnBackToList, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 180, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Password:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Username:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Email:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Last Name:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("First Name:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("User ID:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        txtPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassword1ActionPerformed(evt);
            }
        });
        jPanel3.add(txtPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 326, 370, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 550, 480));

        jPanel4.setBackground(new java.awt.Color(0, 51, 102));
        jPanel4.setForeground(new java.awt.Color(0, 102, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("User Details");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveUserActionPerformed
        String fname = lblValFname.getText().trim();
        String lname = lblValUname.getText().trim();
        String email = lblValEmail.getText().trim();
        String uname = lblValEmail.getText().trim();
        String pass  = new String(txtPassword1.getPassword()).trim();

        if (fname.isEmpty() || lname.isEmpty() || email.isEmpty() || uname.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "First name, last name, email and username are required."); return;
        }
        if (pass.isEmpty()) {
            new config().addRecord(
                "UPDATE tbl_user SET user_fname=?,user_lname=?,user_email=?,username=?,type=?,user_status=? WHERE user_id=?",
                fname, lname, email, uname,
                lblValType.getSelectedItem(), lblValStatus1.getSelectedItem(), userId);
        } else {
            new config().addRecord(
                "UPDATE tbl_user SET user_fname=?,user_lname=?,user_email=?,username=?,password=?,type=?,user_status=? WHERE user_id=?",
                fname, lname, email, uname, pass,
                lblValType.getSelectedItem(), lblValStatus1.getSelectedItem(), userId);
        }
        javax.swing.JOptionPane.showMessageDialog(this, "User saved successfully!");
        loadUser();
        }//GEN-LAST:event_saveUserActionPerformed

    private void btnBackToListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToListActionPerformed
        dispose();
        new UserManagement().setVisible(true);    }//GEN-LAST:event_btnBackToListActionPerformed

    private void txtPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassword1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassword1ActionPerformed

    /**
     * @param args the command line arguments
     */
    


    public static void main(String args[]) {
        try { for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) { if ("Nimbus".equals(info.getName())) { javax.swing.UIManager.setLookAndFeel(info.getClassName()); break; } } } catch (Exception ex) { }
        java.awt.EventQueue.invokeLater(() -> new UserDetails(1).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackToList;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblRoleBadge;
    private javax.swing.JTextField lblValEmail;
    private javax.swing.JTextField lblValFname;
    private javax.swing.JLabel lblValId;
    private javax.swing.JTextField lblValLname;
    private javax.swing.JComboBox<String> lblValStatus1;
    private javax.swing.JComboBox<String> lblValType;
    private javax.swing.JTextField lblValUname;
    private javax.swing.JButton saveUser;
    private javax.swing.JPasswordField txtPassword1;
    // End of variables declaration//GEN-END:variables
}
