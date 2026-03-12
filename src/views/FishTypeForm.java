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
public class FishTypeForm extends javax.swing.JFrame {

    private int selectedId = -1;

    public FishTypeForm() {
        initComponents();
        setLocationRelativeTo(null);

        // ── REQUIRED LOGIN GUARD
        if (!Session.requireLogin(this)) return;

        // ── Populate category combo
        cmbCat.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[]{"Saltwater", "Freshwater", "Brackish"}));

        loadData("");

        // ── Row click → fill form
        tblFish.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) onRowClick();
        });

        // ── Search: button click OR press Enter
        jButton1.addActionListener(e -> loadData(jTextField1.getText().trim()));
        jTextField1.addActionListener(e -> loadData(jTextField1.getText().trim()));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtCode = new javax.swing.JTextField();
        addRecord = new javax.swing.JButton();
        updateRecord = new javax.swing.JButton();
        deleteRecord = new javax.swing.JButton();
        clearForm = new javax.swing.JButton();
        cmbCat = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFish = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setText("BACK TO DASHBOARD");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, -1, -1));

        jPanel4.setBackground(new java.awt.Color(229, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 300, 30));

        jPanel6.setBackground(new java.awt.Color(0, 51, 102));
        jPanel6.setPreferredSize(new java.awt.Dimension(880, 80));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("BUYER FORM");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 90));

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 350, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("FISH TYPE FORM");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        jPanel3.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 200, 30));
        jPanel3.add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 200, 30));

        addRecord.setBackground(new java.awt.Color(0, 153, 51));
        addRecord.setText("ADD");
        addRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRecordActionPerformed(evt);
            }
        });
        jPanel3.add(addRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 160, 30));

        updateRecord.setBackground(new java.awt.Color(0, 204, 204));
        updateRecord.setText("UPDATE");
        updateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRecordActionPerformed(evt);
            }
        });
        jPanel3.add(updateRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 160, 30));

        deleteRecord.setBackground(new java.awt.Color(255, 51, 51));
        deleteRecord.setText("DELETE");
        deleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRecordActionPerformed(evt);
            }
        });
        jPanel3.add(deleteRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 160, 30));

        clearForm.setBackground(new java.awt.Color(204, 204, 204));
        clearForm.setText("CLEAR");
        clearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFormActionPerformed(evt);
            }
        });
        jPanel3.add(clearForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 160, 30));

        cmbCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cmbCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 200, 30));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fish Name:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Category:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fish Code:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/log.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 490));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 370, 490));

        tblFish.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Code", "Fish Name", "Category"
            }
        ));
        jScrollPane1.setViewportView(tblFish);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 470, 140));

        jButton1.setText("SEARCH");
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/log.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 900, 510));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void loadData(String kw) {
        String k = "%" + kw + "%";
        new config().displayData(
            "SELECT fish_type_id AS 'ID', fish_code AS 'Code', fish_name AS 'Fish Name', fish_category AS 'Category' " +
            "FROM tbl_fish_type WHERE fish_name LIKE ? OR fish_code LIKE ? OR fish_category LIKE ? ORDER BY fish_name",
            tblFish, k, k, k);
        // Hide ID column
        if (tblFish.getColumnCount() > 0) {
            tblFish.getColumnModel().getColumn(0).setMinWidth(0);
            tblFish.getColumnModel().getColumn(0).setMaxWidth(0);
            tblFish.getColumnModel().getColumn(0).setWidth(0);
        }
        tblFish.setDefaultEditor(Object.class, null);
    }

    private void onRowClick() {
        int row = tblFish.getSelectedRow();
        if (row < 0) return;
        selectedId = Integer.parseInt(tblFish.getValueAt(row, 0).toString());
        txtCode.setText(tblFish.getValueAt(row, 1).toString());
        txtName.setText(tblFish.getValueAt(row, 2).toString());
        cmbCat.setSelectedItem(tblFish.getValueAt(row, 3).toString());
    }


    private void addRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecordActionPerformed
        if (txtCode.getText().trim().isEmpty() || txtName.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Fish Code and Fish Name are required.");
            return;
        }
        new config().addRecord(
            "INSERT INTO tbl_fish_type (fish_code, fish_name, fish_category) VALUES (?,?,?)",
            txtCode.getText().trim(), txtName.getText().trim(), cmbCat.getSelectedItem().toString());
        javax.swing.JOptionPane.showMessageDialog(this, "Fish type added!");
        clearForm(); loadData("");
    }//GEN-LAST:event_addRecordActionPerformed

    private void updateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRecordActionPerformed
       if (selectedId < 0) { javax.swing.JOptionPane.showMessageDialog(this, "Select a row first."); return; }
        new config().addRecord(
            "UPDATE tbl_fish_type SET fish_code=?, fish_name=?, fish_category=? WHERE fish_type_id=?",
            txtCode.getText().trim(), txtName.getText().trim(),
            cmbCat.getSelectedItem().toString(), selectedId);
        javax.swing.JOptionPane.showMessageDialog(this, "Fish type updated!");
        clearForm(); loadData("");
    }//GEN-LAST:event_updateRecordActionPerformed

    private void deleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRecordActionPerformed
        if (selectedId < 0) { javax.swing.JOptionPane.showMessageDialog(this, "Select a row first."); return; }
        int c = javax.swing.JOptionPane.showConfirmDialog(this, "Delete this fish type?", "Confirm",
            javax.swing.JOptionPane.YES_NO_OPTION);
        if (c != javax.swing.JOptionPane.YES_OPTION) return;
        new config().addRecord("DELETE FROM tbl_fish_type WHERE fish_type_id=?", selectedId);
        javax.swing.JOptionPane.showMessageDialog(this, "Fish type deleted.");
        clearForm(); loadData("");
    }//GEN-LAST:event_deleteRecordActionPerformed

    private void clearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFormActionPerformed
        clearForm();
    }//GEN-LAST:event_clearFormActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose(); 
        new AdminDashboard().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        new AdminDashboard().setVisible(true);            // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void clearForm() {
        selectedId = -1;
        txtCode.setText(""); txtName.setText(""); cmbCat.setSelectedIndex(0);
        tblFish.clearSelection();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try { for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) { if ("Nimbus".equals(info.getName())) { javax.swing.UIManager.setLookAndFeel(info.getClassName()); break; } } } catch (Exception ex) { }
        java.awt.EventQueue.invokeLater(() -> new FishTypeForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRecord;
    private javax.swing.JButton back;
    private javax.swing.JButton clearForm;
    private javax.swing.JComboBox<String> cmbCat;
    private javax.swing.JButton deleteRecord;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblFish;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtName;
    private javax.swing.JButton updateRecord;
    // End of variables declaration//GEN-END:variables
}
