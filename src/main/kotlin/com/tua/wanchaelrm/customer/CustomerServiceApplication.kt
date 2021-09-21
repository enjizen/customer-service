package com.tua.wanchaelrm.customer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
class CustomerServiceApplication

fun main(args: Array<String>) {
	runApplication<CustomerServiceApplication>(*args)
}
