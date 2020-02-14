package entity;

public class OperateFlow {
    private int id;
    private int functionID;
    private String operator;
    private int operateType;
    private String oldStatus;
    private String newStatus;
    private String time;
    private String ip;

    public OperateFlow() {}

    public OperateFlow(int functionID, String operator, int operateType, String oldStatus, String newStatus, String time, String ip) {
        this.functionID = functionID;
        this.operator = operator;
        this.operateType = operateType;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
        this.time = time;
        this.ip = ip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getOperateType() {
        return operateType;
    }

    public void setOperateType(int operateType) {
        this.operateType = operateType;
    }

    public String getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(String oldStatus) {
        this.oldStatus = oldStatus;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "OperateFlow{" +
                "id=" + id +
                ", functionID=" + functionID +
                ", operator='" + operator + '\'' +
                ", operateType=" + operateType +
                ", oldStatus='" + oldStatus + '\'' +
                ", newStatus='" + newStatus + '\'' +
                ", time='" + time + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
