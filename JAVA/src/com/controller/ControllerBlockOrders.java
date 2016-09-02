/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

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

    public void MakeBlock(List<SingleOrder> parsedOrders) {
        //List<SingleOrder> common = new ArrayList();
        //List<SingleOrder> parsedOrders = new ArrayList();
        
        List<Block> blocks = new ArrayList();
        //parsedOrders = parsedOrders;
        for(int i=0;i<parsedOrders.size();i++){
            List<SingleOrder> common = new ArrayList();
            common.add(parsedOrders.get(i));
            for(int j=i+1;j<parsedOrders.size();j++){
                if(!parsedOrders.get(j).equals(parsedOrders.get(i))){
                    if(parsedOrders.get(j).getSymbol().equals(parsedOrders.get(i).getSymbol()) && parsedOrders.get(j).getAction().equals(parsedOrders.get(i).getAction())){
                        if(parsedOrders.get(j).getOrderType().equals(parsedOrders.get(i).getOrderType())){
                            if(parsedOrders.get(j).getOrderType().equals("Market")){
                               // common.add(parsedOrders.get(i));
                                common.add(parsedOrders.get(j));
                                parsedOrders.remove(parsedOrders.get(j));
                            }
                            else if(parsedOrders.get(j).getOrderType().equals("Stop")){
                                if(parsedOrders.get(j).getStopPrice()==parsedOrders.get(i).getStopPrice()){
                                   // common.add(parsedOrders.get(i));
                                    common.add(parsedOrders.get(j));
                                    parsedOrders.remove(parsedOrders.get(j));
                                }
                            }
                            else if(parsedOrders.get(j).getOrderType().equals("Limit")){
                                if(parsedOrders.get(j).getLimitPrice()==parsedOrders.get(i).getLimitPrice()){
                                   // common.add(parsedOrders.get(i));
                                    common.add(parsedOrders.get(j));
                                    parsedOrders.remove(parsedOrders.get(j));
                                }
                            }
                            else if(parsedOrders.get(j).getOrderType().equals("Stop Limit")){
                                if(parsedOrders.get(j).getStopPrice()==parsedOrders.get(i).getStopPrice() && parsedOrders.get(j).getLimitPrice()==parsedOrders.get(i).getLimitPrice()){
                                   
                                    common.add(parsedOrders.get(j));
                                    parsedOrders.remove(parsedOrders.get(j));
                                }
                            }
                        }
                    }
                }
            }
            if(common.size()>0){
                ArrayList c = (ArrayList) common;
                String commonSymbol = common.get(0).getSymbol();
                int totalQuantity = 0;
                        
                for(int k = 0; k < c.size(); k++){
                    totalQuantity += common.get(k).getQuantity();
                }

                String getOrderTy = common.get(0).getOrderType();
                int commonOrderType = -1;
                switch (getOrderTy) {
                    case "Market":
                        commonOrderType = 0;
                        break;
                    case "Stop":
                        commonOrderType = 1;
                        break;
                    case "Limit":
                        commonOrderType = 2;
                        break;
                    case "Stop Limit":
                        commonOrderType = 3;
                        break;
                    default:
                        break;
                }
                
                double commonStop = common.get(0).getStopPrice();
                double commonLimit = common.get(0).getLimitPrice();

                //STATUS: 1 for SENT TO BROKER, 0 for WAITING AT TRADER SIDE STILL
                Block block = new Block(commonSymbol, totalQuantity, commonOrderType, commonStop, commonLimit, 1, c);           
                blocks.add(block);
            }
        }
        for(Block b : blocks){          
            System.out.println("Blocks :\n"+ b);
        }
  }
}
   
