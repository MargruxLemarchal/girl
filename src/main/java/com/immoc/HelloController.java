package com.immoc;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenzhangli01 on 2017/5/31.
 */
@RestController  // 如果是以 web 方式访问需要 加这个注解
@RequestMapping(value = "hello")   // 给该类一个映射前缀
public class HelloController {

//    @Value("${cSize}")   // 从配置文件中读出该项并注入给这个变量，在类中使用配置
//    private String cSize;
//
//    @Value("${age}")
//    private int age;
//
//    @Value("${content}")
//    private String content;

    @Autowired
    private GirlProperties girlProperties;   //此时不再需要将 girl 的每个额属性单独在这里用@Value 来注入，可以将所有和 Girl 有关的属性的读取封装在 GirlProperties 类中， 这里用 @Autowired自动注入

    @RequestMapping(value = { "/{id}/say", "/{id}/hi"}, method = RequestMethod.GET)  // 为安全起见，这个方法一定要设置
    public String say(@PathVariable("id") Integer id) { // localhost:8081/girl/hello/100/say   这种好奇怪但是很简洁，  @PathVariable 可以获得路径中的变量
        return "id: "+id;
        //return girlProperties.getcSize();
        //return  content;
        //return "Hellp Spring Boot";
    }

    @RequestMapping(value = { "/say1", "/hi1"}, method = RequestMethod.GET)
    // @GetMapping(value = "/say")
    // @PutMapping(value = "/say")  组合注解，上述表述的简化方式
    public String say1(@RequestParam( value = "id", required = false, defaultValue = "0") Integer id) { // localhost:8081/girl/hello/say?id=101  方式比较传统
        return "id: "+id;
        //return girlProperties.getcSize();
        //return  content;
        //return "Hellp Spring Boot";
    }


}
