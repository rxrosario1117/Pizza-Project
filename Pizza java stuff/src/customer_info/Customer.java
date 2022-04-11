package customer_info;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static list.ListController.customerList;
import static list.ListController.customerJSON;

public class Customer {
    String firstName;
    String lastName;
    private customerAddress address;
    private String phoneNumber;
    private customerCreditCard creditCard;


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

    //    serialize / deserialize
    public static void serializeAList(){
//        GsonBuilder() will set the string to print nicely in the console
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Gson gson = new Gson();

//       list.ListController.customerList is converted to json text
        customerJSON = gson.toJson(customerList);

//        create new Json file
        try{
            FileWriter file = new FileWriter("Customer.json");
            file.write(customerJSON);
            file.flush();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    deserialize a list of Orders and return the management.Order list
    public static List<Customer> deserializeAList() {

//        we must evaluate the type of the list of orders using a typeToken before we use Gson().fromJson
        Type customerListType = new TypeToken<ArrayList<Customer>>(){}.getType();

//        returns deserialized / hydrated list
        return new Gson().fromJson(customerJSON, customerListType);

    }

    public static boolean createNewCustomer(String firstName, String lastName, customerAddress address, String phoneNumber, customerCreditCard creditCard){
//        Use list.ListController.customerList to make updates to the class list to be used in the json file

        Customer customer = new Customer(firstName, lastName, address, phoneNumber, creditCard);
        customerList.add(customer);

//        re-writes the json file to add the new customer
        serializeAList();

        return true;
    }

    public static boolean removeCustomer(String phoneNumber){
//        Use list.ListController.customerList to make updates to the class list to be used in the json file

//        searches for the customer by phone number and removes them
        for(int i = 0; i < customerList.size(); i++){

            if (customerList.get(i).phoneNumber.equals(phoneNumber)){
                customerList.remove(i);
            }
        }
        return true;
    }
}

////      ------ Customers to / from JSON test ------
////                Just paste into main to test
////        import this line
//      import static list.ListController.customerList;
//
////      Customer 1 creation
//      customerAddress address = new customerAddress("3070 west", "Powder Springs", "GA", "30127");
//      customerCreditCard creditCard = new customerCreditCard("Ray Rosario", "123456789", "123", "02/22");
//
////      Customer 2 creation
//      customerAddress address2 = new customerAddress("919 ensign ave", "Beachwood", "NJ", "08722");
//      customerCreditCard creditCard2 = new customerCreditCard("Melinda Duong", "987654321", "789", "09/59");
//
//      Customer.createNewCustomer("Melinda", "Duong", address2, "9998887777", creditCard2);
//      Customer.createNewCustomer("Ray", "Rosario", address, "848488555", creditCard);
//
//      System.out.println("Size: " + customerList.size());
//
//      Customer.removeCustomer(customerList.get(0).getPhoneNumber());
//
//      System.out.println("Size after: " + customerList.size());
//      System.out.println("Customer phone number at index 0: " + customerList.get(0).getPhoneNumber());
