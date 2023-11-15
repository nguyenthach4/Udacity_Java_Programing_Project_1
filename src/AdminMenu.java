import api.AdminResource;
import constants.AppContant;
import enums.RoomType;
import model.Room;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

/**
 * AdminMenu.
 *
 * @author NguyenT4.
 * @since 2023/08/26.
 */
public class AdminMenu {

	/**
	 * AdminResource.
	 */
	private static final AdminResource adminResource = AdminResource.getInstance();

	/**
	 * adminMenu.
	 */
	public static void adminMenu() {
		int action = AppContant.DEFAULT;
		Scanner scanner = new Scanner(System.in);

		try {
			do {
				System.out.println(AppContant.MessagePattern.AMIN_MENU_INFO);
				action = scanner.nextInt();
				switch (action) {
					case 1:
						adminResource.getAllCustomers().forEach(System.out::println);
						continue;
					case 2:
						adminResource.getAllRooms().forEach(System.out::println);
						continue;
					case 3:
						adminResource.displayAllReservations();
						continue;
					case 4:
						addRoom();
						continue;
					case 5:
						System.out.println(AppContant.MessagePattern.MAIN_MENU_INFO);
						break;
					default:
						System.out.println(AppContant.MessagePattern.UNKNOWN_ACTION);
						break;
				}

			} while (!Objects.equals(action, AppContant.DEFAULT_ACTION));
		} catch (InputMismatchException inputMismatchEx) {
			System.out.println(AppContant.MessagePattern.INVALID_INPUT);
		}
	}

	/**
	 * addRoom.
	 */
	private static void addRoom() {
		Scanner scanner = new Scanner(System.in);
		String roomNumber;
		do {
			System.out.println(AppContant.Room.INPUT_ROOM_NUMBER);
			roomNumber = scanner.nextLine();
		} while (!checkRoomNumber(roomNumber));
		String roomPrice;
		do {
			System.out.println(AppContant.Room.INPUT_ROOM_PRICE);
			roomPrice = scanner.nextLine();
		} while (!checkPrice(roomPrice));
		RoomType roomType = checkRoomType();

		Room room = new Room(roomNumber, Double.parseDouble(roomPrice), roomType);

		adminResource.addRoom(Collections.singletonList(room));
		System.out.println(AppContant.MessagePattern.ROOM_ADD_SUCCESSFULLY);

		System.out.println(AppContant.MessagePattern.ADD_ANOTHER_INFO);
		String anotherRomm = scanner.nextLine();
		while (!Objects.equals(anotherRomm.length(), AppContant.DEFAULT_LENGTH_SELECT)
				|| (!Objects.equals(anotherRomm.substring(0, 1).toUpperCase(), AppContant.ADD_ANOTHER_ROOM) && !Objects
						.equals(anotherRomm.substring(0, 1).toUpperCase(), AppContant.NO_ADD_ANOTHER_ROOM))) {
			System.out.println(AppContant.MessagePattern.SELECT_OPTIONS_INFO);
			anotherRomm = scanner.nextLine();
		}
		switch (anotherRomm.toUpperCase()) {
			case AppContant.ADD_ANOTHER_ROOM:
				addRoom();
				break;
			case AppContant.NO_ADD_ANOTHER_ROOM:
				break;
			default:
				System.out.println(AppContant.MessagePattern.SELECT_OPTIONS_INFO);
				break;
		}
	}

	/**
	 * checkPrice.
	 *
	 * @param price String.
	 * @return TRUE/FALSE.
	 */
	private static boolean checkPrice(String price) {
		try {
			Double.parseDouble(price);
			return true;
		} catch (NumberFormatException numberFormatEx) {
			System.out.println(AppContant.MessagePattern.INVALID_PRICE);
			return false;
		}
	}

	/**
	 * checkRoomNumber.
	 *
	 * @param roomNumber String.
	 * @return TRUE/FALSE.
	 */
	private static boolean checkRoomNumber(String roomNumber) {
		try {
			Integer.parseInt(roomNumber);
			return true;
		} catch (NumberFormatException numberFormatEx) {
			System.out.println(AppContant.MessagePattern.INVALID_ROOM_NUMBER);
			return false;
		}
	}

	/**
	 * checkRoomType.
	 *
	 * @return roomType RoomType.
	 */
	private static RoomType checkRoomType() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println(AppContant.Room.INPUT_ROOM_TYPE);
			String type = scanner.nextLine();
			for (RoomType roomType : RoomType.values()) {
				if (roomType.valueOfRoomType(type).equals(type)) {
					return roomType;
				}
			}
			throw new IllegalArgumentException(AppContant.MessagePattern.INVALID_ROOM_TYPE);
		} catch (IllegalArgumentException illegalArgumentEx) {
			System.out.println(illegalArgumentEx.getMessage());
			return checkRoomType();
		}
	}
}