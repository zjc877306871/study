package com.zhangjc.springStudy.chap8.service;/**
 * Created by user on 2018/10/16.
 */

import com.zhangjc.springStudy.chap8.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @ClassName CarService
 * @Description TODO
 * @Autor user
 * @Date 2018/10/16 11:11
 * @Version 1.0
 **/
@Service
public class CarService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
//    @Qualifier(value = "carDao")//和Autowired配合使用  指定注入的bean
    private CarDao carDao;

    public void println(){
        System.out.println(carDao);
    }
}
