/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.Date;

/**
 *
 * @author thehackermonk
 */
public class CalendarOperations {

    /**
     * Calculate no of days between two given dates
     *
     * @param start: start date
     * @param end: end date
     * @return : no of days
     */
    public long calculateDateDiff(Date start, Date end) {

        long startTime, endTime, diffDays, diffTime;

        startTime = start.getTime();
        endTime = end.getTime();
        diffTime = endTime - startTime;
        diffDays = diffTime / (1000 * 60 * 60 * 24);

        return diffDays;

    }

}
