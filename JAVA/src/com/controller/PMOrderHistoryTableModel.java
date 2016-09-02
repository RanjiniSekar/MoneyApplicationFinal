/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import UserObjects.SingleOrder;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kjha4
 */
public class PMOrderHistoryTableModel extends AbstractTableModel{
    private ArrayList objList = new ArrayList();

    public PMOrderHistoryTableModel(ArrayList datalist) {
        this.objList = datalist;
    }
      
    @Override
    public int getRowCount() {
        return objList.size();
    }

    @Override
    public int getColumnCount() {
        return 11;
    }
    
    @Override
    public String getColumnName(int index) {
        String[] indexName = new String [] {
            "Order ID", "Portfolio ID", "Symbol", "Quantity", "Action", "Stop Price", "Limit Price", "Stock Exchange", "Account Type", "Order Type", "Assigned To"
         }; 

        return indexName[index];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SingleOrder widget = (SingleOrder) objList.get(rowIndex);
        switch (columnIndex) {
         case 0:
          return String.valueOf(widget.getSingleOrderId());
         case 1:
          return String.valueOf(widget.getPortfolioId());
         case 2:
          return widget.getSymbol();
         case 3:
          return String.valueOf(widget.getQuantity());
         case 4:
          return widget.getAction();
         case 5:
          return String.valueOf(widget.getStopPrice());
         case 6:
          return String.valueOf(widget.getLimitPrice());
         case 7:
          return widget.getStockExchange();
         case 8:
			return widget.getAccountType();
         case 9:
          return widget.getOrderType();
         case 10:
          return widget.getAssignedTo();

         default:
          return null;
        }
    }
}
        