import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    // Example to show order creation, and then gson.toJson(Order object) then back to the Order object
    // The created Order object will hold all information in order to make the json conversions work correctly

    public static void main(String[] args) {

        System.out.println("------------- JSON format -------------");


        // call createNewCustomer from below to make new customer
        Customer c1 = createNewCustomer();

        // instantiate new order
        Order o1 = new Order(c1, c1.phoneNumber, true);

        // GsonBuilder() will set the string to print nicely in the console
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // o1 is sent to json text and printed in the console
        String toJson = gson.toJson(o1);
        System.out.println(toJson);

        // Order object is returned from json to java and ready to be used
        Order fromJson = gson.fromJson(toJson, Order.class);

        System.out.println("-------------------------------------");

        // confirmation of successful conversion back
        System.out.println("Customers phone number: " + fromJson.customerPhoneNumber);

    }

    public static Customer createNewCustomer(){

        // first set the nested classes (Address and CredCard) as shown below
        Customer.Address address = new Customer.Address("3070 west", "Powder Springs", "GA", 30127);
        Customer.CreditCard creditCard = new Customer.CreditCard("Ray Rosario", "123456789", "123", "02/22");

        // return new Customer with above information passed in to constructor call
        return new Customer(address, "Ray", "Rosario", "848488555", creditCard);
    }


}
