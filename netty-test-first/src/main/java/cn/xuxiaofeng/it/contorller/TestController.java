package cn.xuxiaofeng.it.contorller;

import cn.xuxiaofeng.it.common.CommRes;
import cn.xuxiaofeng.it.service.MyTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: TestController
 * @Description: 测试
 * @CreateBy: xxf
 * @Date: 2021/8/4 17:12
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private MyTestService myTestService;

    @GetMapping("/find")
    public CommRes<List<Map<String, Object>>> findUserList() {
        List<Map<String, Object>> list = myTestService.findUserList();
        return new CommRes<>(list);
    }
}
