package management;

import customer_info.Customer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import food.Drink;
import food.Pizza;
import food.Side;
import list.JsonController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
//    To handle a case where the customer doesn't order any drink/side
//      make an array list of pizza, side, drink: if the size is 0 ignore that item
    Customer customer;
    String customerPhoneNumber;
    Pizza pizza;
    Side side;
    Drink drink;
//    List<Pizza> pizzaList = new ArrayList<>();
//    List<Side> sideList = new ArrayList<>();
//    List<Drink> drinkList = new ArrayList<>();
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

//    //    serialize a list of Orders and return a String of the json text
//    public static void serializeAList() {
//
////        GsonBuilder() will set the string to print nicely in the console
////        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        Gson gson = new Gson();
//
////        list.JsonController.orderList is converted to json text
//        orderJSON = gson.toJson(orderList);
//
////        create new Json file
//        try{
//            FileWriter file = new FileWriter("Order.json");
//            file.write(orderJSON);
//            file.flush();
//
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    //    deserialize a list of Orders and return the management.Order list
//    public static List<Order> deserializeAList() {
//
////        we must evaluate the type of the list of orders using a typeToken before we use Gson().fromJson
//        Type orderListType = new TypeToken<ArrayList< Order >>(){}.getType();
//
////        returns deserialized / hydrated list
//        return new Gson().fromJson(orderJSON, orderListType);
//
//    }

    public static boolean addToCart(){
        return true;
    }

    public static boolean confirmOrder(){
        return true;
    }

    public static String selectPaymentMethod(String userSelection){
        return userSelection;
    }

    public static void generateReceipt(){
        // display all order items and price
        // put a place to sign for credit card users
    }

////    w/o generics
//    public static boolean createNewOrder(Customer customer, Pizza pizza, Side side, Drink drink, float price , boolean orderType) throws IOException {
//
//        Order order = new Order(customer, pizza, side, drink, price , orderType);
//
////        re-writes the json file to add the new customer
//        JsonController.serializeAnOrderList(order);
//
//        return true;
//    }

//    with generics
    public static boolean createNewOrder(Customer customer, Pizza pizza, Side side, Drink drink, float price , boolean orderType) throws IOException {
        JsonController controller = new JsonController();

        Order order = new Order(customer, pizza, side, drink, price , orderType);

//        re-writes the json file to add the new customer
        controller.serializeAList(order);

        return true;
    }

    public void calculatePrice(){
//        calculate total price for the order

        price += pizza.getPrice() + side.getPrice() + drink.getPrice();

    }
}



