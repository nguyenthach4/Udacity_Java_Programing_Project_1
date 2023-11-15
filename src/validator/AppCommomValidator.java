package validator;

import constants.AppContant;

import java.text.MessageFormat;
import java.util.regex.Pattern;

/**
 * AppCommomValidator.
 *
 * @author NguyenT4.
 * @sine 2023/08/24.
 */
public class AppCommomValidator {

  /**
   * isValidEmail.
   *
   * @param email Email.
   */
  public static void isValidEmail(String email) {

    if (!Pattern.compile(AppContant.EMAIL_REGEX_PATTERN).matcher(email).matches()) {
      throw new IllegalArgumentException(MessageFormat.format(AppContant.MessagePattern.EMAIL_IS_INVALID, email));
    }
  }
}
