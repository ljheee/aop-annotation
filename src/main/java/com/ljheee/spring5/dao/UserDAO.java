package com.ljheee.spring5.dao;

import com.ljheee.spring5.annotation.ResultCache;
import org.springframework.stereotype.Service;

/**
 * Created by lijianhua04 on 2018/9/17.
 */
@Service
public class UserDAO {

    public String query() {
//        int a = 1/0; //若此处抛出异常，前置通知仍能执行成功(包括环绕通知joinPoint.proceed()前的也能执行成功)；后置通知得不到执行就出现异常
        System.out.println("UserDAO::query");
        return "ok";
    }


    @ResultCache
    public String runWithAnnotation(int index) {
        return "runWithAnnotation" + index;
    }

    @ResultCache
    public String runWithAnnotation(String name) {
        return "runWithAnnotation" + name;
    }

}
