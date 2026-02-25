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
public class UserManagement extends javax.swing.JFrame {

    private int selectedUserId = -1;   // tracks which row is selected

    public UserManagement() {
        initComponents();
        setLocationRelativeTo(null);

        // Populate combos with correct values
        cmbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"user", "admin"}));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Active", "Inactive"}));

        loadData("");   // load all users on open

        // Row click → fill form fields
        jTable1.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) onRowClick();
        });

        // Search: button click OR press Enter in search field
        jButton1.addActionListener(e -> loadData(jTextField1.getText().trim()));
        jTextField1.addActionListener(e -> loadData(jTextField1.getText().trim()));

        // Wire all buttons (the ones not wired in initComponents)
        Back.addActionListener(e -> BackAction());
        delete.addActionListener(e -> deleteUserAction());
        clearForm.addActionListener(e -> clearFormAction());
        update.addActionListener(e -> updateUserAction());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Back = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtFname = new javax.swing.JTextField();
        addRecord = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUname = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        clearForm = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        cmbRole = new javax.swing.JComboBox<>();
        btnView = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Search:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 230, 30));

        jButton1.setText("SEARCH");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "Email", "Username", "Role", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setHeaderValue("First Name");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Last Name");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("Status");
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 400, 140));

        Back.setText("BACK TO DASHBOARD");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        jPanel1.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 350, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("USER MANAGEMENT");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        jPanel3.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 200, 30));
        jPanel3.add(txtFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 200, 30));

        addRecord.setBackground(new java.awt.Color(0, 153, 51));
        addRecord.setText("ADD");
        addRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRecordActionPerformed(evt);
            }
        });
        jPanel3.add(addRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 160, 30));

        update.setBackground(new java.awt.Color(0, 204, 204));
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel3.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 160, 30));

        delete.setBackground(new java.awt.Color(255, 51, 51));
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel3.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 160, 30));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Last Name:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("First Name:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        jPanel3.add(txtUname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 200, 30));
        jPanel3.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 200, 30));
        jPanel3.add(txtLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 200, 30));

        clearForm.setBackground(new java.awt.Color(204, 204, 204));
        clearForm.setText("CLEAR");
        clearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFormActionPerformed(evt);
            }
        });
        jPanel3.add(clearForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 160, 30));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Role");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Status:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Email:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 200, 30));

        cmbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cmbRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 200, 30));

        btnView.setText("View Details");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jPanel3.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 330, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 370, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        dispose();
        new AdminDashboard().setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

    private void addRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecordActionPerformed
        String fname = txtFname.getText().trim();
        String lname = txtLname.getText().trim();
        String email = txtEmail.getText().trim();
        String uname = txtUname.getText().trim();
        String pass  = txtPass.getText().trim();

        if (fname.isEmpty() || lname.isEmpty() || email.isEmpty()
                || uname.isEmpty() || pass.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "All fields are required.");
            return;
        }

        // Check for duplicate username
        try (java.sql.Connection conn = config.connectDB();
             java.sql.PreparedStatement chk = conn.prepareStatement(
                "SELECT COUNT(*) FROM tbl_user WHERE username = ?")) {
            chk.setString(1, uname);
            java.sql.ResultSet rs = chk.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Username already exists.");
                return;
            }
        } catch (java.sql.SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            return;
        }

        new config().addRecord(
            "INSERT INTO tbl_user (user_fname, user_lname, user_email, username, password, type, user_status) "
            + "VALUES (?,?,?,?,?,?,?)",
            fname, lname, email, uname, pass,
            cmbRole.getSelectedItem().toString(),
            cmbStatus.getSelectedItem().toString());

        javax.swing.JOptionPane.showMessageDialog(this, "User added successfully!");
        clearFormAction();
        loadData("");
    }//GEN-LAST:event_addRecordActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        updateUserAction();
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        deleteUserAction();
    }//GEN-LAST:event_deleteActionPerformed

    private void clearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFormActionPerformed
        if (selectedUserId < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Select a row first.");
            return;
        }
        new UserDetails(selectedUserId).setVisible(true);
  
                            }//GEN-LAST:event_clearFormActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        if (selectedUserId < 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please select a user first!");
        return;
    }
    dispose();
    new UserDetails(selectedUserId).setVisible(true);    new UserDetails(selectedUserId).setVisible(true);    }//GEN-LAST:event_btnViewActionPerformed
  

    // ══════════════════════════════════════════════
    //  HELPER METHODS
    // ══════════════════════════════════════════════

    /**
     * Fires when user clicks a table row.
     * Reads the HIDDEN col-0 (user_id) and populates all form fields.
     */
    private void onRowClick() {
        int row = jTable1.getSelectedRow();
        if (row < 0) return;

        // Column 0 is the hidden user_id — we still read it programmatically
        selectedUserId = Integer.parseInt(jTable1.getValueAt(row, 0).toString());

        txtFname.setText(jTable1.getValueAt(row, 1).toString());
        txtLname.setText(jTable1.getValueAt(row, 2).toString());
        txtEmail.setText(jTable1.getValueAt(row, 3).toString());
        txtUname.setText(jTable1.getValueAt(row, 4).toString());
        txtPass.setText("");   // never pre-fill password for security
        cmbRole.setSelectedItem(jTable1.getValueAt(row, 5).toString());
        cmbStatus.setSelectedItem(jTable1.getValueAt(row, 6).toString());
    }


    public void loadData(String keyword) {
        String k = "%" + keyword + "%";
        new config().displayData("SELECT user_id AS 'ID', user_fname AS 'First Name', user_lname AS 'Last Name', "
            + "user_email AS 'Email', username AS 'Username', type AS 'Role', user_status AS 'Status' "
            + "FROM tbl_user "
            + "WHERE user_fname LIKE ? OR user_lname LIKE ? OR username LIKE ? OR user_email LIKE ? "
            + "ORDER BY user_fname",
            jTable1, k, k, k, k);

        // ── Hide ID column — width 0, cannot be resized or seen
        if (jTable1.getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(0).setWidth(0);
        }
        // ── Cells not editable by clicking
        jTable1.setDefaultEditor(Object.class, null);
    }

    /** UPDATE helper — writes changes to tbl_user. */
    private void updateUserAction() {
        if (selectedUserId < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Select a row first.");
            return;
        }
        String fname = txtFname.getText().trim();
        String lname = txtLname.getText().trim();
        String email = txtEmail.getText().trim();
        String uname = txtUname.getText().trim();
        String pass  = txtPass.getText().trim();

        if (fname.isEmpty() || lname.isEmpty() || email.isEmpty() || uname.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "First name, last name, email and username are required.");
            return;
        }

        if (pass.isEmpty()) {
            // Leave password unchanged
            new config().addRecord(
                "UPDATE tbl_user SET user_fname=?, user_lname=?, user_email=?, "
                + "username=?, type=?, user_status=? WHERE user_id=?",
                fname, lname, email, uname,
                cmbRole.getSelectedItem().toString(),
                cmbStatus.getSelectedItem().toString(),
                selectedUserId);
        } else {
            // Also update password
            new config().addRecord(
                "UPDATE tbl_user SET user_fname=?, user_lname=?, user_email=?, "
                + "username=?, password=?, type=?, user_status=? WHERE user_id=?",
                fname, lname, email, uname, pass,
                cmbRole.getSelectedItem().toString(),
                cmbStatus.getSelectedItem().toString(),
                selectedUserId);
        }
        javax.swing.JOptionPane.showMessageDialog(this, "User updated successfully!");
        clearFormAction();
        loadData("");
    }

    /** DELETE helper — removes row from tbl_user. */
    private void deleteUserAction() {
        if (selectedUserId < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Select a row first.");
            return;
        }
        int c = javax.swing.JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete this user?", "Confirm Delete",
            javax.swing.JOptionPane.YES_NO_OPTION);
        if (c != javax.swing.JOptionPane.YES_OPTION) return;

        new config().addRecord("DELETE FROM tbl_user WHERE user_id=?", selectedUserId);
        javax.swing.JOptionPane.showMessageDialog(this, "User deleted successfully.");
        clearFormAction();
        loadData("");
    }

    /** Resets form fields and clears table selection. */
    private void clearFormAction() {
        selectedUserId = -1;
        txtFname.setText(""); txtLname.setText(""); txtEmail.setText("");
        txtUname.setText(""); txtPass.setText("");
        cmbRole.setSelectedIndex(0);
        cmbStatus.setSelectedIndex(0);
        jTable1.clearSelection();
    }

    /** Back-navigate helper (also called from constructor lambda). */
    private void BackAction() {
        dispose();
        new AdminDashboard().setVisible(true);
    }

    
    public static void main(String args[]) {
        try { for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) { if ("Nimbus".equals(info.getName())) { javax.swing.UIManager.setLookAndFeel(info.getClassName()); break; } } } catch (Exception ex) { }
        java.awt.EventQueue.invokeLater(() -> new UserManagement().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton addRecord;
    private javax.swing.JButton btnView;
    private javax.swing.JButton clearForm;
    private javax.swing.JComboBox<String> cmbRole;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUname;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
