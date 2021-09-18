package cn.xuxiaofeng.it.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: ExecuteTime
 * @Description: 计时注解
 * @CreateBy: xxf
 * @Date: 2021/9/18 14:58
 */
@Inherited
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExecuteTime {
    boolean really() default true;
}
