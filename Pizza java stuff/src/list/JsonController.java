package list;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import customer_info.Customer;
import management.Manager;
import management.Order;
import management.Staff;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonController <T>{
    public static List<Order> orderList = new ArrayList<>();
//    public static List<Customer> customerList = new ArrayList<>();
    public static List<Staff> staffList = new ArrayList<>();
    public static String orderJSON;
    public static String customerJSON;
    public static String staffJSON;

    public JsonController() {

    }

//    test with generics - WORKS
    public void serializeAList(T object) throws IOException {
        String jsonToUpdate = jsonFileToUpdate(object);

        Gson gson = new Gson();

        List<T> updatedListToBeSer;
        updatedListToBeSer = deserializeAList(jsonToUpdate);

        updatedListToBeSer.add(object);

        String JSON = gson.toJson(updatedListToBeSer);

        try{
            FileWriter file = new FileWriter(jsonToUpdate);
            file.write(JSON);
            file.flush();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<T> deserializeAList(String file) throws IOException {
        // get name/location of json file from the user and store it in a string - DONE IN MAIN

        // convert json file to a string to be deserialized
//        String readInJson = getFileName();
        String readInJson = convertJsonIntoString(file);

//        we must evaluate the type of the list of orders using a typeToken before we use Gson().fromJson
        Type genericListType = new TypeToken<ArrayList<T>>(){}.getType();

//        returns deserialized object
        return new Gson().fromJson(readInJson, genericListType);
    }

    public static String convertJsonIntoString(String file) throws IOException {


//        If the file doesn't exist then create it and add the VERY important [] (to avoid a nullPointerException)
        File newFile = new File(file);
        if(newFile.createNewFile()) {
            System.out.println(newFile.getName() + " has been created.");

            try {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("[]");
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public String jsonFileToUpdate(T object){
        if (object.getClass() == Order.class) {
            return "Order.json";
        }
        else if (object.getClass() == Customer.class){
            return "Customer.json";
        }
        else if (object.getClass() == Staff.class || object.getClass() == Manager.class) {
            return "Staff.json";
        }
        return "";
    }

////      w/o generics
//    public static void serializeAnOrderList(Order order) throws IOException {
//        Gson gson = new Gson();
//
//        List<Order> updatedListToBeSerialized;
//        updatedListToBeSerialized = deserializeAnOrderList("Order.json");
//
//        updatedListToBeSerialized.add(order);
//
//        String orderJSON = gson.toJson(updatedListToBeSerialized);
//
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
//    // works with getFileName()
////    public static ArrayList<Customer> deserializeACustomerList() throws IOException {
//    public static ArrayList<Order> deserializeAnOrderList(String file) throws IOException {
//        // get name/location of json file from the user and store it in a string - DONE IN MAIN
//
//        // convert json file to a string to be deserialized
////        String readInJson = getFileName();
//        String readInJson = convertOrderJsonIntoString(file);
//
////        we must evaluate the type of the list of orders using a typeToken before we use Gson().fromJson
//        Type orderListType = new TypeToken<ArrayList<Order>>(){}.getType();
//
////        returns deserialized object
//        return new Gson().fromJson(readInJson, orderListType);
//    }
//
//    public static void serializeACustomerList(Customer customer) throws IOException {
//        Gson gson = new Gson();
//
//        List<Customer> updatedListToBeSer;
//        updatedListToBeSer = deserializeACustomerList("Customer.json");
//
//        updatedListToBeSer.add(customer);
//
//        String custJSON = gson.toJson(updatedListToBeSer);
//
//        try{
//            FileWriter file = new FileWriter("Customer.json");
//            file.write(custJSON);
//            file.flush();
//
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // works with getFileName()
////    public static ArrayList<Customer> deserializeACustomerList() throws IOException {
//    public static ArrayList<Customer> deserializeACustomerList(String file) throws IOException {
//        // get name/location of json file from the user and store it in a string - DONE IN MAIN
//
//        // convert json file to a string to be deserialized
////        String readInJson = getFileName();
//        String readInJson = convertCustJsonIntoString(file);
//
////        we must evaluate the type of the list of orders using a typeToken before we use Gson().fromJson
//        Type customerListType = new TypeToken<ArrayList<Customer>>(){}.getType();
//
////        returns deserialized object
//        return new Gson().fromJson(readInJson, customerListType);
//    }
//
//    public static void serializeAStaffList(Staff staff) throws IOException {
//        Gson gson = new Gson();
//
//        List<Staff> updatedListToBeSerialized;
//        updatedListToBeSerialized = deserializeAStaffList("Staff.json");
//
//        updatedListToBeSerialized.add(staff);
//
//        String staffJSON = gson.toJson(updatedListToBeSerialized);
//
//        try{
//            FileWriter file = new FileWriter("Staff.json");
//            file.write(staffJSON);
//            file.flush();
//
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // works with getFileName()
////    public static ArrayList<Customer> deserializeACustomerList() throws IOException {
//    public static ArrayList<Staff> deserializeAStaffList(String file) throws IOException {
//        // get name/location of json file from the user and store it in a string - DONE IN MAIN
//
//        // convert json file to a string to be deserialized
////        String readInJson = getFileName();
//        String readInJson = convertStaffJsonIntoString(file);
//
////        we must evaluate the type of the list of orders using a typeToken before we use Gson().fromJson
//        Type staffListType = new TypeToken<ArrayList<Staff>>(){}.getType();
//
////        returns deserialized object
//        return new Gson().fromJson(readInJson, staffListType);
//    }
//
//    // getFileName might be redundant IF we as the developers are the ones controlling the json file name/location
////    public static String getFileName() throws IOException {
////        Scanner sc = new Scanner(System.in);
////
//////        System.out.println("enter path: ");
//////        String path = sc.nextLine();
////        System.out.println("enter file name: ");
////        String fileName = sc.nextLine();
////
//////        String file = (path + "\\" + fileName);
////        String file = (fileName);
////
////        return convertFileIntoString(file);
////    }
//
//    public static String convertOrderJsonIntoString(String file) throws IOException {
//
////        If the file doesn't exist then create it and add the VERY important [] (to avoid a nullPointerException)
//        File newFile = new File("Order.json");
//        if(newFile.createNewFile()) {
//            System.out.println(newFile.getName() + " has been created.");
//
//            try {
//                FileWriter fileWriter = new FileWriter("Order.json");
//                fileWriter.write("[]");
//                fileWriter.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return new String(Files.readAllBytes(Paths.get(file)));
//    }
//
//    public static String convertCustJsonIntoString(String file) throws IOException {
//
////        If the file doesn't exist then create it and add the VERY important [] (to avoid a nullPointerException)
//        File newFile = new File("Customer.json");
//        if(newFile.createNewFile()) {
//            System.out.println(newFile.getName() + " has been created.");
//
//            try {
//                FileWriter fileWriter = new FileWriter("Customer.json");
//                fileWriter.write("[]");
//                fileWriter.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return new String(Files.readAllBytes(Paths.get(file)));
//    }
//
//    public static String convertStaffJsonIntoString(String file) throws IOException {
//
////        If the file doesn't exist then create it and add the VERY important [] (to avoid a nullPointerException)
//        File newFile = new File("Staff.json");
//        if(newFile.createNewFile()) {
//            System.out.println(newFile.getName() + " has been created.");
//
//            try {
//                FileWriter fileWriter = new FileWriter("Staff.json");
//                fileWriter.write("[]");
//                fileWriter.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return new String(Files.readAllBytes(Paths.get(file)));
//    }


}
