/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import TestModules.JTableDataPopulation.JsonParsing;
import UserObjects.Broker;
import UserObjects.Trader;
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
public class CTraderGetAllBrokers {
     public static List<Broker> getBrokerList() {
        String brokersString = "";
        try {
            HttpResponse<JsonNode> resp = Unirest.get("http://139.59.17.119:8080/api/admin/brokers")
                    .header("content-type", "application/json")
                    .asJson();
            //THIS IS THE JSONRESPONSE TURNED INTO JSONOBJECT  
            JSONObject myRespO = new JSONObject(resp.getBody());
            JSONArray arrJson = myRespO.getJSONArray("array");
            //GET ORDERS FROM ARRAY
            List<Broker> brokerList = new ArrayList<>();

            for (int i = 0; i < arrJson.length(); i++) {
                JSONObject currentBr = arrJson.getJSONObject(i);
                Broker currentBroker = JsonParsing.parseJsonToBrokerObject(currentBr.toString());
                String currName = currentBroker.getName();
                brokerList.add(currentBroker);
                brokersString += currName + ", ";
            }
            System.out.println("Added Brokers to dropdown-list: " + brokersString);
            return brokerList;
        } catch (UnirestException | JSONException ex) {
            Logger.getLogger(ControllerPMCreatedOrders.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
