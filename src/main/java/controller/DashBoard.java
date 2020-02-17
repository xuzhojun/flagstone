package controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.FunctionService;
import service.OperateFlowService;
import vo.TaskOverView;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashBoard {

    @Autowired
    OperateFlowService operateFlowService;

    @Autowired
    FunctionService functionService;

    @GetMapping(value = "")
    public String dashboard() {
        System.out.println("hello board");
        return "dashboard";
    }

    @GetMapping(value = "/overview")
    @ResponseBody
    public String overview() {
        TaskOverView tov = functionService.queryTaskOverView();
        if (tov == null) {
            tov = new TaskOverView();

            List<String> chargers = tov.getChargers();
            chargers.add("Xuzj");
            chargers.add("Liuht");
            chargers.add("Zhangq");

            List<Integer> numberOfTasks = tov.getNumberOfTasks();
            numberOfTasks.add(310);
            numberOfTasks.add(450);
            numberOfTasks.add(290);

            List<Integer> numberOfUnfinished = tov.getNumberOfUnfinished();
            numberOfUnfinished.add(190);
            numberOfUnfinished.add(180);
            numberOfUnfinished.add(150);

            List<Integer> numberOfFinished = tov.getNumberOfFinished();
            numberOfFinished.add(120);
            numberOfFinished.add(270);
            numberOfFinished.add(140);
        }

        System.out.println(JSON.toJSONString(tov));
        return JSON.toJSONString(tov);
    }

}
