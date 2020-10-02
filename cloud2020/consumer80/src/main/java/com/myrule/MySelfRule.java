package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {

    //注意包的位置不能放在主启动类所在包及其子包
    @Bean
    public IRule myRule(){
        return new RandomRule();//定义为随机
    }

}
