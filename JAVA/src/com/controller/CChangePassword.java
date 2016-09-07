/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import TestModules.JTableDataPopulation.JsonParsing;
import UserObjects.Admin;
import UserObjects.PortfolioManager;
import UserObjects.Trader;
import UserObjects.UnknownUser;
import UserObjects.User;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import static javax.swing.JOptionPane.showMessageDialog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author csavas
 */
public class CChangePassword {

    public static boolean handleChange(String oldPassText, String newPassText, String confirmPassText) throws JSONException, UnirestException {
        boolean success = false;
        try {
            User curr = CMAIN.reportUser();
            String currUName = curr.getUsername();
            HttpResponse<JsonNode> resp = Unirest.get("http://139.59.17.119:8080/api/admin/user/" + currUName)
                    .header("content-type", "application/json")
                    .asJson();

            //THIS IS THE JSONRESPONSE TURNED INTO JSONOBJECT  
            JSONObject myRespO = new JSONObject(resp.getBody());
            System.out.println("JSON OBJECT BODY: \n" + myRespO.toString());

            JSONArray arrJson = myRespO.getJSONArray("array");

            //GET USERNAME FROM THE DATA ABOVE
            String thisUsername = arrJson.getJSONObject(0).getString("username");
            System.out.println("ACCESSED USERNAME IN CHANGEPASSWORD: \n" + thisUsername);

            //PASSWORD
            String thisPassword = arrJson.getJSONObject(0).getString("password");
            System.out.println("ACCESSED PASSWORD IN CHANGEPASSWORD: \n" + thisPassword);
            System.out.println("PASSWORD IN FIELD ENTERED: \n" + oldPassText);

            //NAME
            String thisName = arrJson.getJSONObject(0).getString("name");
            System.out.println("ACCESSED NAME IN CHANGEPASSWORD: \n" + thisName);

            //TYPE
            String thisType = arrJson.getJSONObject(0).getString("user_type");
            System.out.println("ACCESSED TYPE IN CHANGEPASSWORD: \n" + thisType);

            if (oldPassText.equals(thisPassword)) { //CHECK IF OLD PASSWORD ENTERED CORRECTLY
                //PASSWORD MATCHES: SEND NEW PASSWORD AND CHANGE DATABASE
                System.out.println("CONDITIONS MET, ABOUT TO UPDATE DB PASSWORD. \n");
                updateDBPassword(thisUsername, thisPassword, thisName, thisType, confirmPassText);
                success = true;
            } else {
                showMessageDialog(null, "Your password is incorrect.");
                success = false;
            }
        return success;
        } catch (UnirestException e) {
            System.err.println("Unirest Exception: " + e.getMessage());
            return success;
        }
    }
    
    
    static public void updateDBPassword(String username, String oldPass, String name, String type, String newPass){
        User u1 = new UnknownUser(username,newPass);
        switch(type){
            case "trader":
                 u1 = new Trader(username, name, newPass, type);
                 break;
            case "pm":
                 u1 = new PortfolioManager(username, name, newPass, type);
                 break;
            case "admin":
                 u1 = new Admin(username, name, newPass, type);
                 break;
        }
        
        String jsonifiedUserUpdate = JsonParsing.parseJsonFromObject(u1);
        System.out.println("Jsonified User: " + jsonifiedUserUpdate);
        // send query to db.      
        try {
        Unirest.put("http://139.59.17.119:8080/api/admin/user/" + username)
        .header("content-type", "application/json")
        .body(jsonifiedUserUpdate)
        .asString();     
        } 
        catch (UnirestException e) {
            System.err.println("Unirest Exception: " + e.getMessage());
        }
    }  
}


