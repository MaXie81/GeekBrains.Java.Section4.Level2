package geekgrains.java.section4.level2.lesson7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @GetMapping
    public String getIndex() {
        return "index";
    }
}
