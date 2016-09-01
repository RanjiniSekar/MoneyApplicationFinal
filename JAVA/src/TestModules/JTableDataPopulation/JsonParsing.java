/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestModules.JTableDataPopulation;

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
}
