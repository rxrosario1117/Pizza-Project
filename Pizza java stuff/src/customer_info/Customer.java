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

    //    serialize / deserialize
    public static String serializeAList(List<Customer> customerList){
//        GsonBuilder() will set the string to print nicely in the console
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Gson gson = new Gson();

//        employees.Staff is converted to json text
        String customerToJson = gson.toJson(customerList);

//        create new Json file

        try{
            FileWriter file = new FileWriter("Customer.json");
            file.write(customerToJson);
            file.flush();

        }catch (IOException e) {
            e.printStackTrace();
        }

        return customerToJson;
    }

    //    deserialize a list of Orders and return the Order list
    public static List<Customer> deserializeAList(String json) {

//        we must evaluate the type of the list of orders using a typeToken before we use Gson().fromJson
        Type customerListType = new TypeToken<ArrayList<Customer>>(){}.getType();

//        returns deserialized / hydrated list
        return new Gson().fromJson(json, customerListType);

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
