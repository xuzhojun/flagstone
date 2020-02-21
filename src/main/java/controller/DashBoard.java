package controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.FunctionService;
import service.OperateFlowService;
import vo.TaskFinished;
import vo.TaskOverView;

@Controller
@RequestMapping("/dashboard")
public class DashBoard {

    @Autowired
    OperateFlowService operateFlowService;

    @Autowired
    FunctionService functionService;

    @GetMapping(value = "")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping(value = "/personOverview")
    @ResponseBody
    public String personOverview() {
        TaskOverView tov = functionService.queryTaskOverView();
        return JSON.toJSONString(tov);
    }

    @GetMapping(value = "taskFinished")
    @ResponseBody
    public String taskFinished() {
        return "";
    }

    @GetMapping(value = "everyDayFinished")
    @ResponseBody
    public String everyDayFinished() {
        TaskFinished taskFinished = operateFlowService.queryFinishSt();
        return JSON.toJSONString(taskFinished);
    }
}
