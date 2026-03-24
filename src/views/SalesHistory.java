/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
 
import config.config;
import config.Session;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
 
/**
 * SalesHistory.java — Fixed & Enhanced
 *
 * NEW FEATURES:
 *  1. "MARK AS PAID" button — select any Unpaid row → click → updates tbl_sale.payment_status
 *  2. Color-coded table rows: Unpaid = light red, Paid = light green
 *  3. Payment summary bar: shows total Paid amount vs total Unpaid amount
 *  4. Admin sees ALL transactions; Seller sees only their own
 *  5. "MARK AS PAID" is disabled unless an Unpaid row is selected
 */
public class SalesHistory extends javax.swing.JFrame {
 
    public SalesHistory() {
        initComponents();
        setLocationRelativeTo(null);
 
        if (!Session.requireLogin(this)) return;
 
        // ── Style buttons
        styleBtn(btnSearch,     new Color(0, 102, 153));
       
        styleBtn(back,          new Color(0, 51, 102));
        styleBtn(btnMarkPaid,   new Color(0, 153, 51));
 
        // ── Mark as Paid starts disabled — only enabled when Unpaid row selected
        btnMarkPaid.setEnabled(false);
 
        // ── Apply color renderer to Payment column
        applyPaymentRenderer();
 
        // ── Load all sales on open
        loadSales("");
 
        // ── Row click → load items + enable/disable Mark as Paid
        tblSales.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                loadItemsForSale();
                updateMarkPaidButton();
            }
        });
 
        // ── Search
        btnSearch.addActionListener(e -> loadSales(txtSearch.getText().trim()));
        txtSearch.addActionListener(e -> loadSales(txtSearch.getText().trim()));
 

 
        // ── Mark as Paid — THE CORE FIX
        btnMarkPaid.addActionListener(e -> markSelectedAsPaid());
    }
 
    // ─────────────────────────────────────────────────────────────────────────
    //  MARK AS PAID  — updates payment_status in tbl_sale
    // ─────────────────────────────────────────────────────────────────────────
    private void markSelectedAsPaid() {
        int row = tblSales.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this,
                "Please select a sale from the table first.",
                "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
 
        // Col 0 = Sale #, last col = Payment status
        int saleId = Integer.parseInt(tblSales.getValueAt(row, 0).toString());
        int colCount = tblSales.getColumnCount();
        String currentStatus = tblSales.getValueAt(row, colCount - 1).toString().trim();
 
        if ("Paid".equalsIgnoreCase(currentStatus)) {
            JOptionPane.showMessageDialog(this,
                "Sale #" + saleId + " is already marked as Paid.",
                "Already Paid", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
 
        // Confirm before updating
        String buyer = tblSales.getValueAt(row, colCount - 4) != null
                       ? tblSales.getValueAt(row, colCount - 4).toString() : "";
        String total = tblSales.getValueAt(row, colCount - 2) != null
                       ? tblSales.getValueAt(row, colCount - 2).toString() : "";
 
        int confirm = JOptionPane.showConfirmDialog(this,
            "Mark Sale #" + saleId + " as PAID?\n"
            + "Buyer : " + buyer + "\n"
            + "Total : ₱ " + total,
            "Confirm Payment",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
 
        if (confirm != JOptionPane.YES_OPTION) return;
 
        // ── UPDATE tbl_sale
        try (Connection conn = config.connectDB();
             PreparedStatement ps = conn.prepareStatement(
                "UPDATE tbl_sale SET payment_status = 'Paid' WHERE sale_id = ?")) {
            ps.setInt(1, saleId);
            int affected = ps.executeUpdate();
            if (affected > 0) {
                JOptionPane.showMessageDialog(this,
                    "Sale #" + saleId + " has been marked as PAID successfully!",
                    "Payment Updated", JOptionPane.INFORMATION_MESSAGE);
                loadSales(txtSearch.getText().trim()); // refresh table
                btnMarkPaid.setEnabled(false);         // reset button
            } else {
                JOptionPane.showMessageDialog(this,
                    "Update failed. Sale #" + saleId + " not found.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                "Database error: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    // ─────────────────────────────────────────────────────────────────────────
    //  Enable "MARK AS PAID" only when the selected row is Unpaid
    // ─────────────────────────────────────────────────────────────────────────
    private void updateMarkPaidButton() {
        int row = tblSales.getSelectedRow();
        if (row < 0) {
            btnMarkPaid.setEnabled(false);
            return;
        }
        int colCount = tblSales.getColumnCount();
        String status = tblSales.getValueAt(row, colCount - 1).toString().trim();
        boolean isUnpaid = "Unpaid".equalsIgnoreCase(status);
        btnMarkPaid.setEnabled(isUnpaid);
        btnMarkPaid.setBackground(isUnpaid
            ? new Color(200, 50, 50)   // red when unpaid row selected
            : new Color(150, 150, 150));
    }
 
    // ─────────────────────────────────────────────────────────────────────────
    //  Color renderer — Unpaid rows = light red, Paid = light green
    // ─────────────────────────────────────────────────────────────────────────
    private void applyPaymentRenderer() {
        tblSales.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
 
                Component c = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
 
                if (!isSelected) {
                    int colCount = table.getColumnCount();
                    Object statusObj = table.getValueAt(row, colCount - 1);
                    String status = statusObj != null ? statusObj.toString().trim() : "";
                    if ("Unpaid".equalsIgnoreCase(status)) {
                        c.setBackground(new Color(255, 220, 220)); // light red
                        c.setForeground(new Color(150, 0, 0));
                    } else {
                        c.setBackground(new Color(220, 255, 220)); // light green
                        c.setForeground(new Color(0, 100, 0));
                    }
                } else {
                    c.setBackground(new Color(0, 102, 153));
                    c.setForeground(Color.WHITE);
                }
                return c;
            }
        });
    }
 
    // ─────────────────────────────────────────────────────────────────────────
    //  Load sales — Admin: ALL, Seller: own only
    // ─────────────────────────────────────────────────────────────────────────
    public void loadSales(String kw) {
        String k = "%" + kw + "%";
 
        if ("admin".equalsIgnoreCase(Session.getInstance().getType())) {
            new config().displayData(
                "SELECT s.sale_id AS 'Sale #', " +
                "u.user_fname||' '||u.user_lname AS 'Sold By', " +
                "b.buyer_fname||' '||b.buyer_lname AS 'Buyer', " +
                "s.sale_date AS 'Date', " +
                "s.total_amount AS 'Total (₱)', " +
                "s.payment_status AS 'Payment' " +
                "FROM tbl_sale s " +
                "JOIN tbl_user  u ON s.user_id  = u.user_id " +
                "JOIN tbl_buyer b ON s.buyer_id = b.buyer_id " +
                "WHERE b.buyer_fname LIKE ? OR b.buyer_lname LIKE ? " +
                "   OR s.sale_date LIKE ? OR s.payment_status LIKE ? " +
                "ORDER BY s.sale_id DESC",
                tblSales, k, k, k, k);
        } else {
            int uid = Session.getInstance().getId();
            new config().displayData(
                "SELECT s.sale_id AS 'Sale #', " +
                "b.buyer_fname||' '||b.buyer_lname AS 'Buyer', " +
                "s.sale_date AS 'Date', " +
                "s.total_amount AS 'Total (₱)', " +
                "s.payment_status AS 'Payment' " +
                "FROM tbl_sale s " +
                "JOIN tbl_buyer b ON s.buyer_id = b.buyer_id " +
                "WHERE s.user_id = ? " +
                "  AND (b.buyer_fname LIKE ? OR s.sale_date LIKE ? OR s.payment_status LIKE ?) " +
                "ORDER BY s.sale_id DESC",
                tblSales, uid, k, k, k);
        }
 
        tblSales.setDefaultEditor(Object.class, null);
        applyPaymentRenderer();  // reapply renderer after data refresh
        updatePaymentSummary();  // update totals bar
    }
 
    // ─────────────────────────────────────────────────────────────────────────
    //  Update payment summary label (Paid total vs Unpaid total)
    // ─────────────────────────────────────────────────────────────────────────
    private void updatePaymentSummary() {
        try (Connection conn = config.connectDB()) {
            String sql;
            if ("admin".equalsIgnoreCase(Session.getInstance().getType())) {
                sql = "SELECT " +
                      "COALESCE(SUM(CASE WHEN payment_status='Paid' THEN total_amount ELSE 0 END),0) AS paid_total, " +
                      "COALESCE(SUM(CASE WHEN payment_status='Unpaid' THEN total_amount ELSE 0 END),0) AS unpaid_total, " +
                      "COUNT(CASE WHEN payment_status='Unpaid' THEN 1 END) AS unpaid_count " +
                      "FROM tbl_sale";
            } else {
                sql = "SELECT " +
                      "COALESCE(SUM(CASE WHEN payment_status='Paid' THEN total_amount ELSE 0 END),0) AS paid_total, " +
                      "COALESCE(SUM(CASE WHEN payment_status='Unpaid' THEN total_amount ELSE 0 END),0) AS unpaid_total, " +
                      "COUNT(CASE WHEN payment_status='Unpaid' THEN 1 END) AS unpaid_count " +
                      "FROM tbl_sale WHERE user_id = " + Session.getInstance().getId();
            }
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()) {
                double paidTotal   = rs.getDouble("paid_total");
                double unpaidTotal = rs.getDouble("unpaid_total");
                int    unpaidCount = rs.getInt("unpaid_count");
 
                lblSummary.setText(String.format(
                    "  ✔ Paid: ₱ %,.2f    |    ⚠ Unpaid: ₱ %,.2f  (%d transaction%s)   ",
                    paidTotal, unpaidTotal,
                    unpaidCount, unpaidCount == 1 ? "" : "s"));
 
                lblSummary.setForeground(unpaidCount > 0
                    ? new Color(255,204,204)
                    : new Color(255,204,204));
            }
        } catch (SQLException ex) {
            lblSummary.setText("  Could not load payment summary.");
        }
    }
 
    // ─────────────────────────────────────────────────────────────────────────
    //  Load items for selected sale row
    // ─────────────────────────────────────────────────────────────────────────
    private void loadItemsForSale() {
        int row = tblSales.getSelectedRow();
        if (row < 0) return;
 
        int saleId = Integer.parseInt(tblSales.getValueAt(row, 0).toString());
 
        new config().displayData(
            "SELECT f.fish_name AS 'Fish Type', " +
            "si.quantity_kg AS 'Qty (kg)', " +
            "si.price_per_kg AS 'Price/kg (₱)', " +
            "si.subtotal AS 'Subtotal (₱)' " +
            "FROM tbl_sale_item si " +
            "JOIN tbl_fish_type f ON si.fish_type_id = f.fish_type_id " +
            "WHERE si.sale_id = ?",
            tblItems, saleId);
        tblItems.setDefaultEditor(Object.class, null);
 
        int colCount = tblSales.getColumnCount();
        String total  = tblSales.getValueAt(row, colCount - 2) != null
                        ? tblSales.getValueAt(row, colCount - 2).toString() : "0";
        String buyer  = tblSales.getValueAt(row, colCount - 4) != null
                        ? tblSales.getValueAt(row, colCount - 4).toString() : "";
        String status = tblSales.getValueAt(row, colCount - 1).toString().trim();
 
        lblItemsTitle.setText("  Items for Sale #" + saleId + "  —  Buyer: " + buyer
                              + "  |  Status: " + status);
        lblItemTotal.setText("  TOTAL:  ₱ " + total + "   ");
        lblItemTotal.setForeground("Unpaid".equalsIgnoreCase(status)
            ? new Color(160, 0, 0) : new Color(0, 100, 0));
    }
 
    // ── Style helper ──────────────────────────────────────────────────────────
    private void styleBtn(JButton b, Color bg) {
        b.setBackground(bg);
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Segoe UI", Font.BOLD, 12));
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        jPanel3 = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        lblItemTotal = new javax.swing.JLabel();
        lblWelcome1 = new javax.swing.JLabel();
        lblItemsTitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnMarkPaid = new javax.swing.JButton();
        lblSummary = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(229, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 30));
        jPanel2.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 190, 30));

        btnSearch.setText("SEARCH");
        jPanel2.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, 30));

        tblSales.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 860, 140));

        jPanel3.setBackground(new java.awt.Color(8, 66, 124));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setBackground(new java.awt.Color(255, 204, 204));
        back.setText("BACK TO DASHBOARD");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel3.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, -1, 40));

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("SALE HISTORY");
        jPanel3.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/l.png"))); // NOI18N
        jLabel5.setText("jLabel2");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 80));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 100));

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
        lblWelcome1.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome1.setText("Welcome");
        jPanel4.add(lblWelcome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblItemsTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblItemsTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblItemsTitle.setText("Items for Sale #");
        jPanel4.add(lblItemsTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 550, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/log.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 240));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 860, 240));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/log.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 900, 440));

        btnMarkPaid.setBackground(new java.awt.Color(204, 0, 0));
        btnMarkPaid.setText("MARK AS PAID");
        btnMarkPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarkPaidActionPerformed(evt);
            }
        });
        jPanel2.add(btnMarkPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));

        lblSummary.setForeground(new java.awt.Color(255, 204, 204));
        lblSummary.setText("jLabel4");
        jPanel2.add(lblSummary, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 400, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/log.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 900, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
        if ("admin".equalsIgnoreCase(Session.getInstance().getType()))
            new AdminDashboard().setVisible(true);
        else
            new UserDashboard().setVisible(true); 
    }//GEN-LAST:event_backActionPerformed

    private void btnMarkPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarkPaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMarkPaidActionPerformed
    
 

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) { }
        java.awt.EventQueue.invokeLater(() -> new SalesHistory().setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton btnMarkPaid;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JLabel lblSummary;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblWelcome1;
    private javax.swing.JTable tblItems;
    private javax.swing.JTable tblSales;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
