说明:
    1.本工程主要是测试docker中部署dubbo的实施方案.
    boot-dubbo-api 为dubbo服务的api
    boot-dubbo-provider1 为 springboot整合dubbo的ideal源码,并未使用spring-boot-start-dubbo来整合,而是使用传统xml配置形式,便于传统spring工程复用
    boot-dubbo-provider-war 为 springboot打war包的代码,里面主要是pom文件的修改
    boot-dubbo-consumer1 为 springboot整合dubbo的consumer
    
    2. docker中部署dubbo存在的问题是会在zookeeper中暴露docker的IP,而不是宿主机的IP,而跨主机访问是无法直接获取docker的IP的.
    所以问题的关键在于在zookeeper中暴露宿主机的IP
    
    3.网上解决方案的实测:
    
    (1) cp /etc/hosts /tmp/hosts
    sed -i ‘$d‘ /tmp/hosts
    cat /tmp/hosts > /etc/hosts --未解决
    
    (2) #!/bin/sh
    cp /etc/hosts /etc/hosts.temp
    sed -i "s/.*$(hostname)/$DOCKER_IP $(hostname)/" /etc/hosts.temp
    cat /etc/hosts.temp > /etc/hosts
    /data/app/bin/start.sh     --未解决
    
    (3) docker run -d -p 58080:8080 -v /root/webapps/:/opt/tomcat/webapps/ --net=host --name mytomcat_1 mytomcat:1.0 /root/run.sh --解决
    
    (4) 在dubbo.properties中配置:dubbo.protocol.host=192.168.0.102(宿主机IP)
    在spring-dubbo.xml中配置:<dubbo:protocol name="${dubbo.protocol.name}" port="${dubbo.protocol.port}" host="${dubbo.protocol.host}"/>   --解决
    
    