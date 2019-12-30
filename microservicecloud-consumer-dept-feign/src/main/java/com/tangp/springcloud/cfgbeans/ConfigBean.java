package com.tangp.springcloud.cfgbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class ConfigBean
{
//    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemplate()
    {
         return new RestTemplate();
    }
    
    @Bean
    public IRule iRule() {
    	return new RandomRule();
    }
}