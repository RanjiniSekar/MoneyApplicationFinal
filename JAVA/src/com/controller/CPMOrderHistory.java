/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import UserObjects.SingleOrder;
import com.model.PortfolioManagerDAO;
import java.util.ArrayList;
import javax.swing.table.TableModel;

/**
 *
 * @author kjha4
 */
public class CPMOrderHistory {
    
    public static TableModel getTableModel(){
        ArrayList<SingleOrder> objList = getData();
        return new PMOrderHistoryTableModel(objList);
    }
    
        
    private static ArrayList<SingleOrder> getData(){
        PortfolioManagerDAO pmDAO = new PortfolioManagerDAO();
        return pmDAO.getOrderHistoryObjList();
    }
    
}
