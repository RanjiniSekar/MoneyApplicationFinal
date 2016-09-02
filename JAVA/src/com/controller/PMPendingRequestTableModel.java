package com.controller;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import UserObjects.SingleOrder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kjha4
 */
class PMPendingRequestTableModel extends AbstractTableModel {
    
    private ArrayList objList = new ArrayList();

    public PMPendingRequestTableModel(ArrayList datalist) {
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
          return widget.getAccountType();
         case 8:
          return widget.getOrderType();
         case 9:
          return widget.getAssignedTo();
         case 10:
          return widget.getStatus();
         case 11:
          return widget.getStockExchange();

         default:
          return null;
        }
    }
    
}

