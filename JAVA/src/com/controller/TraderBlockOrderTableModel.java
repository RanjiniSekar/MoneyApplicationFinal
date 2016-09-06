/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import UserObjects.SingleOrder;

import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kjha4
 */
public class TraderBlockOrderTableModel extends AbstractTableModel{
    private ArrayList objList = new ArrayList();
    private Boolean select;

    public TraderBlockOrderTableModel(ArrayList datalist) {
        this.objList = datalist;
        this.select = false;
    }
      
    
    public Boolean getSelect() {
		return select;
	}


	public void setSelect(Boolean select) {
		this.select = select;
	}


	@Override
    public int getRowCount() {
        return objList.size();
    }

    @Override
    public int getColumnCount() {
        return 12;
    }
    
    @Override
    public String getColumnName(int index) {
        String[] indexName = new String [] {
            "Order ID", "Portfolio ID", "Symbol", "Quantity", "Action", "Stop Price", "Limit Price", "Account Type", "Order Type", "Assigned By", "Stock Exchange", "Select"
        };
        return indexName[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SingleOrder widget = (SingleOrder) objList.get(rowIndex);
        
        switch (columnIndex) {
         case 0:
          return String.valueOf(widget.getBlockId());
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
          return widget.getPmId();
         case 10:
          return widget.getStockExchange();
         case 11:
        	 return this.getSelect();
         default:
          return null;
        }
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
    	this.select = (Boolean)value;
    }
    
    @Override
    public boolean isCellEditable(int row,int column){
    	return column==11;
    }
    
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
    	SingleOrder widget = (SingleOrder) objList.get(0);
    	switch (columnIndex) {
        case 0:
         return String.class;
        case 1:
         return String.class;
        case 2:
         return String.class;
        case 3:
         return String.class;
        case 4:
         return String.class;
        case 5:
         return String.class;
        case 6:
         return String.class;
        case 7:
         return String.class;
        case 8:
         return String.class;
        case 9:
         return String.class;
        case 10:
         return String.class;
        case 11:
         return Boolean.class;

        default:
         return null;
       }
    }
}
