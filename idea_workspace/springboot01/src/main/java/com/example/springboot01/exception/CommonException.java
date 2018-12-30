package com.example.springboot01.exception;

/**
 * @ ClassName CommonException
 * @ Description 异常处理
 * @ Author hzd
 * @ Date 2018/12/8 18:49
 * @ Version 1.0
 */
public class CommonException extends RuntimeException {
    private  final  transient Object[] parameters;
    public CommonException(String message, Object... parameters) {
        super(message);
        this.parameters = parameters;
    }
    public CommonException(Throwable cause, Object... parameters) {
        super(cause);
        this.parameters = parameters;
    }
    public Object[] getParameters(){
        return parameters;
    }
}
