/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Bean.Booking;
import Bean.Room;
import Bean.RoomType;
import DTO.BookingData;
import DTO.RoomTypeData;
import DTO.RoomsData;
import Logic.Billing;
import Logic.RoomBooking;
import java.awt.Color;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author thehackermonk
 */
public class BookingForm extends javax.swing.JFrame {

    /**
     * Creates new form BookingForm
     */
    public BookingForm() {
        initComponents();
    }

    /**
     * Set theme of the form
     */
    public void setTheme() {

        this.getContentPane().setBackground(new Color(246, 252, 252));

        titleLabel.setForeground(new Color(45, 58, 84));
        nameLabel.setForeground(new Color(45, 58, 84));
        contactLabel.setForeground(new Color(45, 58, 84));
        roomTypeLabel.setForeground(new Color(45, 58, 84));
        roomNoLabel.setForeground(new Color(45, 58, 84));
        fromLabel.setForeground(new Color(45, 58, 84));
        toLabel.setForeground(new Color(45, 58, 84));
        paymentLabel.setForeground(new Color(45, 58, 84));
        cancelNameLabel.setForeground(new Color(45, 58, 84));
        cancelContactLabel.setForeground(new Color(45, 58, 84));

        delBookingsTable.getTableHeader().setDefaultRenderer(new DefaultTableCellHeaderRenderer() {

            @Override
            public void setOpaque(boolean isOpaque) {
                super.setOpaque(true); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setBackground(Color c) {
                super.setBackground(new Color(45, 58, 84)); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setForeground(Color c) {
                super.setForeground(new Color(255, 255, 255)); //To change body of generated methods, choose Tools | Templates.
            }

        });

    }

    /**
     * To clear the form
     */
    public void clear() {

        DefaultComboBoxModel roomNoComboBoxModel = (DefaultComboBoxModel) roomNoComboBox.getModel();

        nameTextField.setText("");
        contactTextField.setText("");
        paymentTextField.setText("");

        roomNoComboBoxModel.removeAllElements();

    }

    public void clearCancelDialog() {

        delNameTextField.setText("");
        delContactTextField.setText("");

    }

    /**
     * to load type of rooms to combo box
     *
     * @param comboBox
     */
    public void refreshRoomTypeComboBox(DefaultComboBoxModel comboBox) {

        RoomTypeData roomTypeData = new RoomTypeData();

        ArrayList<RoomType> roomTypeList = roomTypeData.getAllRoomTypeDetails();
        Iterator<RoomType> roomTypeListIterator = roomTypeList.iterator();

        comboBox.removeAllElements();

        while (roomTypeListIterator.hasNext()) {

            RoomType roomType = roomTypeListIterator.next();

            comboBox.addElement(roomType.getType());

        }

    }

    /**
     * to load room nos to combo box
     *
     * @param comboBox
     * @param type
     */
    public void refreshRoomNoComboBox(DefaultComboBoxModel comboBox, String type) {

        RoomsData roomsData = new RoomsData();

        ArrayList<Room> roomList = roomsData.getRoomNoOfType(type);
        Iterator<Room> roomListIterator = roomList.iterator();

        comboBox.removeAllElements();

        while (roomListIterator.hasNext()) {

            Room room = roomListIterator.next();

            comboBox.addElement(room.getRoomNo());

        }

    }

    /**
     * Get all booking to the bookings Table
     *
     * @param bookingTable
     */
    public void refreshBookingTable(DefaultTableModel bookingTable) {

        BookingData bookingData = new BookingData();

        while (bookingTable.getRowCount() > 0) {
            bookingTable.removeRow(0);
        }

        ArrayList<Booking> bookingList = bookingData.getAllBookingDetails();
        Iterator<Booking> bookingListIterator = bookingList.iterator();

        while (bookingListIterator.hasNext()) {

            Booking booking = bookingListIterator.next();

            bookingTable.addRow(new Object[]{"ALaCarte#" + booking.getBookingID(), booking.getName(), booking.getContact(), booking.getRoomNo(), booking.getFromDate(), booking.getToDate()});

        }

    }

    /**
     * Get the search results to the bookings table
     *
     * @param bookingTable
     * @param name
     * @param contact
     */
    public void searchBookings(DefaultTableModel bookingTable, String name, String contact) {

        BookingData bookingData = new BookingData();

        ArrayList<Booking> bookingList = bookingData.searchBookings(name, contact);
        Iterator<Booking> bookingListIterator = bookingList.iterator();

        while (bookingTable.getRowCount() > 0) {
            bookingTable.removeRow(0);
        }

        while (bookingListIterator.hasNext()) {

            Booking booking = bookingListIterator.next();

            bookingTable.addRow(new Object[]{"ALaCarte#" + booking.getBookingID(), booking.getName(), booking.getContact(), booking.getRoomNo(), booking.getFromDate(), booking.getToDate()});

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelBookingDialog = new javax.swing.JDialog();
        cancelNameLabel = new javax.swing.JLabel();
        delNameTextField = new javax.swing.JTextField();
        cancelContactLabel = new javax.swing.JLabel();
        delContactTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        delBookingsTable = new javax.swing.JTable();
        delDeleteButton = new javax.swing.JButton();
        nameTextField = new javax.swing.JTextField();
        contactTextField = new javax.swing.JTextField();
        roomTypeComboBox = new javax.swing.JComboBox<>();
        roomNoComboBox = new javax.swing.JComboBox<>();
        fromDateChooser = new com.toedter.calendar.JDateChooser();
        toDateChooser = new com.toedter.calendar.JDateChooser();
        paymentTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        contactLabel = new javax.swing.JLabel();
        roomTypeLabel = new javax.swing.JLabel();
        roomNoLabel = new javax.swing.JLabel();
        fromLabel = new javax.swing.JLabel();
        toLabel = new javax.swing.JLabel();
        paymentLabel = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();
        bookRoomButton = new javax.swing.JButton();
        checkAvailabilityButton = new javax.swing.JButton();
        cancelBookingButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        cancelNameLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        cancelNameLabel.setText("Name");

        delNameTextField.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        delNameTextField.setText("jTextField2");
        delNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                delNameTextFieldKeyReleased(evt);
            }
        });

        cancelContactLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        cancelContactLabel.setText("Contact");

        delContactTextField.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        delContactTextField.setText("jTextField3");
        delContactTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                delContactTextFieldKeyReleased(evt);
            }
        });

        delBookingsTable.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        delBookingsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Booking ID", "Name", "Contact", "Room No", "From", "To"
            }
        ));
        jScrollPane1.setViewportView(delBookingsTable);

        delDeleteButton.setBackground(new java.awt.Color(108, 160, 209));
        delDeleteButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        delDeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        delDeleteButton.setText("DELETE BOOKING");
        delDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delDeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cancelBookingDialogLayout = new javax.swing.GroupLayout(cancelBookingDialog.getContentPane());
        cancelBookingDialog.getContentPane().setLayout(cancelBookingDialogLayout);
        cancelBookingDialogLayout.setHorizontalGroup(
            cancelBookingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cancelBookingDialogLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(delDeleteButton)
                .addGap(555, 555, 555))
            .addGroup(cancelBookingDialogLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(cancelBookingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cancelBookingDialogLayout.createSequentialGroup()
                        .addComponent(cancelNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelContactLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delContactTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        cancelBookingDialogLayout.setVerticalGroup(
            cancelBookingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cancelBookingDialogLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(cancelBookingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelNameLabel)
                    .addComponent(delNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelContactLabel)
                    .addComponent(delContactTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(delDeleteButton)
                .addGap(54, 54, 54))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        nameTextField.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        nameTextField.setText("jTextField1");

        contactTextField.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        contactTextField.setText("jTextField2");

        roomTypeComboBox.setBackground(new java.awt.Color(246, 252, 252));
        roomTypeComboBox.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        roomTypeComboBox.setForeground(new java.awt.Color(45, 58, 84));
        roomTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        roomNoComboBox.setBackground(new java.awt.Color(246, 252, 252));
        roomNoComboBox.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        roomNoComboBox.setForeground(new java.awt.Color(45, 58, 84));
        roomNoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roomNoComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                roomNoComboBoxFocusGained(evt);
            }
        });

        fromDateChooser.setBackground(new java.awt.Color(246, 252, 252));
        fromDateChooser.setForeground(new java.awt.Color(45, 58, 84));
        fromDateChooser.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        toDateChooser.setBackground(new java.awt.Color(246, 252, 252));
        toDateChooser.setForeground(new java.awt.Color(45, 58, 84));
        toDateChooser.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        paymentTextField.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        paymentTextField.setText("jTextField3");
        paymentTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                paymentTextFieldFocusGained(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nameLabel.setText("Name");

        contactLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        contactLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        contactLabel.setText("Contact No.");

        roomTypeLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        roomTypeLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        roomTypeLabel.setText("Room Type");

        roomNoLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        roomNoLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        roomNoLabel.setText("Room No");

        fromLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        fromLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        fromLabel.setText("From Date");

        toLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        toLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        toLabel.setText("To Date");

        paymentLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        paymentLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        paymentLabel.setText("Payment");

        closeButton.setBackground(new java.awt.Color(255, 0, 0));
        closeButton.setForeground(new java.awt.Color(255, 255, 255));
        closeButton.setText("X");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        bookRoomButton.setBackground(new java.awt.Color(108, 160, 209));
        bookRoomButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        bookRoomButton.setForeground(new java.awt.Color(255, 255, 255));
        bookRoomButton.setText("BOOK ROOM");
        bookRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookRoomButtonActionPerformed(evt);
            }
        });

        checkAvailabilityButton.setBackground(new java.awt.Color(108, 160, 209));
        checkAvailabilityButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        checkAvailabilityButton.setForeground(new java.awt.Color(255, 255, 255));
        checkAvailabilityButton.setText("CHECK AVAILABILITY");
        checkAvailabilityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAvailabilityButtonActionPerformed(evt);
            }
        });

        cancelBookingButton.setBackground(new java.awt.Color(108, 160, 209));
        cancelBookingButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        cancelBookingButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelBookingButton.setText("CANCEL BOOKING");
        cancelBookingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBookingButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        titleLabel.setText("Booking");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(565, 565, 565)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nameLabel)
                    .addComponent(contactLabel)
                    .addComponent(roomTypeLabel)
                    .addComponent(roomNoLabel)
                    .addComponent(fromLabel)
                    .addComponent(toLabel)
                    .addComponent(paymentLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameTextField)
                    .addComponent(contactTextField)
                    .addComponent(roomTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roomNoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fromDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paymentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(557, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(500, 500, 500)
                .addComponent(bookRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelBookingButton)
                .addGap(500, 500, 500))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(643, 643, 643))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(checkAvailabilityButton)
                        .addGap(597, 597, 597))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(titleLabel)
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomTypeLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomNoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomNoLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(checkAvailabilityButton)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paymentLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookRoomButton)
                    .addComponent(cancelBookingButton))
                .addGap(100, 100, 100))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

        setTheme();

        DefaultComboBoxModel roomTypeComboBoxModel = (DefaultComboBoxModel) roomTypeComboBox.getModel();

        clear();
        refreshRoomTypeComboBox(roomTypeComboBoxModel);
        paymentTextField.setEditable(false);
        bookRoomButton.setEnabled(false);
        nameTextField.requestFocus();

        fromDateChooser.setMinSelectableDate(Calendar.getInstance().getTime());
        toDateChooser.setMinSelectableDate(Calendar.getInstance().getTime());

    }//GEN-LAST:event_formWindowGainedFocus

    private void roomNoComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roomNoComboBoxFocusGained

        DefaultComboBoxModel roomNoComboBoxModel = (DefaultComboBoxModel) roomNoComboBox.getModel();

        String type = roomTypeComboBox.getSelectedItem().toString();

        refreshRoomNoComboBox(roomNoComboBoxModel, type);

    }//GEN-LAST:event_roomNoComboBoxFocusGained

    private void paymentTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_paymentTextFieldFocusGained

        Billing billing = new Billing();

        String type;
        Date fromDate, toDate;
        int percentage = 20;
        float payment;

        type = roomTypeComboBox.getSelectedItem().toString();
        fromDate = fromDateChooser.getDate();
        toDate = toDateChooser.getDate();

        if (type.equals("")) {

            payment = billing.calculateAdvancePayment(type, fromDate, toDate, percentage);

            paymentTextField.setText(payment + "");

        }

    }//GEN-LAST:event_paymentTextFieldFocusGained

    private void bookRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookRoomButtonActionPerformed

        Booking booking = new Booking();
        BookingData bookingData = new BookingData();

        int bookingID;

        booking.setName(nameTextField.getText());
        booking.setContact(contactTextField.getText());
        booking.setRoomNo(Integer.parseInt(roomNoComboBox.getSelectedItem().toString()));
        booking.setFromDate(fromDateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        booking.setToDate(toDateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        booking.setPayment(Float.parseFloat(paymentTextField.getText()));

        if (bookingData.bookRoom(booking)) {

            JOptionPane.showMessageDialog(null, "Your booking was successful!");

        }
        bookingID = bookingData.getLastBookingID();
        JOptionPane.showMessageDialog(null, "Your booking number is ALaCarte#" + bookingID);

    }//GEN-LAST:event_bookRoomButtonActionPerformed

    private void checkAvailabilityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAvailabilityButtonActionPerformed

        RoomBooking room = new RoomBooking();

        if (roomNoComboBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Please select room no!");
        } else if (fromDateChooser.getDate() == null || toDateChooser.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Please select both dates!");
        } else {

            int roomNo = Integer.parseInt(roomNoComboBox.getSelectedItem().toString());
            LocalDate fromDate = fromDateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate toDate = toDateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if (room.checkAvailability(roomNo, fromDate, toDate)) {
                bookRoomButton.setEnabled(true);
            } else {
                bookRoomButton.setEnabled(false);
            }
        }
    }//GEN-LAST:event_checkAvailabilityButtonActionPerformed

    private void cancelBookingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBookingButtonActionPerformed

        DefaultTableModel bookingTableModel = (DefaultTableModel) delBookingsTable.getModel();

        clearCancelDialog();
        refreshBookingTable(bookingTableModel);

        cancelBookingDialog.setSize(1250, 650);
        cancelBookingDialog.show();

    }//GEN-LAST:event_cancelBookingButtonActionPerformed

    private void delNameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_delNameTextFieldKeyReleased

        DefaultTableModel tableModel = (DefaultTableModel) delBookingsTable.getModel();
        String name, contact;

        if (delNameTextField.getText() == null) {
            name = "";
        } else {
            name = delNameTextField.getText();
        }

        if (delContactTextField.getText() == null) {
            contact = "";
        } else {
            contact = delContactTextField.getText();
        }

        searchBookings(tableModel, name, contact);

    }//GEN-LAST:event_delNameTextFieldKeyReleased

    private void delContactTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_delContactTextFieldKeyReleased

        DefaultTableModel tableModel = (DefaultTableModel) delBookingsTable.getModel();
        String name, contact;

        if (delNameTextField.getText() == null) {
            name = "";
        } else {
            name = delNameTextField.getText();
        }

        if (delContactTextField.getText() == null) {
            contact = "";
        } else {
            contact = delContactTextField.getText();
        }

        searchBookings(tableModel, name, contact);

    }//GEN-LAST:event_delContactTextFieldKeyReleased

    private void delDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delDeleteButtonActionPerformed

        BookingData bookingData = new BookingData();

        String bookingID;
        int booking, confirm;

        JOptionPane.showMessageDialog(null, "Enter booking ID like ALaCarte#1");
        bookingID = JOptionPane.showInputDialog("Enter booking ID");
        booking = Integer.parseInt(bookingID.substring(9));
        confirm = JOptionPane.showConfirmDialog(null, "Are you sure to delete " + bookingID);

        if (confirm == 0) {
            if (bookingData.deleteBooking(booking)) {

                JOptionPane.showMessageDialog(null, bookingID + " deleted successfully!");

            }
        }

    }//GEN-LAST:event_delDeleteButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed

        this.setVisible(false);
        new FrontOfficeMenu().show();

    }//GEN-LAST:event_closeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
 /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookingForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookRoomButton;
    private javax.swing.JButton cancelBookingButton;
    private javax.swing.JDialog cancelBookingDialog;
    private javax.swing.JLabel cancelContactLabel;
    private javax.swing.JLabel cancelNameLabel;
    private javax.swing.JButton checkAvailabilityButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel contactLabel;
    private javax.swing.JTextField contactTextField;
    private javax.swing.JTable delBookingsTable;
    private javax.swing.JTextField delContactTextField;
    private javax.swing.JButton delDeleteButton;
    private javax.swing.JTextField delNameTextField;
    private com.toedter.calendar.JDateChooser fromDateChooser;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel paymentLabel;
    private javax.swing.JTextField paymentTextField;
    private javax.swing.JComboBox<String> roomNoComboBox;
    private javax.swing.JLabel roomNoLabel;
    private javax.swing.JComboBox<String> roomTypeComboBox;
    private javax.swing.JLabel roomTypeLabel;
    private javax.swing.JLabel titleLabel;
    private com.toedter.calendar.JDateChooser toDateChooser;
    private javax.swing.JLabel toLabel;
    // End of variables declaration//GEN-END:variables
}
