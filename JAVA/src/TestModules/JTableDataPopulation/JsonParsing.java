/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestModules.JTableDataPopulation;

import UserObjects.Block;
import UserObjects.Broker;
import UserObjects.SingleOrder;
import UserObjects.Trader;
import UserObjects.User;

import com.google.gson.Gson;

/**
 *
 * @author kjha4
 */
public class JsonParsing {
    
    // Pass an object and this returns the json of it.
    public static String parseJsonFromObject(Object obj){
        Gson gson = new Gson();
        String jsonStr = gson.toJson(obj);
        return jsonStr;
    } 
    
    // parse Json input into Trade class object.
    public static Trade parseJsonToTradeObject(String json){
        Gson gson = new Gson();
        // Just Specify the class the json is need to be parsed into.
        Trade trade = gson.fromJson(json, Trade.class);
        return trade;
    }
    
    // parse Json input into Block class object.
    public static Block parseJsonToBlockObject(String json){
        Gson gson = new Gson();
        // Just Specify the class the json is need to be parsed into.
        Block block = gson.fromJson(json, Block.class);
        return block;
    }
    
    // parse Json input into Trade class object.
    public static User parseJsonToUserObject(String json){
        Gson gson = new Gson();
        // Just Specify the class the json is need to be parsed into.
        User u = gson.fromJson(json, User.class);
        return u;
    }
    
    // parse Json input into Trade class object.
    public static Broker parseJsonToBrokerObject(String json){
        Gson gson = new Gson();
        // Just Specify the class the json is need to be parsed into.
        Broker u = gson.fromJson(json, Broker.class);
        return u;
    }
    
    // parse Json input into Trade class object.
    public static SingleOrder parseJsonToSingleOrderObject(String json){
        Gson gson = new Gson();
        // Just Specify the class the json is need to be parsed into.
        SingleOrder singleO = gson.fromJson(json, SingleOrder.class);
        return singleO;
    }
    
    // parse Json input into Trade class object.
    public static Trader parseJsonToTraderObject(String json){
        Gson gson = new Gson();
        // Just Specify the class the json is need to be parsed into.
        Trader t = gson.fromJson(json, Trader.class);
        return t;
    }
    
    
}
