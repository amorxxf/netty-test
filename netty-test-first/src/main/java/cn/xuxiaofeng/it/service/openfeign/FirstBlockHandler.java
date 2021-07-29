package cn.xuxiaofeng.it.service.openfeign;

import cn.xuxiaofeng.it.common.CommRes;
import org.springframework.stereotype.Component;

/**
 * @ClassName: FirstBlockHandler
 * @Description: 自定义返回
 * @CreateBy: xxf
 * @Date: 2021/7/29 19:13
 */
@Component
public class FirstBlockHandler implements FirstClient{
    @Override
    public CommRes<Boolean> get() {
        return new CommRes<>("哎呀，保险丝断了", 500);
    }
}
