/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author thehackermonk
 */
public class Sort {

    /**
     * Sort the values in alphabetical order
     *
     * @param comboBoxModel
     */
    public void sortComboBox(DefaultComboBoxModel comboBoxModel) {

        ArrayList<String> sortedList = new ArrayList<>();
        int i;

        for (i = 0; i < comboBoxModel.getSize(); i++) {
            sortedList.add(comboBoxModel.getElementAt(i).toString());
        }

        Collections.sort(sortedList);

        comboBoxModel.removeAllElements();

        sortedList.forEach(value -> {
            comboBoxModel.addElement(value);
        });

    }

}
