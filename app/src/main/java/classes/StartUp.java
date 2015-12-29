package classes;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

/**
 * This is the class which starts in the beginning to initialize prerequisites.
 * And also acts as database for the application.
 * Created by Pankaj Nimgade on 12/26/2015.
 */
public class StartUp extends Application {

    /**
     * This is the list representing all PhoneNumber instances in the application (available + assigned to customers)
     */
    private static ArrayList<PhoneNumber> phoneNumbers;

    /**
     * This list represents the customers in the application who is been assigned the phone Number
     */
    private static ArrayList<Customer> customers;

    /**
     * AS both the list are static we initialize them in static bock
     */
    static {
        phoneNumbers = new ArrayList<>();
        customers = new ArrayList<>();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setPhoneNumbers();
    }

    /**
     * this is where we populate the PhoneNumber list to carry some random number,
     * available to be assigned to the customer who would call
     */
    private void setPhoneNumbers() {
        for (int i = 0; i < 6; i++) {
            String prefix = "" + i;
            String post = prefix + "12345678";
            phoneNumbers.add(new PhoneNumber(post));
        }
    }

    /**
     * This returns entire list of PhoneNumber in the application
     * @return PhoneNumber  List in the application
     */
    public static ArrayList<PhoneNumber> getPhoneNumbers() {
        Log.d("TAG", "Start up phoneNumbers: size: " + phoneNumbers.size());
        return phoneNumbers;
    }

    /**
     * This checks if the given number already exists in the application
     * @param tempPhoneNumber this is the phone Number to be checked.
     * @return true if the given phone number already exists in the list otherwise false
     */
    public static boolean isAlreadyInList(String tempPhoneNumber) {
        for (PhoneNumber phoneNumber : phoneNumbers) {
            if (phoneNumber.getPhone_Number().trim().contentEquals(tempPhoneNumber)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This find a given phone Number in the list and returns it
     * @param tempPhoneNumber this the phone number to be searched in the PhoneNumber List
     * @return PhoneNumber instance if it exists otherwise null
     */
    public static PhoneNumber findGivenPhoneNumber(String tempPhoneNumber) {
        PhoneNumber phoneNumber = null;
        if (getUnusedPhoneNumbers().size() > 0) {
            for (PhoneNumber number : getUnusedPhoneNumbers()) {
                if (number.getPhone_Number().trim().contentEquals(tempPhoneNumber.trim())) {
                    phoneNumber = number;
                    break;
                }
            }
        }
        return phoneNumber;
    }

    /**
     * This method tries to add a given Phone Number to the List, while checking if it already exists.
     * @param tempPhoneNumber this is the phone Number to be added
     * @return returns appropriate Response instance depending on the result.
     */
    public static Response addPhoneNumber(String tempPhoneNumber) {
        Response response = new Response();
        PhoneNumber phoneNumber = null;
        if (getUnusedPhoneNumbers().size() > 0) {
            for (PhoneNumber number : getUnusedPhoneNumbers()) {
                if (number.getPhone_Number().trim().contentEquals(tempPhoneNumber.trim())) {
                    response.setMessage("Number already exists in List");
                    phoneNumber = number;
                    return response;
                }
            }
        }

        if (phoneNumber == null) {
            phoneNumber = new PhoneNumber();
            phoneNumber.setPhone_Number(tempPhoneNumber.trim());
            response.setIsSuccessful(true);
            response.setMessage("Number has been Added");
            phoneNumbers.add(0, phoneNumber);
        }
        return response;
    }

    public static ArrayList<PhoneNumber> getUnusedPhoneNumbers() {
        ArrayList<PhoneNumber> temp = new ArrayList<>();
        for (PhoneNumber phoneNumber : phoneNumbers) {
            if (!phoneNumber.isAssigned()) {
                temp.add(phoneNumber);
            }
        }
        return temp;
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(ArrayList<Customer> customers) {
        StartUp.customers = customers;
    }


    public static void addNumber() {

    }
}
