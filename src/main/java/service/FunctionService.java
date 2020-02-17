package service;

import entity.Function;
import jdk.internal.jline.internal.ShutdownHooks;
import vo.NewTask;
import vo.TaskOverView;

import java.util.List;

public interface FunctionService {
    int modify(NewTask taskModify);
    List<Function> queryAll();
    List<Function> queryByName(String name);
    TaskOverView queryTaskOverView();
}
