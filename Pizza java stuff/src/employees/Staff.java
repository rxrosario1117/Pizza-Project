package employees;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Staff {
    private String firstName;
    private String lastName;
    private String password;
    private String employeeType;
    private String employeeID;

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

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

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    //    serialize a list of Orders and return a String of the json text
    public static String serializeAList(List<Staff> staffList) {

//        GsonBuilder() will set the string to print nicely in the console
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Gson gson = new Gson();

//        order is converted to json text
        String toJson = gson.toJson(staffList);

//        create new Json file
        try{
            FileWriter file = new FileWriter("Staff.json");
            file.write(toJson);
            file.flush();

        }catch (IOException e) {
            e.printStackTrace();
        }

        return toJson;
    }

    //    deserialize a list of Orders and return the Order list
    public static List<Staff> deserializeAList(String json) {

//        we must evaluate the type of the list of orders using a typeToken before we use Gson().fromJson
        Type staffListType = new TypeToken<ArrayList<Staff>>(){}.getType();

//        returns deserialized / hydrated list
        return new Gson().fromJson(json, staffListType);

    }
}

////      ------ Staff members to / from JSON test ------
////                Just paste into main to test
//
//      Staff staff1 = new Staff("Ray", "Rosario", "1234qwer", "55555");
//      Staff mngr1 = new Manager("Nelos", "Villalobos", "!@#$QWER", "99999");
//
//      List<Staff> empl = new ArrayList<>();
//      empl.add(staff1);
//      empl.add(mngr1);
//
//      Staff.serializeAList(empl);
//
//      empl = Staff.deserializeAList(Staff.serializeAList(empl));
//
//      System.out.println(empl.get(0).getPassword());
