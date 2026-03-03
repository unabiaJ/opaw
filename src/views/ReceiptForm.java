package views;

import config.config;
import config.Session;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ReceiptForm extends javax.swing.JFrame {

    private final int saleId;

    public ReceiptForm(int saleId) {
        this.saleId = saleId;
        initComponents();
        // Set font to Monospaced so columns align perfectly
        txtReceipt.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
        setLocationRelativeTo(null);
        loadReceipt(); // This will populate the text and the title label
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblReceiptTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        goBack = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        printReceipt = new javax.swing.JButton();
        btnNewSale = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReceipt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblReceiptTitle.setText("Receipt #\" + saleId + \"   |   Date: \" + date + \"   |   \" + payment");
        jPanel1.add(lblReceiptTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 350, -1));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        goBack.setBackground(new java.awt.Color(255, 204, 204));
        goBack.setText("Go back to Dashboard");
        goBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackActionPerformed(evt);
            }
        });
        jPanel2.add(goBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("FISHSALE TRACKER");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("OFFICIAL SALES RECEIPT");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 90));

        printReceipt.setText("PRINT RECEIPT");
        printReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printReceiptActionPerformed(evt);
            }
        });
        jPanel1.add(printReceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, -1, 30));

        btnNewSale.setText("NEW SALE");
        btnNewSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewSaleActionPerformed(evt);
            }
        });
        jPanel1.add(btnNewSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 550, 100, 30));

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 550, 210, 30));

        txtReceipt.setColumns(20);
        txtReceipt.setRows(5);
        jScrollPane1.setViewportView(txtReceipt);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 750, 400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackActionPerformed
        dispose();
        if ("admin".equalsIgnoreCase(Session.getInstance().getType()))
        new SalesHistory().setVisible(true);
        else
        new UserDashboard().setVisible(true);
    }//GEN-LAST:event_goBackActionPerformed

    private void printReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printReceiptActionPerformed
        doPrint();
    }//GEN-LAST:event_printReceiptActionPerformed

    private void btnNewSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewSaleActionPerformed
        dispose();
        new SalesForm().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewSaleActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int c = javax.swing.JOptionPane.showConfirmDialog(this,
            "Are you sure you want to logout?", "Confirm Logout",
            javax.swing.JOptionPane.YES_NO_OPTION);
        if (c == javax.swing.JOptionPane.YES_OPTION) {
            Session.clearSession();
            dispose();
            new LoginForm().setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed
private void loadReceipt() {
        StringBuilder sb = new StringBuilder();
        String sep  = "==========================================================\n";
        String sep2 = "----------------------------------------------------------\n";

        try (java.sql.Connection conn = config.connectDB()) {
            java.sql.PreparedStatement ps = conn.prepareStatement(
                "SELECT s.sale_id, s.sale_date, s.total_amount, s.payment_status, " +
                "u.user_fname || ' ' || u.user_lname AS sold_by, " +
                "b.buyer_fname || ' ' || b.buyer_lname AS buyer_name " +
                "FROM tbl_sale s " +
                "JOIN tbl_user  u ON s.user_id  = u.user_id " +
                "JOIN tbl_buyer b ON s.buyer_id = b.buyer_id " +
                "WHERE s.sale_id = ?");
            ps.setInt(1, saleId);
            java.sql.ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String date    = rs.getString("sale_date");
                double total   = rs.getDouble("total_amount");
                String payment = rs.getString("payment_status");
                String soldBy  = rs.getString("sold_by");
                String buyer   = rs.getString("buyer_name");

                sb.append(sep).append("            FISHSALE TRACKER\n").append("         Official Sales Receipt\n").append(sep);
                sb.append(String.format("  Receipt No. : #%d\n", saleId));
                sb.append(String.format("  Date        : %s\n", date));
                sb.append(String.format("  Sold By     : %s\n", soldBy));
                sb.append(sep2).append("  BUYER: ").append(buyer).append("\n").append(sep2);
                sb.append(String.format("  %-20s %7s  %9s  %10s\n", "Fish Type", "Qty(kg)", "Price/kg", "Subtotal"));
                sb.append(sep2);

                java.sql.PreparedStatement ps2 = conn.prepareStatement(
                    "SELECT f.fish_name, si.quantity_kg, si.price_per_kg, si.subtotal " +
                    "FROM tbl_sale_item si " +
                    "JOIN tbl_fish_type f ON si.fish_type_id = f.fish_type_id " +
                    "WHERE si.sale_id = ?");
                ps2.setInt(1, saleId);
                java.sql.ResultSet rs2 = ps2.executeQuery();

                while (rs2.next()) {
                    sb.append(String.format("  %-20s %7.2f  %9.2f  %10.2f\n", 
                            rs2.getString("fish_name"), rs2.getDouble("quantity_kg"), 
                            rs2.getDouble("price_per_kg"), rs2.getDouble("subtotal")));
                }

                sb.append(sep2).append(String.format("  GRAND TOTAL:                           Ph %.2f\n", total)).append(sep);

                txtReceipt.setText(sb.toString());
                txtReceipt.setCaretPosition(0);
                lblReceiptTitle.setText("Receipt #\" + saleId + \"   |   Date: \" + date + \"   |   \" + payment");
            } else {
                txtReceipt.setText("Receipt not found for Sale #" + saleId);
            }
        } catch (java.sql.SQLException ex) {
            txtReceipt.setText("Database Error: " + ex.getMessage());
        }
    }

    private void doPrint() {
        try {
            // JTextArea has the .print() method
            boolean printed = txtReceipt.print();
            if (printed) {
                javax.swing.JOptionPane.showMessageDialog(this, "Print Job Sent Successfully!");
            }
        } catch (java.awt.print.PrinterException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Print Error: " + ex.getMessage());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ReceiptForm(1).setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNewSale;
    private javax.swing.JButton goBack;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblReceiptTitle;
    private javax.swing.JButton printReceipt;
    private javax.swing.JTextArea txtReceipt;
    // End of variables declaration//GEN-END:variables
}
