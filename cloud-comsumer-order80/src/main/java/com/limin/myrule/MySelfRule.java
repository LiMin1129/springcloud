package com.limin.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.aspectj.bridge.MessageWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiMin
 * @date 2021/12/24-14:45
 * @DESCRIPTION
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
