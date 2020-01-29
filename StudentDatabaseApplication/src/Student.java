import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private int gradeYear;
    private ArrayList<String> courses = new ArrayList<>(); //may become an array
    private int tuitionBalance;

    private static int costOfCourse = 600;
    private static int id = 1000;

    public Student() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student first name: ");
        this.firstName = input.nextLine();

        System.out.print("Enter Student last name: ");
        this.lastName = input.nextLine();

        System.out.print("From year 1 to 4: ");
        this.gradeYear = input.nextInt();

        setStudentId();

        System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentId);
    }

    public void enroll() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enroll in courses, choose Q to quit: ");
        String course = input.nextLine();

        while (!course.equalsIgnoreCase("Q")) {
            if (!course.equals("Q")) {
                courses.add(course);
                tuitionBalance += costOfCourse;
            } else {
                System.exit(0);
            }

            System.out.println("Enrollred course " + courses);
            System.out.println("Total tuition balance " + tuitionBalance);

            enroll();
        }

        System.exit(0);
    }

    private void setStudentId() {
        id++;
        this.studentId = gradeYear + "" + id;
    }
}
