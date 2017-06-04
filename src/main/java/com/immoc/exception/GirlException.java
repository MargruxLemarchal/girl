package com.immoc.exception;

import com.immoc.enums.ResultEnum;

/**
 * Created by chenzhangli01 on 2017/6/2.
 */
public class GirlException extends RuntimeException {  // Spring 框架只会对 runtimeException 才会进行事务回滚，Exception 不会

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

//    public GirlException(Integer code, String message){
//         super(message);
//
//         this.code = code;
//    }
    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());

        this.code = resultEnum.getCode();
    }
}
