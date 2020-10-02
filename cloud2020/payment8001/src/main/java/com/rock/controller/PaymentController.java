package com.rock.controller;

import com.rock.payment.entities.CommonResult;
import com.rock.payment.entities.Payment;
import com.rock.service.PaymentService;
import com.sun.istack.internal.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    private static final Logger log = Logger.getLogger(PaymentController.class);

    @PostMapping("/add")
    public CommonResult<Integer> add(@RequestBody Payment payment) {
        int result = paymentService.add(payment);
        log.info("支付插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功，端口为：" + serverPort, result);
        } else {
            return new CommonResult(500, "插入数据库失败，端口为：" + serverPort);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("查询结果：" + result);
        if (result != null) {
            return new CommonResult(200, "查询成功，端口为：" + serverPort, result);
        } else {
            return new CommonResult(500, "没有查询到该记录，端口为：" + serverPort);
        }
    }

    @GetMapping("/getDiscovery")
    public Object getDiscovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("server:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("instance:" + instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
