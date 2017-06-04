package com.immoc.utils;

import com.immoc.domain.Result;

/**
 * Created by chenzhangli01 on 2017/6/2.
 */
public class ResultUtil{
    public  static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMessage("成功");
        result.setData(object);
        return result;
    }

    public  static Result success(){
        return success(null);
    }

    public  static Result error(Integer code, String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
