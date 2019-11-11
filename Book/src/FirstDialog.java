import javax.swing.JOptionPane;

public class FirstDialog {
    public static void main(String[] args) {
        int selection;
        boolean isYes;
        selection = JOptionPane.showConfirmDialog(null,
            "Do you want to upgrade to first class?"); isYes = (selection == JOptionPane.YES_OPTION); JOptionPane.showMessageDialog(null,
            "You responded " + isYes);

        String love = JOptionPane.showInputDialog(null, "What is your name?", "who is my pasticcy?", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Ciao " + love + "!");
        long perl = 2444555888L;

        String wageString, dependentsString;
        double wage, weeklyPay;
        int dependents;
        final double HOURS_IN_WEEK = 37.5;
        wageString = JOptionPane.showInputDialog(null,
            "Enter employee's hourly wage", "Salary dialog 1", JOptionPane.INFORMATION_MESSAGE);
        weeklyPay = Double.parseDouble(wageString) * HOURS_IN_WEEK;
        dependentsString = JOptionPane.showInputDialog(null, "How many dependents?", "Salary dialog 2", JOptionPane.QUESTION_MESSAGE);
        dependents = Integer.parseInt(dependentsString); JOptionPane.showMessageDialog(null, "Weekly salary is $" +
            weeklyPay + "\nDeductions will be made for " +
            dependents + " dependents");
    }
}
