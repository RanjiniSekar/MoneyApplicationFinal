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
import org.apache.http.nio.client.HttpAsyncClient;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author kjha4
 */
public class CPMOrderMANIAC {

    static List<SingleOrder> arrayOrdersMaster = new ArrayList<>();
    static ArrayList<SingleOrder> pendings = new ArrayList<>();
    static ArrayList<SingleOrder> executed = new ArrayList<>();

    static public void setPendings(ArrayList<SingleOrder> pendings) {
        CPMOrderMANIAC.pendings = pendings;
    }

    static public void setExecuted(ArrayList<SingleOrder> executed) {
        CPMOrderMANIAC.executed = executed;
    }

    public static ArrayList<SingleOrder> getPendings() {
        return pendings;
    }

    public static ArrayList<SingleOrder> getExecuted() {
        return executed;
    }

    public static TableModel getPRTableModel() {
        if (pendings.isEmpty()) {
            return new DefaultTableModel();
        } else {
            ArrayList objList = (ArrayList) pendings;
            return new PMPendingRequestTableModel(objList);
        }
    }

    public static TableModel getOHTableModel() {
        if (executed.isEmpty()) {
            return new DefaultTableModel();
        } else {
            ArrayList<SingleOrder> objList = (ArrayList) executed;
            return new PMOrderHistoryTableModel(objList);
        }

    }

    public static TableModel getTableModel() throws ExecutionException, InterruptedException, IOException, JSONException {
        ArrayList objList = (ArrayList) updateOrders();
        return new PMPendingRequestTableModel(objList);
    }

    public static List<SingleOrder> updateOrders() throws ExecutionException, InterruptedException, IOException, JSONException {
        String currUsername = CMAIN.reportUser().getUsername();
        HttpResponse<JsonNode> resp;
        // resp = Unirest.get("http://139.59.17.119:8080/api/pm/orders/" + currUsername)
        //         .header("content-type", "application/json")
        //         .asJson();
        CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
        client.start();
        HttpGet request = new HttpGet("http://139.59.17.119:8080/api/pm/orders/" + currUsername);

        Future<org.apache.http.HttpResponse> future = client.execute(request, null);
        org.apache.http.HttpResponse response = future.get();
        String json_string = EntityUtils.toString(response.getEntity());
        JSONArray arrJson = new JSONArray(json_string);
        
        //JSONObject myRespO = new JSONObject(response.getBody());
        //String s = EntityUtils.toString(response.getEntity());
        System.out.println("ASYNC JSONARRAY IS : " + arrJson.toString());     
        //JSONArray arrJson = new JSONArray();
       
        List<SingleOrder> arrayOrders = new ArrayList<>();
        for (int i = 0; i < arrJson.length(); i++) {
            JSONObject currentOrder = new JSONObject();
            try {
                currentOrder = arrJson.getJSONObject(i);
            } catch (JSONException ex) {
                Logger.getLogger(CPMOrderMANIAC.class.getName()).log(Level.SEVERE, null, ex);
            }
            SingleOrder currentSingleOrder = JsonParsing.parseJsonToSingleOrderObject(currentOrder.toString());
            arrayOrders.add(currentSingleOrder);
        }
        arrayOrdersMaster = arrayOrders;

      
        try {
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(CPMOrderMANIAC.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!arrayOrdersMaster.isEmpty()) {
            return arrayOrdersMaster;
        } else {
            System.out.println("ASYNC ORDERS IS EMPTY.");
            return null;
        }
    }
}
