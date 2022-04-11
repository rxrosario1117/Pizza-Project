package management;

import customer_info.Customer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import food.Drink;
import food.Pizza;
import food.Side;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static list.ListController.orderList;
import static list.ListController.orderJSON;

public class Order {
    Customer customer;
    String customerPhoneNumber;
    Pizza pizza;
    Side side;
    Drink drink;
    float price;
    // True = pickup | False = deliver
     Boolean orderType;
    int orderID;
    // static order counter | updated in the constructor for every new order
    public static int nextOrderID = 1;

    // management.Order constructor
    public Order(Customer customer, Pizza pizza, Side side, Drink drink, float price , Boolean orderType) {
        this.customer = customer;
        this.customerPhoneNumber = customer.getPhoneNumber();
        this.orderType = orderType;
        this.pizza = pizza;
        this.side = side;
        this.drink = drink;
        this.price = price;
        orderID = nextOrderID;
        nextOrderID++;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Boolean getOrderType() {
        return orderType;
    }

    public void setOrderType(Boolean orderType) {
        this.orderType = orderType;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public static int getNextOrderID() {
        return nextOrderID;
    }

    public static void setNextOrderID(int nextOrderID) {
        Order.nextOrderID = nextOrderID;
    }

    //    serialize a list of Orders and return a String of the json text
    public static void serializeAList() {

//        GsonBuilder() will set the string to print nicely in the console
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Gson gson = new Gson();

//        list.ListController.orderList is converted to json text
        orderJSON = gson.toJson(orderList);

//        create new Json file
        try{
            FileWriter file = new FileWriter("Order.json");
            file.write(orderJSON);
            file.flush();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    deserialize a list of Orders and return the management.Order list
    public static List<Order> deserializeAList() {

//        we must evaluate the type of the list of orders using a typeToken before we use Gson().fromJson
        Type orderListType = new TypeToken<ArrayList< Order >>(){}.getType();

//        returns deserialized / hydrated list
        return new Gson().fromJson(orderJSON, orderListType);

    }

    public static boolean addToCart(){
        return true;
    }

    public static boolean confirmOrder(){
        return true;
    }

    public static String selectPaymentInfo(String userSelection){
        return userSelection;
    }

    public static void generateReceipt(){
        // display all order items and price
        // put a place to sign for credit card users
    }

    public static void createNewOrder(Customer customer, Pizza pizza, Side side, Drink drink, float price , boolean orderType){
//        Use list.ListController class to make updates to the class list to be used in the json file

        Order order = new Order(customer, pizza, side, drink, price , orderType);
        orderList.add(order);

//        re-writes the json file to add the new customer
        serializeAList();
    }

    public void calculatePrice(){
//        calculate total price for the order

        price += pizza.getPrice() + side.getPrice() + drink.getPrice();

    }
}

////      ------ Two Orders with one SPECIALTY PIZZA and one BYO PIZZA to / from JSON test ------
////                Just paste into main to test
////        import this line
//      import static list.ListController.orderList;
////      Customer 1 creation
//        customerAddress address = new customerAddress("3070 west", "Powder Springs", "GA", "30127");
//        customerCreditCard creditCard = new customerCreditCard("Ray Rosario", "123456789", "123", "02/22");
//        Customer c1 = new Customer( "Ray",  "Rosario", address, "848488555", creditCard);
//
////        o1 BYO PIZZA ORDER
//        List<String> toppings = new ArrayList<>();
//        toppings.add("cheese");
//        toppings.add("pepperoni");
//        toppings.add("sausage");
//        toppings.add("veggies");
//        BYO pizza = new BYO("stuffed", "marinara", "mozzarella", toppings, "small");
//        Side side = new Side("wings");
//        Drink drink = new Drink("coke", "medium");
//
////      Customer 2 creation
//        customerAddress address2 = new customerAddress("919 ensign ave", "Beachwood", "NJ", "08722");
//        customerCreditCard creditCard2 = new customerCreditCard("Melinda Duong", "987654321", "789", "09/59");
//        Customer c2 = new Customer( "Melinda",  "Duong", address2, "9998887777", creditCard2);
//
////      o2 SPECIALTY PIZZA ORDER
//        Pizza pizza2 = new Pizza("Sausage", "Large");
//        Side sides2 = new Side("boneless wings");
//        Drink drink2 = new Drink("sprite", "large");
//
//
//        Order.createNewOrder(c1, pizza, side, drink, 11.11f, true);
//        Order.createNewOrder(c2, pizza2, sides2 , drink2, 22.22f, false);
//
//        System.out.println(orderList.get(0).getCustomerPhoneNumber());


