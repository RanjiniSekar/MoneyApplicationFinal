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
 * @author csavas
 */
public class TraderPendingRequestsTableModel extends AbstractTableModel{
    private ArrayList objList = new ArrayList();
    private Boolean[] select;

    public TraderPendingRequestsTableModel(ArrayList datalist) {
        this.objList = datalist;
        
    }
      
    
    public Boolean getSelect(int row) {
		return select[row];
	}


	public void setSelect(Boolean select,int row) {
		this.select[row] = select;
	}

    public int getRowCount() {
        return objList.size();
    }

    public int getColumnCount() {
        return 11;
    }
    
    public String getColumnName(int index) {
        String[] indexName = new String [] {
            "Order ID", "Portfolio ID", "Symbol", "Quantity", "Action", "Stop Price", "Limit Price", "Stock Exchange", "Account Type", "Order Type", "Assigned By"
        };
        return indexName[index];
    }

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
          return String.valueOf(widget.getStockExchange());
         case 8:
          return widget.getAccountType();
         case 9:
          return widget.getOrderType();
         case 10:
          return widget.getPmUsername();
         default:
          return null;
        }
    }
    
   
}
