package vo;

import java.util.List;

public class FinishedTaskItem {
    private String name;
    private List<Integer> finishedTask;

    public FinishedTaskItem(String name, List<Integer> finishedTask) {
        this.name = name;
        this.finishedTask = finishedTask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getFinishedTask() {
        return finishedTask;
    }

    public void setFinishedTask(List<Integer> finishedTask) {
        this.finishedTask = finishedTask;
    }
}
