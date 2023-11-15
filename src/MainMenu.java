import Interface.IRoom;
import api.HotelResource;
import constants.AppContant;
import model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * MainMenu.
 *
 * @author NguyenT4.
 * @since 2023/08/26.
 */
public class MainMenu {

	/**
	 * HotelResource.
	 */
	private static final HotelResource hotelResource = HotelResource.getInstance();

	/**
	 * mainMenu.
	 */
	public static void mainMenu() {
		int action = AppContant.DEFAULT;
		Scanner scanner = new Scanner(System.in);
		try {
			do {
				System.out.println(AppContant.MessagePattern.MAIN_MENU_INFO);
				action = scanner.nextInt();
				switch (action) {
					case 1:
						findAndReserveRoom();
						continue;
					case 2:
						seeMyReservations();
						continue;
					case 3:
						createAccount();
						continue;
					case 4:
						AdminMenu.adminMenu();
						continue;
					case 5:
						break;
					default:
						System.out.println(AppContant.MessagePattern.UNKNOWN_ACTION);
						break;
				}
			} while (!Objects.equals(action, AppContant.DEFAULT_ACTION));
		} catch (InputMismatchException inputMismatchEx) {
			System.out.println(AppContant.MessagePattern.INVALID_INPUT);
			mainMenu();
		}

	}

	private static void findAndReserveRoom() {
		Scanner scanner = new Scanner(System.in);
		Date currentDate = new Date();
		try {
			System.out.println(AppContant.Room.INPUT_CHECK_IN_DATE);
			Date checkInDate = new SimpleDateFormat(AppContant.DEFAULT_DATE_FORMAT).parse(scanner.nextLine());
			if (checkInDate.after(currentDate)) {
				System.out.println(AppContant.MessagePattern.INVALID_CHECK_IN_DATE);
				findAndReserveRoom();
			}

			System.out.println(AppContant.Room.INPUT_CHECK_OUT_DATE);
			Date checkOutDate = new SimpleDateFormat(AppContant.DEFAULT_DATE_FORMAT).parse(scanner.nextLine());
			if (checkOutDate.before(checkInDate)) {
				System.out.println(AppContant.MessagePattern.INVALID_CHECK_OUT_DATE);
				findAndReserveRoom();
			}
			if (Objects.nonNull(checkInDate) && Objects.nonNull(checkOutDate)) {
				Collection<IRoom> availableRooms = hotelResource.findARoom(checkInDate, checkOutDate);
				if (availableRooms.isEmpty()) {
					Collection<IRoom> alternativeRooms = hotelResource.findARoom(addDays(checkInDate),
							addDays(checkOutDate));
					if (alternativeRooms.isEmpty()) {
						System.out.println(AppContant.MessagePattern.ROOM_NOT_FOUND);
						return;
					}
					System.out.println(AppContant.MessagePattern.FOUND_ROOM_ON_ALTERNATIVE_DATE);
					System.out.println("Check-In Date: " + addDays(checkInDate));
					System.out.println("Check-Out Date: " + addDays(checkOutDate));
					alternativeRooms.forEach(System.out::println);
					System.out.println(AppContant.MessagePattern.BOOK_ROOM_INFO);
					String bookRoom = scanner.nextLine();
					while (!Objects.equals(bookRoom.length(), AppContant.DEFAULT_LENGTH_SELECT) || (!Objects
							.equals(bookRoom.substring(0, 1).toUpperCase(), AppContant.ADD_ANOTHER_ROOM)
							&& !Objects.equals(bookRoom.substring(0, 1).toUpperCase(),
									AppContant.NO_ADD_ANOTHER_ROOM))) {
						System.out.println(AppContant.MessagePattern.SELECT_OPTIONS_INFO);
						bookRoom = scanner.nextLine();
					}
					switch (bookRoom.toUpperCase()) {
						case AppContant.ADD_ANOTHER_ROOM:
							bookRoom(alternativeRooms, addDays(checkInDate), addDays(checkOutDate));
							break;
						case AppContant.NO_ADD_ANOTHER_ROOM:
							break;
						default:
							System.out.println(AppContant.MessagePattern.SELECT_OPTIONS_INFO);
							break;
					}
					return;
				}
				availableRooms.forEach(System.out::println);
				System.out.println(AppContant.MessagePattern.BOOK_ROOM_INFO);
				String bookRoom = scanner.nextLine();

				while (!Objects.equals(bookRoom.length(), AppContant.DEFAULT_LENGTH_SELECT) || (!Objects
						.equals(bookRoom.substring(0, 1).toUpperCase(), AppContant.ADD_ANOTHER_ROOM)
						&& !Objects.equals(bookRoom.substring(0, 1).toUpperCase(), AppContant.NO_ADD_ANOTHER_ROOM))) {
					System.out.println(AppContant.MessagePattern.SELECT_OPTIONS_INFO);
					bookRoom = scanner.nextLine();
				}
				switch (bookRoom.toUpperCase()) {
					case AppContant.ADD_ANOTHER_ROOM:
						bookRoom(availableRooms, checkInDate, checkOutDate);
						break;
					case AppContant.NO_ADD_ANOTHER_ROOM:
						break;
					default:
						System.out.println(AppContant.MessagePattern.SELECT_OPTIONS_INFO);
						break;
				}
			}
		} catch (ParseException parseExc) {
			System.out.println(AppContant.MessagePattern.INVALID_DATE);
			findAndReserveRoom();
		}

	}

	private static void bookRoom(Collection<IRoom> rooms, Date checkInDate, Date checkOutDate) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(AppContant.MessagePattern.ACCOUNT_INFO);
		String bookRoom = scanner.nextLine();
		while (!Objects.equals(bookRoom.length(), AppContant.DEFAULT_LENGTH_SELECT)
				|| (!Objects.equals(bookRoom.substring(0, 1).toUpperCase(), AppContant.ADD_ANOTHER_ROOM)
						&& !Objects.equals(bookRoom.substring(0, 1).toUpperCase(), AppContant.NO_ADD_ANOTHER_ROOM))) {
			System.out.println(AppContant.MessagePattern.SELECT_OPTIONS_INFO);
			bookRoom = scanner.nextLine();
		}
		switch (bookRoom.toUpperCase()) {
			case AppContant.ADD_ANOTHER_ROOM:
				System.out.println(AppContant.Account.INPUT_EMAIL);
				String email = scanner.nextLine();
				if (Objects.isNull(hotelResource.getCustomer(email))) {
					System.out.println(AppContant.MessagePattern.CUSTOMER_NOT_FOUND);
					System.out.println(AppContant.MessagePattern.CREATE_ACCOUNT_INFO);
				} else {
					System.out.println(AppContant.MessagePattern.RESERVE_INFO);
					String roomNumber = scanner.nextLine();

					if (rooms.stream().anyMatch(room -> room.getRoomNumber().equals(roomNumber))) {
						IRoom room = hotelResource.getIRoom(roomNumber);

						Reservation reservation = hotelResource.bookARoom(email, room, checkInDate, checkOutDate);
						System.out.println(AppContant.MessagePattern.RESERVE_CREATED_SUCCESSFULLY);
						System.out.println(reservation);
					} else {
						System.out.println(AppContant.MessagePattern.ROOM_NUMBER_NOT_AVAILABLE);
					}
				}
				break;
			case AppContant.NO_ADD_ANOTHER_ROOM:
				break;
			default:
				System.out.println(AppContant.MessagePattern.SELECT_OPTIONS_INFO);
				break;
		}
	}

	/**
	 * seeMyReservations.
	 */
	private static void seeMyReservations() {
		System.out.println(AppContant.Account.INPUT_EMAIL);
		Scanner scanner = new Scanner(System.in);
		String email = scanner.nextLine();
		Collection<Reservation> reservationList = hotelResource.getCustomersReservations(email);
		if (reservationList.isEmpty() || Objects.isNull(reservationList)) {
			System.out.println(AppContant.MessagePattern.RESERVATION_NOT_FOUND);
			return;
		}
		for (Reservation reservation : reservationList) {
			System.out.println(reservation);
		}
	}

	/**
	 * createAccount.
	 */
	private static void createAccount() {
		Scanner scanner = new Scanner(System.in);

		System.out.println(AppContant.Account.INPUT_EMAIL);
		String email = scanner.nextLine();

		System.out.println(AppContant.Account.INPUT_FIRST_NAME);
		String firstName = scanner.nextLine();

		System.out.println(AppContant.Account.INPUT_LAST_NAME);
		String lastName = scanner.nextLine();

		try {
			hotelResource.createACustomer(email, firstName, lastName);
			System.out.println(AppContant.Account.ACCOUNT_CREATED_SUCCESSFULLY);
		} catch (IllegalArgumentException illegalArgumentEx) {
			System.out.println(illegalArgumentEx.getMessage());
			createAccount();
		}
	}

	/**
	 * addDays.
	 *
	 * @param date Date
	 * @return calendar Date
	 */
	private static Date addDays(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, AppContant.DEFAULT_PLUS_DAY);
		return calendar.getTime();
	}
}
