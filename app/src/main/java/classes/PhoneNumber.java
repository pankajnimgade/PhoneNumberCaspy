package classes;

/**
 * This class represents Phone Number
 * @author Pankaj Nimgade
 */
public class PhoneNumber {

    /**
     * This keeps count of PhoneNumber object
     */
    private static double phone_Number_Count;
    /**
     * set this value to true if it is been assigned to a customer
     * */
    private String phone_Number;

    /**
     * this is serial number for each Phone number object
     * (and can be considered as Primary id if this data was to be fetched from remote or local database)
     * */
    private double phone_Number_Serial_Number;

    /**
     * set this value to true if it is been assigned to a customer
     * */
    private boolean isAssigned;

    static {
        phone_Number_Count = 0;
    }


    /**
     * An Empty constructor that it may be used in parsing if used in JAX-RS, which is used to
     * convert things in JSON / XML.
     * */
    public PhoneNumber() {
        phone_Number_Count++;
        phone_Number_Serial_Number = phone_Number_Count;
    }


    /**
     * @param phone is the Phone Number is text
     * */
    public PhoneNumber(String phone) {
        phone_Number_Count++;
        phone_Number_Serial_Number = phone_Number_Count;
        if (checkNumber(phone)) {
            this.phone_Number = phone;
        }else{
            throw new InvalidPhoneNumber();
        }
        isAssigned = false;
    }

    public static double getPhone_Number_Count() {
        return phone_Number_Count;
    }

    public static void setPhone_Number_Count(double phone_Number_Count) {
        PhoneNumber.phone_Number_Count = phone_Number_Count;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

    /**
     * @return true if given instance of PhoneNumber is assigned to a customer otherwise false.
     */
    public boolean isAssigned() {
        return isAssigned;
    }

    public void setIsAssigned(boolean isAssigned) {
        this.isAssigned = isAssigned;
    }

    /**
     * This method checks if given number is valid Number
     * @param number this is the parameters to be checked
     * @return true if the given number is indeed a number otherwise false
     */
    private boolean checkNumber(String number){
        if (number == null) {
            return false;
        }

        if (number.length()<=0) {
            return false;
        }

        if (!number.matches("[0-9]+")) {
            return false;
        }

        return android.util.Patterns.PHONE.matcher(number).matches();
    }

    /**
     * This is the Exception thrown by the constructor if given number is not a valid Number
     */
    private class InvalidPhoneNumber extends NumberFormatException{
        public InvalidPhoneNumber() {
            super("InvalidPhoneNumber: give phone number is not a number");

        }
    }

    public double getPhone_Number_Serial_Number() {
        return phone_Number_Serial_Number;
    }

    public void setPhone_Number_Serial_Number(double phone_Number_Serial_Number) {
        this.phone_Number_Serial_Number = phone_Number_Serial_Number;
    }

    /**
     * this method is overridden, that it may be used in ArrayAdapter
     * @return phone_Number
     */
    @Override
    public String toString() {
        return phone_Number;
    }
}
