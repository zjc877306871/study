package com.zhangjc.springStudy.chap8.config;/**
 * Created by user on 2018/10/11.
 */

import com.zhangjc.springStudy.chap1.Person;
import com.zhangjc.springStudy.chap7.vo.Bike;
import com.zhangjc.springStudy.chap8.dao.CarDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @ClassName Chap8Config
 * @Description 扫描的注解  service/reposity 在使用Autowired注入时，优先级高于@bean 注入的实例
 * @Autor user
 * @Date 2018/10/11 16:11
 * @Version 1.0
 **/
@Configuration
@ComponentScan("com.zhangjc.springStudy.chap8")
public class Chap8Config {

    @Primary//spring 自动装配时，默认首选
    @Bean("carDao2")
    public CarDao carDao(){
        CarDao carDao = new CarDao();
        carDao.setColor("3");
        return carDao;
    }



}
