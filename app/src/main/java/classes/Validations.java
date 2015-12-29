package classes;

import android.text.TextUtils;

/**
 * This class represents different behaviours related to validation done in the application while taking user input.
 * @author Pankaj Nimgade
 */
public class Validations {

    /**
     * Checks if given number is valid Phone Number
     * @param phone_Number this is the parameters to be checked
     * @return true if given number is indeed a Phone Number
     */
    public static final boolean isValidPhoneNumber(CharSequence phone_Number) {
        if (phone_Number == null || TextUtils.isEmpty(phone_Number)) {
            return false;
        } else {
            return android.util.Patterns.PHONE.matcher(phone_Number).matches();
        }
    }

    /**
     * Checks if given Name is a name of a customer,
     * Example: "first last" is a valid customer name
     * @param text this parameter represents a customer name to be checked.
     * @return true if given parameter is indeed a customer name otherwise false
     */
    public static final boolean isValidCustomerName(String text) {
        if (text == null) {
            return false;
        }
        if (text.trim().contentEquals("")) {
            return false;
        }

        if (text.trim().length() < 1) {
            return false;
        }

        if (text.trim().toLowerCase().contentEquals("null")) {
            return false;
        }

        if (!text.matches("[a-zA-Z0-9\\s&.'-]+")) {
            return false;
        }
        if (text.trim().matches("\\d+")) {
            return false;
        }

        return true;
    }

    public boolean isValidNumber(String text) {
        if (text == null) {
            return false;
        }
        if (text.trim().contentEquals("")) {
            return false;
        }
        if (text.trim().length() < 1) {
            return false;
        }

        if (text.trim().toLowerCase().contentEquals("null")) {
            return false;
        }

        if (!text.matches("\\d+")) {
            return false;
        }

        int number = Integer.parseInt(text);
        if (number <= 0) {
            return false;
        }
        return true;
    }
}
