/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Bean.RoomType;
import DTO.RoomTypeData;
import java.time.Duration;
import java.util.Date;

/**
 *
 * @author thehackermonk
 */
public class Billing {

    /**
     * Calculate advance payment
     *
     * @param type Type of room
     * @param fromDate
     * @param toDate
     * @param percentage How much percentage to collect in advance
     * @return total amount to be collected
     */
    public float calculateAdvancePayment(String type, Date fromDate, Date toDate, int percentage) {

        RoomTypeData roomTypeData = new RoomTypeData();

        RoomType roomType;
        long dateDiff;
        float price, payment;

        roomType = roomTypeData.getRoomTypeDetails(type);
        price = roomType.getPrice();

        dateDiff = Duration.between(fromDate.toInstant(), toDate.toInstant()).toDays();

        payment = price * dateDiff;
        payment = (payment * percentage) / 100;

        return payment;

    }

}
