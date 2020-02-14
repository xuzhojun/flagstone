package controller;

import entity.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.FunctionService;
import service.TaskModifyService;
import vo.NewTask;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    FunctionService functionService;

    @Autowired
    TaskModifyService taskModifyService;


    @GetMapping("/")
    public String index(Model model) {
        List<Function> tasks = functionService.queryAll();
        model.addAttribute("tasks", tasks);

        return "index";
    }

    @GetMapping("/who")
    public String index(@RequestParam(name = "name") String operator, Model model) {
        List<Function> tasks = functionService.queryAll();
        model.addAttribute("tasks", tasks);
        if (operator != null || !operator.isEmpty()) {
            model.addAttribute("operatorName", operator);
        }

        return "index";
    }

    @GetMapping("/myTask")
    public String myTask(@RequestParam(name = "name") String name, Model model) {
        List<Function> tasks = functionService.queryByName(name);
        model.addAttribute("tasks", tasks);
        model.addAttribute("operatorName", name);

        return "index";
    }

    @PostMapping("/taskModify")
    public String taskModify(HttpServletRequest request, NewTask newTask) throws UnsupportedEncodingException {
        taskModifyService.modifyTask(newTask);

        return "redirect:/who?name=" + java.net.URLEncoder.encode(newTask.getOperator(),"UTF-8");
    }
}
