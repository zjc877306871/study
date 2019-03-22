
package com.zhangjc.springStudy;
/**
 * Created by user on 2018/10/11.
 */

import com.zhangjc.springStudy.chap10.bean.BookAop;
import com.zhangjc.springStudy.chap10.config.Chap10Config;
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
public class TestChap10 {

    @Test
    public void test(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Chap10Config.class);

        BookAop bookAop = app.getBean(BookAop.class);
        bookAop.read(1,2);


//        String[] names = app.getBeanDefinitionNames();
//        for(String name : names){
//            System.out.println(name);
//        }
        System.out.println("容器初始化完成！！！！！！！！！！");

    }
}
