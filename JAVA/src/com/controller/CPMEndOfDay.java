/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import TestModules.JTableDataPopulation.JsonParsing;
import UserObjects.SingleOrder;
import static com.controller.CPMOrderMANIAC.executed;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.model.PortfolioManagerDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author kjha4
 */
public class CPMEndOfDay {

    public static ArrayList<SingleOrder> getBought() {
        return bought;
    }

    public static void setBought(ArrayList<SingleOrder> bought) {
        CPMEndOfDay.bought = bought;
    }

    public static ArrayList<SingleOrder> getSold() {
        return sold;
    }

    public static void setSold(ArrayList<SingleOrder> sold) {
        CPMEndOfDay.sold = sold;
    }

    static ArrayList<SingleOrder> bought = new ArrayList<>();
    static ArrayList<SingleOrder> sold = new ArrayList<>();

    public static TableModel getBuyTableModel() {
        ArrayList<SingleOrder> objList = getBought();

        return new PMEndOfDayTableModel(objList);
    }

    public static TableModel getSellTableModel() {
        ArrayList objList = sold;
        return new PMEndOfDayTableModel(objList);
    }

    public static void getEODData() throws InterruptedException, IOException, JSONException {
        System.out.println("EOD DATA THREAD RUNNING.");
        try {
            String currUsername = CMAIN.reportUser().getUsername();
            HttpResponse<JsonNode> resp;

            ArrayList<SingleOrder> boughtOrders = new ArrayList<>();
            ArrayList<SingleOrder> soldOrders = new ArrayList<>();

            String currentTime = new SimpleDateFormat("HH:mm").format(new Date());
            String timeToCompare = "16:30";
            int x = currentTime.compareTo(timeToCompare);
 

            //INIT CLIENT
            CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
            client.start();

            //REQUEST
            HttpGet request ;
            
            if (x > 0) {
                request = new HttpGet("http://139.59.17.119:8080/api/pm/eod/" + currUsername + "/1");
            } else {
                request = new HttpGet("http://139.59.17.119:8080/api/pm/eod/" + currUsername + "/0");
            }

            //GET AND PARSE RESPONSE
            Future<org.apache.http.HttpResponse> future = client.execute(request, null);
            org.apache.http.HttpResponse response = future.get();
            String json_string = EntityUtils.toString(response.getEntity());
            JSONArray arrJson = new JSONArray(json_string);

            //GET ORDERS FROM ARRAY
            ArrayList<SingleOrder> arrayOrders = new ArrayList<>();

            for (int i = 0; i < arrJson.length(); i++) {
                JSONObject currentOrder = arrJson.getJSONObject(i);
                SingleOrder currentSingleOrder = JsonParsing.parseJsonToSingleOrderObject(currentOrder.toString());

                //DO THE DATE PART
                if (currentSingleOrder.getStatus().equals("Executed")) {
                    // System.out.println("# executed by :" + currUsername);
                    arrayOrders.add(currentSingleOrder);
                }
            }

            for (SingleOrder o : arrayOrders) {
                if (o.getAction().equals("Sell")) {
                    soldOrders.add(o);
                } else if (o.getAction().equals("Buy")) {
                    boughtOrders.add(o);
                }
            }

            setBought(boughtOrders);
            setSold(soldOrders);

            //DONT FORGET TO KILL CLIENT
            try {
                client.close();
            } catch (IOException ex) {
                Logger.getLogger(CPMOrderMANIAC.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ExecutionException ex) {
            Logger.getLogger(CPMEndOfDay.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
