/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import UserObjects.Block;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kjha4
 */
public class TraderBlockOrderHistoryTableModel extends AbstractTableModel {

    private ArrayList objList = new ArrayList();

    public TraderBlockOrderHistoryTableModel(ArrayList datalist) {
        this.objList = datalist;
    }

    @Override
    public int getRowCount() {
        return objList.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int index) {
        String[] indexName = new String[]{
            "Block ID", "Symbol", "Quantity", "Order Type", "Price Executed", "Broker Assigned", "Status"
        };
        return indexName[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Block widget = (Block) objList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return String.valueOf(widget.getBlockId());
            case 1:
                return widget.getSymbol();
            case 2:
                return String.valueOf(widget.getQuantity());
            case 3:
                return widget.getOrderType();
            case 4:
                return widget.getPriceExecuted();
            case 5:
                return widget.getB_name();
            case 6:
                return widget.getStatus();
            default:
                return null;
        }
    }
}
