package cn.xuxiaofeng.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: FirstMainApplication
 * @Description: 启动类
 * @CreateBy: xxf
 * @Date: 2021/7/21 10:35
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FirstMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstMainApplication.class);
    }
}
