package cn.xuxiaofeng.it.common;

import lombok.Getter;

/**
 * @ClassName: CommResEnum
 * @Description: 公共返回枚举类
 * @CreateBy: xxf
 * @Date: 2021/7/29 19:25
 */
@Getter
public enum CommResEnum {
    SUCCESS(200, "成功"),
    ERROR(500, "出错了")
    ;
    
    private final int code;
    private final String msg;

    CommResEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
