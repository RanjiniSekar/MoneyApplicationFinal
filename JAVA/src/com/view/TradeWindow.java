package com.view;

import TestModules.JTableDataPopulation.JsonParsing;
import UserObjects.Block;
import UserObjects.Broker;
import UserObjects.SingleOrder;
import com.controller.CMAIN;
import com.controller.CPMOrderHistory;
import com.controller.CPMOrderMANIAC;

import com.controller.CTraderBlockOrder;
import com.controller.CTraderGetAllBrokers;
import com.controller.CTraderOrderMANIAC;
import com.controller.CTraderPendingRequest;
import com.controller.ControllerBlockOrders;
import com.controller.ControllerPMCreatedOrders;
import com.google.gson.Gson;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import org.json.JSONException;
import org.json.JSONObject;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
/**
 *
 * @author agopa3
 */
public class TradeWindow extends javax.swing.JFrame {
    
    
    /**
     * Creates new form TradeWindow
     */
    public TradeWindow() {
        super();
        //The following line is for the exit confirmation
         
        addWindowListener( new AreYouSure() );
        initComponents();

        //START TIMER TO UPDATE ORDERS
        Timer timer = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<SingleOrder> ordersDone = new ArrayList<>();
                ArrayList<SingleOrder> pendingOrders = new ArrayList<>();
                ArrayList<Block> blockHistory = new ArrayList<>();
                
                //MAKE PENDING ORDERS FROM PM UPDATE
                try {
                    ordersDone = (ArrayList) CTraderOrderMANIAC.updateOrders();
                } catch (InterruptedException | IOException | JSONException | ExecutionException ex) {
                    Logger.getLogger(TradeWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //MAKE BLOCK ORDER HISTORY UPDATE
                try {
                    blockHistory = (ArrayList) CTraderOrderMANIAC.updateBlockOrderHistory();
                } catch (InterruptedException | ExecutionException | IOException | JSONException ex) {
                    Logger.getLogger(TradeWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if (null != ordersDone) {
                    for(SingleOrder o : ordersDone){
                        if(o.getStatus().equals("Pending")){
                            pendingOrders.add(o);
                        }
                    }
                    int currentlyInPendings = CTraderOrderMANIAC.getPendings().size();
                    int updatedPendings = pendingOrders.size();
                    System.out.println("Size of currentPend = " + currentlyInPendings + " and of updated: " + updatedPendings);
                    CTraderOrderMANIAC.setPendings(pendingOrders);                 
                    TraderIncomingRequestsTable.setModel(CTraderOrderMANIAC.getPRTableModel());
                    if(currentlyInPendings < updatedPendings){
                        showMessageDialog(null, "You have received new orders.");
                    }
                } else {
                    System.out.println("ERROR UPDATING ORDERS");
                }
                
                if(null != blockHistory){
                	CTraderOrderMANIAC.setBlockHistory(blockHistory);
                    
                	TraderBlockHistoryTable.setModel(CTraderOrderMANIAC.getBlockHistoryTableModel());
                } else {
                    System.out.println("ERROR UPDATING BLOCKS");
                }

            }
        });
        timer.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        timer.restart();

}

/**
 * This method is called from within the constructor to initialize the form.
 * WARNING: Do NOT modify this code. The content of this method is always
 * regenerated by the Form Editor.
 */
// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        test =  new JPanel();
        clearFilterBlockHistory = new javax.swing.JButton();
        clearFilterRequests = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        TraderPlatformTabbedPane = new javax.swing.JTabbedPane();
        TraderPlatformRequestsTab = new javax.swing.JPanel();
        TraderIncomingRequestsScrollPane = new javax.swing.JScrollPane();
        TraderIncomingRequestsTable = new javax.swing.JTable();
        TraderBlockOrders = new javax.swing.JButton();
        FilterOptionsTraderRequests = new javax.swing.JComboBox<>();
        FilterTextTraderRequests = new javax.swing.JTextField();
        TraderRequestsFilter = new javax.swing.JButton();
        TraderPlatformBlockedRequests = new javax.swing.JPanel();
        blockOptions = new javax.swing.JPanel();
        TraderSubmitBlocks = new javax.swing.JButton();
        selectBrokerLabel = new javax.swing.JLabel();
        TraderSelectAllBlocks = new javax.swing.JCheckBox();
        TraderSelectBrokerOptions = new javax.swing.JComboBox<>();
        TraderPlatformBlockOrderHistory = new javax.swing.JPanel();
        TraderBlockHistoryScrollPane = new javax.swing.JScrollPane();
        TraderBlockHistoryTable = new javax.swing.JTable();
        FilterTextTraderBlockHistory = new javax.swing.JTextField();
        FilterOptionsTraderBlockHistory = new javax.swing.JComboBox<>();
        TraderBlockHistoryFilter = new javax.swing.JButton();
        ChangePassword = new javax.swing.JButton();
        brokerListForBox = (ArrayList) CTraderGetAllBrokers.getBrokerList();
        blockMap = new HashMap<Integer,ArrayList<SingleOrder>>();
        cPanelList = new ArrayList<JPanel>();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trader Platform");
        setName("TraderPlatformFrame"); // NOI18N
        getContentPane().setLayout(new java.awt.GridBagLayout());
        logOutButton.setText("Logout");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logOutButton, new java.awt.GridBagConstraints());
        TraderPlatformTabbedPane.setName("TraderPlatformTabbedPane");

        TraderPlatformRequestsTab.setName("TraderPlatformRequestsTab"); // NOI18N

       /* TraderIncomingRequestsTable

.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Portfolio ID", "Symbol", "Quantity", "Action", "Stop Price", "Limit Price", "Stock Exchange", "Account Type", "Order Type", "Assigned By"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class

, java.lang.Long.class

, java.lang.String.class

, java.lang.Integer.class

, java.lang.String.class

, java.lang.Double.class

, java.lang.Double.class

, java.lang.String.class

, java.lang.String.class

, java.lang.String.class

, java.lang.Long.class

};

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });*/
        TraderIncomingRequestsScrollPane.setViewportView(TraderIncomingRequestsTable);

        TraderBlockOrders.setText("Block Orders");
        TraderBlockOrders.setActionCommand("BlockOrders()");
        TraderBlockOrders.setName("TraderBlockOrders"); // NOI18N
        TraderBlockOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TraderBlockOrdersActionPerformed(evt);
            }
        });

        FilterOptionsTraderRequests.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Order ID", "Portfolio ID", "Symbol", "Quantity", "Action", "Stop Price", "Limit Price", "Account Type", "Order Type", "Assigned By" }));
        FilterOptionsTraderRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterOptionsTraderRequestsActionPerformed(evt);
            }
        });

        FilterTextTraderRequests.setText("Filter By");
        FilterTextTraderRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterTextTraderRequestsActionPerformed(evt);
            }
        });

        TraderRequestsFilter.setText("Filter");
        TraderRequestsFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TraderRequestsFilterActionPerformed(evt);
            }
        });
        
        clearFilterRequests.setText("Clear Filter");
        clearFilterRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFilterActionPerformed(evt);
            }
        });
        

        javax.swing.GroupLayout TraderPlatformRequestsTabLayout = new javax.swing.GroupLayout(TraderPlatformRequestsTab);
        TraderPlatformRequestsTab.setLayout(TraderPlatformRequestsTabLayout);
        TraderPlatformRequestsTabLayout.setHorizontalGroup(TraderPlatformRequestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TraderPlatformRequestsTabLayout.createSequentialGroup()
                .addGroup(TraderPlatformRequestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TraderIncomingRequestsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                    .addGroup(TraderPlatformRequestsTabLayout.createSequentialGroup()
                        .addComponent(FilterTextTraderRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(FilterOptionsTraderRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TraderRequestsFilter)
                        .addGap(2, 2, 2)   
                        .addComponent(clearFilterRequests)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TraderBlockOrders)))
                .addContainerGap())
        );
        TraderPlatformRequestsTabLayout.setVerticalGroup(TraderPlatformRequestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TraderPlatformRequestsTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TraderIncomingRequestsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TraderPlatformRequestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TraderPlatformRequestsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FilterTextTraderRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FilterOptionsTraderRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TraderRequestsFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clearFilterRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TraderBlockOrders))
                .addContainerGap(318, Short.MAX_VALUE))
        );

        TraderPlatformTabbedPane.addTab("Requests", TraderPlatformRequestsTab);

        TraderSubmitBlocks.setText("Submit Selected Blocks");
        TraderSubmitBlocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TraderSubmitBlocksActionPerformed(evt);
            }
        });

        selectBrokerLabel.setText("Select Broker");

        TraderSelectAllBlocks.setText("Select All");
        TraderSelectAllBlocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TraderSelectAllBlocksActionPerformed(evt);
            }
        });
        
        
        
        TraderSelectBrokerOptions.setModel(new javax.swing.DefaultComboBoxModel<>(BrokerNames));
        TraderSelectBrokerOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TraderSelectBrokerOptionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(blockOptions);
        blockOptions.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TraderSelectAllBlocks)
                .addGap(136, 136, 136)
                .addComponent(selectBrokerLabel)
                .addGap(18, 18, 18)
                .addComponent(TraderSelectBrokerOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(TraderSubmitBlocks)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TraderSubmitBlocks)
                    .addComponent(TraderSelectAllBlocks)
                    .addComponent(selectBrokerLabel)
                    .addComponent(TraderSelectBrokerOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout TraderPlatformBlockedRequestsLayout = new javax.swing.GroupLayout(TraderPlatformBlockedRequests);
        TraderPlatformBlockedRequests.setLayout(TraderPlatformBlockedRequestsLayout);
        TraderPlatformBlockedRequestsLayout.setHorizontalGroup(
            TraderPlatformBlockedRequestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TraderPlatformBlockedRequestsLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(blockOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        TraderPlatformBlockedRequestsLayout.setVerticalGroup(
            TraderPlatformBlockedRequestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TraderPlatformBlockedRequestsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(blockOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(588, Short.MAX_VALUE))
        );

        TraderPlatformTabbedPane.addTab("Blocked Orders", TraderPlatformBlockedRequests);

        TraderBlockHistoryTable

.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Block ID", "Symbol", "Quantity", "Order Type", "Stop Price", "Limit Price", "Broker Assigned", "Status", "Stock Exchange"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class

, java.lang.String.class

, java.lang.Integer.class

, java.lang.String.class

, java.lang.Double.class

, java.lang.Double.class

, java.lang.String.class

, java.lang.String.class

, java.lang.String.class

};

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TraderBlockHistoryScrollPane.setViewportView(TraderBlockHistoryTable);

        FilterTextTraderBlockHistory.setText("Filter By");
        FilterTextTraderBlockHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterTextTraderBlockHistoryActionPerformed(evt);
            }
        });

        FilterOptionsTraderBlockHistory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Block ID", "Symbol", "Quantity", "Order Type", "Stop Price", "Limit Price", "Broker Assigned", "Status" }));
        FilterOptionsTraderBlockHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterOptionsTraderBlockHistoryActionPerformed(evt);
            }
        });

        TraderBlockHistoryFilter.setText("Filter");
        TraderBlockHistoryFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TraderBlockHistoryFilterActionPerformed(evt);
            }
        });
        
        clearFilterBlockHistory.setText("Clear Filter");
        clearFilterBlockHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFilterBlockHistoryActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout TraderPlatformBlockOrderHistoryLayout = new javax.swing.GroupLayout(TraderPlatformBlockOrderHistory);
        TraderPlatformBlockOrderHistory.setLayout(TraderPlatformBlockOrderHistoryLayout);
        TraderPlatformBlockOrderHistoryLayout.setHorizontalGroup(
            TraderPlatformBlockOrderHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TraderPlatformBlockOrderHistoryLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(TraderPlatformBlockOrderHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TraderPlatformBlockOrderHistoryLayout.createSequentialGroup()
                        .addComponent(FilterTextTraderBlockHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(FilterOptionsTraderBlockHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TraderBlockHistoryFilter)
                        .addGap(2, 2, 2)
                        .addComponent(clearFilterBlockHistory))
                    .addComponent(TraderBlockHistoryScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TraderPlatformBlockOrderHistoryLayout.setVerticalGroup(
            TraderPlatformBlockOrderHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TraderPlatformBlockOrderHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TraderBlockHistoryScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(TraderPlatformBlockOrderHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FilterTextTraderBlockHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FilterOptionsTraderBlockHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TraderBlockHistoryFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearFilterBlockHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(388, Short.MAX_VALUE))
        );

        TraderPlatformTabbedPane.addTab("Block Order History", TraderPlatformBlockOrderHistory);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 36;
        gridBagConstraints.ipady = -83;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 11, 10);
        getContentPane().add(TraderPlatformTabbedPane, gridBagConstraints);

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
        gridBagConstraints.insets = new java.awt.Insets(11, 607, 0, 10);
        getContentPane().add(ChangePassword, gridBagConstraints);

        pack();
    }// </editor-fold>                        
 
    /*public void SplitBlockActionPerformed(ActionEvent e, ArrayList<Integer> index,JPanel tempPane, JPanel tempPanel) {            
    	ArrayList<SingleOrder> temp = singleOrderLists.get(Integer.parseInt(((JComponent)e.getSource()).getName()));
    	ArrayList<SingleOrder> selected = new ArrayList<SingleOrder>();
    	//System.out.println(index);
    	for(int i=0;i<index.size();i++){
    		selected.add(temp.get(index.get(i)));
    		temp.remove(temp.get(index.get(i)));
    	}
    	tempPanel.remove(tempPane);
    	tempPanel.validate();
    	
    	JTable jTable = new JTable();
        jTable.setModel(CTraderBlockOrder.getTableModel(selected));
        Dimension d = jTable.getPreferredSize();
       // System.out.println(d);
        int rows = jTable.getRowCount();
       // System.out.println(rows);
        JScrollPane jPane=new JScrollPane();
        jPane.setPreferredSize(new Dimension(d.width,jTable.getRowHeight()*rows + 50));
        jPane.add(jTable);
        jPane.setViewportView(jTable);
        jPane.validate();
        JPanel tempPanel2 = new JPanel();
        tempPanel2.add(jTable);
        tempPanel2.validate();
    	tempPanel.add(tempPanel2);
    	tempPanel.validate();
    	System.out.println(selected);
    	System.out.println(temp);
    }
   */ 

    public void PopulateBlocks(int n){
        
        if(blockMap.containsKey(n)){
                
    		blockMap.remove(n);
                System.out.println("Removed from blocks::"+blockMap.toString());
        }
        else{
    		blockMap.put(n,singleOrderLists.get(n));
                System.out.println("Added to blocks::"+blockMap.toString());
        }
    }
    public void SelectBlockActionPerformed(ActionEvent e) {  
        if(!((JCheckBox)e.getSource()).isSelected()){
            TraderSelectAllBlocks.setSelected(false);
        }
    	int n = Integer.parseInt(((JComponent)e.getSource()).getName());
    	PopulateBlocks(n);
    }
    
    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        UserLogin u = new UserLogin();
        //u.setSize(300,300);
        u.setVisible (true);
        CMAIN.handleLogout();
      this.dispose();

    }               
    
    private void FilterTextTraderBlockHistoryActionPerformed(java.awt.event.ActionEvent evt) {                                                             
        // TODO add your handling code here:
    }                                                            

    private void FilterOptionsTraderBlockHistoryActionPerformed(java.awt.event.ActionEvent evt) {                                                                
        // TODO add your handling code here:
    }                                                               

    private void ChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {                                               
         new ChangePassword().setVisible(true);
    }                                              

    private void FilterOptionsTraderRequestsActionPerformed(java.awt.event.ActionEvent evt) {                                                            
        // TODO add your handling code here:
    }                                                           

    private void FilterTextTraderRequestsActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        // TODO add your handling code here:
    }                                                        

    public String[] blist() {    
        ArrayList<Broker> listOfBrokers = (ArrayList) CTraderGetAllBrokers.getBrokerList();
        ArrayList<String> listOfNames = new ArrayList<>();
        for (int i = 0; i < listOfBrokers.size(); i++) {
                String currName = listOfBrokers.get(i).getName();
                listOfNames.add(currName);
        }
        System.out.println(listOfNames);
        String[] b = new String[listOfNames.size()];
        b = listOfNames.toArray(b);
        return b;
    }

    //BROKER NAMESB
    String[] BrokerNames = blist();
    
    private void TraderBlockOrdersActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        TableModel dtm = (TableModel) TraderIncomingRequestsTable.getModel();
        int nRow = dtm.getRowCount();
        int nCol = dtm.getColumnCount();
        Object[][] tableData = new Object[nRow][nCol];
        ArrayList<SingleOrder> parsedOrders = new ArrayList();
        ControllerBlockOrders control = new ControllerBlockOrders();
        
        for(int i = 0; i < nRow; i++){
            for (int j = 0 ; j < nCol ; j++){
                tableData[i][j] = dtm.getValueAt(i,j);
            }
            SingleOrder o = new SingleOrder();
            o.SingleOrderMakeBlocks(tableData[i]);
            parsedOrders.add(o);                   
        }
        singleOrderLists = control.MakeBlock(parsedOrders);
        showMessageDialog(null, "Blocks have been successfully completed."); 
        //dtm.setRowCount(0);
        TraderPlatformBlockedRequests.setLayout(new BorderLayout());
        int count = 1;
        ArrayList<JScrollPane> paneList = new ArrayList<JScrollPane>();
        for(ArrayList<SingleOrder> b: singleOrderLists){
            JTable jTable = new JTable();
            jTable.setModel(CTraderBlockOrder.getTableModel(b));
            Dimension d = jTable.getPreferredSize();
           // System.out.println(d);
            int rows = jTable.getRowCount();
           // System.out.println(rows);
            JScrollPane jPane=new JScrollPane();
            jPane.setPreferredSize(new Dimension(d.width,jTable.getRowHeight()*rows + 50));
            jPane.add(jTable);
            jPane.setViewportView(jTable);
            paneList.add(jPane);
            count++;
        }
        
        
        test.add(blockOptions);
        int i=0;
        for(final JScrollPane j:paneList){          
        //	JButton btn = new JButton();
          //  btn.setText("Split Block");
       //     btn.setName(""+i);
           
            JPanel cPanel = new JPanel();
          /*  btn.addActionListener(new java.awt.event.ActionListener() {
             	public void actionPerformed(java.awt.event.ActionEvent evt) {
              		JViewport viewport = j.getViewport(); 
                    final JTable mytable = (JTable)viewport.getView();
                    final ArrayList<Integer> index = new ArrayList<Integer>();
                    for(int row = 0;row<mytable.getRowCount();row++){
                    		if((boolean)mytable.getValueAt(row, 11)){
                    			index.add(row);
                    		}
                    }
               		SplitBlockActionPerformed(evt,index,cPanel,test);
              	}
            });*/
            JCheckBox check = new JCheckBox();  
            JLabel label = new JLabel();
            label.setText("Select Block");
            check.setName(""+i);
            check.addActionListener(new java.awt.event.ActionListener() {
              	public void actionPerformed(java.awt.event.ActionEvent evt) {
               		SelectBlockActionPerformed(evt);
              	}
            });
            JPanel splitOptions = new JPanel();
            splitOptions.add(label);
            splitOptions.add(check);
            splitOptions.setName("splitOpt");
          //  splitOptions.add(btn);
            cPanel.setName("cPanel"+i);
            cPanel.add(splitOptions);
            cPanel.add(j);
            cPanel.setLayout(new BoxLayout(cPanel,BoxLayout.Y_AXIS));
            test.add(cPanel);
            cPanelList.add(cPanel);
            i++;
        } 
       
        test.setLayout(new BoxLayout(test,BoxLayout.Y_AXIS));
        JScrollPane p = new JScrollPane(test);
        p.setName("ParentP");
        TraderPlatformBlockedRequests.add(p);
        TraderPlatformBlockedRequests.validate();
        TraderPlatformTabbedPane.setSelectedIndex(TraderPlatformTabbedPane.getSelectedIndex()+1);
        
    }                                                 
           
    private void TraderRequestsFilterActionPerformed(java.awt.event.ActionEvent evt) {                                                     
            // TODO add your handling code here:
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TraderIncomingRequestsTable.getModel());
        TraderIncomingRequestsTable.setRowSorter(sorter);
        String text = FilterTextTraderRequests.getText();
        if (text.length() == 0) {
          sorter.setRowFilter(null);
        } else {
          sorter.setRowFilter(RowFilter.regexFilter(text));
        }
        
    }                                                    

    private void clearFilterActionPerformed(java.awt.event.ActionEvent evt) {                                                     
            // TODO add your handling code here:
        
        FilterTextTraderRequests.setText("");
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TraderIncomingRequestsTable.getModel());
        TraderIncomingRequestsTable.setRowSorter(sorter);
        sorter.setRowFilter(null);
        
        
    }      
    
    private void clearFilterBlockHistoryActionPerformed(java.awt.event.ActionEvent evt) {                                                     
            // TODO add your handling code here:
        FilterTextTraderBlockHistory.setText("");
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TraderBlockHistoryTable.getModel());
        TraderBlockHistoryTable.setRowSorter(sorter);
        sorter.setRowFilter(null);
        
        
    }   
    
    private void TraderBlockHistoryFilterActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TraderBlockHistoryTable.getModel());
        TraderBlockHistoryTable.setRowSorter(sorter);
        String text = FilterTextTraderBlockHistory.getText();
        if (text.length() == 0) {
          sorter.setRowFilter(null);
        } else {
          sorter.setRowFilter(RowFilter.regexFilter(text));
        }
    }                                                        

    private void TraderSelectBrokerOptionsActionPerformed(java.awt.event.ActionEvent evt) {                                                          
        // TODO add your handling code here:
    }                                                         

    private void TraderSelectAllBlocksActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        
        for(JPanel j: cPanelList){
           Component[] c = j.getComponents(); 
           for(Component singleC:c){
               if(singleC.getName()==null){
                   continue;
               }
               else if(singleC.getName().equals("splitOpt")){
                   JPanel p = (JPanel)singleC;
                   if(!TraderSelectAllBlocks.isSelected()){                       
                        ((JCheckBox)p.getComponent(1)).setSelected(false);
                        int n = Integer.parseInt(((JCheckBox)p.getComponent(1)).getName());
                        PopulateBlocks(n);
                   }
                   else{   
                        if(!((JCheckBox)p.getComponent(1)).isSelected()){
                            ((JCheckBox)p.getComponent(1)).setSelected(true);
                            int n = Integer.parseInt(((JCheckBox)p.getComponent(1)).getName());
                            PopulateBlocks(n);
                        }
                    }
               }
               
           }
        }
    }                                                     

    private void TraderSubmitBlocksActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        //GET OUR TRADER USER INFO
        long ourUID = CMAIN.reportUser().getU_id();
    	//System.out.println(blockMap);
    	int index = TraderSelectBrokerOptions.getSelectedIndex();
    	Broker br = brokerListForBox.get(index);
        long b_id = br.getBrokerId();
        String b_name = br.getName();
    	String b_email = br.getEmail();
        System.out.println("Broker name: " + b_name + " and email: " + b_email );
    	Gson gson = new Gson();
    	String json = "";
    	ArrayList<Block> blockList  = new ArrayList<Block>();
        ArrayList<Integer> blockNoList = new ArrayList<Integer>(); 
    	for (Map.Entry<Integer, ArrayList<SingleOrder>> entry : blockMap.entrySet()){
    		ArrayList<SingleOrder> temp = entry.getValue();
                blockNoList.add(entry.getKey());
    		int quantity=0;
    		for(SingleOrder a : temp){
                        System.out.println("THIS ONE CEREN: " + a.getSingleOrderId());
    			quantity = quantity + a.getQuantity();
    		}
    		Block b = new Block(ourUID, b_id, b_name, b_email,temp.get(0).getSymbol(),quantity,temp.get(0).getOrderType(),temp.get(0).getStatus(),temp,temp.get(0).getStockExchange());
                blockList.add(b);
    	}
    	json = gson.toJson(blockList);
    	System.out.println(json);
        CTraderOrderMANIAC.sendBlockList(json); 
        for(Integer i:blockNoList){
            test.remove(cPanelList.get(i));
            
        }
        test.validate();
    }  
    
    //Code for giving a pop up box for exit confirmation
    private class AreYouSure extends WindowAdapter {  
        public void windowClosing( WindowEvent e ) {  
            int option = JOptionPane.showOptionDialog(  
                    TradeWindow.this,  
                    "Are you sure you want to quit?",  
                    "Exit Dialog", JOptionPane.YES_NO_OPTION,  
                    JOptionPane.WARNING_MESSAGE, null, null,  
                    null );  
            if( option == JOptionPane.YES_OPTION ) {  
                dispose();  
            } 
            else{
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
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
            /*
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }*/
        

} catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TradeWindow.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TradeWindow.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TradeWindow.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TradeWindow.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TradeWindow().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify     
    private JPanel test;
    private javax.swing.JButton ChangePassword;
    private ArrayList<JPanel> cPanelList;
    private javax.swing.JComboBox<String> FilterOptionsTraderBlockHistory;
    private javax.swing.JComboBox<String> FilterOptionsTraderRequests;
    private javax.swing.JTextField FilterTextTraderBlockHistory;
    private javax.swing.JTextField FilterTextTraderRequests;
    private javax.swing.JButton TraderBlockHistoryFilter;
    private javax.swing.JScrollPane TraderBlockHistoryScrollPane;
    private javax.swing.JTable TraderBlockHistoryTable;
    private javax.swing.JButton TraderBlockOrders;
    private javax.swing.JScrollPane TraderIncomingRequestsScrollPane;
    private javax.swing.JTable TraderIncomingRequestsTable;
    private javax.swing.JPanel TraderPlatformBlockOrderHistory;
    private javax.swing.JPanel TraderPlatformBlockedRequests;
    private javax.swing.JPanel TraderPlatformRequestsTab;
    private javax.swing.JTabbedPane TraderPlatformTabbedPane;
    private javax.swing.JButton TraderRequestsFilter;
    private javax.swing.JCheckBox TraderSelectAllBlocks;
    private javax.swing.JComboBox<String> TraderSelectBrokerOptions;
    private javax.swing.JButton TraderSubmitBlocks;
    private javax.swing.JLabel selectBrokerLabel;
    private javax.swing.JPanel blockOptions;
    private ArrayList<ArrayList<SingleOrder>> singleOrderLists;
    private Map<Integer,ArrayList<SingleOrder>> blockMap;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton clearFilterRequests;
    private javax.swing.JButton clearFilterBlockHistory;
    static public ArrayList<Broker> brokerListForBox;
    // End of variables declaration              ;     
}
