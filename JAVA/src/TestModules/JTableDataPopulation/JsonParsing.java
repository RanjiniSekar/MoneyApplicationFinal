/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestModules.JTableDataPopulation;

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
    // parse Json input into Trade class object.
    public static User parseJsonToUserObject(String json){
        Gson gson = new Gson();
        // Just Specify the class the json is need to be parsed into.
        User u = gson.fromJson(json, User.class);
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
        System.out.println("Trying to parse into trader: "  + json);
        Gson gson = new Gson();
        // Just Specify the class the json is need to be parsed into.
        Trader t = gson.fromJson(json, Trader.class);
        System.out.println("TRADER PARSING SUCCESS. RETURNING TRADER.");
        return t;
    }
    
    
}
