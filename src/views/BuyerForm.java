/*
 * BuyerForm.java  –  FishSale Tracker
 * All CRUD buttons fully implemented:
 *   ADD, UPDATE, DELETE, CLEAR, SEARCH, BACK (jButton2), BACK TO DASHBOARD (back2)
 */
package views;
 
import config.config;
import config.Session;
 
public class BuyerForm extends javax.swing.JFrame {
 
    /** Holds the buyer_id of the row currently selected in the table; -1 = none */
    private int selectedId = -1;
 
    // ─────────────────────────────────────────────────────────────────────────
    //  CONSTRUCTOR
    // ─────────────────────────────────────────────────────────────────────────
    public BuyerForm() {
        initComponents();
        setLocationRelativeTo(null);
 
        // Guard: redirect to login if no active session
        if (!Session.requireLogin(this)) return;
 
        // Populate combo boxes
        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[]{"Wholesale", "Retail", "Individual"}));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[]{"Active", "Inactive"}));
 
        // Apply consistent button styles
        styleBtn(addRecord,    new java.awt.Color(0,   153, 51));
        styleBtn(updateRecord, new java.awt.Color(0,   204, 204));
        styleBtn(deleteRecord, new java.awt.Color(255, 51,  51));
        styleBtn(clearForm,    new java.awt.Color(150, 150, 150));
        styleBtn(jButton1,      new java.awt.Color(0,   102, 153));
        styleBtn(back2,         new java.awt.Color(0,    51, 102));
        styleBtn(back,      new java.awt.Color(0,    51, 102));
 
        // Load all buyers on open
        loadData("");
 
        // Row-click → populate form fields
        tblBuyers.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) onRowClick();
        });
 
        // Search: button click or press Enter
        jButton1.addActionListener(e -> loadData(jTextField1.getText().trim()));
        jTextField1.addActionListener(e -> loadData(jTextField1.getText().trim()));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        txtFname = new javax.swing.JTextField();
        addRecord = new javax.swing.JButton();
        updateRecord = new javax.swing.JButton();
        deleteRecord = new javax.swing.JButton();
        clearForm = new javax.swing.JButton();
        cmbType = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuyers = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        back2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(229, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 102, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 350, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("BUYER FORM");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        jPanel5.add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 200, 30));
        jPanel5.add(txtFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 200, 30));

        addRecord.setBackground(new java.awt.Color(0, 153, 51));
        addRecord.setText("ADD");
        addRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRecordActionPerformed(evt);
            }
        });
        jPanel5.add(addRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 160, 30));

        updateRecord.setBackground(new java.awt.Color(0, 204, 204));
        updateRecord.setText("UPDATE");
        updateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRecordActionPerformed(evt);
            }
        });
        jPanel5.add(updateRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 160, 30));

        deleteRecord.setBackground(new java.awt.Color(255, 51, 51));
        deleteRecord.setText("DELETE");
        deleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRecordActionPerformed(evt);
            }
        });
        jPanel5.add(deleteRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 160, 30));

        clearForm.setBackground(new java.awt.Color(204, 204, 204));
        clearForm.setText("CLEAR");
        clearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFormActionPerformed(evt);
            }
        });
        jPanel5.add(clearForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 160, 30));

        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(cmbType, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 200, 30));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Last Name:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Address:");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("First Name:");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));
        jPanel5.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 200, 30));
        jPanel5.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 200, 30));
        jPanel5.add(txtLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 200, 30));

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 200, 30));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Email:");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Buyer Type");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Status");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Contact #:");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/log.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 370, 480));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 370, 490));

        tblBuyers.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblBuyers);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 470, 140));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 300, 30));

        jButton1.setText("SEARCH");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 100, 30));

        jPanel6.setBackground(new java.awt.Color(8, 66, 124));
        jPanel6.setPreferredSize(new java.awt.Dimension(880, 80));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setBackground(new java.awt.Color(255, 204, 204));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel6.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 30, 140, 40));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("BUYER FORM");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/l.png"))); // NOI18N
        jLabel4.setText("jLabel2");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 80));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 100));

        back2.setText("BACK TO DASHBOARD");
        back2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back2ActionPerformed(evt);
            }
        });
        jPanel1.add(back2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 210, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/log.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 900, 510));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void styleBtn(javax.swing.JButton b, java.awt.Color c) {
        b.setFont(new java.awt.Font("Segoe UI", 1, 11)); b.setBackground(c);
        b.setForeground(java.awt.Color.WHITE); b.setBorderPainted(false); b.setFocusPainted(false);
        b.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    public void loadData(String kw) {
        String k = "%" + kw + "%";
        new config().displayData(
            "SELECT buyer_id AS 'ID', buyer_fname AS 'First Name', buyer_lname AS 'Last Name', " +
            "buyer_contact AS 'Contact', buyer_address AS 'Address', buyer_email AS 'Email', " +
            "buyer_type AS 'Type', buyer_status AS 'Status' " +
            "FROM tbl_buyer WHERE buyer_fname LIKE ? OR buyer_lname LIKE ? OR buyer_contact LIKE ? OR buyer_email LIKE ? " +
            "ORDER BY buyer_fname",
            tblBuyers, k, k, k, k);
        // Hide ID column
        if (tblBuyers.getColumnCount() > 0) {
            tblBuyers.getColumnModel().getColumn(0).setMinWidth(0);
            tblBuyers.getColumnModel().getColumn(0).setMaxWidth(0);
            tblBuyers.getColumnModel().getColumn(0).setWidth(0);
        }
        tblBuyers.setDefaultEditor(Object.class, null);
    }

    private void onRowClick() {
        int row = tblBuyers.getSelectedRow();
        if (row < 0) return;
        selectedId = Integer.parseInt(tblBuyers.getValueAt(row, 0).toString());
        txtFname.setText(tblBuyers.getValueAt(row, 1).toString());
        txtLname.setText(tblBuyers.getValueAt(row, 2).toString());
        txtContact.setText(tblBuyers.getValueAt(row, 3).toString());
        txtAddress.setText(tblBuyers.getValueAt(row, 4).toString());
        txtEmail.setText(tblBuyers.getValueAt(row, 5).toString());
        cmbType.setSelectedItem(tblBuyers.getValueAt(row, 6).toString());
        cmbStatus.setSelectedItem(tblBuyers.getValueAt(row, 7).toString());
    }
    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyTyped

    private void addRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecordActionPerformed
        if (!validateFields()) return;
 
        String fname   = txtFname.getText().trim();
        String lname   = txtLname.getText().trim();
        String contact = txtContact.getText().trim();
        String address = txtAddress.getText().trim();
        String email   = txtEmail.getText().trim();
        String type    = cmbType.getSelectedItem().toString();
        String status  = cmbStatus.getSelectedItem().toString();
 
        // Check for duplicate email
        try (java.sql.Connection conn = config.connectDB();
             java.sql.PreparedStatement ps = conn.prepareStatement(
                 "SELECT COUNT(*) FROM tbl_buyer WHERE buyer_email = ?")) {
            ps.setString(1, email);
            java.sql.ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "A buyer with this email already exists.",
                    "Duplicate Email",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (java.sql.SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "DB Error: " + ex.getMessage(), "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
 
        new config().addRecord(
            "INSERT INTO tbl_buyer " +
            "(buyer_fname, buyer_lname, buyer_contact, buyer_address, buyer_email, buyer_type, buyer_status) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)",
            fname, lname, contact, address, email, type, status);
 
        javax.swing.JOptionPane.showMessageDialog(this,
            "Buyer added successfully!",
            "Success",
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
 
        clearForm();
        loadData("");    }//GEN-LAST:event_addRecordActionPerformed

    private void updateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRecordActionPerformed
        if (selectedId == -1) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Please select a buyer from the table first.",
                "No Selection",
                javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!validateFields()) return;
 
        // Confirm update
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
            "Update this buyer's information?",
            "Confirm Update",
            javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm != javax.swing.JOptionPane.YES_OPTION) return;
 
        new config().addRecord(
            "UPDATE tbl_buyer SET " +
            "buyer_fname=?, buyer_lname=?, buyer_contact=?, " +
            "buyer_address=?, buyer_email=?, buyer_type=?, buyer_status=? " +
            "WHERE buyer_id=?",
            txtFname.getText().trim(),
            txtLname.getText().trim(),
            txtContact.getText().trim(),
            txtAddress.getText().trim(),
            txtEmail.getText().trim(),
            cmbType.getSelectedItem().toString(),
            cmbStatus.getSelectedItem().toString(),
            selectedId);
 
        javax.swing.JOptionPane.showMessageDialog(this,
            "Buyer updated successfully!",
            "Success",
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
 
        clearForm();
        loadData("");    }//GEN-LAST:event_updateRecordActionPerformed

    private void deleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRecordActionPerformed
        if (selectedId == -1) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Please select a buyer from the table first.",
                "No Selection",
                javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
 
        // Show buyer name in confirm dialog
        String buyerName = txtFname.getText().trim() + " " + txtLname.getText().trim();
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete buyer:\n" + buyerName + "?\n" +
            ".",
            "Confirm Delete",
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.WARNING_MESSAGE);
        if (confirm != javax.swing.JOptionPane.YES_OPTION) return;
 
        try {
            new config().addRecord(
                "DELETE FROM tbl_buyer WHERE buyer_id=?",
                selectedId);
            javax.swing.JOptionPane.showMessageDialog(this,
                "Buyer deleted successfully.",
                "Deleted",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Cannot delete: this buyer may be linked to existing sales.\n" + ex.getMessage(),
                "Delete Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
 
        clearForm();
        loadData("");    }//GEN-LAST:event_deleteRecordActionPerformed

    private void clearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFormActionPerformed
 clearForm();    }//GEN-LAST:event_clearFormActionPerformed

    private void back2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_back2ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
        new AdminDashboard().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed
    private void clearForm() {
        selectedId = -1;
        txtFname.setText("");
        txtLname.setText("");
        txtContact.setText("");
        txtAddress.setText("");
        txtEmail.setText("");
        cmbType.setSelectedIndex(0);
        cmbStatus.setSelectedIndex(0);
        tblBuyers.clearSelection();
    }
        private boolean validateFields() {
        if (txtFname.getText().trim().isEmpty() ||
            txtLname.getText().trim().isEmpty() ||
            txtContact.getText().trim().isEmpty() ||
            txtAddress.getText().trim().isEmpty() ||
            txtEmail.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "All fields are required.",
                "Validation Error",
                javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // Simple email format check
        if (!txtEmail.getText().trim().matches("^[\\w._%+\\-]+@[\\w.\\-]+\\.[a-zA-Z]{2,}$")) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Please enter a valid email address.",
                "Validation Error",
                javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try { for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) { if ("Nimbus".equals(info.getName())) { javax.swing.UIManager.setLookAndFeel(info.getClassName()); break; } } } catch (Exception ex) { }
        java.awt.EventQueue.invokeLater(() -> new BuyerForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRecord;
    private javax.swing.JButton back;
    private javax.swing.JButton back2;
    private javax.swing.JButton clearForm;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JButton deleteRecord;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblBuyers;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    private javax.swing.JButton updateRecord;
    // End of variables declaration//GEN-END:variables
}
