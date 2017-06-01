package com.immoc.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by chenzhangli01 on 2017/5/31.
 */
@Component
@ConfigurationProperties(prefix="girl")   // 这个类 将所有 girl 前缀下的配置映射过来， 注入配置需要加 这里的两个注解
public class GirlProperties {

    private String cSize;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getcSize() {

        return cSize;
    }

    public void setcSize(String cSize) {
        this.cSize = cSize;
    }

}
