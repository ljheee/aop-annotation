package com.ljheee.spring5;

import com.ljheee.spring5.config.AopConfig;
import com.ljheee.spring5.dao.UserDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Configuration.html
 */
public class AppTest {

    public static void main(String[] args) {

        /**
         * Spring5 Java config方式，使用AOP
         * https://my.oschina.net/discry/blog/1529629
         * 使用Java code配置，无XML配置。
         */

        // spring init
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        // getBean
        UserDAO bean = context.getBean(UserDAO.class);

        bean.query();

        for (int i = 0; i < 3; i++) {
            bean.runWithAnnotation(i);
            if(i ==2){
                bean.runWithAnnotation(i);
                bean.runWithAnnotation(i);
            }
        }

    }
}
