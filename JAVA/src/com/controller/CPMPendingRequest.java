/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;
import com.model.PortfolioManagerDAO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author kjha4
 */
public class CPMPendingRequest {
    
    public static TableModel getTableModel(){
        ArrayList objList = getData();
        return new PMPendingRequestTableModel(objList);
    }
    
    private static ArrayList getData(){
        PortfolioManagerDAO pmDAO = new PortfolioManagerDAO();
        return pmDAO.getPendingRequestObjList();
    }
    
}

