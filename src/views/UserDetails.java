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

    /**
     * Creates new form UserDetails
     * @param userId the user_id to display
     */
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

                // Avatar: first letter of first name
                lblAvatar.setText(fname.substring(0, 1).toUpperCase());
                lblFullName.setText(fname + " " + lname);
                lblAvatar.setText("  " + type.toUpperCase() + "  ");

                // Read-only display labels
                lblAvatar.setText(String.valueOf(userId));
                lblValFname.setText(fname);
                lblValLname.setText(lname);
                lblValEmail.setText(email);
                lblValUname.setText(uname);
                lblValType.setText(status);
                lblValType.setText(type);

                // Color badge by role
                if ("admin".equalsIgnoreCase(type)) {
                    lblAvatar.setBackground(new java.awt.Color(0, 77, 128));
                } else {
                    lblAvatar.setBackground(new java.awt.Color(0, 160, 80));
                }

                // Status color
                if ("Active".equalsIgnoreCase(status)) {
                    lblValType.setForeground(new java.awt.Color(0, 160, 80));
                } else {
                    lblValType.setForeground(new java.awt.Color(200, 40, 40));
                }
            }
        } catch (java.sql.SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error loading user: " + ex.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblValLname = new javax.swing.JTextField();
        lblValEmail = new javax.swing.JTextField();
        lblValUname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnBackToList = new javax.swing.JButton();
        saveUser = new javax.swing.JButton();
        txtPassword1 = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        lblValFname = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblFullName = new javax.swing.JLabel();
        lblRoleBadge = new javax.swing.JLabel();
        lblAvatar = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblValType = new javax.swing.JTextField();
        lblValId = new javax.swing.JLabel();
        lblValStatus1 = new javax.swing.JTextField();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(lblValLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 280, 30));
        jPanel1.add(lblValEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 280, 30));
        jPanel1.add(lblValUname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 280, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("User ID:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Last Name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Username:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Role:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Status");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Password:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        btnBackToList.setText("Back to User List");
        jPanel1.add(btnBackToList, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 130, 30));

        saveUser.setText("SAVE");
        saveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveUserActionPerformed(evt);
            }
        });
        jPanel1.add(saveUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 130, 30));
        jPanel1.add(txtPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 280, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("First Name:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));
        jPanel1.add(lblValFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 280, 30));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 180, 220));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Email:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));
        jPanel1.add(lblValType, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 100, 30));
        jPanel1.add(lblValId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 280, 20));
        jPanel1.add(lblValStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 100, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveUserActionPerformed

        }//GEN-LAST:event_saveUserActionPerformed

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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblRoleBadge;
    private javax.swing.JTextField lblValEmail;
    private javax.swing.JTextField lblValFname;
    private javax.swing.JLabel lblValId;
    private javax.swing.JTextField lblValLname;
    private javax.swing.JTextField lblValStatus1;
    private javax.swing.JTextField lblValType;
    private javax.swing.JTextField lblValUname;
    private javax.swing.JButton saveUser;
    private javax.swing.JPasswordField txtPassword1;
    // End of variables declaration//GEN-END:variables
}
