import java.util.ArrayList;
import java.util.List;

public class BusinessLead extends BusinessEmployee implements Manager {
    private int headcount;
    private List<Accountant> report = new ArrayList<Accountant>();

    public BusinessLead(String name) {
        super(name);
        this.setSalary(super.getBaseSalary() * 2);
        this.headcount = 10;
    }

    public boolean hasHeadCount() {
        return this.headcount >= report.size();
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        if (this.hasHeadCount()) {
            report.add(e);
            e.setManager(this);
            this.setBonusBudget(this.getBonusBudget() + (e.getBaseSalary() * 1.1));
            e.supportTeam(supportTeam);
            return true;
        } else {
            return false;
        }
    }

    public boolean requestBonus(Employee e, double bonus) {
        if (bonus <= this.getBonusBudget()) {
            this.setBonusBudget(this.getBonusBudget() - bonus);
            return true;
        } else {
            return false;
        }
    }

    public boolean approveBonus(Employee e, double bonus) {
        for (Accountant accountant : report) {
            if ((accountant.getTeamSupported() == e.getManager()) && accountant.approveBonus(bonus)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getTeamStatus() {
        return null;
    }
}
