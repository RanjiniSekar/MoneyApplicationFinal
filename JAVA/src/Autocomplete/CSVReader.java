package Autocomplete;

import Autocomplete.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class CSVReader {
    
    public static void main(String[] args) {

        //String csvFile = "/Users/mkyong/csv/country.csv";
        
        CSVReader csv = new CSVReader();
        ArrayList<String> symbolList = csv.loadSymbol();
        
            for(String symbol : symbolList){
                System.out.println(symbol);
            }
            
            String[] symbolArray = (String[])CSVReader.loadSymbol().toArray();
            System.out.println(symbolArray[10]);
        
    }
    
    public static ArrayList<String> loadSymbol(){
        String csvFile=".\\JAVA\\Resources\\symbols_NYSE.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        TreeMap<String, String> symbols = new TreeMap<String, String>();
        ArrayList<String> symbolList = new ArrayList<String>();
        
        try {
            
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] symbol = line.split(cvsSplitBy);
                //System.out.println("Symbol : " + symbol[0] + ", name : " + symbol[1] + "]");
                symbols.put(symbol[0], symbol[1]);
                symbolList.add(symbol[0]);
            }
            
//            for(String symbol : symbols.keySet()){
//                System.out.println(symbol+ "  " + symbols.get(symbol) );
//            }
            
            return symbolList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
