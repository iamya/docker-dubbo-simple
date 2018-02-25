package my.spring.boot.stu.config;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class InitSystemProperties {

	@PostConstruct
	public void init() {
		
		String hostToRegist = System.getProperty("VMIP");
		if(hostToRegist != null && hostToRegist.length() > 0) {
			System.setProperty("DUBBO_IP_TO_REGISTRY", hostToRegist);
		} else {
			System.setProperty("DUBBO_IP_TO_REGISTRY", "172.20.10.2");
		}
	}
}
