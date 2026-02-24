/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import config.config;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Administrator
 */
public class UserManagement
        extends javax.swing.JFrame {

    private int selectedUserId = -1;

    /**
     * Creates new form UserManagement
     */
    public UserManagement() {
        initComponents();
        setLocationRelativeTo(null);
        loadUsers("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        clearForm = new javax.swing.JButton();
        addUser = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Search:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 230, 30));

        jButton1.setText("SEARCH");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, -1, 30));

        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblUsers);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 400, 140));

        jButton2.setText("BACK TO DASHBOARD");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, -1, -1));

        jButton3.setText("DELETE");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

        clearForm.setText("CLEAR");
        jPanel1.add(clearForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, -1, -1));

        addUser.setText("ADD");
        addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserActionPerformed(evt);
            }
        });
        jPanel1.add(addUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jButton6.setText("UPDATE");
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserActionPerformed

    }//GEN-LAST:event_addUserActionPerformed
private void styleBtn(javax.swing.JButton b, java.awt.Color c) {
        b.setFont(new java.awt.Font("Segoe UI", 1, 11));
        b.setBackground(c); b.setForeground(java.awt.Color.WHITE);
        b.setBorderPainted(false); b.setFocusPainted(false);
        b.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    public void loadUsers(String keyword) {
        config cfg = new config();
        String k = "%" + keyword + "%";
        String sql = "SELECT user_id AS 'ID', user_fname AS 'First Name', user_lname AS 'Last Name', " +
                     "user_email AS 'Email', username AS 'Username', type AS 'Role', user_status AS 'Status' " +
                     "FROM tbl_user WHERE user_fname LIKE ? OR user_lname LIKE ? OR username LIKE ? OR user_email LIKE ?";
        cfg.displayData(sql, tblUsers, k, k, k, k);
        if (tblUsers.getColumnCount() > 0) {
            tblUsers.getColumnModel().getColumn(0).setMinWidth(0);
            tblUsers.getColumnModel().getColumn(0).setMaxWidth(0);
        }
    }
    


   private void goBack() { dispose(); new AdminDashboard().setVisible(true); }
   
    public static void main(String args[]) {
        try { for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) { if ("Nimbus".equals(info.getName())) { javax.swing.UIManager.setLookAndFeel(info.getClassName()); break; } } } catch (Exception ex) { }
        java.awt.EventQueue.invokeLater(() -> new UserManagement().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUser;
    private javax.swing.JButton clearForm;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblUsers;
    // End of variables declaration//GEN-END:variables
}
