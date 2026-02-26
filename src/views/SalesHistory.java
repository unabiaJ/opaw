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
public class SalesHistory extends javax.swing.JFrame {

    public SalesHistory() {
        initComponents();
        setLocationRelativeTo(null);

        // ── REQUIRED LOGIN GUARD
        if (!Session.requireLogin(this)) return;

        loadSales("");

        // ── Row click → load sale items
        tblSales.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) loadItemsForSale();
        });

        // ── Search: button click OR press Enter
        btnSearch.addActionListener(e -> loadSales(txtSearch.getText().trim()));
        txtSearch.addActionListener(e -> loadSales(txtSearch.getText().trim()));

        // ── New Sale button
        addUser.addActionListener(e -> {
            dispose();
            new SalesForm().setVisible(true);
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSales = new javax.swing.JTable();
        addUser = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        lblItemTotal = new javax.swing.JLabel();
        lblWelcome1 = new javax.swing.JLabel();
        lblItemsTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Search:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));
        jPanel2.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 230, 30));

        btnSearch.setText("SEARCH");
        jPanel2.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, 30));

        tblSales.setModel(new javax.swing.table.DefaultTableModel(
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
                "Sale #", "Sold By", "Buyer", "Date", "Total", "Payment"
            }
        ));
        jScrollPane1.setViewportView(tblSales);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 850, 140));

        addUser.setText("New Sale");
        addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserActionPerformed(evt);
            }
        });
        jPanel2.add(addUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, 120, -1));

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setText("BACK TO DASHBOARD");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel3.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, -1, -1));

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("SALE HISTORY");
        jPanel3.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 90));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 830, 10));

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fish Type", "Qty (kg)", "Price/kg", "Subtotal"
            }
        ));
        jScrollPane2.setViewportView(tblItems);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 830, 100));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 51)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblItemTotal.setText("TOTAL:");
        jPanel5.add(lblItemTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 230, 40));

        lblWelcome1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblWelcome1.setText("Welcome, Admin");
        jPanel4.add(lblWelcome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblItemsTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblItemsTitle.setText("Items for Sale #");
        jPanel4.add(lblItemsTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 230, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 850, 240));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserActionPerformed
        dispose();
        new SalesForm().setVisible(true);
    }//GEN-LAST:event_addUserActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
        if ("admin".equalsIgnoreCase(Session.getInstance().getType()))
            new AdminDashboard().setVisible(true);
        else
            new UserDashboard().setVisible(true); 
    }//GEN-LAST:event_backActionPerformed
    
     public void loadSales(String kw) {
        String k = "%" + kw + "%";
        // Sales table has no hidden ID — sale_id IS shown as col 0 (Sale #)
        if ("admin".equalsIgnoreCase(Session.getInstance().getType())) {
            new config().displayData(
                "SELECT s.sale_id AS 'Sale #', " +
                "u.user_fname||' '||u.user_lname AS 'Sold By', " +
                "b.buyer_fname||' '||b.buyer_lname AS 'Buyer', " +
                "s.sale_date AS 'Date', s.total_amount AS 'Total (₱)', s.payment_status AS 'Payment' " +
                "FROM tbl_sale s " +
                "JOIN tbl_user u ON s.user_id=u.user_id " +
                "JOIN tbl_buyer b ON s.buyer_id=b.buyer_id " +
                "WHERE b.buyer_fname LIKE ? OR b.buyer_lname LIKE ? " +
                "OR s.sale_date LIKE ? OR s.payment_status LIKE ? " +
                "ORDER BY s.sale_id DESC",
                tblSales, k, k, k, k);
        } else {
            int uid = Session.getInstance().getId();
            new config().displayData(
                "SELECT s.sale_id AS 'Sale #', " +
                "b.buyer_fname||' '||b.buyer_lname AS 'Buyer', " +
                "s.sale_date AS 'Date', s.total_amount AS 'Total (₱)', s.payment_status AS 'Payment' " +
                "FROM tbl_sale s " +
                "JOIN tbl_buyer b ON s.buyer_id=b.buyer_id " +
                "WHERE s.user_id=? AND (b.buyer_fname LIKE ? OR s.sale_date LIKE ?) " +
                "ORDER BY s.sale_id DESC",
                tblSales, uid, k, k);
        }
        tblSales.setDefaultEditor(Object.class, null);
    }

    /** Fires when a row in tblSales is clicked — loads its items below. */
    private void loadItemsForSale() {
        int row = tblSales.getSelectedRow();
        if (row < 0) return;

        // Col 0 = Sale # (visible, used as the ID)
        int saleId = Integer.parseInt(tblSales.getValueAt(row, 0).toString());

        new config().displayData(
            "SELECT f.fish_name AS 'Fish Type', si.quantity_kg AS 'Qty (kg)', " +
            "si.price_per_kg AS 'Price/kg', si.subtotal AS 'Subtotal (₱)' " +
            "FROM tbl_sale_item si " +
            "JOIN tbl_fish_type f ON si.fish_type_id = f.fish_type_id " +
            "WHERE si.sale_id = ?",
            tblItems, saleId);
        tblItems.setDefaultEditor(Object.class, null);

        // Update labels — find buyer and total columns safely
        int colCount = tblSales.getColumnCount();
        String total = tblSales.getValueAt(row, colCount - 2).toString();
        String buyer = tblSales.getValueAt(row, colCount - 3).toString();
        lblItemsTitle.setText("Items for Sale #" + saleId + "  —  Buyer: " + buyer);
        lblItemTotal.setText("  TOTAL:  ₱ " + total + "   ");
    }

    public static void main(String args[]) {
        try { for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) { if ("Nimbus".equals(info.getName())) { javax.swing.UIManager.setLookAndFeel(info.getClassName()); break; } } } catch (Exception ex) { }
        java.awt.EventQueue.invokeLater(() -> new SalesHistory().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUser;
    private javax.swing.JButton back;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblItemTotal;
    private javax.swing.JLabel lblItemsTitle;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblWelcome1;
    private javax.swing.JTable tblItems;
    private javax.swing.JTable tblSales;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
