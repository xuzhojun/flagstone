package vo;

import java.util.LinkedList;
import java.util.List;

public class TaskFinished {
    private List<String> day;
    private List<Integer> totalFinished;
    private List<FinishedTaskItem> finishedTaskItemsList;

    public TaskFinished() {
        day = new LinkedList<String>();
        totalFinished = new LinkedList<Integer>();
        finishedTaskItemsList = new LinkedList<FinishedTaskItem>();
    }

    public List<String> getDay() {
        return day;
    }

    public void setDay(List<String> day) {
        this.day = day;
    }

    public List<Integer> getTotalFinished() {
        return totalFinished;
    }

    public void setTotalFinished(List<Integer> totalFinished) {
        this.totalFinished = totalFinished;
    }

    public List<FinishedTaskItem> getFinishedTaskItemsList() {
        return finishedTaskItemsList;
    }

    public void setFinishedTaskItemsList(List<FinishedTaskItem> finishedTaskItemsList) {
        this.finishedTaskItemsList = finishedTaskItemsList;
    }
}
