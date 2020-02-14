package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.FunctionService;
import service.OperateFlowService;

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

}
