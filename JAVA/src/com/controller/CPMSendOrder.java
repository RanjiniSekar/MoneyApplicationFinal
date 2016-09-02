/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import UserObjects.SingleOrder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kjha4
 */
public class CPMSendOrder {
    public static boolean sendRequestToTrader(List<SingleOrder> orderList){
        
        for(SingleOrder singleOrder : orderList){
            // send reuest to model;
        }
        
        return true;
    }
}
