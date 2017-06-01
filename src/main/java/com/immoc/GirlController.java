package com.immoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenzhangli01 on 2017/6/1.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private  GirlService girlService;

    /**
     * 查询女生列表
     * */
    @GetMapping(value = "/girls/list")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }
    /**
     * 添加一个女生
     * */
    @PostMapping(value = "/girls/add")
    public Girl girlAdd(@RequestParam("cSize") String cSize, @RequestParam("age") Integer age){  // RequestParam 在 PostMan 中需要 Body-- form-data 添加，不可以用 raw--json
        Girl girl = new Girl();
        girl.setcSize(cSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    /**
     * 根据 id查询一个女生
     * */
    @PostMapping(value = "/girls/{id}")
    public Girl girlFind(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }
    /**
     * 根据年龄查询女生
     * */
    @PostMapping(value = "/girls/age")
    public List<Girl> girlFindByAge(@RequestParam("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 更新一个女生
     * */
    @PostMapping(value = "/girls/update/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
           @RequestParam("cSize") String cSize, @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setcSize(cSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }
    /**
     * 删除一个女生
     * */
    @PostMapping(value = "/girls/delete/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    @PostMapping(value = "girls/two")
    public void girlAddTwo(){
        girlService.addTwo();
    }
}
