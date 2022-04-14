package management;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import list.JsonController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static list.JsonController.*;

public class Staff {
    private String firstName;
    private String lastName;
    private String password;
    private String employeeType;
    private String employeeID;

    public Staff(String firstName, String lastName, String password, String employeeID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.employeeID = employeeID;
        employeeType = "Staff";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

//    //    serialize a list of Orders and return a String of the json text
//    public static void serializeAList() {
//
////        GsonBuilder() will set the string to print nicely in the console
////        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        Gson gson = new Gson();
//
////        list.JsonController.staffList is converted to json text
//        staffJSON = gson.toJson(staffList);
//
////        create new Json file
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
//    //    deserialize a list of Orders and return the management.Staff list
//    public static List<Staff> deserializeAList() {
//
////        we must evaluate the type of the list of orders using a typeToken before we use Gson().fromJson
//        Type staffListType = new TypeToken<ArrayList<Staff>>(){}.getType();
//
////        returns deserialized / hydrated list
//        return new Gson().fromJson(staffJSON, staffListType);
//
//    }

    //    check username and password are valid
    public static boolean loginVerification(String userName, String password){

//        temp
        return true;
    }

//    checks for existing customer
    public static void startOrder(String phoneNumber){
        // for loop to go through customerList to verify existing customer
    }

    public static boolean logout(){
        return true;
    }

    public static void goToPrevScreen(){
    }

    public static boolean updateCustomerInfo(String phoneNumber){
        return true;
    }

////    w/o generics
//    public static boolean createNewStaff(String firstName, String lastName, String password, String employeeID) throws IOException {
//        // Use list.JsonController class to make updates to the class list to be used in the json file
//        Staff staff = new Staff(firstName, lastName, password, employeeID);
//
////        re-writes the json file to add the new customer
//        JsonController.serializeAStaffList(staff);
//
//        return true;
//    }
//
//    public static boolean createNewManager(String firstName, String lastName, String password, String employeeID) throws IOException {
//        // Use list.JsonController class to make updates to the class list to be used in the json file
//        Staff staff = new Manager(firstName, lastName, password, employeeID);
//
////        re-writes the json file to add the new customer
//        JsonController.serializeAStaffList(staff);
//
//        return true;
//    }

//    with generics
public static boolean createNewStaff(String firstName, String lastName, String password, String employeeID) throws IOException {
    JsonController controller = new JsonController();

        // Use list.JsonController class to make updates to the class list to be used in the json file
    Staff staff = new Staff(firstName, lastName, password, employeeID);

//        re-writes the json file to add the new customer
    controller.serializeAList(staff);

    return true;
}

    public static boolean createNewManager(String firstName, String lastName, String password, String employeeID) throws IOException {
        JsonController controller = new JsonController();

        // Use list.JsonController class to make updates to the class list to be used in the json file
        Staff staff = new Manager(firstName, lastName, password, employeeID);

//        re-writes the json file to add the new customer
        controller.serializeAList(staff);

        return true;
    }

    public static boolean removeStaff(String employeeID){
//        Use list.JsonController.staffList to make updates to the class list to be used in the json file

//        searches for the customer by phone number and removes them
        for(int i = 0; i < staffList.size(); i++){

            if (staffList.get(i).getEmployeeID().equals(employeeID)){
                staffList.remove(i);
            }
        }

        return true;
    }

    public static boolean removeManager(String employeeID){
//        Use list.JsonController.staffList to make updates to the class list to be used in the json file

//        searches for the customer by phone number and removes them
        for(int i = 0; i < staffList.size(); i++){

            if (staffList.get(i).getEmployeeID().equals(employeeID)){
                staffList.remove(i);
            }
        }

        return true;
    }
}
