package vo;

import entity.Function;

public class NewTask {
    private int functionID;
    private String operator;
    private String function;
    private String className;
    private String personInCharge;
    private String mileStone;
    private int rateOfProcess;
    private String nowTime;
    private String ip;

    public int getFunctionID() {
        return functionID;
    }

    public void setFunctionID(int functionID) {
        this.functionID = functionID;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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

    public String getNowTime() {
        return nowTime;
    }

    public void setNowTime(String nowTime) {
        this.nowTime = nowTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Function toNewFunction() {
        return new Function(this.functionID, this.function, this.className, this.personInCharge, this.mileStone, this.rateOfProcess);
    }

    @Override
    public String toString() {
        return "TaskModify{" +
                "functionID=" + functionID +
                ", operator='" + operator + '\'' +
                ", function='" + function + '\'' +
                ", className='" + className + '\'' +
                ", personInCharge='" + personInCharge + '\'' +
                ", mileStone='" + mileStone + '\'' +
                ", rateOfProcess=" + rateOfProcess +
                ", nowTime='" + nowTime + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
