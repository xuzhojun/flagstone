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

import java.util.List;

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
}
