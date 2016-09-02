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
public class PMEndOfDayTableModel extends AbstractTableModel{
    private ArrayList objList = new ArrayList();

    public PMEndOfDayTableModel(ArrayList datalist) {
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
            "Portfolio ID", "Symbol", "Quantity", "Price"
         }; 

        return indexName[index];
    }
     

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SingleOrder widget = (SingleOrder) objList.get(rowIndex);
        switch (columnIndex) {
          case 0:
          return String.valueOf(widget.getPortfolioId());
         case 2:
          return widget.getSymbol();
         case 3:
          return String.valueOf(widget.getQuantity());
         case 4:
          return String.valueOf(widget.getPricePaid());

         default:
          return null;
        }
    }
}
    