/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import TestModules.JTableDataPopulation.JsonParsing;
import UserObjects.Block;
import UserObjects.SingleOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author agopa3
 */
public class ControllerBlockOrders {

    public  ArrayList<ArrayList<SingleOrder>> MakeBlock(ArrayList<SingleOrder> parsedOrders) {

        ArrayList<ArrayList<SingleOrder>> singleOrderLists = new ArrayList<ArrayList<SingleOrder>>();
        for(int i=0;i<parsedOrders.size();i++){
            ArrayList<SingleOrder> common = new ArrayList();
            common.add(parsedOrders.get(i));
            for(int j=i+1;j<parsedOrders.size();j++){
                    if(parsedOrders.get(j).getSymbol().equals(parsedOrders.get(i).getSymbol()) && parsedOrders.get(j).getAction().equals(parsedOrders.get(i).getAction()) && parsedOrders.get(j).getStockExchange().equals(parsedOrders.get(i).getStockExchange())){
                        if(parsedOrders.get(j).getOrderType().equals(parsedOrders.get(i).getOrderType())){
                            if(parsedOrders.get(j).getOrderType().equals("Market Order")){
                               // common.add(parsedOrders.get(i));
                                common.add(parsedOrders.get(j));
                                parsedOrders.remove(parsedOrders.get(j));
                            }
                            else if(parsedOrders.get(j).getOrderType().equals("Stop Order")){
                                if(parsedOrders.get(j).getStopPrice()==parsedOrders.get(i).getStopPrice()){
                                   // common.add(parsedOrders.get(i));
                                    common.add(parsedOrders.get(j));
                                    parsedOrders.remove(parsedOrders.get(j));
                                }
                            }
                            else if(parsedOrders.get(j).getOrderType().equals("Limit Order")){
                                if(parsedOrders.get(j).getLimitPrice()==parsedOrders.get(i).getLimitPrice()){
                                   // common.add(parsedOrders.get(i));
                                    common.add(parsedOrders.get(j));
                                    parsedOrders.remove(parsedOrders.get(j));
                                }
                            }
                            else if(parsedOrders.get(j).getOrderType().equals("Stop Limit Order")){
                                if(parsedOrders.get(j).getStopPrice()==parsedOrders.get(i).getStopPrice() && parsedOrders.get(j).getLimitPrice()==parsedOrders.get(i).getLimitPrice()){
                                   
                                    common.add(parsedOrders.get(j));
                                    parsedOrders.remove(parsedOrders.get(j));
                                }
                            }
                        }
                    }
  
            }
            singleOrderLists.add(common);
            System.out.println(common);
        }
        System.out.println(singleOrderLists);
        return singleOrderLists;
  }
}
   
