/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestModules.JTableDataPopulation;

import java.util.ArrayList;

/**
 *
 * @author kjha4
 */
public class ServerResponse {
    
    // This would make Individual object json String out of JSON response.
    public static ArrayList getJsonArr(){
        ArrayList arrList = new ArrayList();
        
        String trade1,trade2,trade3,trade4;
        trade1 = "{\"orderID\":\"tm1234\",\"portfolioID\":\"pmt3256\",\"symbol\":\"AAPL\",\"quantity\":990,\"action\":\"BUY\",\"stopPrice\":124.3,\"limitPrice\":154.0,\"accountType\":\"Margin\",\"orderType\":\"Market Order\",\"assignedTo\":\"Kumar Jha\",\"status\":\"Pending\"}";
        trade2 = "{\"orderID\":\"tm1235\",\"portfolioID\":\"pmt3257\",\"symbol\":\"DELL\",\"quantity\":220,\"action\":\"BUY\",\"stopPrice\":124.3,\"limitPrice\":154.0,\"accountType\":\"Margin\",\"orderType\":\"Market Order\",\"assignedTo\":\"Kumar Jha\",\"status\":\"Executed\"}";
        trade3 = "{\"orderID\":\"tm1236\",\"portfolioID\":\"pmt3258\",\"symbol\":\"BRIT\",\"quantity\":250,\"action\":\"BUY\",\"stopPrice\":124.3,\"limitPrice\":154.0,\"accountType\":\"Margin\",\"orderType\":\"Market Order\",\"assignedTo\":\"Kumar Jha\",\"status\":\"Pending\"}";
        trade4 = "{\"orderID\":\"tm1237\",\"portfolioID\":\"pmt3256\",\"symbol\":\"AAPL\",\"quantity\":400,\"action\":\"BUY\",\"stopPrice\":124.3,\"limitPrice\":154.0,\"accountType\":\"Margin\",\"orderType\":\"Market Order\",\"assignedTo\":\"Kumar Jha\",\"status\":\"Executed\"}";
        
        arrList.add(trade1);
        arrList.add(trade2);
        arrList.add(trade3);
        arrList.add(trade4);
        
        return arrList;
    }
    
}
