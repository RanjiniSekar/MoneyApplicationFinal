/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import TestModules.JTableDataPopulation.JsonParsing;
import UserObjects.Broker;
import UserObjects.PortfolioManager;
import UserObjects.Trader;
import UserObjects.User;

/**
 *
 * @author kjha4
 */
public class CAdmin {
    public static boolean addPortfolioManager(String name, String username, String password){
        User pm1 = new PortfolioManager(name, username, password, "PM");
        String jsonifiedPM = JsonParsing.parseJsonFromObject(pm1);
        // send query to db.
        return true;
    }
    
    public static boolean addTrader(String name, String username, String password){
        User t1 = new Trader(name, username, password, "Trader");
        String jsonifiedPM = JsonParsing.parseJsonFromObject(t1);
        // send query to db.
        return true;
    }
    
    public static boolean addBroker(String name, String email){
        Broker b1 = new Broker(name, email);
        String jsonifiedPM = JsonParsing.parseJsonFromObject(b1);
        // send query to db.
        return true;
    }
}
