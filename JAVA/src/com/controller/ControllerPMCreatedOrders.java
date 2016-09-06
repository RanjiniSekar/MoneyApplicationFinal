/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import TestModules.JTableDataPopulation.JsonParsing;
import UserObjects.Broker;
import UserObjects.Order;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        System.out.println(receivedJson);

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

}
