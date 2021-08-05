package cn.xuxiaofeng.it.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: TestDao
 * @Description: 测试dao
 * @CreateBy: xxf
 * @Date: 2021/8/4 16:09
 */
@Mapper
public interface TestDao {
    List<Map<String, Object>> findTestView();
}
