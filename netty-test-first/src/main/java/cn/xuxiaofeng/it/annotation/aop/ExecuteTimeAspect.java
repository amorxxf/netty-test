package cn.xuxiaofeng.it.annotation.aop;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.xuxiaofeng.it.annotation.ExecuteTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ExecuteTimeAspect
 * @Description: @ExecuteTime 增强
 * @CreateBy: xxf
 * @Date: 2021/9/18 15:02
 */
@Slf4j
@Aspect
@Component
public class ExecuteTimeAspect {
    /**
     * 切入
     */
    @Pointcut("@annotation(cn.xuxiaofeng.it.annotation.ExecuteTime)")
    public void pointcut() {}

    @Before("pointcut() && @annotation(executeTime)")
    public void before(ExecuteTime executeTime) {
        log.info("  =========== 2.计时开始 ");
    }

    @Around("@annotation(executeTime)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, ExecuteTime executeTime) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        if (args != null && args.length > 0) {
            log.info("参数为：");
            for (Object o : args) {
                log.info("参数：{}", o);
            }
        }

//        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
//        Method method = signature.getMethod();
//        ExecuteTime annotation = method.getAnnotation(ExecuteTime.class);
        if (executeTime.really()) log.info("1.计时启用....");

        DateTime start = DateUtil.date();
        Object result = proceedingJoinPoint.proceed();
        DateTime end = DateUtil.date();
        log.info("4.该方法的执行时间为：{}", DateUtil.formatBetween(start, end));

        return result;
    }

    @After("pointcut() && @annotation(executeTime)")
    public void after(ExecuteTime executeTime) {
        log.info("3.计时结束 =========== ");
    }

}
