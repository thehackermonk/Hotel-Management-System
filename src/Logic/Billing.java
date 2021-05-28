/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Bean.FoodOrder;
import Bean.OrderedFood;
import Bean.RoomType;
import DTO.BookingData;
import DTO.FoodData;
import DTO.OrderFoodData;
import DTO.RoomTypeData;
import DTO.RoomsData;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

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

    /**
     * Get total amount to be payed without subtracting the advance amount
     *
     * @param roomNo
     * @param checkInDate
     * @param checkOutDate
     * @return total amount to be payed
     */
    public float getTotalAmount(int roomNo, Date checkInDate, Date checkOutDate) {

        CalendarOperations calendarOperations = new CalendarOperations();

        long dateDiff;
        float bill = 0, roomBill, restaurantBill;

        dateDiff = calendarOperations.calculateDateDiff(checkInDate, checkOutDate);

        roomBill = getRoomBill(roomNo, dateDiff);
        restaurantBill = getRestaurantBill(roomNo, checkInDate, checkOutDate);

        bill = roomBill + restaurantBill;

        return bill;

    }

    /**
     * Get total amount to be payed after subtracting the advance amount
     *
     * @param roomNo
     * @param checkInDate
     * @param checkOutDate
     * @return total amount to be payed
     */
    public float getPayableAmount(int roomNo, int bookingID, Date checkInDate, Date checkOutDate) {

        float bill, totalPayment, advancePayment = 0;

        totalPayment = getTotalAmount(roomNo, checkInDate, checkOutDate);

        if (bookingID != 0) {
            advancePayment = getAdvanceAmount(bookingID);
        }

        bill = totalPayment - advancePayment;

        return bill;

    }

    /**
     * Get bill of staying in the hotel
     *
     * @param roomNo
     * @param noOfDays
     * @return amount
     */
    public float getRoomBill(int roomNo, long noOfDays) {

        RoomsData roomsData = new RoomsData();
        RoomTypeData roomTypeData = new RoomTypeData();

        String roomType;
        float bill = 0, price;

        roomType = roomsData.getRoomDetails(roomNo).getType();
        price = roomTypeData.getRoomTypeDetails(roomType).getPrice();

        bill = noOfDays * price;

        return bill;

    }

    /**
     * Get bill of total food ordered during the time period
     *
     * @param roomNo
     * @param checkInDate
     * @param checkOutDate
     * @return amount
     */
    public float getRestaurantBill(int roomNo, Date checkInDate, Date checkOutDate) {

        OrderFoodData orderFoodData = new OrderFoodData();
        FoodData foodData = new FoodData();

        ArrayList<FoodOrder> foodOrderList = new ArrayList<>();
        ArrayList<OrderedFood> orderedFoodList = new ArrayList<>();

        Iterator<FoodOrder> foodOrderListIterator;
        Iterator<OrderedFood> orderedFoodListIterator;

        float bill = 0;

        foodOrderList = orderFoodData.getOrderDetails(roomNo, checkInDate, checkOutDate);
        foodOrderListIterator = foodOrderList.iterator();

        while (foodOrderListIterator.hasNext()) {

            FoodOrder foodOrder = foodOrderListIterator.next();

            orderedFoodList = orderFoodData.getOrderDetails(foodOrder.getOrderNo());
            orderedFoodListIterator = orderedFoodList.iterator();

            while (orderedFoodListIterator.hasNext()) {

                OrderedFood orderedFood = orderedFoodListIterator.next();

                bill += ((foodData.getFoodDetails(orderedFood.getFoodNo()).getPrice()) * orderedFood.getQuantity());

            }

        }

        return bill;

    }

    /**
     * Get total amount payed by the guest in advance
     *
     * @param bookingID
     * @return amount
     */
    public float getAdvanceAmount(int bookingID) {

        BookingData bookingData = new BookingData();

        float amount = 0;

        amount = bookingData.getBookingDetails(bookingID).getPayment();

        return amount;

    }

}
