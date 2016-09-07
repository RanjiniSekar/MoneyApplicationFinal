/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Autocomplete;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

public class MyTableCellEditor extends AbstractCellEditor implements TableCellEditor {

    List<String> myWords = new ArrayList<String>();

    CSVReader csv = new CSVReader();
    ArrayList<String> symbolList = csv.loadSymbol();

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
        int rowIndex, int vColIndex) {

        for (String symbol : symbolList) {
            myWords.add(symbol);
        }

        StringSearchable searchable = new StringSearchable(myWords);
        JComponent component = new AutocompleteJComboBox(searchable);

        return component;
    }

    @Override
    public Object getCellEditorValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
