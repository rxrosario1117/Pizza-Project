import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
//    Example to show order creation, and then gson.toJson(Order object) then back to the Order object
//    The created Order object will hold all information in order to make the json conversions work correctly

    public static void main(String[] args) {

        System.out.println("------------- JSON format -------------");


//        call createNewCustomer from below to make new customer
        Customer c1 = createNewCustomer();

//        call createNewOrder from below to make new order
        Order o1 = createNewOrder(c1);

//        call serialize from below to make serialize data and store the String in toJson
        String toJson = serialize(o1);


//         Order object is returned from deserialize() ready to be used
        Order fromJson = deserialize(toJson);

        System.out.println("-------------------------------------");

//        confirmation of successful conversion back
        System.out.println("Customers phone number: " + fromJson.customerPhoneNumber);

    }

//    create and return new Customer object
    public static Customer createNewCustomer(){

//        first set the nested classes (Address and CredCard) as shown below
        Customer.Address address = new Customer.Address("3070 west", "Powder Springs", "GA", 30127);
        Customer.CreditCard creditCard = new Customer.CreditCard("Ray Rosario", "123456789", "123", "02/22");

//        return new Customer with above information passed in to constructor call
        return new Customer(address, "Ray", "Rosario", "848488555", creditCard);
    }

//    create and return new Order object
    public static Order createNewOrder(Customer customer){

        return new Order(customer, customer.phoneNumber, true);
    }

//    serialize data and return a String of the json text
    public static String serialize(Order order) { // may need to change parameters to accept a list of Orders

//        GsonBuilder() will set the string to print nicely in the console
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

//        order is converted to json text and printed in the console
        String toJson = gson.toJson(order);

//        just for example to see what the json file will look like
        System.out.println(toJson);

        return toJson;
    }

//    deserialize data and return the Order object
    public static Order deserialize(String json) {

        return new Gson().fromJson(json, Order.class);
    }






}
