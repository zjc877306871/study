
package com.zhangjc.springStudy;
/**
 * Created by user on 2018/10/11.
 */

import com.zhangjc.springStudy.chap7.config.Chap7Config;
import com.zhangjc.springStudy.chap8.config.Chap8Config;
import com.zhangjc.springStudy.chap8.dao.CarDao;
import com.zhangjc.springStudy.chap8.service.CarService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName TestChap1
 * @Description  测试不同的势力注入方式
 * @Autor user
 * @Date 2018/10/11 16:05
 * @Version 1.0
 **/
public class TestChap8 {

    @Test
    public void test(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Chap8Config.class);


        //通过Autowired注入获取到的carDao实例
        CarService carService = app.getBean(CarService.class);
        carService.println();

        //获取容器中carDao实例
        CarDao carDao = app.getBean(CarDao.class);
        System.out.println("直接获取------》" + carDao);




        System.out.println("容器初始化完成！！！！！！！！！！");

        app.close();

    }
}
