package cn.xuxiaofeng.it.service.openfeign;

import cn.xuxiaofeng.it.common.CommRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: FirstClient
 * @Description: TODO
 * @CreateBy: xxf
 * @Date: 2021/7/29 19:13
 */
@FeignClient(value = "netty-test-first")
public interface FirstClient {
    @GetMapping("/get")
    CommRes<Boolean> get();
}
