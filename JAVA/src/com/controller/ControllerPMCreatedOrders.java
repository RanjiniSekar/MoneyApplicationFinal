/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import TestModules.JTableDataPopulation.JsonParsing;
import UserObjects.Broker;
import UserObjects.Order;
import UserObjects.SingleOrder;
import UserObjects.Trader;
import UserObjects.User;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author csavas
 */
public class ControllerPMCreatedOrders {

    public static void handleOrder(Order receivedOrder) {
        //HERE YOU NEED TO HANDLE GETTING PM ID FROM SESSION
        long currentUID = CMAIN.reportUser().getU_id();
        receivedOrder.setPortfolioManagerId(currentUID);
        String receivedJson = JsonParsing.parseJsonFromObject(receivedOrder);
        
        //HERE YOU NEED TO HANDLE GETTING THE ID OF THE TRADER WHOS NAME WE HAVE STORED IN STRING
        // send query to db.
        try {
            Unirest.post("http://139.59.17.119:8080/api/pm/orders")
                    .header("content-type", "application/json")
                    .body(receivedJson)
                    .asString();
        } catch (UnirestException e) {
            System.err.println("Unirest Exception: " + e.getMessage());
        }
    }

    public static List<Trader> getTraderList() {
        String tradersString = "";
        try {
            HttpResponse<JsonNode> resp = Unirest.get("http://139.59.17.119:8080/api/admin/traders")
                    .header("content-type", "application/json")
                    .asJson();
            //THIS IS THE JSONRESPONSE TURNED INTO JSONOBJECT  
            JSONObject myRespO = new JSONObject(resp.getBody());
            JSONArray arrJson = myRespO.getJSONArray("array");
            //GET ORDERS FROM ARRAY
            List<Trader> traderList = new ArrayList<>();

            for (int i = 0; i < arrJson.length(); i++) {
                JSONObject currentTr = arrJson.getJSONObject(i);
                Trader currentTrader = JsonParsing.parseJsonToTraderObject(currentTr.toString());
                String currUname = currentTrader.getUsername();
                traderList.add(currentTrader);
                tradersString += currUname + ", ";
            }
            System.out.println("Added Traders to list: " + tradersString);
            return traderList;
        } catch (UnirestException | JSONException ex) {
            Logger.getLogger(ControllerPMCreatedOrders.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
