package service;

import constants.AppContant;
import model.Customer;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * CustomerService.
 *
 * @author NguyenT4.
 * @sine 2023/08/24.
 */
public class CustomerService {

  /**
   * Type Singleton.
   */
  private static final CustomerService instance = new CustomerService();

  /**
   * Customer Map.
   */
  private final Map<String, Customer> customerMap = new HashMap<>();

  /**
   * CustomerService.
   */
  private CustomerService() {
  }

  /**
   * getInstance.
   *
   * @return instance CustomerService
   */
  public static CustomerService getInstance() {
    return instance;
  }

  /**
   * addCustomer.
   *
   * @param email     Email.
   * @param firstName FirstName.
   * @param lastName  LastName.
   */
  public void addCustomer(String email, String firstName, String lastName) {
    customerMap.put(email, new Customer(firstName, lastName, email));
  }

  /**
   * getCustomer.
   *
   * @param email Email.
   * @return customerMap Customer.
   */
  public Customer getCustomer(String email) {
    return customerMap.get(email);
  }

  /**
   * getAllCustomers.
   *
   * @return customerMap List Customer
   */
  public Collection<Customer> getAllCustomers() {
    if (customerMap.values().isEmpty()) {
      System.out.println(AppContant.MessagePattern.CUSTOMER_NOT_FOUND);
      return Collections.emptyList();
    }
    return customerMap.values();
  }
}
