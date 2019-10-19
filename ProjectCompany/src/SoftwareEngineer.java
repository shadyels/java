public class SoftwareEngineer extends TechnicalEmployee {
    private boolean hasAccesToCode;
    private double bonus;

    public SoftwareEngineer(String name){
        super(name);
        this.hasAccesToCode = false;
    }

    public boolean getCodeAccess(){
        return hasAccesToCode;
    }

    public void setCodeAccess(boolean access){
        this.hasAccesToCode = access;
    }

    public void receiveBonus(double bonus){
        this.bonus += bonus;
    }

    public int getSuccessfulCheckIns(){
        return this.succesfulCheckIns;
    }
}
