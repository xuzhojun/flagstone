package service.impl;

import comm.ConstVal;
import comm.SomeUtils;
import dao.FunctionMapper;
import dao.OperateFlowMapper;
import entity.Function;
import entity.OperateFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.FunctionService;
import vo.NewTask;
import vo.TaskOverView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    private FunctionMapper functionMapper;

    @Autowired
    private OperateFlowMapper operateFlowMapper;

    public int modify(NewTask taskModify) {
        Function function = new Function(
                taskModify.getFunctionID(),
                taskModify.getFunction(),
                taskModify.getClassName(),
                taskModify.getPersonInCharge(),
                taskModify.getMileStone(),
                taskModify.getRateOfProcess()
        );

        OperateFlow operateFlow = new OperateFlow(
                taskModify.getFunctionID(),
                taskModify.getOperator(),
                ConstVal.OPERATE_TYPE_MODIFY,
                taskModify.getFunction().toString(),
                taskModify.toNewFunction().toString(),
                SomeUtils.getNowTime(),
                taskModify.getIp()
        );

        functionMapper.updateById(function);
        operateFlowMapper.add(operateFlow);
        return 0;
    }

    public List<Function> queryAll() {
        return functionMapper.queryAllFunction();
    }

    @Override
    public List<Function> queryByName(String name) {
        return functionMapper.searchByPersonInCharge(name);
    }

    @Override
    public TaskOverView queryTaskOverView() {

        class NumberOfTasks {
            int numberOfTasks;
            int numberOfUnfinished;
            int numberOfFinished;
        }

        List<Function> functions = queryAll();

        HashMap<String, NumberOfTasks> hm = new HashMap<>(32);

        for (Function function: functions) {
            if (hm.containsKey(function.getPersonInCharge())) {
                NumberOfTasks n = hm.get(function.getPersonInCharge());
                n.numberOfTasks++;
                if (function.getRateOfProcess() == 100) {
                    n.numberOfFinished++;
                } else {
                    n.numberOfUnfinished++;
                }
            } else {
                NumberOfTasks n = new NumberOfTasks();
                n.numberOfTasks++;
                if (function.getRateOfProcess() == 100) {
                    n.numberOfFinished++;
                } else {
                    n.numberOfUnfinished++;
                }
                hm.put(function.getPersonInCharge(), n);
            }
        }

        TaskOverView tov = new TaskOverView();
        for (Map.Entry<String, NumberOfTasks> entry : hm.entrySet()) {
            tov.getChargers().add(entry.getKey());
            tov.getNumberOfTasks().add(entry.getValue().numberOfTasks);
            tov.getNumberOfFinished().add(entry.getValue().numberOfFinished);
            tov.getNumberOfUnfinished().add(entry.getValue().numberOfUnfinished);
        }

        return tov;
    }


}
