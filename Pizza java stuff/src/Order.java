import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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

//    serialize a list of Orders and return a String of the json text
    public static void serializeAList(List<Order> orderList) {

//        GsonBuilder() will set the string to print nicely in the console
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Gson gson = new Gson();

//        order is converted to json text
        String toJson = gson.toJson(orderList);

//        create new Json file
        try{
            FileWriter file = new FileWriter("Order.json");
            file.write(toJson);
            file.flush();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    deserialize a list of Orders and return the Order list
    public static List<Order> deserializeAList(String json) {

//        we must evaluate the type of the list of orders using a typeToken before we use Gson().fromJson
        Type orderListType = new TypeToken<ArrayList< Order >>(){}.getType();

//        returns deserialized / hydrated list
        return new Gson().fromJson(json, orderListType);

    }
}
