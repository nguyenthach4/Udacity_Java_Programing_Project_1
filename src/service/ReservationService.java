package service;

import Interface.IRoom;
import constants.AppContant;
import model.Customer;
import model.Reservation;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ReservationService.
 *
 * @author NguyenT4.
 * @since 2023/08/24.
 */
public class ReservationService {

	/**
	 * Type Singleton.
	 */
	private static final ReservationService instance = new ReservationService();

	/**
	 * Room Map.
	 */
	HashSet<IRoom> roomHashSet = new HashSet<>();

	/**
	 * Reservation Map.
	 */
	Map<String, LinkedList<Reservation>> reservationMap = new HashMap<>();

	private ReservationService() {

	}

	/**
	 * getInstance.
	 *
	 * @return instance ReservationService.
	 */
	public static ReservationService getInstance() {
		return instance;
	}

	/**
	 * addRoom.
	 *
	 * @param room Room.
	 */
	public void addRoom(IRoom room) {
		roomHashSet.add(room);
	}

	/**
	 * getARoom.
	 *
	 * @param roomId RoomID.
	 * @return roomMap IRoom.
	 */
	public IRoom getARoom(String roomId) {
		for (IRoom room : roomHashSet) {
			if (Objects.equals(room.getRoomNumber(), roomId)) {
				return room;
			}
		}
		return null;
	}

	/**
	 * getAllRooms.
	 *
	 * @return roomMap List Room.
	 */
	public Collection<IRoom> getAllRooms() {
		if (roomHashSet.isEmpty()) {
			System.out.println(AppContant.MessagePattern.ROOM_NOT_FOUND);
			return Collections.emptyList();
		}
		return roomHashSet;
	}

	/**
	 * reserveARoom.
	 *
	 * @param customer     Customer
	 * @param room         IRoom
	 * @param checkInDate  Date
	 * @param checkOutDate Date
	 * @return reservation Reservation
	 */
	public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
		Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
		reservationMap.computeIfAbsent(customer.getEmail(), key -> new LinkedList<>());
		reservationMap.put(customer.getEmail(), reservationMap.get(customer.getEmail())).add(reservation);
		return reservation;
	}

	/**
	 * findRooms.
	 *
	 * @param checkInDate  CheckInDate
	 * @param checkOutDate CheckOutDate
	 * @return roomResponse IRoom Collection
	 */
	public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
		Collection<Reservation> reservationList = new LinkedList<>();
		reservationMap.values().forEach(reservationList::addAll);
		Collection<IRoom> noRooms = new LinkedList<IRoom>();
		for (Reservation reservation : reservationList) {
			if (checkInDate.before(reservation.getCheckOutDate()) && checkOutDate.after(reservation.getCheckInDate())) {
				noRooms.add(reservation.getRoom());
			}
		}
		return roomHashSet.stream().filter(room -> !noRooms.contains(room)).collect(Collectors.toList());
	}

	/**
	 * getCustomersReservation.
	 *
	 * @param customer Customer.
	 * @return reservationMap List Reservation.
	 */
	public Collection<Reservation> getCustomersReservation(Customer customer) {
		return reservationMap.get(customer.getEmail());
	}

	/**
	 * printAllReservation.
	 */
	public void printAllReservation() {
		Collection<Reservation> reservationList = new LinkedList<>();
		reservationMap.values().forEach(reservationList::addAll);
		if (reservationList.isEmpty()) {
			System.out.println(AppContant.MessagePattern.RESERVATION_NOT_FOUND);
			return;
		}
		for (Reservation reservation : reservationList) {
			System.out.println(reservation);
		}
	}
}
