/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Bean.FoodProduction;
import DTO.FoodProductionData;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

/**
 *
 * @author thehackermonk
 */
public class FoodProductionLogic {

    public ArrayList<FoodProduction> getFoodProducedToday() {

        FoodProductionData foodProductionData = new FoodProductionData();

        Date date = new Date(Calendar.getInstance().getTime().getTime());

        return (foodProductionData.getFoodProducedToday(date));

    }

    public boolean produceFood(ArrayList<FoodProduction> foodProductionList) {

        FoodProductionData foodProductionData = new FoodProductionData();

        Date date = new Date(Calendar.getInstance().getTime().getTime());

        Iterator<FoodProduction> foodProductionListIterator = foodProductionList.iterator();

        while (foodProductionListIterator.hasNext()) {

            FoodProduction foodProduction = foodProductionListIterator.next();

            foodProduction.setProductionDate(date);

            foodProductionData.clearTodaysFood(foodProduction);
            foodProductionData.addTodaysFood(foodProduction);

        }

        return true;

    }

}
