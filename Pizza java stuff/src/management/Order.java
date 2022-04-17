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

    List<Pizza> pizzaList = new ArrayList<>();
    List<Side> sideList = new ArrayList<>();
    List<Drink> drinkList = new ArrayList<>();
    float price = 0f;
//    True = pickup | False = deliver
    Boolean orderType;
    int orderID;
    // static order counter | updated in the constructor for every new order
    public static int nextOrderID = 1;

    // management.Order constructor
    public Order(Customer customer, Boolean orderType) {
        this.customer = customer;
        this.customerPhoneNumber = customer.getPhoneNumber();
        this.orderType = orderType;
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

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(Pizza pizza) {
        pizzaList.add(pizza);
        price += pizza.getPrice();
    }

    public List<Side> getSideList() {
        return sideList;
    }

    public void setSideList(Side side) {
        sideList.add(side);
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(Drink drink) {
        drinkList.add(drink);
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

    public boolean addToCart( boolean side, boolean drink) {
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

//    w/o generics
    public static boolean createNewOrder(Customer customer, boolean orderType) throws IOException {

        Order order = new Order(customer, orderType);

//        re-writes the json file to add the new customer
        JsonController.orderList.add(order);

        JsonController.serializeAnOrderList(order);

        return true;
    }

////    with generics
//    public static boolean createNewOrder(Customer customer, Pizza pizza, Side side, Drink drink, float price , boolean orderType) throws IOException {
//        JsonController controller = new JsonController();
//
//        Order order = new Order(customer, pizza, side, drink, price , orderType);
//
////        re-writes the json file to add the new customer
//        controller.serializeAList(order);
//
//        return true;
//    }

    public void calculatePrice(){
//        calculate total price for the order



    }
}



