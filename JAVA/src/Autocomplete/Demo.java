/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Autocomplete;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author kjha4
 */
public class Demo {

    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeAndWait(new Runnable() {

            @Override

            public void run() {
/////////////////////////////////////////////////////////////////////////////////////////////////////////
                List<String> myWords = new ArrayList<String>();

                CSVReader csv = new CSVReader();
                ArrayList<String> symbolList = csv.loadSymbol();

                for (String symbol : symbolList) {
                    myWords.add(symbol);
                }
                System.out.println(symbolList.size());

                StringSearchable searchable = new StringSearchable(myWords);

                AutocompleteJComboBox combo = new AutocompleteJComboBox(searchable);
/////////////////////////////////////////////////////////////////////////////////////////////////////////
                JFrame frame = new JFrame();

                frame.add(combo);

                frame.pack();

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setVisible(true);

            }

        });

    }

}
