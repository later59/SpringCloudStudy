package com.rock.controller;

import com.sun.istack.internal.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {


    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    private static final Logger log = Logger.getLogger(PaymentController.class);

    @GetMapping("/zk")
    public String getDiscovery() {

        return "springCloud with zookeeper：" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
