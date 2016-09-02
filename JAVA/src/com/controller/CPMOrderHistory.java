/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.util.ArrayList;
import javax.swing.table.TableModel;

/**
 *
 * @author kjha4
 */
public class CPMOrderHistory {
    
    public static TableModel getTableModel(ArrayList objList){
        
        return new PMOrderHistoryTableModel(objList);
    }
}
