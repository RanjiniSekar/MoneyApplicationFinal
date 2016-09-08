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
    
    static public void handleUserPersistence(long uid, String uname, String name, String pass, String type){
        User curr = new UnknownUser(uname, pass);
        switch(type){
            case "trader":
                 curr = new Trader(name, uname, pass, type);
                 curr.setU_id(uid);
                 break;
            case "pm":
                 curr = new PortfolioManager(uname, name, pass, type);
                 curr.setU_id(uid);
                 break;
            case "admin":
                 curr = new Admin(uname, name, pass, type);
                 curr.setU_id(uid);
                 break;
        }
        CMAIN.currentUser = curr;
        
    }
    
    public static User reportUser(){
        return currentUser;
    }
    
    public static String triggerWindow(){
        return currentUser.getUserType();
    }

	public static void handleLogout() {
		// TODO Auto-generated method stub
		CMAIN.currentUser = new UnknownUser("Unkown", "Unknown");
	}
}
