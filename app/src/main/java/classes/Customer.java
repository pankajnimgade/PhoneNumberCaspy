package classes;

/**
 * This class represents Customer
 * @author Pankaj Nimgade
 */
public class Customer {

    /**
     * This instance variable provides the name of the customer
     * */
    private String customer_Name;

    /**
     * This is the PhoneNumber instance which is delegated to Customer instance which would be assigned to it.
     */
    private PhoneNumber phoneNumber;

    /**
     * This is not used yet
     * */
    private String customer_SSN;

    /**
     * This is not used yet
     * */
    private String customer_Address;

    /**
     * An Empty constructor that it may be used in parsing if used in JAX-RS, which is used to
     * convert things in JSON / XML.
     * */
    public Customer() {
    }

    /**
     * This constructs the Customer instance with given parameters
     * @param customer_Name this represents the name of customer
     * @param phoneNumber this represents the instance of PhoneNumber assigned to this customer instance.
     */
    public Customer(String customer_Name, PhoneNumber phoneNumber) {
        this.customer_Name = customer_Name;
        this.phoneNumber = phoneNumber;
    }

    public String getCustomer_Name() {
        return customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomer_SSN() {
        return customer_SSN;
    }

    public void setCustomer_SSN(String customer_SSN) {
        this.customer_SSN = customer_SSN;
    }

    public String getCustomer_Address() {
        return customer_Address;
    }

    public void setCustomer_Address(String customer_Address) {
        this.customer_Address = customer_Address;
    }
}
