package api;

import Interface.IRoom;
import model.Customer;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;

/**
 * HotelResource.
 *
 * @author NguyenT4.
 * @since 2023/08/26
 */
public class HotelResource {

	/**
	 * Type Singleton.
	 */
	private static final HotelResource instance = new HotelResource();

	/**
	 * CustomerService.
	 */
	private static final CustomerService customerService = CustomerService.getInstance();

	/**
	 * ReservationService.
	 */
	private static final ReservationService reservationService = ReservationService.getInstance();

	private HotelResource() {

	}

	/**
	 * getInstance.
	 *
	 * @return instance HotelResource.
	 */
	public static HotelResource getInstance() {
		return instance;
	}

	public Customer getCustomer(String email) {
		return customerService.getCustomer(email);
	}

	public void createACustomer(String email, String firstName, String lastName) {
		customerService.addCustomer(email, firstName, lastName);
	}

	public IRoom getIRoom(String numberRoom) {
		return reservationService.getARoom(numberRoom);
	}

	public Reservation bookARoom(String customerEmail, IRoom room, Date checkIndate, Date checkOutDate) {
		return reservationService.reserveARoom(getCustomer(customerEmail), room, checkIndate, checkOutDate);
	}

	public Collection<Reservation> getCustomersReservations(String customerEmail) {
		return Objects.isNull(getCustomer(customerEmail)) ? Collections.emptyList()
				: reservationService.getCustomersReservation(getCustomer(customerEmail));
	}

	public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
		return reservationService.findRooms(checkIn, checkOut);
	}
}
