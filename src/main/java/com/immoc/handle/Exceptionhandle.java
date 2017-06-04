package com.immoc.handle;

import com.immoc.domain.Result;
import com.immoc.exception.GirlException;
import com.immoc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenzhangli01 on 2017/6/2.
 */
@ControllerAdvice
public class Exceptionhandle {  // 异常捕获并处理类

    private static Logger logger = LoggerFactory.getLogger(Exceptionhandle.class);

    @ExceptionHandler(value =  Exception.class) // 说明要捕获的异常
    @ResponseBody   // 返回给浏览器的格式是 JSON
    public Result handle(Exception e) {

        if(e instanceof GirlException){
            return ResultUtil.error(((GirlException) e).getCode(), e.getMessage());
        }

        logger.error("[系统异常]{}", e);
        return ResultUtil.error(-1, e.getMessage());

    }

}
