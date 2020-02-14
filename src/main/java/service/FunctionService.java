package service;

import entity.Function;
import vo.NewTask;

import java.util.List;

public interface FunctionService {
    int modify(NewTask taskModify);
    List<Function> queryAll();
    List<Function> queryByName(String name);
}
