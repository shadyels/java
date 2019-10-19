public class TechnicalEmployee extends Employee {
    public int succesfulCheckIns;
    private double salary = 75000;

    public TechnicalEmployee(String name) {
        super(name,75000);
    }

    public String employeeStatus(){
        return this.toString() + " has completed "+ succesfulCheckIns +"successful check-ins";
    }

}
