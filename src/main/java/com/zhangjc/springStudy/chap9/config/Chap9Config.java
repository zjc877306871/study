package com.zhangjc.springStudy.chap9.config;/**
 * Created by user on 2018/10/11.
 */

import com.zhangjc.springStudy.chap8.dao.CarDao;
import com.zhangjc.springStudy.chap9.vo.Bird;
import org.springframework.context.annotation.*;

/**
 * @ClassName Chap8Config
 * @Description
 * @Autor user
 * @Date 2018/10/11 16:11
 * @Version 1.0
 **/
@Configuration
//@PropertySource(value = "classpath:/bird.properties")//加载配置文件的数据
public class Chap9Config {

    @Bean
    public Bird bird(){
        return new Bird();
    }


}
