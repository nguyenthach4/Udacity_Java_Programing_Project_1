package test;

import model.Customer;

/**
 * Tester.
 *
 * @author NguyenT4.
 * @sine 2023/08/24.
 */
public class Tester {

  public static void main(String[] args) {

    /**
     * Customer.
     */
    Customer customer = new Customer("Nguyen", "Thach", "Nguyen@123.com");

    // Display Customer
    System.out.println(customer.toString());

    try {
      // Customer Invalid
      Customer customerInvalid = new Customer("Nguyen", "Thach", "email");
    } catch (IllegalArgumentException illegalArgumentEx) {
      System.out.println(illegalArgumentEx.getMessage());
    }

  }
}
