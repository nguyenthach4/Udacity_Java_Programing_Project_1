package constants;

/**
 * AppContant.
 *
 * @author NguyenT4.
 * @since 2023/08/24
 */
public class AppContant {

	/**
	 * DEFAULT.
	 */
	public static final int DEFAULT = 0;

	/**
	 * DEFAULT_PRICE.
	 */
	public static final Double DEFAULT_PRICE = 0.0;

	/**
	 * DEFAULT_LENGTH_SELECT.
	 */
	public static final int DEFAULT_LENGTH_SELECT = 1;

	/**
	 * ADD_ANOTHER_ROOM.
	 */
	public static final String ADD_ANOTHER_ROOM = "Y";

	/**
	 * NO_ADD_ANOTHER_ROOM.
	 */
	public static final String NO_ADD_ANOTHER_ROOM = "N";

	/**
	 * EMAIL_REGEX_PATTERN.
	 */
	public static final String EMAIL_REGEX_PATTERN = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

	/**
	 * DEFAULT_DATE_FORMAT.
	 */
	public static final String DEFAULT_DATE_FORMAT = "MM/dd/yyyy";

	/**
	 * DEFAULT_PLUS_DAY.
	 */
	public static final int DEFAULT_PLUS_DAY = 7;

	/**
	 * DEFAULT_ACTION.
	 */
	public static final int DEFAULT_ACTION = 5;

	/**
	 * Room.
	 */
	public class Room {

		/**
		 * INPUT_ROOM_NUMBER.
		 */
		public static final String INPUT_ROOM_NUMBER = "Enter room number:";

		/**
		 * INPUT_ROOM_PRICE.
		 */
		public static final String INPUT_ROOM_PRICE = "Enter price per night:";

		/**
		 * INPUT_ROOM_PRICE.
		 */
		public static final String INPUT_ROOM_TYPE = "Enter room type: 1 for single bed, 2 for double bed:";

		/**
		 * ADD_ANOTHER_ROOM.
		 */
		public static final String ADD_ANOTHER_ROOM = "Would like to add another room? Y/N";

		/**
		 * INPUT_CHECK_IN_DATE.
		 */
		public static final String INPUT_CHECK_IN_DATE = "Enter Check-In Date mm/dd/yyyy example 08/27/2023";

		/**
		 * INPUT_CHECK_OUT_DATE.
		 */
		public static final String INPUT_CHECK_OUT_DATE = "Enter Check-Out Date mm/dd/yyyy example 08/30/2023";
	}

	/**
	 * Account.
	 */
	public class Account {

		/**
		 * INPUT_EMAIL.
		 */
		public static final String INPUT_EMAIL = "Enter Email format: name@domain.com";

		/**
		 * INPUT_FIRST_NAME.
		 */
		public static final String INPUT_FIRST_NAME = "Enter First Name:";

		/**
		 * INPUT_LAST_NAME.
		 */
		public static final String INPUT_LAST_NAME = "Enter Last Name:";

		/**
		 * ACCOUNT_CREATED_SUCCESSFULLY.
		 */
		public static final String ACCOUNT_CREATED_SUCCESSFULLY = "Account created successfully !";

	}

	/**
	 * MessagePattern.
	 */
	public class MessagePattern {

		/**
		 * ROOM_INFO.
		 */
		public static final String ROOM_INFO = "Room Number: {0} Price: ${1} Enumeration: {2}";

		/**
		 * CUSTOMER_INFO.
		 */
		public static final String CUSTOMER_INFO = "First Name: {0} Last Name: {1} Email: {2}";

		/**
		 * FREE_ROOM_INFO.
		 */
		public static final String FREE_ROOM_INFO = "FreeRoom: ";

		/**
		 * RESERVATION_INFO.
		 */
		public static final String RESERVATION_INFO = "Customer: {0} \nRoom: {1} \nCheckIn Date: {2} \nCheckOut Date: {3}";

		/**
		 * EMAIL_IS_INVALID.
		 */
		public static final String EMAIL_IS_INVALID = "{0} is invalid email";

		/**
		 * RESERVATION_NOT_FOUND.
		 */
		public static final String RESERVATION_NOT_FOUND = "No reservation found.";

		/**
		 * ROOM_NOT_FOUND.
		 */
		public static final String ROOM_NOT_FOUND = "No room found.";

		/**
		 * CUSTOMER_NOT_FOUND.
		 */
		public static final String CUSTOMER_NOT_FOUND = "No customer found.";

		/**
		 * INVALID_PRICE.
		 */
		public static final String INVALID_PRICE = "Invalid price! Please, enter a valid double number.";

			/**
		 * INVALID_PRICE.
		 */
		public static final String INVALID_ROOM_NUMBER = "Invalid room number! Please, enter a valid number.";

		/**
		 * INVALID_DATE.
		 */
		public static final String INVALID_DATE = "Invalid date..";

		/**
		 * INVALID_CHECK_IN_DATE.
		 */
		public static final String INVALID_CHECK_IN_DATE = "Invalid check in date..Check in date must be greater than current date";

		/**
		 * INVALID_CHECK_IN_DATE.
		 */
		public static final String INVALID_CHECK_OUT_DATE = "Invalid check out date..Check out date must be greater than check in date";

		/**
		 * INVALID_ROOM_TYPE.
		 */
		public static final String INVALID_ROOM_TYPE = "Invalid price! Please, enter 1 for single bed, 2 for double bed.";

		/**
		 * ROOM_ADD_SUCCESSFULLY.
		 */
		public static final String ROOM_ADD_SUCCESSFULLY = "Room add successfully !";

		/**
		 * UNKNOWN_ACTION.
		 */
		public static final String UNKNOWN_ACTION = "Unknown action !";

		/**
		 * ADD_ANOTHER_INFO.
		 */
		public static final String ADD_ANOTHER_INFO = "Would you like to add another room? Y/N";

		/**
		 * BOOK_ROOM_INFO.
		 */
		public static final String BOOK_ROOM_INFO = "Would you like to book? Y/N";

		/**
		 * ACCOUNT_INFO.
		 */
		public static final String ACCOUNT_INFO = "Do you have an account with us? Y/N";

		/**
		 * SELECT_OPTIONS_INFO.
		 */
		public static final String SELECT_OPTIONS_INFO = "Please enter Y (Yes) or N (No)";

		/**
		 * CREATE_ACCOUNT_INFO.
		 */
		public static final String CREATE_ACCOUNT_INFO = "You may need create a new account.";

		/**
		 * RESERVE_INFO.
		 */
		public static final String RESERVE_INFO = "What room would you like to reserve?.";

		/**
		 * RESERVE_CREATED_SUCCESSFULLY.
		 */
		public static final String RESERVE_CREATED_SUCCESSFULLY = "Reservation created successfully !";

		/**
		 * ROOM_NUMBER_NOT_AVAILABLE.
		 */
		public static final String ROOM_NUMBER_NOT_AVAILABLE = "Room number not available !";

		/**
		 * INVALID_INPUT.
		 */
		public static final String INVALID_INPUT = "Invalid input !. Please select a valid option !";

		/**
		 * FOUND_ROOM_ON_ALTERNATIVE_DATE.
		 */
		public static final String FOUND_ROOM_ON_ALTERNATIVE_DATE = "We've only found room on alternative dates";

		/**
		 * MAIN_MENU_INFO.
		 */
		public static final String MAIN_MENU_INFO = "\nWelcome to the Hotel Reservation Application\n"
				+ "-----------------------------------------------\n" + "1. Find and reserve a room\n"
				+ "2. See my reservations\n" + "3. Create an Account\n" + "4. Admin\n" + "5. Exit\n"
				+ "-----------------------------------------------\n" + "Please select a number for the menu option:\n";

		/**
		 * AMIN_MENU_INFO.
		 */
		public static final String AMIN_MENU_INFO = "\nAdmin Menu\n"
				+ "-----------------------------------------------\n" + "1. See all Customers\n" + "2. See all Rooms\n"
				+ "3. See all Reservations\n" + "4. Add a Room\n" + "5. Back to Main Menu\n"
				+ "-----------------------------------------------\n" + "Please select a number for the menu option:\n";
	}
}
