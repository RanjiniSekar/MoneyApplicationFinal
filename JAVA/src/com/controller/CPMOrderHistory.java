/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import TestModules.JTableDataPopulation.JsonParsing;
import UserObjects.SingleOrder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.model.PortfolioManagerDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.table.TableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author kjha4
 */
public class CPMOrderHistory {

    public static TableModel getTableModel() {
        ArrayList<SingleOrder> objList = (ArrayList) updateOrders();
        return new PMOrderHistoryTableModel(objList);

    }

    private static ArrayList<SingleOrder> getData() {
        PortfolioManagerDAO pmDAO = new PortfolioManagerDAO();
        return pmDAO.getOrderHistoryObjList();
    }

    public static List<SingleOrder> updateOrders() {
        String currUsername = CMAIN.reportUser().getUsername();
        HttpResponse<JsonNode> resp;
        try {
            resp = Unirest.get("http://139.59.17.119:8080/api/pm/orders/" + currUsername)
                    .header("content-type", "application/json")
                    .asJson();

            //THIS IS THE JSONRESPONSE TURNED INTO JSONOBJECT  
            JSONObject myRespO = new JSONObject(resp.getBody());

            JSONArray arrJson = myRespO.getJSONArray("array");
            
            //GET ORDERS FROM ARRAY
            List<SingleOrder> arrayOrders = new ArrayList<>();

            for (int i = 0; i < arrJson.length(); i++) {
                JSONObject currentOrder = arrJson.getJSONObject(i);
                SingleOrder currentSingleOrder = JsonParsing.parseJsonToSingleOrderObject(currentOrder.toString());
                if(currentSingleOrder.getStatus().equals("Executed")){
                    arrayOrders.add(currentSingleOrder);
                }
            }
            
            System.out.println("ARRAY OF ORDERS RETURNED FROM SERVER.");
            return arrayOrders;
        } catch (UnirestException | JSONException ex) {
            Logger.getLogger(CPMOrderHistory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
