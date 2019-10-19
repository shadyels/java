import java.util.ArrayList;
import java.util.List;

public class TechnicalLead extends TechnicalEmployee implements Manager {
    private int headcount;
    private List<SoftwareEngineer> report = new ArrayList<SoftwareEngineer>();

    public TechnicalLead(String name) {
        super(name);
        this.setSalary(super.getBaseSalary() * 1.3);
        this.headcount = 4;
    }

    public boolean hasHeadCount() {
        return this.headcount >= report.size();
    }

    public boolean addReport(SoftwareEngineer e) {
        if (this.hasHeadCount()) {
            report.add(e);
            e.setCodeAccess(true);
            e.setManager(this);
            return true;
        } else {
            return false;
        }
    }

    public List<SoftwareEngineer> getReport(){
        return report;
    }

    public boolean approveCheckIn(SoftwareEngineer e) {
        return e.getManager() == this && e.getCodeAccess();
    }

    public boolean requestBonus(Employee e, double bonus) {
        if(((Accountant) getManager()).approveBonus(bonus)){
            ((SoftwareEngineer) e).receiveBonus(bonus);
            return true;
        }
        return false;
    }

    public String getTeamStatus() {
        ArrayList<String> finalList = new ArrayList<String>();

        if (report.size() == 0) {
            finalList.add(this.toString() + " and no direct reports yet");
        } else {
            finalList.add(this.toString() + " is managing:\n");
            for (SoftwareEngineer softwareEngineer : report) {
                finalList.add(softwareEngineer.toString()+" has "+softwareEngineer.getSuccessfulCheckIns()+" succesful checkins\n");
            }
        }

        String finalString = "";
        for (String entry : finalList) {
            finalString += entry;
        }

        return finalString;
    }
}
