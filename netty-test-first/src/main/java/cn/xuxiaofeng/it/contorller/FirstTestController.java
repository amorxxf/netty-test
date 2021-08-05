package cn.xuxiaofeng.it.contorller;

import cn.xuxiaofeng.it.common.CommRes;
import cn.xuxiaofeng.it.service.openfeign.FirstBlockHandler;
//import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: FirstTestController
 * @Description: 第一生产模块测试
 * @CreateBy: xxf
 * @Date: 2021/7/29 19:09
 */
//@RefreshScope
@RestController
@RequestMapping("/config")
public class FirstTestController {
    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

//    @SentinelResource(value = "configGet", blockHandlerClass = FirstBlockHandler.class)
    @RequestMapping("/get")
    public CommRes<Boolean> get() {
        return new CommRes<>(useLocalCache);
    }
}
