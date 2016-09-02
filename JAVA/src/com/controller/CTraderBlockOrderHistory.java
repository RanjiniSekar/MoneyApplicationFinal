/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import UserObjects.Block;
import com.model.PortfolioManagerDAO;
import java.util.ArrayList;
import javax.swing.table.TableModel;

/**
 *
 * @author kjha4
 */
public class CTraderBlockOrderHistory {
    public static TableModel getTableModel(){
        ArrayList<Block> objList = getData();
        return new TraderBlockOrderHistoryTableModel(objList);
    }
    
        
    private static ArrayList<Block> getData(){
        PortfolioManagerDAO pmDAO = new PortfolioManagerDAO();
        return pmDAO.getOrderHistoryObjList();
    }
}
