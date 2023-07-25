package com.baseddevs.ecommerce.runner;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class DataLoader {

    @Bean
    public CommandLineRunner initData() {
        return (args) -> {

        };
    }
}