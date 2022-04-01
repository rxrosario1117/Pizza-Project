public class Staff {
    String firstName;
    String lastName;
    String password;
    int employeeID;

    // Staff constructor
    public Staff(String firstName, String lastName, String password, int employeeID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.employeeID = employeeID;
    }

    //
    Staff(){

    }
    //

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

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
