/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import TestModules.JTableDataPopulation.JsonParsing;
import UserObjects.Block;
import UserObjects.SingleOrder;
import static com.controller.CPMOrderMANIAC.arrayOrdersMaster;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
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
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author csavas
 */
public class CTraderOrderMANIAC {

    static ArrayList<SingleOrder> pendings = new ArrayList<>();
    static ArrayList<SingleOrder> executed = new ArrayList<>();
    static ArrayList<Block> blockHistory = new ArrayList<>();
    
    public static ArrayList<Block> getBlockHistory() {
		return blockHistory;
	}

	public static void setBlockHistory(ArrayList<Block> blockHistory) {
		CTraderOrderMANIAC.blockHistory = blockHistory;
	}
            
    static public void setPendings(ArrayList<SingleOrder> pendings) {
        CTraderOrderMANIAC.pendings = pendings;
    }

    static public void setExecuted(ArrayList<SingleOrder> executed) {
        CTraderOrderMANIAC.executed = executed;
    }

    public static ArrayList<SingleOrder> getPendings() {
        return pendings;
    }

    public static ArrayList<SingleOrder> getExecuted() {
        return executed;
    }
    
    public static TableModel getPRTableModel() {
        if(pendings.isEmpty()){
            return new DefaultTableModel();
        } else { 
            ArrayList<SingleOrder> objList = (ArrayList) pendings;
            return new TraderPendingRequestsTableModel(objList);
        }       
    }
    
    public static TableModel getBlockHistoryTableModel() {
        if(blockHistory.isEmpty()){
            return new DefaultTableModel();
        } else { 
            ArrayList<Block> objList = (ArrayList) blockHistory;
            return new TraderBlockOrderHistoryTableModel(objList);
        }

    }
    
    public static TableModel getTableModel() throws InterruptedException, IOException, JSONException, ExecutionException {
        ArrayList objList = (ArrayList) updateOrders();
        return new PMPendingRequestTableModel(objList);
    }

    public static List<SingleOrder> updateOrders() throws InterruptedException, IOException, JSONException, ExecutionException {
                
        String currUsername = CMAIN.reportUser().getUsername();
        HttpResponse<JsonNode> resp;
        System.out.println("Username in update orders is: " + currUsername);
        //INIT CLIENT
        CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
        client.start();
        
        //REQUEST
        HttpGet request = new HttpGet("http://139.59.17.119:8080/api/trader/orders/" + currUsername);

        //GET AND PARSE RESPONSE
        Future<org.apache.http.HttpResponse> future = client.execute(request, null);
        org.apache.http.HttpResponse response = future.get();
        String json_string = EntityUtils.toString(response.getEntity());
        System.out.println("ASYNC JSON STRING IS : " + json_string);     
        JSONArray arrJson = new JSONArray(json_string);      
        System.out.println("ASYNC JSONARRAY IS : " + arrJson.toString());     
       
        //PARSE ARRAY INTO SINGLE ORDERS
        List<SingleOrder> arrayOrders = new ArrayList<>();
        for (int i = 0; i < arrJson.length(); i++) {
            JSONObject currentOrder = new JSONObject();
            try {
                currentOrder = arrJson.getJSONObject(i);
            } catch (JSONException ex) {
                Logger.getLogger(CTraderOrderMANIAC.class.getName()).log(Level.SEVERE, null, ex);
            }
            SingleOrder currentSingleOrder = JsonParsing.parseJsonToSingleOrderObject(currentOrder.toString());
            
            arrayOrders.add(currentSingleOrder);
        }
        arrayOrdersMaster = arrayOrders;
        System.out.println("-----------------> THIS ARRAY IS: " + arrayOrdersMaster.size());
        //DONT FORGET TO KILL CLIENT
        try {
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(CPMOrderMANIAC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //RETURN ORDERS RETRIEVED
        if (!arrayOrdersMaster.isEmpty()) {
            return arrayOrdersMaster;
        } else {
            System.out.println("ASYNC ORDERS IS EMPTY.");
            return null;
        }
    }

    public static void sendBlockList(String parsedJSON) {
        try {
            Unirest.post("http://139.59.17.119:8080/api/trader/blocks")
                    .header("content-type", "application/json")
                    .body(parsedJSON)
                    .asString();
        } catch (UnirestException e) {
            System.err.println("Unirest Exception: " + e.getMessage());
        }
    }
    
    public static List<Block> updateBlockOrderHistory() throws InterruptedException, ExecutionException, IOException, JSONException{
        String currUsername = CMAIN.reportUser().getUsername();
        HttpResponse<JsonNode> resp;
        
        //INIT CLIENT
        CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
        client.start();
        
        //REQUEST
        HttpGet request = new HttpGet("http://139.59.17.119:8080/api/trader/blocks/" + currUsername);

        //GET AND PARSE RESPONSE
        Future<org.apache.http.HttpResponse> future = client.execute(request, null);
        org.apache.http.HttpResponse response = future.get();
        String json_string = EntityUtils.toString(response.getEntity());
        JSONArray arrJson = new JSONArray(json_string);      
        System.out.println("ASYNC JSONARRAY IS : " + arrJson.toString());     
       
        //PARSE ARRAY INTO SINGLE ORDERS
        ArrayList<Block> arrayBlock = new ArrayList<>();
        for (int i = 0; i < arrJson.length(); i++) {
            JSONObject currentBlock = new JSONObject();
            try {
                currentBlock = arrJson.getJSONObject(i);
            } catch (JSONException ex) {
                Logger.getLogger(CTraderOrderMANIAC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Block currBlock = JsonParsing.parseJsonToBlockObject(currentBlock.toString());
            arrayBlock.add(currBlock);
        }
        blockHistory = arrayBlock;

        //DONT FORGET TO KILL CLIENT
        try {
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(CPMOrderMANIAC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //RETURN ORDERS RETRIEVED
        if (!blockHistory.isEmpty()) {
            return blockHistory;
        } else {
            System.out.println("ASYNC BLOCK HISTORY IS EMPTY.");
            return null;
        }
    }
}

