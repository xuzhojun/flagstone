package service;


import entity.OperateFlow;
import vo.TaskFinished;

import java.util.List;

public interface OperateFlowService {

    List<OperateFlow> queryAll();

    TaskFinished queryFinishSt();
}
