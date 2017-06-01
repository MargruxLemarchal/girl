package com.immoc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by chenzhangli01 on 2017/6/1.
 */
@Entity  // 该类对应数据库中的某个表，会利用其自动在数据库中创建对应的表
public class Girl {
    private Integer age;

    private String cSize;

    @Id
    @GeneratedValue
    private Integer id;

    public Girl() {

    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
