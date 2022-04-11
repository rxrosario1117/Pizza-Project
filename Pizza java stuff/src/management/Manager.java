package management;

public class Manager extends Staff{

    // constructor to call parent constructor (management.Staff) with super
    public Manager(String firstName, String lastName, String password, String employeeID) {
//        
        super(firstName, lastName, password, employeeID);
        super.setEmployeeType("Manager");
    }
}
