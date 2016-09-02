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
import UserObjects.UnknownUser;
import UserObjects.User;


/**
 *
 * @author csavas
 */
public class CLogin {

    public static void handleLogin(String nameText, String passText) {
        //CHECK AGAINST THE DATABASE TO SEE IF THIS USER EXISTS AND LOG THEM IN
        //BASED ON USERTYPE, SHOULD SHOW THE APPROPRIATE JFRAME
        User u = new UnknownUser(nameText, passText);
        String jsonifiedLoginInfo = JsonParsing.parseJsonFromObject(u);
        
        //SEND TO DB Jsonified Login Info HERE
        
    }
    
}
