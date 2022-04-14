package customer_info;

import list.JsonController;

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

////    w/o generics
//    public static boolean createNewCustomer(String firstName, String lastName, customerAddress address, String phoneNumber, customerCreditCard creditCard) throws IOException {
//
//        Customer customer = new Customer(firstName, lastName, address, phoneNumber, creditCard);
//
////        re-writes the json file to add the new customer
//        JsonController.serializeACustomerList(customer);
//
//        return true;
//    }

//    with generics
    public static boolean createNewCustomer(String firstName, String lastName, customerAddress address, String phoneNumber, customerCreditCard creditCard) throws IOException {
        JsonController controller = new JsonController();

        Customer customer = new Customer(firstName, lastName, address, phoneNumber, creditCard);

//        re-writes the json file to add the new customer
        controller.serializeAList(customer);

        return true;
    }

    public static void removeCustomer(String phoneNumber) throws IOException {
//        Use list.JsonController.customerList to make updates to the class list to be used in the json file

        JsonController controller = new JsonController();

        ArrayList<Customer> customers = JsonController.deserializeACustomerList("Customer.json");

        customers.remove(0);

        controller.serializeAList(customers);

    }
}
