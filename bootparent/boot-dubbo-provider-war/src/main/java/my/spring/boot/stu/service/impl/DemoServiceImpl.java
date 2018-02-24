package my.spring.boot.stu.service.impl;

import my.spring.boot.stu.service.IDemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements IDemoService {
    @Override
    public String sayHello() {
        return "Hello, dubbo-war !!!";
    }
}
