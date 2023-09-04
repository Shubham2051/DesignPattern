package pattern.parkinglot.models;

public class Operator extends BaseModel{
    private  String Name;
    private int employeeID;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
