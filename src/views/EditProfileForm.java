/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import config.config;
import config.Session;

/**
 *
 * @author Administrator
 */
public class EditProfileForm extends javax.swing.JFrame {

    public EditProfileForm() {
        initComponents();
        setLocationRelativeTo(null);
        loadProfile();
    }

    private void loadProfile() {
        Session s = Session.getInstance();

        // Header bar info
        lblUsernameDisp.setText("Email: " + s.getEmail() + "   |   Role: " + s.getType() + "   |   Status: " + s.getStatus());

        // Avatar panel
        String initial = (s.getFname() != null && !s.getFname().isEmpty())
                ? s.getFname().substring(0, 1).toUpperCase() : "?";
        lblAvatar.setText(initial);
        lblFullName.setText(s.getFname() + " " + s.getLname());

        // READ-ONLY fields (JLabels — cannot be clicked or edited)
        lblValId.setText(String.valueOf(s.getId()));
        lblValUsername.setText(s.getUsername());
        lblValType.setText(s.getType());
        lblValStatus.setText(s.getStatus());

        // EDITABLE fields
        txtFname.setText(s.getFname());
        txtLname.setText(s.getLname());
        txtEmail.setText(s.getEmail());



        lblStatusMsg.setText(" ");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        goBack = new javax.swing.JButton();
        lblUsernameDisp = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblAvatar = new javax.swing.JLabel();
        lblFullName = new javax.swing.JLabel();
        txtLname = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        lblValUsername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        saveProfile = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        lblStatusMsg = new javax.swing.JLabel();
        lblValType = new javax.swing.JTextField();
        lblValStatus = new javax.swing.JTextField();
        lblValId = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtFname = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("MY PROFILE");
        jPanel2.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        goBack.setText("BACK");
        goBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackActionPerformed(evt);
            }
        });
        jPanel2.add(goBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, 100, -1));

        lblUsernameDisp.setForeground(new java.awt.Color(255, 255, 255));
        lblUsernameDisp.setText("Email:    |   Role:    |   Status:");
        jPanel2.add(lblUsernameDisp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 280, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 90));

        jPanel3.setBackground(new java.awt.Color(174, 217, 238));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 102, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAvatar.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblAvatar.setForeground(new java.awt.Color(255, 255, 255));
        lblAvatar.setText("C");
        jPanel4.add(lblAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 70, -1));

        lblFullName.setForeground(new java.awt.Color(255, 255, 255));
        lblFullName.setText("USER");
        jPanel4.add(lblFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 160, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 180, 90));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 900, 110));

        txtLname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLnameActionPerformed(evt);
            }
        });
        jPanel1.add(txtLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 680, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 820, 20));

        jLabel3.setText("Last Name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        lblValUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblValUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(lblValUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 280, 30));

        jLabel6.setText("First Name:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jPanel5.setBackground(new java.awt.Color(174, 217, 238));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saveProfile.setBackground(new java.awt.Color(0, 102, 153));
        saveProfile.setText("SAVE CHANGES");
        saveProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveProfileActionPerformed(evt);
            }
        });
        jPanel5.add(saveProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 680, -1));

        jLabel5.setText("User Type:");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel7.setText("User Status:");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel8.setText("User ID:");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));
        jPanel5.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 830, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Change Password (optional)");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lblStatusMsg.setForeground(new java.awt.Color(0, 51, 153));
        lblStatusMsg.setText("lblStatusMsg");
        jPanel5.add(lblStatusMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, -1, -1));

        lblValType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblValTypeActionPerformed(evt);
            }
        });
        jPanel5.add(lblValType, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 680, 30));

        lblValStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblValStatusActionPerformed(evt);
            }
        });
        jPanel5.add(lblValStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 680, 30));
        jPanel5.add(lblValId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 50, 20));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 900, 220));

        jLabel9.setText("User Name:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Edit Profile Information");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel11.setText("Email Address:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 290, 30));

        txtFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFnameActionPerformed(evt);
            }
        });
        jPanel1.add(txtFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 680, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtLnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLnameActionPerformed

    private void lblValUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblValUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblValUsernameActionPerformed

    private void lblValTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblValTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblValTypeActionPerformed

    private void saveProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveProfileActionPerformed
        String fname = txtFname.getText().trim();
        String lname = txtLname.getText().trim();
        String email = txtEmail.getText().trim();

        if (fname.isEmpty() || lname.isEmpty() || email.isEmpty()) {
            lblStatusMsg.setForeground(new java.awt.Color(200, 0, 0));
            lblStatusMsg.setText("⚠  First name, last name and email are required."); return;
        }
        if (!email.matches("^[\\w._%+\\-]+@[\\w.\\-]+\\.[a-zA-Z]{2,}$")) {
            lblStatusMsg.setForeground(new java.awt.Color(200, 0, 0));
            lblStatusMsg.setText("⚠  Invalid email format."); return;
        }

        int uid = Session.getInstance().getId();



        // Update session
        Session s = Session.getInstance();
        s.setFname(fname); s.setLname(lname); s.setEmail(email);

        loadProfile();
        lblStatusMsg.setForeground(new java.awt.Color(0, 160, 60));
        lblStatusMsg.setText("✅  Profile saved successfully!");
  
        }//GEN-LAST:event_saveProfileActionPerformed

    private void goBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackActionPerformed
        dispose();
        if ("admin".equalsIgnoreCase(Session.getInstance().getType()))
            new AdminDashboard().setVisible(true);
        else
            new UserDashboard().setVisible(true);
            }//GEN-LAST:event_goBackActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void lblValStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblValStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblValStatusActionPerformed

    private void txtFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFnameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try { for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) { if ("Nimbus".equals(info.getName())) { javax.swing.UIManager.setLookAndFeel(info.getClassName()); break; } } } catch (Exception ex) { }
        java.awt.EventQueue.invokeLater(() -> new EditProfileForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblStatusMsg;
    private javax.swing.JLabel lblUsernameDisp;
    private javax.swing.JLabel lblValId;
    private javax.swing.JTextField lblValStatus;
    private javax.swing.JTextField lblValType;
    private javax.swing.JTextField lblValUsername;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JButton saveProfile;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    // End of variables declaration//GEN-END:variables
}
