import java.util.List;

public class Accountant extends BusinessEmployee {
    private TechnicalLead teamSupport;

    public Accountant(String name){
        super(name);
        setBonusBudget(0);
    }

    public TechnicalLead getTeamSupported(){
        return this.teamSupport;
    }

    public void supportTeam(TechnicalLead lead){
        this.teamSupport = lead;
        List<SoftwareEngineer> report = lead.getReport();
        for(SoftwareEngineer softwareEngineer: report){
            this.setBonusBudget(getBonusBudget() + softwareEngineer.getBaseSalary());
        }

        this.setBonusBudget(getBonusBudget()*1.1);
    }

    public boolean approveBonus(double bonus){
        if(bonus > this.getBonusBudget() || this.teamSupport == null){
            return false;
        } else {
            this.setBonusBudget(getBonusBudget()-bonus);
            return true;
        }
    }

    public String employeeStatus(){
        return this.toString()+" with a budget of "+this.getBonusBudget()+" and is assisting"+getTeamSupported();
    }
}
