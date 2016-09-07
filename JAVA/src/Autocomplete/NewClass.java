/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Autocomplete;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author kjha4
 */
public class NewClass {

    public static void main(String[] args) {
        // For the symbol list
        List<String> myWords = new ArrayList<String>();

        // load all symbol from the csv file.
        CSVReader csv = new CSVReader();
        ArrayList<String> symbolList = csv.loadSymbol();

        for (String symbol : symbolList) {
            myWords.add(symbol);
        }

        //Make a autocomplete JComboBox
        StringSearchable searchable = new StringSearchable(myWords);
        AutocompleteJComboBox autoBox = new AutocompleteJComboBox(searchable);

        //Create a frame to display JComboBox
        JFrame frame = new JFrame();

        frame.add(autoBox);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
