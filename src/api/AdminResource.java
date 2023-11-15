package api;

import Interface.IRoom;
import model.Customer;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

/**
 * AdminResource.
 *
 * @author NguyenT4.
 * @since 2023/08/26.
 */
public class AdminResource {
  /**
   * Type Singleton.
   */
  private static final AdminResource instance = new AdminResource();

  /**
   * CustomerService.
   */
  private static final CustomerService customerService = CustomerService.getInstance();

  /**
   * ReservationService.
   */
  private static final ReservationService reservationService = ReservationService.getInstance();

  private AdminResource() {

  }

  /**
   * getInstance.
   *
   * @return instance AdminResource.
   */
  public static AdminResource getInstance() {
    return instance;
  }

  public Customer getCustomer(String email) {
    return customerService.getCustomer(email);
  }

  public void addRoom(List<IRoom> rooms) {
    rooms.forEach(reservationService::addRoom);
  }

  public Collection<IRoom> getAllRooms() {
    return reservationService.getAllRooms();
  }

  public Collection<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

  public void displayAllReservations() {
    reservationService.printAllReservation();
  }
}
