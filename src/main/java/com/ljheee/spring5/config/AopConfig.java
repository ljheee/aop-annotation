package com.ljheee.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP配置
 * 使用＠EnableAspectJ AutoProxy 注解开启Spring 对AspectJ 代理的支持。
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.ljheee.spring5")
public class AopConfig {


}
