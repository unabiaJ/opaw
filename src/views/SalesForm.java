/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import config.config;
import config.Session;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class SalesForm extends javax.swing.JFrame {

    // Each item: [fish_type_id, fish_name, qty, price, subtotal]
    private ArrayList<Object[]> items = new ArrayList<>();

    public SalesForm() {
        initComponents();
        setLocationRelativeTo(null);
        loadBuyers();
        loadFishTypes();
        updateTotal();
    }

    private void loadBuyers() {
        cmbBuyer.removeAllItems();
        try (java.sql.Connection conn = config.connectDB();
             java.sql.Statement st = conn.createStatement();
             java.sql.ResultSet rs = st.executeQuery(
                "SELECT buyer_id, buyer_fname||' '||buyer_lname AS name FROM tbl_buyer WHERE buyer_status='Active' ORDER BY buyer_fname")) {
            while (rs.next()) cmbBuyer.addItem(rs.getInt("buyer_id") + " - " + rs.getString("name"));
        } catch (java.sql.SQLException ex) { }
    }

    private void loadFishTypes() {
        cmbFish.removeAllItems();
        try (java.sql.Connection conn = config.connectDB();
             java.sql.Statement st = conn.createStatement();
             java.sql.ResultSet rs = st.executeQuery(
                "SELECT fish_type_id, fish_name FROM tbl_fish_type ORDER BY fish_name")) {
            while (rs.next()) cmbFish.addItem(rs.getInt("fish_type_id") + " - " + rs.getString("fish_name"));
        } catch (java.sql.SQLException ex) { }
    }

    private void updateTotal() {
        double total = 0;
        for (Object[] r : items) total += (Double) r[4];
        lblTotal.setText(String.format("TOTAL:  ₱ %.2f", total));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        goBack = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        txtPrice = new javax.swing.JTextField();
        addItemToList = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        cmbFish = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();
        save = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbBuyer = new javax.swing.JComboBox<>();
        cmbPayment = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        goBack.setBackground(new java.awt.Color(255, 204, 204));
        goBack.setText("Go back to Dashboard");
        goBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackActionPerformed(evt);
            }
        });
        jPanel2.add(goBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 50));

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 640, -1));
        jPanel3.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 230, -1));

        addItemToList.setBackground(new java.awt.Color(51, 204, 0));
        addItemToList.setText("Add Item to List");
        addItemToList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemToListActionPerformed(evt);
            }
        });
        jPanel3.add(addItemToList, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 230, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Quantity kg:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Price per kg:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, 20));

        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });
        jPanel3.add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 230, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ADD FISH ITEM");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fish Type:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jButton5.setBackground(new java.awt.Color(204, 0, 0));
        jButton5.setText("Remove Item");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 230, -1));

        cmbFish.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cmbFish, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 560, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 660, 140));

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fish Type", "Quantity", "Price", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(tblItems);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 660, 70));

        save.setBackground(new java.awt.Color(0, 102, 255));
        save.setText("SAVE TRANSACTION");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 660, -1));

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTotal.setText("TOTAL:");
        jPanel4.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 160, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 660, 30));

        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });
        jPanel1.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 130, -1));

        jLabel3.setText("Sale Date:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        jLabel6.setText("Payment Status:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));

        jLabel7.setText("Buyer:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        cmbBuyer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbBuyer, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 150, -1));

        cmbPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paid", "Unpaid", " " }));
        jPanel1.add(cmbPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyActionPerformed

    private void goBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackActionPerformed
        if ("admin".equalsIgnoreCase(Session.getInstance().getType()))
            { dispose(); new SalesHistory().setVisible(true); }
        else
            { dispose(); new UserDashboard().setVisible(true); }    }//GEN-LAST:event_goBackActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
    
        if (cmbBuyer.getSelectedItem() == null) { javax.swing.JOptionPane.showMessageDialog(this, "Please select a buyer."); return; }
        if (items.isEmpty()) { javax.swing.JOptionPane.showMessageDialog(this, "Please add at least one fish item."); return; }
        if (txtDate.getText().trim().isEmpty()) { javax.swing.JOptionPane.showMessageDialog(this, "Please enter a sale date."); return; }

        int buyerId = Integer.parseInt(cmbBuyer.getSelectedItem().toString().split(" - ")[0]);
        int userId  = Session.getInstance().getId();
        String date = txtDate.getText().trim();
        String pay  = cmbPayment.getSelectedItem().toString();
        double total = 0; for (Object[] r : items) total += (Double) r[4];

        try (java.sql.Connection conn = config.connectDB()) {
            conn.setAutoCommit(false);
            // Insert sale header
            java.sql.PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO tbl_sale (buyer_id,user_id,sale_date,total_amount,payment_status) VALUES (?,?,?,?,?)",
                java.sql.Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, buyerId); ps.setInt(2, userId); ps.setString(3, date);
            ps.setDouble(4, total); ps.setString(5, pay);
            ps.executeUpdate();
            java.sql.ResultSet keys = ps.getGeneratedKeys();
            int saleId = 0;
            if (keys.next()) saleId = keys.getInt(1);

            // Insert each item
            java.sql.PreparedStatement ps2 = conn.prepareStatement(
                "INSERT INTO tbl_sale_item (sale_id,fish_type_id,quantity_kg,price_per_kg,subtotal) VALUES (?,?,?,?,?)");
            for (Object[] r : items) {
                ps2.setInt(1, saleId); ps2.setInt(2, (int) r[0]);
                ps2.setDouble(3, (Double) r[2]); ps2.setDouble(4, (Double) r[3]); ps2.setDouble(5, (Double) r[4]);
                ps2.addBatch();
            }
            ps2.executeBatch();
            conn.commit();
            javax.swing.JOptionPane.showMessageDialog(this, "Transaction saved successfully!");
            dispose();
            // Go to sales history after saving
            if ("admin".equalsIgnoreCase(Session.getInstance().getType()))
                new SalesHistory().setVisible(true);
            else
                new UserDashboard().setVisible(true);
        } catch (java.sql.SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error saving: " + ex.getMessage());
        }
            }//GEN-LAST:event_saveActionPerformed

    private void addItemToListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemToListActionPerformed
        String fishSel = (String) cmbFish.getSelectedItem();
        if (fishSel == null) { javax.swing.JOptionPane.showMessageDialog(this, "Please select a fish type."); return; }
        double qty, price;
        try {
            qty   = Double.parseDouble(txtQty.getText().trim());
            price = Double.parseDouble(txtPrice.getText().trim());
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Quantity and Price must be valid numbers."); return;
        }
        if (qty <= 0 || price <= 0) { javax.swing.JOptionPane.showMessageDialog(this, "Qty and Price must be > 0."); return; }

        int fishId   = Integer.parseInt(fishSel.split(" - ")[0]);
        String fishName = fishSel.substring(fishSel.indexOf(" - ") + 3);
        double sub = qty * price;

        items.add(new Object[]{fishId, fishName, qty, price, sub});

        javax.swing.table.DefaultTableModel m = (javax.swing.table.DefaultTableModel) tblItems.getModel();
        m.addRow(new Object[]{fishName, qty, price, String.format("%.2f", sub)});

        txtQty.setText(""); txtPrice.setText("");
        updateTotal();        updateTotal();    }//GEN-LAST:event_addItemToListActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int row = tblItems.getSelectedRow();
        if (row < 0) { javax.swing.JOptionPane.showMessageDialog(this, "Select an item to remove."); return; }
        items.remove(row);
        ((javax.swing.table.DefaultTableModel) tblItems.getModel()).removeRow(row);
        updateTotal();    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try { for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) { if ("Nimbus".equals(info.getName())) { javax.swing.UIManager.setLookAndFeel(info.getClassName()); break; } } } catch (Exception ex) { }
        java.awt.EventQueue.invokeLater(() -> new SalesForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemToList;
    private javax.swing.JComboBox<String> cmbBuyer;
    private javax.swing.JComboBox<String> cmbFish;
    private javax.swing.JComboBox<String> cmbPayment;
    private javax.swing.JButton goBack;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JButton save;
    private javax.swing.JTable tblItems;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQty;
    // End of variables declaration//GEN-END:variables
}
