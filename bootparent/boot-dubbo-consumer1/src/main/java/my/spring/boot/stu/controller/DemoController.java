package my.spring.boot.stu.controller;

import my.spring.boot.stu.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @GetMapping("/say")
    public String say() {
        return demoService.sayHello();
    }
}
