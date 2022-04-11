package list;

import customer_info.Customer;
import management.Order;
import management.Staff;

import java.util.ArrayList;
import java.util.List;

public class ListController {
    public static List<Order> orderList = new ArrayList<>();
    public static List<Customer> customerList = new ArrayList<>();
    public static List<Staff> staffList = new ArrayList<>();
    public static String orderJSON;
    public static String customerJSON;
    public static String staffJSON;


    public ListController(){

    }
}
