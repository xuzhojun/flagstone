package service.impl;

import com.alibaba.fastjson.JSON;
import comm.ConstVal;
import comm.SomeUtils;
import dao.FunctionMapper;
import dao.OperateFlowMapper;
import entity.Function;
import entity.OperateFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.TaskModifyService;
import vo.NewTask;

@Service
public class TaskModifyServiceImpl implements TaskModifyService {

    @Autowired
    FunctionMapper functionMapper;

    @Autowired
    OperateFlowMapper operateFlowMapper;

    @Override
    public int modifyTask(NewTask newTask) {
            Function oldFunction = functionMapper.searchByID(newTask.getFunctionID());
            Function newFunction = new Function(newTask.getFunctionID(), newTask.getFunction(), newTask.getClassName(), newTask.getPersonInCharge(), newTask.getMileStone(), newTask.getRateOfProcess());
            functionMapper.updateById(newFunction);

            OperateFlow operateFlow = new OperateFlow(newTask.getFunctionID(), newTask.getOperator(), ConstVal.OPERATE_TYPE_MODIFY, JSON.toJSONString(oldFunction), JSON.toJSONString(newFunction), SomeUtils.getNowTime(), "");

            operateFlowMapper.add(operateFlow);

        return 0;
    }
}
