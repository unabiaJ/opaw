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
public class BuyerForm extends javax.swing.JFrame {

    private int selectedId = -1;

    public BuyerForm() {
        initComponents();
        setLocationRelativeTo(null);
        loadData("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        back = new javax.swing.JButton();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuyers = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Search:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 230, 30));

        jButton1.setText("SEARCH");
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, 30));

        back.setText("BACK TO DASHBOARD");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel3.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        jPanel4.setBackground(new java.awt.Color(0, 102, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 220, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BUYER FORM");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel4.add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 130, -1));
        jPanel4.add(txtFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 130, -1));

        addRecord.setBackground(new java.awt.Color(0, 153, 51));
        addRecord.setText("ADD");
        addRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRecordActionPerformed(evt);
            }
        });
        jPanel4.add(addRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 100, -1));

        updateRecord.setBackground(new java.awt.Color(0, 204, 204));
        updateRecord.setText("UPDATE");
        updateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRecordActionPerformed(evt);
            }
        });
        jPanel4.add(updateRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 100, 20));

        deleteRecord.setBackground(new java.awt.Color(255, 51, 51));
        deleteRecord.setText("DELETE");
        deleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRecordActionPerformed(evt);
            }
        });
        jPanel4.add(deleteRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 100, 20));

        clearForm.setBackground(new java.awt.Color(204, 204, 204));
        clearForm.setText("CLEAR");
        clearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFormActionPerformed(evt);
            }
        });
        jPanel4.add(clearForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 100, 20));

        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cmbType, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 130, 20));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Last Name:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Address:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("First Name:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        jPanel4.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 130, -1));
        jPanel4.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 130, -1));
        jPanel4.add(txtLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 130, -1));

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 130, 20));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Buyer Type");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Status");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Contact #:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 240, 350));

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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 400, 140));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

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
            "FROM tbl_buyer WHERE buyer_fname LIKE ? OR buyer_lname LIKE ? OR buyer_contact LIKE ? ORDER BY buyer_fname",
            tblBuyers, k, k, k);
        if (tblBuyers.getColumnCount() > 0) {
            tblBuyers.getColumnModel().getColumn(0).setMinWidth(0);
            tblBuyers.getColumnModel().getColumn(0).setMaxWidth(0);
            tblBuyers.getColumnModel().getColumn(0).setWidth(0);
        }
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
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
        new AdminDashboard().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    private void addRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecordActionPerformed
        if (txtFname.getText().trim().isEmpty() || txtContact.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Fish Code and Fish Name are required."); return;
        }
        new config().addRecord(
            "INSERT INTO tbl_fish_type (fish_code, fish_name, category) VALUES (?,?,?)",
            txtFname.getText().trim(), txtContact.getText().trim(), cmbType.getSelectedItem());
        javax.swing.JOptionPane.showMessageDialog(this, "Fish type added!");
        clearForm(); loadData("");
    }//GEN-LAST:event_addRecordActionPerformed

    private void updateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRecordActionPerformed
        if (selectedId < 0) { javax.swing.JOptionPane.showMessageDialog(this, "Select a row first."); return; }
        new config().addRecord(
            "UPDATE tbl_fish_type SET fish_code=?, fish_name=?, category=? WHERE fish_type_id=?",
            txtFname.getText().trim(), txtContact.getText().trim(), cmbType.getSelectedItem(), selectedId);
        javax.swing.JOptionPane.showMessageDialog(this, "Fish type updated!");
        clearForm(); loadData("");
    }//GEN-LAST:event_updateRecordActionPerformed

    private void deleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRecordActionPerformed
        if (selectedId < 0) { javax.swing.JOptionPane.showMessageDialog(this, "Select a row first."); return; }
        int c = javax.swing.JOptionPane.showConfirmDialog(this, "Delete this fish type?", "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);
        if (c != javax.swing.JOptionPane.YES_OPTION) return;
        new config().addRecord("DELETE FROM tbl_fish_type WHERE fish_type_id=?", selectedId);
        javax.swing.JOptionPane.showMessageDialog(this, "Fish type deleted.");
        clearForm(); loadData("");
    }//GEN-LAST:event_deleteRecordActionPerformed

    private void clearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFormActionPerformed
         
        selectedId = -1;
        txtFname.setText(""); txtLname.setText(""); txtContact.setText("");
        txtAddress.setText(""); txtEmail.setText("");
        cmbType.setSelectedIndex(0); cmbStatus.setSelectedIndex(0);
        tblBuyers.clearSelection();
    
    }//GEN-LAST:event_clearFormActionPerformed
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
            java.util.logging.Logger.getLogger(BuyerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuyerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuyerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuyerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuyerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRecord;
    private javax.swing.JButton back;
    private javax.swing.JButton clearForm;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JButton deleteRecord;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
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
