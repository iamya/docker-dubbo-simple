package my.spring.boot.stu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ImportResource({"classpath:dubbo/spring-dubbo.xml"})
@PropertySource({"classpath:dubbo/dubbo.properties"})
public class DubboConfig {
}
