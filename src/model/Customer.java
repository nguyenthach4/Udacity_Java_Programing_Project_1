package model;

import constants.AppContant;
import validator.AppCommomValidator;

import java.text.MessageFormat;

/**
 * Customer.
 *
 * @author NguyenT4.
 * @sine 2023/08/24.
 */
public class Customer {

    /**
     * FirstName.
     */
    private final String firstName;

    /**
     * LastName.
     */
    private final String lastName;

    /**
     * Email.
     */
    private final String email;

    public Customer(String firstName, String lastName, String email) {

        AppCommomValidator.isValidEmail(email);

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return MessageFormat.format(AppContant.MessagePattern.CUSTOMER_INFO, this.firstName, this.lastName, this.email);
    }
}
