package org.seckill.exception;

/**
 * 秒杀关闭异常（运行期异常）
 * Created by chen on 2016/5/30.
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
