/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import TestModules.JTableDataPopulation.JsonParsing;
import UserObjects.Order;

/**
 *
 * @author csavas
 */
public class ControllerPMCreatedOrders {

    public static void handleOrder(Order receivedOrder) {
        //HERE YOU NEED TO HANDLE GETTING PM ID FROM SESSION
        
        
        //HERE YOU NEED TO HANDLE GETTING THE ID OF THE TRADER WHOS NAME WE HAVE STORED IN STRING
        
        
        //THEN YOU PARSE THE ORDER OBJECT COMPLETELY. RIGHT NOW WE ONLY PARSE THE STRING OF TRADER 
        //NAME AND LIST OF SINGLE ORDERS
        System.out.println(JsonParsing.parseJsonFromObject(receivedOrder));
    }
}
    
