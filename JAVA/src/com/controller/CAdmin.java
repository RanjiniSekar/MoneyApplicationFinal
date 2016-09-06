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
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author kjha4
 */
public class CAdmin {
    public static boolean addPortfolioManager(String name, String username, String password){
        User pm1 = new PortfolioManager(name, username, password, "pm");
        String jsonifiedPM = JsonParsing.parseJsonFromObject(pm1);
        // send query to db.
        try {
        Unirest.post("http://139.59.17.119:8080/api/admin")
        .header("content-type", "application/json")
        .body(jsonifiedPM)
        .asString();     
        showMessageDialog(null, "You have successfully entered a new PM.");
        } 
        catch (UnirestException e) {
            System.err.println("Unirest Exception: " + e.getMessage());
        }
        return true;
    }
    
    public static boolean addTrader(String name, String username, String password){
        Trader t1 = new Trader(name, username, password, "trader");
        String jsonifiedTrader = JsonParsing.parseJsonFromObject(t1);
        System.out.println(jsonifiedTrader);
        
        // send query to db.
        try {
        Unirest.post("http://139.59.17.119:8080/api/admin")
        .header("content-type", "application/json")
        .body(jsonifiedTrader)
        .asString();     
        showMessageDialog(null, "You have successfully entered a new Trader.");
        } 
        catch (UnirestException e) {
            System.err.println("Unirest Exception: " + e.getMessage());
        }
        return true;
    }
    
    public static boolean addBroker(String name, String email) throws UnirestException{
        Broker b1 = new Broker(name, email);
        String jsonifiedbroker = JsonParsing.parseJsonFromObject(b1);
        // send query to db.
                
        try {
        Unirest.post("http://139.59.17.119:8080/api/broker")
        .header("content-type", "application/json")
        .body(jsonifiedbroker)
        .asString();     
        } 
        catch (UnirestException e) {
            System.err.println("Unirest Exception: " + e.getMessage());
        }
        return true;
    }
}
