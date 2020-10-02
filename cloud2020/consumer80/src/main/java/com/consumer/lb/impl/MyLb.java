package com.consumer.lb.impl;

import com.consumer.lb.MyLoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLb implements MyLoadBalancer {

    private AtomicInteger nextServerCyclicCounter = new AtomicInteger(0);

    public final int getAndIncrement(){
         
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        return null;
    }
}
