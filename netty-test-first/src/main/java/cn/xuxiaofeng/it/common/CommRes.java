package cn.xuxiaofeng.it.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName: CommRes
 * @Description: 公共返回类
 * @CreateBy: xxf
 * @Date: 2021/7/29 19:17
 */
@Getter
@Setter
public class CommRes<T> implements Serializable {
    private static final long serialVersionUID = -7367995372616638542L;

    private final T result;

    private final String msg;

    private final int code;

    public CommRes (String msg, int code, T result) {
        this.msg = msg;
        this.code = code;
        this.result = result;
    }

    public CommRes (String msg, int code) {
        this.result = null;
        this.msg = msg;
        this.code = code;
    }

    public CommRes (T result) {
        this.result = result;
        this.msg = CommResEnum.SUCCESS.getMsg();
        this.code = CommResEnum.SUCCESS.getCode();
    }
}
