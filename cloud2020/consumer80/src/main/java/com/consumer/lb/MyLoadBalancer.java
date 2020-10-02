package com.consumer.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 手写轮询
 */
public interface MyLoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
