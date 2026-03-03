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
public class BuyerForm extends javax.swing.JFrame {

    private int selectedId = -1;

    public BuyerForm() {
        initComponents();
        setLocationRelativeTo(null);

        // ── REQUIRED LOGIN GUARD
        if (!Session.requireLogin(this)) return;

        // ── Populate combos
        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[]{"Wholesale", "Retail", "Individual"}));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[]{"Active", "Inactive"}));

        loadData("");

        // ── Row click → fill form
        tblBuyers.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) onRowClick();
        });

        // ── Search: button click OR press Enter
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
        txtContact1 = new javax.swing.JTextField();
        txtFname1 = new javax.swing.JTextField();
        addRecord1 = new javax.swing.JButton();
        updateRecord1 = new javax.swing.JButton();
        deleteRecord1 = new javax.swing.JButton();
        clearForm1 = new javax.swing.JButton();
        cmbType1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtAddress1 = new javax.swing.JTextField();
        txtEmail1 = new javax.swing.JTextField();
        txtLname1 = new javax.swing.JTextField();
        cmbStatus1 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuyers = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        back2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        txtFname = new javax.swing.JTextField();
        addRecord = new javax.swing.JButton();
        updateRecord = new javax.swing.JButton();
        deleteRecord = new javax.swing.JButton();
        clearForm = new javax.swing.JButton();
        cmbType = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 102, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 350, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("BUYER FORM");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        jPanel5.add(txtContact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 200, 30));
        jPanel5.add(txtFname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 200, 30));

        addRecord1.setBackground(new java.awt.Color(0, 153, 51));
        addRecord1.setText("ADD");
        addRecord1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRecord1ActionPerformed(evt);
            }
        });
        jPanel5.add(addRecord1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 160, 30));

        updateRecord1.setBackground(new java.awt.Color(0, 204, 204));
        updateRecord1.setText("UPDATE");
        updateRecord1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRecord1ActionPerformed(evt);
            }
        });
        jPanel5.add(updateRecord1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 160, 30));

        deleteRecord1.setBackground(new java.awt.Color(255, 51, 51));
        deleteRecord1.setText("DELETE");
        deleteRecord1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRecord1ActionPerformed(evt);
            }
        });
        jPanel5.add(deleteRecord1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 160, 30));

        clearForm1.setBackground(new java.awt.Color(204, 204, 204));
        clearForm1.setText("CLEAR");
        clearForm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearForm1ActionPerformed(evt);
            }
        });
        jPanel5.add(clearForm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 160, 30));

        cmbType1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(cmbType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 200, 30));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Last Name:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Address:");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("First Name:");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));
        jPanel5.add(txtAddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 200, 30));
        jPanel5.add(txtEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 200, 30));
        jPanel5.add(txtLname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 200, 30));

        cmbStatus1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(cmbStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 200, 30));

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

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 370, 500));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 470, 140));

        jLabel1.setText("SEARCH:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 230, 30));

        jButton1.setText("SEARCH");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 100, 30));

        jPanel6.setBackground(new java.awt.Color(0, 51, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("BACK TO DASHBOARD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("BUYER FORM");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 80));

        back2.setText("BACK TO DASHBOARD");
        back2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back2ActionPerformed(evt);
            }
        });
        jPanel1.add(back2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 210, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        jPanel4.setBackground(new java.awt.Color(0, 102, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 350, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BUYER FORM");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        jPanel4.add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 200, 30));
        jPanel4.add(txtFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 200, 30));

        addRecord.setBackground(new java.awt.Color(0, 153, 51));
        addRecord.setText("ADD");
        addRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRecordActionPerformed(evt);
            }
        });
        jPanel4.add(addRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 160, 30));

        updateRecord.setBackground(new java.awt.Color(0, 204, 204));
        updateRecord.setText("UPDATE");
        updateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRecordActionPerformed(evt);
            }
        });
        jPanel4.add(updateRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 160, 30));

        deleteRecord.setBackground(new java.awt.Color(255, 51, 51));
        deleteRecord.setText("DELETE");
        deleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRecordActionPerformed(evt);
            }
        });
        jPanel4.add(deleteRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 160, 30));

        clearForm.setBackground(new java.awt.Color(204, 204, 204));
        clearForm.setText("CLEAR");
        clearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFormActionPerformed(evt);
            }
        });
        jPanel4.add(clearForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 160, 30));

        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cmbType, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 200, 30));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Last Name:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Address:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("First Name:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));
        jPanel4.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 200, 30));
        jPanel4.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 200, 30));
        jPanel4.add(txtLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 200, 30));

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 200, 30));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Buyer Type");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Status");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Contact #:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 370, 480));

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
    private void clearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFormActionPerformed

       clearForm();

    }//GEN-LAST:event_clearFormActionPerformed

    private void deleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRecordActionPerformed
        if (selectedId < 0) { javax.swing.JOptionPane.showMessageDialog(this, "Select a row first."); return; }
        int c = javax.swing.JOptionPane.showConfirmDialog(this, "Delete this buyer?", "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);
        if (c != javax.swing.JOptionPane.YES_OPTION) return;
        new config().addRecord("DELETE FROM tbl_buyer WHERE buyer_id=?", selectedId);
        javax.swing.JOptionPane.showMessageDialog(this, "Buyer deleted.");
        clearForm(); loadData("");
    }//GEN-LAST:event_deleteRecordActionPerformed

    private void updateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRecordActionPerformed
        if (selectedId < 0) { javax.swing.JOptionPane.showMessageDialog(this, "Select a row first."); return; }
        new config().addRecord(
            "UPDATE tbl_buyer SET buyer_fname=?,buyer_lname=?,buyer_contact=?,buyer_address=?,buyer_email=?,buyer_type=?,buyer_status=? WHERE buyer_id=?",
            txtFname.getText().trim(), txtLname.getText().trim(), txtContact.getText().trim(),
            txtAddress.getText().trim(), txtEmail.getText().trim(),
            cmbType.getSelectedItem(), cmbStatus.getSelectedItem(), selectedId);
        javax.swing.JOptionPane.showMessageDialog(this, "Buyer updated!");
        clearForm(); loadData("");
    }//GEN-LAST:event_updateRecordActionPerformed

    private void addRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecordActionPerformed
        if (txtFname.getText().trim().isEmpty() || txtLname.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "First name and last name are required.");
            return;
        }
        new config().addRecord(
            "INSERT INTO tbl_buyer (buyer_fname, buyer_lname, buyer_contact, buyer_address, buyer_email, buyer_type, buyer_status) VALUES (?,?,?,?,?,?,?)",
            txtFname.getText().trim(), txtLname.getText().trim(),
            txtContact.getText().trim(), txtAddress.getText().trim(),
            txtEmail.getText().trim(),
            cmbType.getSelectedItem().toString(),
            cmbStatus.getSelectedItem().toString());
        javax.swing.JOptionPane.showMessageDialog(this, "Buyer added!");
        clearForm(); loadData("");
    }//GEN-LAST:event_addRecordActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyTyped

    private void addRecord1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecord1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addRecord1ActionPerformed

    private void updateRecord1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRecord1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateRecord1ActionPerformed

    private void deleteRecord1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRecord1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteRecord1ActionPerformed

    private void clearForm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearForm1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearForm1ActionPerformed

    private void back2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_back2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        new AdminDashboard().setVisible(true);            // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    private void clearForm() {
        selectedId = -1;
        txtFname.setText(""); txtLname.setText(""); txtContact.setText("");
        txtAddress.setText(""); txtEmail.setText("");
        cmbType.setSelectedIndex(0); cmbStatus.setSelectedIndex(0);
        tblBuyers.clearSelection();
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
    private javax.swing.JButton addRecord1;
    private javax.swing.JButton back2;
    private javax.swing.JButton clearForm;
    private javax.swing.JButton clearForm1;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JComboBox<String> cmbStatus1;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JComboBox<String> cmbType1;
    private javax.swing.JButton deleteRecord;
    private javax.swing.JButton deleteRecord1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblBuyers;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAddress1;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtContact1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtFname1;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtLname1;
    private javax.swing.JButton updateRecord;
    private javax.swing.JButton updateRecord1;
    // End of variables declaration//GEN-END:variables
}
