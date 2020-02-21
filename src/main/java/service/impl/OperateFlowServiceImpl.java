package service.impl;

import com.alibaba.fastjson.JSON;
import comm.SomeUtils;
import dao.FunctionMapper;
import dao.OperateFlowMapper;
import entity.Function;
import entity.OperateFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OperateFlowService;
import vo.FinishedTaskItem;
import vo.TaskFinished;

import java.util.*;

@Service
public class OperateFlowServiceImpl implements OperateFlowService {

    @Autowired
    private FunctionMapper functionMapper;

    @Autowired
    private OperateFlowMapper operateFlowMapper;

    @Override
    public List<OperateFlow> queryAll() {
        return operateFlowMapper.queryAll();
    }

    @Override
    public TaskFinished queryFinishSt() {
        List<String> chargers = functionMapper.searchAllChargers();
        HashMap<String, List<Integer>> hm = new HashMap<>(32);
        for (String charger : chargers) {
            hm.put(charger, new LinkedList<Integer>());
        }

        List<OperateFlow> operateFlowsList = queryAll();
        String newStatus = null;
        Function f = null;
        TaskFinished taskFinished = new TaskFinished();
        String lastDay = null;
        String updateTime;
        HashSet<Integer> funcSet = new HashSet<>(512);
        for (OperateFlow operateFlow : operateFlowsList) {
            newStatus = operateFlow.getNewStatus();
            f = JSON.parseObject(newStatus, Function.class);
            updateTime = SomeUtils.getDate(operateFlow.getTime());
            if (!updateTime.equals(lastDay)) {
                lastDay = updateTime;
                taskFinished.getDay().add(lastDay);
                for (Map.Entry<String, List<Integer>> entry : hm.entrySet()) {
                    Integer i = SomeUtils.getLastElement(entry.getValue());
                    if (i == null) {
                        i = 0;
                    }
                    if (f.getPersonInCharge().equals(entry.getKey()) && f.getRateOfProcess() == 100 && !funcSet.contains(f.getId())) {
                        funcSet.add(f.getId());
                        entry.getValue().add(i + 1);
                    } else {
                        entry.getValue().add(i);
                    }
                }
            } else {
                for (Map.Entry<String, List<Integer>> entry : hm.entrySet()) {
                    Integer i = SomeUtils.getLastElement(entry.getValue());
                    if (i == null) {
                        i = 0;
                    }

                    if (f.getPersonInCharge().equals(entry.getKey()) && f.getRateOfProcess() == 100 && !funcSet.contains(f.getId())) {
                        funcSet.add(f.getId());
                        entry.getValue().set(entry.getValue().size() - 1, i + 1);
                    }
                }
            }
        }

        int total;
        for (int i = 0; i < taskFinished.getDay().size(); i++) {
            total = 0;
            for (Map.Entry<String, List<Integer>> entry : hm.entrySet()) {
                total += entry.getValue().get(i);
            }
            taskFinished.getTotalFinished().add(total);
        }

        for (Map.Entry<String, List<Integer>> entry : hm.entrySet()) {
            taskFinished.getFinishedTaskItemsList().add(new FinishedTaskItem(entry.getKey(), entry.getValue()));
        }
        System.out.println(JSON.toJSONString(taskFinished));
        return taskFinished;
    }
}
