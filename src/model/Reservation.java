package model;

import Interface.IRoom;
import constants.AppContant;

import java.text.MessageFormat;
import java.util.Date;

/**
 * Reservation.
 *
 * @author NguyenT4.
 * @sine 2023/08/24.
 */
public class Reservation {

    /**
     * Customer.
     */
    private final Customer customer;

    /**
     * Room
     */
    private final IRoom room;

    /**
     * CheckInDate.
     */
    private final Date checkInDate;

    /**
     * CheckOutDate.
     */
    private final Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public IRoom getRoom() {
        return room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    @Override
    public String toString() {
        return MessageFormat.format(AppContant.MessagePattern.RESERVATION_INFO, this.customer, this.room, this.checkInDate, this.checkOutDate);
    }
}
