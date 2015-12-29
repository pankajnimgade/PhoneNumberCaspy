package classes;

import java.util.ArrayList;

/**
 * This class is used to create response to different task in the application
 * @author Pankaj Nimgade
 */
public class Response {

    /**
     * set this to true if given task was completed.
     */
    private boolean isSuccessful;

    /**
     * This gives the appropriate message if given task was completed or not.
     */
    private String message;

    private ArrayList<PhoneNumber> phoneNumbers;

    public Response() {
        phoneNumbers = new ArrayList<>();
    }

    /**
     * This constructs the Response instance with appropriate values describing how the task was handled.
     * @param isSuccessful this would be true if task was done otherwise false.
     * @param message this would be set depending on the task result.
     */
    public Response(boolean isSuccessful, String message) {
        this.isSuccessful = isSuccessful;
        this.message = message;
        phoneNumbers = new ArrayList<>();
    }

    /**
     * @return true if given task of application was successful otherwise false
     */
    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
