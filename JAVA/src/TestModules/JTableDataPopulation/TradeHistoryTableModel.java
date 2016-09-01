package TestModules.JTableDataPopulation;


import TestModules.JTableDataPopulation.Trade;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kjha4
 */
public class TradeHistoryTableModel extends AbstractTableModel {
    
    private ArrayList datalist = new ArrayList();

    public TradeHistoryTableModel(ArrayList datalist) {
        this.datalist = datalist;
    }
      
    @Override
    public int getRowCount() {
        return datalist.size();
    }

    @Override
    public int getColumnCount() {
        return 11;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Trade widget = (Trade) datalist.get(rowIndex);
        switch (columnIndex) {
         case 0:
          return widget.getOrderID();
         case 1:
          return widget.getPortfolioID();
         case 2:
          return widget.getSymbol();
         case 3:
          return String.valueOf(widget.getQuantity());
         case 4:
          return widget.getAction();
         case 5:
          return widget.getStopPrice();
         case 6:
          return widget.getLimitPrice();
         case 7:
          return widget.getAccountType();
         case 8:
          return widget.getOrderType();
         case 9:
          return widget.getAssignedTo();
         case 10:
          return widget.getStatus();

         default:
          return null;
        }
    }
    
}
