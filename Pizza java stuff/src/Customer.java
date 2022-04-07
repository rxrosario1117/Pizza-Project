import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class Customer {

    private Address address;
    String firstName;
    String lastName;
    private String phoneNumber;
    private CreditCard creditCard;

    //    customer constructor and getters and setters
    public Customer(Address address, String firstName, String lastName, String phoneNumber, CreditCard creditCard) {
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.creditCard = creditCard;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    // nested class for address w/ constructor, getters, and setters
    public static class Address{
        private String streetAddress;
        private String city;
        private String state;
        private String zipCode;

        public Address(String streetAddress, String city, String state, String zipCode) {
            this.streetAddress = streetAddress;
            this.city = city;
            this.state = state;
            this.zipCode = zipCode;
        }

        public String getStreetAddress() {
            return streetAddress;
        }

        public void setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }

    // nested class for credit card w/ constructor, getters, and setters
    public static class CreditCard{
        private String nameOnCard;
        private String cardNumber;
        private String securityCode;
        private String expirationDate;

        public CreditCard(String nameOnCard, String cardNumber, String securityCode, String expirationDate) {
            this.nameOnCard = nameOnCard;
            this.cardNumber = cardNumber;
            this.securityCode = securityCode;
            this.expirationDate = expirationDate;
        }

        public String getNameOnCard() {
            return nameOnCard;
        }

        public void setNameOnCard(String nameOnCard) {
            this.nameOnCard = nameOnCard;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public String getSecurityCode() {
            return securityCode;
        }

        public void setSecurityCode(String securityCode) {
            this.securityCode = securityCode;
        }

        public String getExpirationDate() {
            return expirationDate;
        }

        public void setExpirationDate(String expirationDate) {
            this.expirationDate = expirationDate;
        }
    }

    //    serialize / deserialize
    public String serialize(Customer customer){
//        GsonBuilder() will set the string to print nicely in the console
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Gson gson = new Gson();

//        Staff is converted to json text
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

    public Staff deserialize(String json){

        return new Gson().fromJson(json, Staff.class);
    }

}
