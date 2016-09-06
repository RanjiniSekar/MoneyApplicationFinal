/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import UserObjects.Admin;
import UserObjects.PortfolioManager;
import UserObjects.Trader;
import UserObjects.UnknownUser;
import UserObjects.User;

/**
 *
 * @author csavas
 */
public class CMAIN {
    static User currentUser;
    
    static public void handleUserPersistence(String uname, String name, String pass, String type){
        User curr = new UnknownUser(uname, pass);
        switch(type){
            case "trader":
                 curr = new Trader(uname, name, pass, type);
                 break;
            case "pm":
                 curr = new PortfolioManager(uname, name, pass, type);
                 break;
            case "admin":
                 curr = new Admin(uname, name, pass, type);
                 break;
        }
        CMAIN.currentUser = curr;
        
    }
    
    static public User reportUser(){
        return currentUser;
    }
    
    static public String triggerWindow(){
        return currentUser.getUserType();
    }
}
