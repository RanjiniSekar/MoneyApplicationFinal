/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;


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
public class CLogin {

    public static void handleLogin(String nameText, String passText) throws JSONException, UnirestException {
        //CHECK AGAINST THE DATABASE TO SEE IF THIS USER EXISTS AND LOG THEM IN
        //BASED ON USERTYPE, SHOULD SHOW THE APPROPRIATE JFRAME    
        boolean nullTrigg = false;
        try {
        HttpResponse<JsonNode> resp = Unirest.get("http://139.59.17.119:8080/api/admin/user/" + nameText)
        .header("content-type", "application/json")
        .asJson();   
        
        //THIS IS THE JSONRESPONSE TURNED INTO JSONOBJECT  
        JSONObject myRespO = new JSONObject(resp.getBody());
       
        JSONArray arrJson= myRespO.getJSONArray("array");

        //GET USERNAME FROM THE DATA ABOVE
        String thisUsername = arrJson.getJSONObject(0).getString("username");
        
        if(thisUsername == null || resp.getBody() == null){
            showMessageDialog(null, "A user with this username does not exist."); 
            nullTrigg = true;
        }
        
        //RETRIEVE USER INFO FROM ARRAY
        String thisPassword = arrJson.getJSONObject(0).getString("password");   
        String thisName = arrJson.getJSONObject(0).getString("name");
        String thisType = arrJson.getJSONObject(0).getString("user_type");
        long thisID = arrJson.getJSONObject(0).getLong("u_id");
        
        if(thisPassword.equals(passText) && nullTrigg == false){
           //PASSWORD MATCHES: SAVE USER IN SESSION
           CMAIN.handleUserPersistence(thisID, thisUsername,thisName, thisPassword,thisType);     
           } 
        else if(!(thisPassword.equals(passText)) && nullTrigg == false){
           showMessageDialog(null, "Your password is incorrect."); 
           } 
        } 
        catch (UnirestException e) {
            System.err.println("Unirest Exception: " + e.getMessage());
        }
    }
    
    
}
