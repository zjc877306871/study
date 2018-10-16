
package com.zhangjc.springStudy;
/**
 * Created by user on 2018/10/11.
 */

import com.zhangjc.springStudy.chap8.config.Chap8Config;
import com.zhangjc.springStudy.chap8.dao.CarDao;
import com.zhangjc.springStudy.chap8.service.CarService;
import com.zhangjc.springStudy.chap9.config.Chap9Config;
import com.zhangjc.springStudy.chap9.vo.Bird;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName TestChap1
 * @Description  测试不同的势力注入方式
 * @Autor user
 * @Date 2018/10/11 16:05
 * @Version 1.0
 **/
public class TestChap9 {

    @Test
    public void test(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Chap9Config.class);



        //获取容器中carDao实例
        Bird bird = (Bird) app.getBean("bird");
        System.out.println("直接获取------》" + bird);




        System.out.println("容器初始化完成！！！！！！！！！！");

        app.close();

    }
}
