package management;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static list.ListController.staffJSON;
import static list.ListController.staffList;

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

    //    serialize a list of Orders and return a String of the json text
    public static void serializeAList() {

//        GsonBuilder() will set the string to print nicely in the console
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Gson gson = new Gson();

//        list.ListController.staffList is converted to json text
        staffJSON = gson.toJson(staffList);

//        create new Json file
        try{
            FileWriter file = new FileWriter("Staff.json");
            file.write(staffJSON);
            file.flush();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    deserialize a list of Orders and return the management.Staff list
    public static List<Staff> deserializeAList() {

//        we must evaluate the type of the list of orders using a typeToken before we use Gson().fromJson
        Type staffListType = new TypeToken<ArrayList<Staff>>(){}.getType();

//        returns deserialized / hydrated list
        return new Gson().fromJson(staffJSON, staffListType);

    }

    public static void createNewStaff(String firstName, String lastName, String password, String employeeID){
        // Use list.ListController class to make updates to the class list to be used in the json file
        Staff staff = new Staff(firstName, lastName, password, employeeID);

        staffList.add(staff);

//        re-writes the json file to add the new customer
        serializeAList();
    }

    public static void createNewManager(String firstName, String lastName, String password, String employeeID){
        // Use list.ListController class to make updates to the class list to be used in the json file
        Staff staff = new Manager(firstName, lastName, password, employeeID);

        staffList.add(staff);

//        re-writes the json file to add the new customer
        serializeAList();
    }

    public static void removeStaff(String employeeID){
//        Use list.ListController.staffList to make updates to the class list to be used in the json file

//        searches for the customer by phone number and removes them
        for(int i = 0; i < staffList.size(); i++){

            if (staffList.get(i).getEmployeeID().equals(employeeID)){
                staffList.remove(i);
            }
        }
    }

    public static void removeManager(String employeeID){
//        Use list.ListController.staffList to make updates to the class list to be used in the json file

//        searches for the customer by phone number and removes them
        for(int i = 0; i < staffList.size(); i++){

            if (staffList.get(i).getEmployeeID().equals(employeeID)){
                staffList.remove(i);
            }
        }
    }
}

////      ------ Staff members to / from JSON test ------
////                Just paste into main to test
////        import this line
//      import static list.ListController.staffList;
//      Staff.createNewStaff("Ray", "Rosario", "1234qwer", "55555");
//      Staff.createNewManager("Nelso", "Villalobos", "!@#$QWER", "99999");
//
//      System.out.println("Size: " + staffList.size());
//
//      Staff.removeStaff("99999");
//
//      System.out.println("Size after removal: " + staffList.size());
//
//      System.out.println("Staff employee ID at index 0: " + staffList.get(0).getEmployeeID());
