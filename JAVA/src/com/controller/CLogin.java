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
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.Iterator;
import static javax.swing.JOptionPane.showMessageDialog;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author csavas
 */
public class CLogin {

    public static void handleLogin(String nameText, String passText) throws JSONException, UnirestException {
        //CHECK AGAINST THE DATABASE TO SEE IF THIS USER EXISTS AND LOG THEM IN
        //BASED ON USERTYPE, SHOULD SHOW THE APPROPRIATE JFRAME    
        try {
        HttpResponse<JsonNode> resp = Unirest.get("http://139.59.17.119:8080/api/admin/" + nameText)
        .header("content-type", "application/json")
        .asJson();   
        
        //THIS IS THE JSONRESPONSE TURNED INTO JSONOBJECT  
        JSONObject myRespO = new JSONObject(resp.getBody());
        
        JSONArray arrJson= myRespO.getJSONArray("array");

        //GET USERNAME FROM THE DATA ABOVE
        String thisUsername = arrJson.getJSONObject(0).getString("username");
        
        //PASSWORD
        String thisPassword = arrJson.getJSONObject(0).getString("password");
        
        //NAME
        String thisName = arrJson.getJSONObject(0).getString("name");

        //TYPE
        String thisType = arrJson.getJSONObject(0).getString("user_type");
        
        long thisID = arrJson.getJSONObject(0).getLong("u_id");
        System.out.println("ACCESSED USERID: \n" + thisName);
        
        if(thisPassword.equals(passText)){
           //PASSWORD MATCHES: SAVE USER IN SESSION
           System.out.println("Now we can handle persistence");
           CMAIN.handleUserPersistence(thisID, thisUsername,thisName, thisPassword,thisType);     
        } 
        else {
            showMessageDialog(null, "Your password is incorrect."); 
        } 
        } 
        catch (UnirestException e) {
            System.err.println("Unirest Exception: " + e.getMessage());
        }
    }
    
    
}
