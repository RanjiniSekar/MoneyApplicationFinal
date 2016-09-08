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
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;
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
        ArrayList objList = bought;
        return new PMEndOfDayTableModel(objList);
    }

    public static TableModel getSellTableModel() {
        ArrayList objList = sold;
        return new PMEndOfDayTableModel(objList);
    }

    private static List<SingleOrder> getEODData() {
        String currUsername = CMAIN.reportUser().getUsername();
        HttpResponse<JsonNode> resp;
        
        ArrayList<SingleOrder> boughtOrders = new ArrayList<>();
        ArrayList<SingleOrder> soldOrders = new ArrayList<>();

        
        
        try {
            //THIS DOESNT WORK: WAITING ON ORIOL
            resp = Unirest.get("http://139.59.17.119:8080/api/pm/eod/" + currUsername + "/1")
                    .header("content-type", "application/json")
                    .asJson();

            //THIS IS THE JSONRESPONSE TURNED INTO JSONOBJECT  
            JSONObject myRespO = new JSONObject(resp.getBody());
            System.out.println(myRespO);
            JSONArray arrJson = myRespO.getJSONArray("array");
            
            //GET ORDERS FROM ARRAY
            ArrayList<SingleOrder> arrayOrders = new ArrayList<>();

            for (int i = 0; i < arrJson.length(); i++) {
                JSONObject currentOrder = arrJson.getJSONObject(i);
                SingleOrder currentSingleOrder = JsonParsing.parseJsonToSingleOrderObject(currentOrder.toString());
                
                //DO THE DATE PART
                if(currentSingleOrder.getStatus() == "EXECUTED"){
                    arrayOrders.add(currentSingleOrder);
                }
            }
            
            for(SingleOrder o : arrayOrders){
                if(o.getAction().equals("SELL")){
                    soldOrders.add(o);
                }
                else if(o.getAction().equals("BUY")){
                    boughtOrders.add(o);
                }
            }
            
            setBought(boughtOrders);
            setSold(soldOrders);
            System.out.println("Print here for sold and bought: ");
            return arrayOrders;
        } catch (UnirestException | JSONException ex) {
            return null;
        }
    }
}
