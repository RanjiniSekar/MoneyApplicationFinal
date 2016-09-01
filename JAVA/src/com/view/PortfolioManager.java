package com.view;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author csavas
 */
public class PortfolioManager extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    public PortfolioManager() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        PMPlatformTabbedPane = new javax.swing.JTabbedPane();
        PendingOrders = new javax.swing.JPanel();
        PendingOrderRequests = new javax.swing.JScrollPane();
        PMPendingOrdersTable = new javax.swing.JTable();
        PMPendingOrderFilter = new javax.swing.JButton();
        FilterOptionsPMPending = new javax.swing.JComboBox<>();
        FilterTextPMPending = new javax.swing.JTextField();
        PMEOD = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PMEODBoughtScrollPane = new javax.swing.JScrollPane();
        PMEODBoughtTable = new javax.swing.JTable();
        PMEODSoldScrollPane = new javax.swing.JScrollPane();
        PMEODSoldTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        FilterTextPMEOD = new javax.swing.JTextField();
        FilterOptionsPMEOD = new javax.swing.JComboBox<>();
        PMEODFilter = new javax.swing.JButton();
        CreateOrder = new javax.swing.JPanel();
        PMSendOrderScrollPane = new javax.swing.JScrollPane();
        PMSendOrderTable = new javax.swing.JTable();
        PMSendOrder = new javax.swing.JButton();
        PMAddOrderRow = new javax.swing.JButton();
        PMOrderHistory = new javax.swing.JPanel();
        PMOrderHistoryScrollPane = new javax.swing.JScrollPane();
        PMOrderHistoryTable = new javax.swing.JTable();
        FilterTextPMOrderHistory = new javax.swing.JTextField();
        FilterOptionsPMOrderHistory = new javax.swing.JComboBox<>();
        PMOrderHistoryFilter = new javax.swing.JButton();
        ChangePassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Portfolio Manager Platform");
        setMinimumSize(new java.awt.Dimension(1024, 768));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        PMPlatformTabbedPane.setMinimumSize(new java.awt.Dimension(150, 65));

        PMPendingOrdersTable.setBackground(new java.awt.Color(240, 240, 240));
        PMPendingOrdersTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        String[] CurrencyValues = {"USD", "GBP"};
        PMPendingOrdersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Portfolio ID", "Symbol", "Quantity", "Action", "Stop Price", "Limit Price", "Account Type", "Order Type", "Assigned To", "Status", "Stock Exchange"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        PMPendingOrdersTable.setGridColor(new java.awt.Color(255, 255, 255));
        PMPendingOrdersTable.getTableHeader().setReorderingAllowed(false);
        PendingOrderRequests.setViewportView(PMPendingOrdersTable);

        PMPendingOrderFilter.setText("Filter");

        FilterOptionsPMPending.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Order ID", "Portfolio ID", "Symbol", "Quantity", "Action", "Stop Price", "Limit Price", "Account Type", "Order Type", "Assigned To" }));

        FilterTextPMPending.setText("Filter Text");

        javax.swing.GroupLayout PendingOrdersLayout = new javax.swing.GroupLayout(PendingOrders);
        PendingOrders.setLayout(PendingOrdersLayout);
        PendingOrdersLayout.setHorizontalGroup(
            PendingOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PendingOrdersLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PendingOrderRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(PendingOrdersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FilterTextPMPending, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(FilterOptionsPMPending, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PMPendingOrderFilter)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PendingOrdersLayout.setVerticalGroup(
            PendingOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PendingOrdersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PendingOrderRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PendingOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FilterTextPMPending, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FilterOptionsPMPending, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PMPendingOrderFilter))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PMPlatformTabbedPane.addTab("Pending Order Requests", PendingOrders);

        jLabel2.setText("Bought");

        PMEODBoughtTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Portfolio ID", "Symbol", "Quantity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        PMEODBoughtScrollPane.setViewportView(PMEODBoughtTable);

        PMEODSoldTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Portfolio ID", "Symbol", "Quantity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        PMEODSoldScrollPane.setViewportView(PMEODSoldTable);

        jLabel3.setText("Sold");

        FilterTextPMEOD.setText("Filter By");

        FilterOptionsPMEOD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Portfolio ID", "Symbol", "Quantity", "Price" }));

        PMEODFilter.setText("Filter");

        javax.swing.GroupLayout PMEODLayout = new javax.swing.GroupLayout(PMEOD);
        PMEOD.setLayout(PMEODLayout);
        PMEODLayout.setHorizontalGroup(
            PMEODLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PMEODLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(PMEODLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PMEODLayout.createSequentialGroup()
                        .addComponent(FilterTextPMEOD, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(FilterOptionsPMEOD, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PMEODFilter))
                    .addGroup(PMEODLayout.createSequentialGroup()
                        .addGroup(PMEODLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PMEODLayout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jLabel2))
                            .addComponent(PMEODBoughtScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PMEODLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PMEODSoldScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PMEODLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(132, 132, 132)))))
                .addGap(118, 118, 118))
        );
        PMEODLayout.setVerticalGroup(
            PMEODLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PMEODLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PMEODLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PMEODLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(PMEODBoughtScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PMEODLayout.createSequentialGroup()
                        .addGroup(PMEODLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PMEODSoldScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(PMEODLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PMEODFilter)
                    .addComponent(FilterOptionsPMEOD, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FilterTextPMEOD, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PMPlatformTabbedPane.addTab("EOD", PMEOD);

        PMSendOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Portfolio ID", "Symbol", "Quantity", "Action", "Stop Price", "Limit Price", "Account Type", "Order Type", "Assign To", "Stock Exchange"
            }
        ));
        TableColumn col = PMSendOrderTable.getColumnModel().getColumn(9);
        col.setCellEditor(new myComboBoxEditor(TraderNames));
        col.setCellRenderer(new MyComboBoxRenderer(TraderNames));
        TableColumn col2 = PMSendOrderTable.getColumnModel().getColumn(10);
        col2.setCellEditor(new myComboBoxEditor(StockExchange));
        col2.setCellRenderer(new MyComboBoxRenderer(StockExchange));
        PMSendOrderScrollPane.setViewportView(PMSendOrderTable);

        PMSendOrder.setText("Send Order");
        PMSendOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PMSendOrderActionPerformed(evt);
            }
        });

        PMAddOrderRow.setText("Add Row");

        javax.swing.GroupLayout CreateOrderLayout = new javax.swing.GroupLayout(CreateOrder);
        CreateOrder.setLayout(CreateOrderLayout);
        CreateOrderLayout.setHorizontalGroup(
            CreateOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PMSendOrderScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreateOrderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CreateOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PMSendOrder, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PMAddOrderRow, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        CreateOrderLayout.setVerticalGroup(
            CreateOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateOrderLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(PMSendOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PMSendOrderScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(PMAddOrderRow)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PMPlatformTabbedPane.addTab("Create Order", CreateOrder);

        PMOrderHistoryTable.setBackground(new java.awt.Color(240, 240, 240));
        PMOrderHistoryTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PMOrderHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Portfolio ID", "Symbol", "Quantity", "Action", "Stop Price", "Limit Price", "Account Type", "Order Type", "Assigned To", "Stock Exchange"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        PMOrderHistoryTable.setGridColor(new java.awt.Color(255, 255, 255));
        PMOrderHistoryTable.getTableHeader().setReorderingAllowed(false);
        PMOrderHistoryScrollPane.setViewportView(PMOrderHistoryTable);

        FilterTextPMOrderHistory.setText("Filter By");

        FilterOptionsPMOrderHistory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Order ID", "Portfolio ID", "Symbol", "Quantity", "Action", "Stop Price", "Limit Price", "Account Type", "Order Type", "Assigned To" }));

        PMOrderHistoryFilter.setText("Filter");

        javax.swing.GroupLayout PMOrderHistoryLayout = new javax.swing.GroupLayout(PMOrderHistory);
        PMOrderHistory.setLayout(PMOrderHistoryLayout);
        PMOrderHistoryLayout.setHorizontalGroup(
            PMOrderHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PMOrderHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PMOrderHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PMOrderHistoryScrollPane)
                    .addGroup(PMOrderHistoryLayout.createSequentialGroup()
                        .addComponent(FilterTextPMOrderHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(FilterOptionsPMOrderHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PMOrderHistoryFilter)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PMOrderHistoryLayout.setVerticalGroup(
            PMOrderHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PMOrderHistoryLayout.createSequentialGroup()
                .addComponent(PMOrderHistoryScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PMOrderHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FilterTextPMOrderHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FilterOptionsPMOrderHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PMOrderHistoryFilter))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PMPlatformTabbedPane.addTab("Order History", PMOrderHistory);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipady = 127;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 85);
        getContentPane().add(PMPlatformTabbedPane, gridBagConstraints);

        ChangePassword.setText("Change Password");
        ChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangePasswordActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 610, 0, 85);
        getContentPane().add(ChangePassword, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PMSendOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PMSendOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PMSendOrderActionPerformed

    private void ChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangePasswordActionPerformed
        new ChangePassword().setVisible(true);
    }//GEN-LAST:event_ChangePasswordActionPerformed
private class myComboBoxEditor extends DefaultCellEditor {
    myComboBoxEditor(String[] items) {
        super(new JComboBox(items));
    }
}
private class MyComboBoxRenderer extends JComboBox implements TableCellRenderer {
    public MyComboBoxRenderer(String[] items) {
        super(items);
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            super.setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }
        setSelectedItem(value);
        return this;
    }
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
            javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            /*for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }*/
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PortfolioManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PortfolioManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PortfolioManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PortfolioManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PortfolioManager().setVisible(true);
            }
        });
    }
    //Trader Names and Currency Strings
    String[] TraderNames = {"Trader 1","Trader 2"};
    String[] StockExchange = {"New York Exchange","London Stock Exchange"};
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChangePassword;
    private javax.swing.JPanel CreateOrder;
    private javax.swing.JComboBox<String> FilterOptionsPMEOD;
    private javax.swing.JComboBox<String> FilterOptionsPMOrderHistory;
    private javax.swing.JComboBox<String> FilterOptionsPMPending;
    private javax.swing.JTextField FilterTextPMEOD;
    private javax.swing.JTextField FilterTextPMOrderHistory;
    private javax.swing.JTextField FilterTextPMPending;
    private javax.swing.JButton PMAddOrderRow;
    private javax.swing.JPanel PMEOD;
    private javax.swing.JScrollPane PMEODBoughtScrollPane;
    private javax.swing.JTable PMEODBoughtTable;
    private javax.swing.JButton PMEODFilter;
    private javax.swing.JScrollPane PMEODSoldScrollPane;
    private javax.swing.JTable PMEODSoldTable;
    private javax.swing.JPanel PMOrderHistory;
    private javax.swing.JButton PMOrderHistoryFilter;
    private javax.swing.JScrollPane PMOrderHistoryScrollPane;
    private javax.swing.JTable PMOrderHistoryTable;
    private javax.swing.JButton PMPendingOrderFilter;
    private javax.swing.JTable PMPendingOrdersTable;
    private javax.swing.JTabbedPane PMPlatformTabbedPane;
    private javax.swing.JButton PMSendOrder;
    private javax.swing.JScrollPane PMSendOrderScrollPane;
    private javax.swing.JTable PMSendOrderTable;
    private javax.swing.JScrollPane PendingOrderRequests;
    private javax.swing.JPanel PendingOrders;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
