public class Order {
    Customer customer;
    String customerPhoneNumber;

    // True = pickup | False = deliver
    Boolean orderMethod;
    Pizza pizza;
    Sides side;
    Drink drink;
    float price;
    // static order counter | updated in the constructor for every new order
    public static int orderID = 0;

    // Order constructor
    public Order(Customer customer, String customerPhoneNumber, Boolean orderMethod) {
        this.customer = customer;
        this.customerPhoneNumber = customerPhoneNumber;
        this.orderMethod = orderMethod;
        orderID++;
    }




}
