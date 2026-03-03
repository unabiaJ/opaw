package views;

import config.Session;
import config.config;
import java.sql.*;

/**
 * @author Administrator (updated)
 */
public class AdminDashboard extends javax.swing.JFrame {

    public AdminDashboard() {
        initComponents();
        setLocationRelativeTo(null);

        // ── REQUIRED LOGIN GUARD ─────────────────────────────────────────────
        if (!Session.requireLogin(this)) return;

        loadWelcome();
        loadStats();
    }

    // ── Fills header labels from session ────────────────────────────────────
    private void loadWelcome() {
        Session s = Session.getInstance();
        lblWelcome1.setText("Welcome, " + s.getFname() + " " + s.getLname() + "!");
        lblUserInfo.setText("Email: " + s.getEmail()
                + "   |   Role: Admin   |   Status: " + s.getStatus());
    }

    // ── Queries DB for live counts, fills stat panels and pending badge ──────
    private void loadStats() {
        int totalUsers = 0, pendingUsers = 0, fishTypes = 0, totalSales = 0;
        try (Connection conn = config.connectDB()) {
            ResultSet rs;
            rs = conn.createStatement().executeQuery("SELECT COUNT(*) FROM tbl_user");
            if (rs.next()) totalUsers = rs.getInt(1);

            rs = conn.createStatement().executeQuery(
                    "SELECT COUNT(*) FROM tbl_user WHERE user_status='Pending'");
            if (rs.next()) pendingUsers = rs.getInt(1);

            rs = conn.createStatement().executeQuery("SELECT COUNT(*) FROM tbl_fish_type");
            if (rs.next()) fishTypes = rs.getInt(1);

            rs = conn.createStatement().executeQuery("SELECT COUNT(*) FROM tbl_sale");
            if (rs.next()) totalSales = rs.getInt(1);
        } catch (SQLException ex) { /* DB not ready yet — zeros shown */ }

        // ── Fill each blank stat panel ────────────────────────────────────────
        fillStatCard(jPanel5, "Total Users",      String.valueOf(totalUsers),
                new java.awt.Color(51, 153, 255));
        fillStatCard(jPanel7, "Pending Approval", String.valueOf(pendingUsers),
                pendingUsers > 0 ? new java.awt.Color(220, 100, 0)
                                 : new java.awt.Color(0, 153, 51));
        fillStatCard(jPanel8, "Fish Types",       String.valueOf(fishTypes),
                new java.awt.Color(255, 153, 0));
        fillStatCard(jPanel6, "Total Sales",      String.valueOf(totalSales),
                new java.awt.Color(0, 204, 153));

        // ── Pending badge ──────────────────────────────────────────────────────
        if (pendingUsers > 0) {
            lblPendingBadge.setText("  \u26A0  " + pendingUsers
                    + " account(s) awaiting approval \u2014 go to USER MANAGEMENT to approve.");
            lblPendingBadge.setForeground(new java.awt.Color(200, 80, 0));
        } else {
            lblPendingBadge.setText("  \u2714  All user accounts are approved.");
            lblPendingBadge.setForeground(new java.awt.Color(0, 160, 60));
        }
    }

    /** Clears a stat panel and inserts a bold title + large number. */
    private void fillStatCard(javax.swing.JPanel panel,
            String title, String value, java.awt.Color color) {
        panel.removeAll();
        panel.setBackground(java.awt.Color.WHITE);
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(color, 2));
        panel.setLayout(new java.awt.BorderLayout(0, 2));

        javax.swing.JLabel lTitle = new javax.swing.JLabel(title, javax.swing.SwingConstants.CENTER);
        lTitle.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 11));
        lTitle.setForeground(color);
        lTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 2, 0, 2));

        javax.swing.JLabel lValue = new javax.swing.JLabel(value, javax.swing.SwingConstants.CENTER);
        lValue.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 28));
        lValue.setForeground(new java.awt.Color(20, 20, 20));

        panel.add(lTitle, java.awt.BorderLayout.NORTH);
        panel.add(lValue, java.awt.BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnFishType = new javax.swing.JButton();
        btnBuyers = new javax.swing.JButton();
        btnSales = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnUserMgmt = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lblUserInfo = new javax.swing.JLabel();
        lblWelcome1 = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lblPendingBadge = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setForeground(new java.awt.Color(0, 102, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFishType.setText("FISH TYPES");
        btnFishType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFishTypeActionPerformed(evt);
            }
        });
        jPanel2.add(btnFishType, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 210, 30));

        btnBuyers.setText("BUYERS");
        btnBuyers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyersActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuyers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 210, 30));

        btnSales.setText("SALES");
        btnSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalesActionPerformed(evt);
            }
        });
        jPanel2.add(btnSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 210, 30));

        btnProfile.setText("MY PROFILE");
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });
        jPanel2.add(btnProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 210, 30));

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 210, 30));

        btnUserMgmt.setText("USER MANAGEMENT");
        btnUserMgmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserMgmtActionPerformed(evt);
            }
        });
        jPanel2.add(btnUserMgmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, 30));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 690, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 600));

        jPanel3.setBackground(new java.awt.Color(0, 51, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 670, 10));

        lblUserInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUserInfo.setForeground(new java.awt.Color(255, 255, 255));
        lblUserInfo.setText("Email:    |   Role: Admin   |   Status:");
        jPanel3.add(lblUserInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        lblWelcome1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblWelcome1.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome1.setText("Welcome, Admin");
        jPanel3.add(lblWelcome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("ADMIN DASHBOARD");
        jPanel3.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 690, 120));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 150, 80));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 153)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 150, 80));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 153)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 160, 80));

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 160, 80));

        lblPendingBadge.setText("account(s) awaiting approval \\u2014 go to USER MANAGEMENT to approve.");
        jPanel1.add(lblPendingBadge, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 510, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
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

    private void btnFishTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFishTypeActionPerformed
        dispose();
        new FishTypeForm().setVisible(true);    }//GEN-LAST:event_btnFishTypeActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        dispose();
        new EditProfileForm().setVisible(true);
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnUserMgmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserMgmtActionPerformed
        dispose();
        new UserManagement().setVisible(true);
    }//GEN-LAST:event_btnUserMgmtActionPerformed

    private void btnSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalesActionPerformed
        dispose();
        new SalesHistory().setVisible(true);    }//GEN-LAST:event_btnSalesActionPerformed

    private void btnBuyersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyersActionPerformed
        dispose();
        new BuyerForm().setVisible(true);    }//GEN-LAST:event_btnBuyersActionPerformed
    private javax.swing.JButton sideBtn(String text) {
        javax.swing.JButton b = new javax.swing.JButton(text);
        b.setFont(new java.awt.Font("Segoe UI", 0, 13));
        b.setBackground(new java.awt.Color(0, 100, 160));
        b.setForeground(java.awt.Color.WHITE);
        b.setBorderPainted(false); b.setFocusPainted(false);
        b.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        return b;
    }

    private javax.swing.JButton navBtn(String text, java.awt.Color color) {
        javax.swing.JButton b = new javax.swing.JButton(text);
        b.setFont(new java.awt.Font("Segoe UI", 1, 15));
        b.setBackground(color);
        b.setForeground(java.awt.Color.WHITE);
        b.setBorderPainted(false); b.setFocusPainted(false);
        b.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        return b;
    }

    private javax.swing.JPanel statCard(String title, String value, java.awt.Color color) {
        javax.swing.JPanel p = new javax.swing.JPanel(new java.awt.BorderLayout());
        p.setBackground(java.awt.Color.WHITE);
        p.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(color, 2),
            javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12)));
        javax.swing.JLabel t = new javax.swing.JLabel(title, javax.swing.SwingConstants.CENTER);
        t.setFont(new java.awt.Font("Segoe UI", 1, 12)); t.setForeground(color);
        javax.swing.JLabel v = new javax.swing.JLabel(value, javax.swing.SwingConstants.CENTER);
        v.setFont(new java.awt.Font("Segoe UI", 1, 24)); v.setForeground(new java.awt.Color(30,30,30));
        p.add(t, java.awt.BorderLayout.NORTH); p.add(v, java.awt.BorderLayout.CENTER);
        return p;
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) { }
        java.awt.EventQueue.invokeLater(() -> new AdminDashboard().setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuyers;
    private javax.swing.JButton btnFishType;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnSales;
    private javax.swing.JButton btnUserMgmt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblPendingBadge;
    private javax.swing.JLabel lblUserInfo;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblWelcome1;
    // End of variables declaration//GEN-END:variables
}
