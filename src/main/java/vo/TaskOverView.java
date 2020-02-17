package vo;

import java.util.LinkedList;
import java.util.List;

public class TaskOverView {
    private List<String> chargers;
    private List<Integer> numberOfTasks;
    private List<Integer> numberOfUnfinished;
    private List<Integer> numberOfFinished;

    public TaskOverView() {
        chargers = new LinkedList<>();
        numberOfTasks = new LinkedList<>();
        numberOfUnfinished = new LinkedList<>();
        numberOfFinished = new LinkedList<>();
    }


    public List<String> getChargers() {
        return chargers;
    }

    public void setChargers(List<String> chargers) {
        this.chargers = chargers;
    }

    public List<Integer> getNumberOfTasks() {
        return numberOfTasks;
    }

    public void setNumberOfTasks(List<Integer> numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }

    public List<Integer> getNumberOfUnfinished() {
        return numberOfUnfinished;
    }

    public void setNumberOfUnfinished(List<Integer> numberOfUnfinished) {
        this.numberOfUnfinished = numberOfUnfinished;
    }

    public List<Integer> getNumberOfFinished() {
        return numberOfFinished;
    }

    public void setNumberOfFinished(List<Integer> numberOfFinished) {
        this.numberOfFinished = numberOfFinished;
    }
}
