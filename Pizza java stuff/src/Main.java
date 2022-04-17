import customer_info.Customer;
import customer_info.customerAddress;
import customer_info.customerCreditCard;
import food.BYO;
import food.Drink;
import food.Pizza;
import food.Side;
import list.JsonController;
import management.Manager;
import management.Order;
import management.Staff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
//        Creates a new staff, order, customer and adds them to their respective json files
//        If the json file doesn't exist, it is created then written to
//        genericSerializeTest();


//        Deserialize works with individual deserialize methods in JsonController
//        orderDeserializeTest();
//        customerDeserializeTest();
//        staffDeserializeTest();
        removeCustomer();
    }

    public static void orderCreationTest() throws IOException {
//      Customer 1 creation
        customerAddress address = new customerAddress("3070 west", "Powder Springs", "GA", "30127");
        customerCreditCard creditCard = new customerCreditCard("Ray Rosario", "123456789", "123", "02/22");
        Customer c1 = new Customer( "Ray",  "Rosario", address, "848488555", creditCard);

//        o1 BYO PIZZA ORDER
        List<String> toppings = new ArrayList<>();
        toppings.add("cheese");
        toppings.add("pepperoni");
        toppings.add("sausage");
        toppings.add("veggies");
        Pizza pizza = new BYO("stuffed", "marinara", "mozzarella", toppings, "small");
        Side side = new Side("wings");
        Drink drink = new Drink("coke", "medium");

//      Customer 2 creation
        customerAddress address2 = new customerAddress("919 ensign ave", "Beachwood", "NJ", "08722");
        customerCreditCard creditCard2 = new customerCreditCard("Melinda Duong", "987654321", "789", "09/59");
        Customer c2 = new Customer( "Melinda",  "Duong", address2, "9998887777", creditCard2);

//      o2 SPECIALTY PIZZA ORDER
        Pizza pizza2 = new Pizza("Sausage", "Large");
        Side sides2 = new Side("boneless wings");
        Drink drink2 = new Drink("sprite", "large");


        Order.createNewOrder(c1,true);



        Order.createNewOrder(c2, false);
    }

    public static void customerCreationTest() throws IOException {
//        use pre entered info
//        Customer 1 creation
        customerAddress address = new customerAddress("3070 west", "Powder Springs", "GA", "30127");
        customerCreditCard creditCard = new customerCreditCard("Nobyl Rosario", "123456789", "123", "02/22");
        Customer.createNewCustomer("Nobyl", "Rosario", address, "789456", creditCard);

////        or enter your own
//        Scanner sc = new Scanner(System.in);
////        Customer Address
//        String streetAddress, city, state, zipCode;
////        Customer Credit Card
//        String nameOnCard, cardNumber, securityCode, expDate;
////        Customer info
//        String firstName, lastName, phoneNum;
//
//        System.out.println("--- Customer Address Info ---");
//        System.out.println("-----------------------------");
//        System.out.print("Enter street address: ");
//        streetAddress = sc.nextLine();
//        System.out.print("Enter city: ");
//        city = sc.nextLine();
//        System.out.print("Enter state: ");
//        state = sc.nextLine();
//        System.out.print("Enter zip code: ");
//        zipCode = sc.nextLine();
//
//        System.out.println("--- Customer Credit Card Info ---");
//        System.out.println("---------------------------------");
//        System.out.print("Enter name on card: ");
//        nameOnCard = sc.nextLine();
//        System.out.print("Enter card number: ");
//        cardNumber = sc.nextLine();
//        System.out.print("Enter security code: ");
//        securityCode = sc.nextLine();
//        System.out.print("Enter expiration date: ");
//        expDate = sc.nextLine();
//
//        System.out.println("--- Customer Creation ---");
//        System.out.println("-------------------------");
//        System.out.print("Enter first name: ");
//        firstName = sc.nextLine();
//        System.out.print("Enter last name: ");
//        lastName = sc.nextLine();
//        System.out.print("Enter phone number: ");
//        phoneNum = sc.nextLine();
//
//        customerAddress customerAddress = new customerAddress(streetAddress, city, state, zipCode);
//        customerCreditCard customerCreditCard = new customerCreditCard(nameOnCard, cardNumber, securityCode, expDate);
//        Customer.createNewCustomer(firstName, lastName, customerAddress, phoneNum, customerCreditCard);

    }

    public static void staffCreationTest() throws IOException {
        Staff.createNewStaff("Ray", "Rosario", "1234qwer", "55555");
        Staff.createNewManager("Melinda", "Rosario", "!@#$QWER", "45613");
    }

    public static void genericSerializeTest() throws IOException {
        JsonController j = new JsonController();

        Staff.createNewStaff("Ray", "Rosario", "1234qwer", "55555");
        Staff.createNewStaff("Melinda", "Rosario", "!@#$QWER", "45613");

        //        Customer 1 creation
        customerAddress address = new customerAddress("3070 west", "Powder Springs", "GA", "30127");
        customerCreditCard creditCard = new customerCreditCard("Nobyl Rosario", "123456789", "123", "02/22");
        Customer.createNewCustomer("Nobyl", "Rosario", address, "789456", creditCard);


        //      o2 SPECIALTY PIZZA ORDER
        Pizza pizza2 = new Pizza("Sausage", "Large");
        Side sides2 = new Side("boneless wings");
        Drink drink2 = new Drink("sprite", "large");

//        Order.createNewOrder(new Customer("Nobyl", "Rosario", address, "789456", creditCard), pizza2, sides2 , drink2, 22.22f, false);
    }

    public static void orderDeserializeTest() throws IOException {
        String file = "Order.json";

        ArrayList<Order> orderList = new ArrayList<>();
        orderList = JsonController.deserializeAnOrderList(file);

        System.out.println(orderList.get(0).getCustomerPhoneNumber());
    }

    public static void customerDeserializeTest() throws IOException {
        String file = "Customer.json";

        ArrayList<Customer> customerList = new ArrayList<>();
        customerList = JsonController.deserializeACustomerList(file);

        System.out.println(customerList.get(0).getCreditCard());
    }

    public static void staffDeserializeTest() throws IOException {
        String file = "Staff.json";

        ArrayList<Staff> staffList = new ArrayList<>();
        staffList = JsonController.deserializeAStaffList(file);

        System.out.println(staffList.get(0).getEmployeeType());
    }

    public static void removeCustomer() throws IOException {

        Customer.removeCustomer("789456");
    }

}
