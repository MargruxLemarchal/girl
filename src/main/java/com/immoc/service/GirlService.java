package com.immoc.service;

import com.immoc.domain.Girl;
import com.immoc.respository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by chenzhangli01 on 2017/6/1.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional   //只有查询不需要加事务，这里加事务是为一条不成功则整体回滚
    public void addTwo(){
        Girl girl = new Girl();
        girl.setcSize("A");
        girl.setAge(24);

        girlRepository.save(girl);

        girl = new Girl();
        girl.setcSize("BBBBB");// 数据库限制了这个字段只有一个字符，所以这里添加不会成功
        girl.setAge(24);

        girlRepository.save(girl);
    }

}
