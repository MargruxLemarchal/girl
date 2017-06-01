package com.immoc.respository;

import com.immoc.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by chenzhangli01 on 2017/6/1.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer>{  //这是 jpa 中对应的操作数据库的接口，和 mybatis 的 mapper 作用一样

    // 通过年龄来查询 ， jpa 自带的只有根据 id 来查询, 名字一定要按照规定的格式，这样jpa 才能自动生成函数
    public List<Girl>  findByAge(Integer age);
}
