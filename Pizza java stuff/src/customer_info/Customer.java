package customer_info;

import list.JsonController;
import list.JsonController.*;

import java.io.IOException;
import java.util.ArrayList;

public class Customer {
    String firstName;
    String lastName;
    private customerAddress address;
    private String phoneNumber;
    private customerCreditCard creditCard;

    public Customer(){

    }

    //    customer constructor and getters and setters
    public Customer(String firstName, String lastName, customerAddress address, String phoneNumber, customerCreditCard creditCard) {
        this.firstName = firstName;
        this.address = address;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.creditCard = creditCard;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public customerAddress getAddress() {
        return address;
    }

    public void setAddress(customerAddress address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public customerCreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(customerCreditCard creditCard) {
        this.creditCard = creditCard;
    }

//    with generics
    public static boolean createNewCustomer(String firstName, String lastName, customerAddress address, String phoneNumber, customerCreditCard creditCard) throws IOException {

        for (Customer c : JsonController.customerList) {
            if (c.phoneNumber.equals(phoneNumber)) {
                return false;
            }
        }

        Customer customer = new Customer(firstName, lastName, address, phoneNumber, creditCard);

//        re-writes the json file to add the new customer
        JsonController.customerList.add(customer);

        JsonController.serializeACustomerList(customer);

        return true;
    }

    public static boolean removeCustomer(String phoneNumber) throws IOException {
//        Use list.JsonController.customerList to make updates to the class list to be used in the json file

        boolean temp = false;

        for (Customer c : JsonController.customerList) {
            if (c.phoneNumber.equals(phoneNumber)) {
                JsonController.customerList.remove(c);
                temp = true;
            }
        }

        JsonController.serializeACustomerList();

        return temp;
    }
}
