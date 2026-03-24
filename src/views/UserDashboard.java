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
public class UserDashboard extends javax.swing.JFrame {

    public UserDashboard() {
        initComponents();
        setLocationRelativeTo(null);
        loadSessionInfo();
        loadStats();
        loadMySales();
        // Table not editable
        tblSales.setDefaultEditor(Object.class, null);
    }

    private void loadSessionInfo() {
        Session s = Session.getInstance();
        lblWelcome1.setText("Welcome back, " + s.getFname() + " " + s.getLname() + "!");
        lblInfo.setText("Email: " + s.getEmail() + "   |   Role: User   |   Status: " + s.getStatus());
        lblSession.setText(s.getFname() + " " + s.getLname() + "  |  User");
    }

    private void loadStats() {
        int uid = Session.getInstance().getId();
        try (java.sql.Connection conn = config.connectDB();
             java.sql.PreparedStatement ps = conn.prepareStatement(
                "SELECT COUNT(*), COALESCE(SUM(total_amount),0) FROM tbl_sale WHERE user_id=?")) {
            ps.setInt(1, uid);
            java.sql.ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                lblStatTx.setText(String.valueOf(rs.getInt(1)));
                lblStatRev.setText(String.format("₱ %.2f", rs.getDouble(2)));
            }
            lblStatStatus.setText(Session.getInstance().getStatus());
        } catch (java.sql.SQLException ex) { /* ignore */ }
    }

    private void loadMySales() {
        int uid = Session.getInstance().getId();
        new config().displayData(
            "SELECT s.sale_id AS 'Sale #', b.buyer_fname||' '||b.buyer_lname AS 'Buyer', " +
            "s.sale_date AS 'Date', s.total_amount AS 'Total (₱)', s.payment_status AS 'Payment Status' " +
            "FROM tbl_sale s JOIN tbl_buyer b ON s.buyer_id=b.buyer_id " +
            "WHERE s.user_id=? ORDER BY s.sale_id DESC",
            tblSales, uid);
        tblSales.setDefaultEditor(Object.class, null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnProfile = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnNewSale = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        sjkc = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lblWelcome = new javax.swing.JLabel();
        lblWelcome1 = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        lblSession = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSales = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lblStatTx = new javax.swing.JLabel();
        lblStatTx1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblStatRev = new javax.swing.JLabel();
        lblStatRev1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblStatStatus = new javax.swing.JLabel();
        lblStatStatus1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(229, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProfile.setBackground(new java.awt.Color(204, 255, 255));
        btnProfile.setText("MY PROFILE");
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });
        jPanel2.add(btnProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 190, 40));

        btnLogout.setBackground(new java.awt.Color(255, 204, 204));
        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 190, 40));

        btnNewSale.setBackground(new java.awt.Color(204, 255, 255));
        btnNewSale.setText("NEW SALE");
        btnNewSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewSaleActionPerformed(evt);
            }
        });
        jPanel2.add(btnNewSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, 40));

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setText("SALE HISTORY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 190, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 210, 460));

        sjkc.setBackground(new java.awt.Color(8, 66, 124));
        sjkc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        sjkc.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 730, 30));

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("MY DASHBOARD");
        sjkc.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        lblWelcome1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblWelcome1.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome1.setText("Welcome, User!");
        sjkc.add(lblWelcome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        lblInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(255, 255, 255));
        lblInfo.setText("Email:    |   Role: Admin   |   Status:");
        sjkc.add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        lblSession.setText("jLabel1");
        sjkc.add(lblSession, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, -1, -1));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/l.png"))); // NOI18N
        jLabel29.setText("jLabel2");
        sjkc.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 100));

        jPanel1.add(sjkc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 120));

        tblSales.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tblSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Sale #", "Buyer", "Date", "Total", "Payment Status"
            }
        ));
        jScrollPane1.setViewportView(tblSales);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 620, 140));

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblStatTx.setBackground(new java.awt.Color(0, 102, 255));
        lblStatTx.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblStatTx.setText("TRANSACTION");
        jPanel3.add(lblStatTx, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 130, 60));

        lblStatTx1.setBackground(new java.awt.Color(0, 102, 255));
        lblStatTx1.setText("TRANSACTION");
        jPanel3.add(lblStatTx1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 110, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 220, 100));

        jPanel4.setBackground(new java.awt.Color(102, 204, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblStatRev.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblStatRev.setText("REVENUE");
        jPanel4.add(lblStatRev, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 130, 60));

        lblStatRev1.setText("REVENUE");
        jPanel4.add(lblStatRev1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 130, 60));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 230, 100));

        jPanel5.setBackground(new java.awt.Color(204, 204, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblStatStatus.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblStatStatus.setText("STATUS");
        jPanel5.add(lblStatStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 130, 60));

        lblStatStatus1.setText("STATUS");
        jPanel5.add(lblStatStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 130, 60));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 210, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/log.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 610));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int c = javax.swing.JOptionPane.showConfirmDialog(this,
            "Are you sure you want to logout?", "Confirm Logout",
            javax.swing.JOptionPane.YES_NO_OPTION);
        if (c == javax.swing.JOptionPane.YES_OPTION) {
            Session.clearSession();
            dispose();
            new LoginForm().setVisible(true);
        
        }    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnNewSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewSaleActionPerformed
        this.dispose();
        SalesForm saleForm = new SalesForm();
        saleForm.setVisible(true);    }//GEN-LAST:event_btnNewSaleActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        this.dispose();
        EditProfileForm profileForm = new EditProfileForm();
        profileForm.setVisible(true);    }//GEN-LAST:event_btnProfileActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        SalesHistory salehistory = new SalesHistory();
        salehistory.setVisible(true);    
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try { for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) { if ("Nimbus".equals(info.getName())) { javax.swing.UIManager.setLookAndFeel(info.getClassName()); break; } } } catch (Exception ex) { }
        java.awt.EventQueue.invokeLater(() -> new UserDashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNewSale;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblSession;
    private javax.swing.JLabel lblStatRev;
    private javax.swing.JLabel lblStatRev1;
    private javax.swing.JLabel lblStatStatus;
    private javax.swing.JLabel lblStatStatus1;
    private javax.swing.JLabel lblStatTx;
    private javax.swing.JLabel lblStatTx1;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblWelcome1;
    private javax.swing.JPanel sjkc;
    private javax.swing.JTable tblSales;
    // End of variables declaration//GEN-END:variables
}
