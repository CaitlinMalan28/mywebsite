package za.co.shinysneaker.util;

import java.util.UUID;
import org.apache.commons.validator.routines.EmailValidator;

public class Helper {
    public static boolean NullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isValidEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

    // Todo: isValidPostalCode method - 4 digits with range 1000 to 9999
    public static boolean isValidPostalCode(int postalCode) {
        if (postalCode < 1000 || postalCode > 9999) {
            return false;
        }
        return true;
    }

    // Todo: isValidStreetNumber method - 1 to 5 digits with range 1 to 99999
    public static boolean isValidStreetNumber(String streetNumber) {
        if (streetNumber == null || streetNumber.isEmpty()) return false;
        try {
            int number = Integer.parseInt(streetNumber);
            return number >= 1 && number <= 99999;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static String generateId() {
        return UUID.randomUUID().toString();
    }


}
