package com.ezgroceries.shoppinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EzGroceriesShippingListApplication {

    public static void main(String[] args) {
        SpringApplication.run(EzGroceriesShippingListApplication.class, args);
    }

}
