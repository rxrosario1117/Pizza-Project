package customer_info;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import employees.Staff;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    String firstName;
    String lastName;
    private customerAddress address;
    private String phoneNumber;
    private customerCreditCard creditCard;

    //    customer constructor and getters and setters
    public Customer(String firstName, customerAddress address, String lastName, String phoneNumber, customerCreditCard creditCard) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    public CreditCard getCreditCard() {
//        return creditCard;
//    }
//
//    public void setCreditCard(CreditCard creditCard) {
//        this.creditCard = creditCard;
//    }
//
//    // nested class for address w/ constructor, getters, and setters
//    public static class Address{
//        private String streetAddress;
//        private String city;
//        private String state;
//        private String zipCode;
//
//        public Address(String streetAddress, String city, String state, String zipCode) {
//            this.streetAddress = streetAddress;
//            this.city = city;
//            this.state = state;
//            this.zipCode = zipCode;
//        }
//
//        public String getStreetAddress() {
//            return streetAddress;
//        }
//
//        public void setStreetAddress(String streetAddress) {
//            this.streetAddress = streetAddress;
//        }
//
//        public String getCity() {
//            return city;
//        }
//
//        public void setCity(String city) {
//            this.city = city;
//        }
//
//        public String getState() {
//            return state;
//        }
//
//        public void setState(String state) {
//            this.state = state;
//        }
//
//        public String getZipCode() {
//            return zipCode;
//        }
//
//        public void setZipCode(String zipCode) {
//            this.zipCode = zipCode;
//        }
//    }
//
//    // nested class for credit card w/ constructor, getters, and setters
//    public static class CreditCard{
//        private String nameOnCard;
//        private String cardNumber;
//        private String securityCode;
//        private String expirationDate;
//
//        public CreditCard(String nameOnCard, String cardNumber, String securityCode, String expirationDate) {
//            this.nameOnCard = nameOnCard;
//            this.cardNumber = cardNumber;
//            this.securityCode = securityCode;
//            this.expirationDate = expirationDate;
//        }
//
//        public String getNameOnCard() {
//            return nameOnCard;
//        }
//
//        public void setNameOnCard(String nameOnCard) {
//            this.nameOnCard = nameOnCard;
//        }
//
//        public String getCardNumber() {
//            return cardNumber;
//        }
//
//        public void setCardNumber(String cardNumber) {
//            this.cardNumber = cardNumber;
//        }
//
//        public String getSecurityCode() {
//            return securityCode;
//        }
//
//        public void setSecurityCode(String securityCode) {
//            this.securityCode = securityCode;
//        }
//
//        public String getExpirationDate() {
//            return expirationDate;
//        }
//
//        public void setExpirationDate(String expirationDate) {
//            this.expirationDate = expirationDate;
//        }
//    }

    //    serialize / deserialize
    public static String serializeAList(List<Customer> customer){
//        GsonBuilder() will set the string to print nicely in the console
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Gson gson = new Gson();

//        employees.Staff is converted to json text
        String toJson = gson.toJson(customer);

//        create new Json file

        try{
            FileWriter file = new FileWriter("Customer.json");
            file.write(toJson);
            file.flush();

        }catch (IOException e) {
            e.printStackTrace();
        }

        return toJson;
    }

    //    deserialize a list of Orders and return the Order list
    public static List<Customer> deserializeAList(String json) {

//        we must evaluate the type of the list of orders using a typeToken before we use Gson().fromJson
        Type orderListType = new TypeToken<ArrayList<Customer>>(){}.getType();

//        returns deserialized / hydrated list
        return new Gson().fromJson(json, orderListType);

    }
}

////      ------ Customers to / from JSON test ------
////                Just paste into main to test
//
//      Customer 1 creation
//      customerAddress address = new customerAddress("3070 west", "Powder Springs", "GA", "30127");
//      customerCreditCard creditCard = new customerCreditCard("Ray Rosario", "123456789", "123", "02/22");
//      Customer c1 = new Customer( "Ray", address, "Rosario", "848488555", creditCard);
//
////      Customer 2 creation
//      customerAddress address2 = new customerAddress("919 ensign ave", "Beachwood", "NJ", "08722");
//      customerCreditCard creditCard2 = new customerCreditCard("Melinda Duong", "987654321", "789", "09/59");
//      Customer c2 = new Customer( "Melinda", address2, "Duong", "9998887777", creditCard2);
//
//      List<Customer> custList = new ArrayList<>();
//      custList.add(c1);
//      custList.add(c2);
//
//      custList =  Customer.deserializeAList(Customer.serializeAList(custList));
//
//      System.out.println(custList.get(0).getPhoneNumber());
