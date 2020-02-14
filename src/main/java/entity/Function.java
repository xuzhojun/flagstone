package entity;

public class Function {
    private int id;
    private String function;
    private String className;
    private String personInCharge;
    private String mileStone;
    private int rateOfProcess;

    public Function() {}

    public Function(int id, String function, String className, String personInCharge, String mileStone, int rateOfProcess) {
        this.id = id;
        this.function = function;
        this.className = className;
        this.personInCharge = personInCharge;
        this.mileStone = mileStone;
        this.rateOfProcess = rateOfProcess;
    }

    public Function(String function, String className, String personInCharge, String mileStone, int rateOfProcess) {
        this.function = function;
        this.className = className;
        this.personInCharge = personInCharge;
        this.mileStone = mileStone;
        this.rateOfProcess = rateOfProcess;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(String personInCharge) {
        this.personInCharge = personInCharge;
    }

    public String getMileStone() {
        return mileStone;
    }

    public void setMileStone(String mileStone) {
        this.mileStone = mileStone;
    }

    public int getRateOfProcess() {
        return rateOfProcess;
    }

    public void setRateOfProcess(int rateOfProcess) {
        this.rateOfProcess = rateOfProcess;
    }

    @Override
    public String toString() {
        return "Function{" +
                "id=" + id +
                ", function='" + function + '\'' +
                ", className='" + className + '\'' +
                ", personInCharge='" + personInCharge + '\'' +
                ", mileStone='" + mileStone + '\'' +
                ", rateOfProcess=" + rateOfProcess +
                '}';
    }

}
