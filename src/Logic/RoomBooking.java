/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Bean.Booking;
import DTO.BookingData;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author thehackermonk
 */
public class RoomBooking {

    /**
     * Check if room is available
     *
     * @param roomNo
     * @param fromDate
     * @param toDate
     * @return true is room is available for booking and false otherwise
     */
    public boolean checkAvailability(int roomNo, LocalDate fromDate, LocalDate toDate) {

        BookingData bookingData = new BookingData();

        ArrayList<Booking> bookingList = bookingData.bookingDetails(roomNo);
        Iterator<Booking> bookingListIterator = bookingList.iterator();

        while (bookingListIterator.hasNext()) {

            Booking booking = bookingListIterator.next();

            System.out.println(booking.getFromDate() + " : " + booking.getToDate());

            if (!(fromDate.isBefore(booking.getFromDate()) && toDate.isBefore(booking.getToDate())) || (fromDate.isAfter(booking.getFromDate()) && toDate.isAfter(booking.getToDate()))) {
                return false;
            }

        }

        return true;

    }
}
