public class Order {
    Customer customer;
    String customerPhoneNumber;
    Pizza pizza;
    Side side;
    Drink drink;
    float price;
    // True = pickup | False = deliver
    Boolean pickup;
    int orderID;
    // static order counter | updated in the constructor for every new order
    public static int nextOrderID = 1;

    // Order constructor
    public Order(Customer customer, Pizza pizza, Side side, Drink drink, float price , Boolean pickup) {
        this.customer = customer;
        this.customerPhoneNumber = customer.getPhoneNumber();
        this.pickup = pickup;
        this.pizza = pizza;
        this.side = side;
        this.drink = drink;
        this.price = price;
        orderID = nextOrderID;
        nextOrderID++;
    }
}
