/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestModules.JTableDataPopulation;

import java.util.ArrayList;
import javax.swing.table.TableModel;

/**
 *
 * @author kjha4
 */
public class ControllerTradeHistory {
    
    // An array of JSON.
    ArrayList<String> strArr;
    // Parsed objects from JSON is stored in it.
    ArrayList<Trade> objArr;
    
    //Constructor.    
    public ControllerTradeHistory(ArrayList strArr){
        this.strArr = strArr;
        this.objArr = new ArrayList();
    }
    
    //To add a JSON str to the strArr.
    public void addObj(String jsonStr){
        this.strArr.add(jsonStr);
    } 
    
    // This returns the TableModel for Trade type object.
    public TableModel getTableModel(){

        for(String str : strArr){
            // JsonParsing has static methods to parse String to Object.
            this.objArr.add(JsonParsing.parseJsonToTradeObject(str));
        }
        return new TradeHistoryTableModel(objArr);
    }
  
}
