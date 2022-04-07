import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class Staff {
    private String firstName;
    private String lastName;
    private String password;
    private String employeeID;

    // Staff constructor with getters and setters
    public Staff(String firstName, String lastName, String password, String employeeID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.employeeID = employeeID;
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

    //    serialize / deserialize
    public String serialize(Staff staff){
//        GsonBuilder() will set the string to print nicely in the console
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Gson gson = new Gson();

//        Staff is converted to json text
        String toJson = gson.toJson(staff);

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

    public Staff deserialize(String json){

        return new Gson().fromJson(json, Staff.class);
    }
}
