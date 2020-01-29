public class Student {
    private String id;
    private String name;
    private int grade;
    private double feesPaid;
    private double feesTotal;

    public Student(String id, String name, int grade){
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.feesPaid = 0;
        this.feesTotal = 1000;
    }

    public void updateFees(double feesPaid) {
        this.feesPaid = feesPaid;
        feesTotal = feesTotal + feesPaid;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public double getFeesTotal() {
        return feesTotal;
    }
}
