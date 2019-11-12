public abstract class Employee {
    private static int baseId = 0;
    private String name;
    private double salary;
    private int id;
    private Employee manager;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.id = baseId++;
    }

    public double getBaseSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return id;
    }

    public Employee getManager() {
        return this.manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public boolean equals(Employee other) {
        return this.id == other.id;
    }

    public String toString() {
        return id + " " + name;
    }

    public abstract String employeeStatus();
}
