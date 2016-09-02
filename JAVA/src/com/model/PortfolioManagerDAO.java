/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import UserObjects.SingleOrder;
import java.util.ArrayList;

/**
 *
 * @author kjha4
 */
public class PortfolioManagerDAO {
   
    public ArrayList getEODObjList(){
        return fakeData();
    }
    
    public ArrayList getOrderHistoryObjList(){
        return fakeData();
    }
    
    public ArrayList getPendingRequestObjList(){
        return fakeData();
    }   
    
    public boolean sendOrderToBroker(){
    
        return true;
    } 
    
    public ArrayList fakeData(){
        ArrayList eodList = new ArrayList();
        eodList.add(new SingleOrder(132, 12, 241, 12, "AAPL", 200, "Buy", 100, 100, 100, "NYSE", "Credit", "Market Order", "Pending"));
        eodList.add(new SingleOrder(133, 14, 241, 12, "AAPL", 200, "Sell", 100, 100, 100, "NYSE", "Credit", "Market Order", "Pending"));
        eodList.add(new SingleOrder(134, 16, 244, 12, "Dell", 200, "Buy", 100, 100, 100, "NYSE", "Credit", "Market Order", "Pending"));
        eodList.add(new SingleOrder(135, 14, 241, 12, "AAPL", 200, "Buy", 100, 100, 100, "NYSE", "Credit", "Market Order", "Pending"));
        eodList.add(new SingleOrder(136, 12, 243, 12, "Dell", 200, "Buy", 100, 100, 100, "NYSE", "Credit", "Market Order", "Pending"));
        eodList.add(new SingleOrder(137, 16, 243, 12, "Google", 200, "Buy", 100, 100, 100, "NYSE", "Credit", "Market Order", "Pending"));
        
        return eodList;
    }
    
}
