package org.seckill.exception;

/**
 * 秒杀异常父类
 * Created by wutongpeng on 2017/1/16.
 */
public class SeckillException extends  RuntimeException{

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
