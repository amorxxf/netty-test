package cn.xuxiaofeng.it.service.impl;

import cn.xuxiaofeng.it.dao.TestDao;
import cn.xuxiaofeng.it.service.MyTestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: TestServiceImpl
 * @Description: 实现类dao
 * @CreateBy: xxf
 * @Date: 2021/8/4 17:35
 */
@Service
public class TestServiceImpl implements MyTestService {
    @Resource
    private TestDao testDao;

    @Override
    public List<Map<String, Object>> findUserList() {
        return testDao.findTestView();
    }
}
