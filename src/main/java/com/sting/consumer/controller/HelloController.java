package com.sting.consumer.controller;

import com.sting.consumer.remoteService.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {

    @Autowired
    HelloRemote helloRemote;

    @Autowired
    private LoadBalancerClient client;

//    @Autowired
//    private RestTemplate restTemplate;

    @GetMapping("/")
    public String hello(@RequestParam String name){
        name += "!";
//        ServiceInstance instance = client.choose("EUREKA-PRODUCER");
//
//        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/hello/?name=" + name;
//        System.out.println(url);
//        String url = "http://EUREKA-PRODUCER/hello/?name=" + name;
//        System.out.println(url);
//        return restTemplate.getForObject(url,String.class);
        return helloRemote.hello(name);
    }
}
