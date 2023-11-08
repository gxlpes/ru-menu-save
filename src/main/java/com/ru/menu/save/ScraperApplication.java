package com.ru.menu.save;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.function.Function;

@SpringBootApplication
@ComponentScan(basePackages = "com.ru.menu.save")
public class ScraperApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScraperApplication.class, args);
    }

    private final RuMenuService ruMenuService;

    public ScraperApplication(RuMenuService ruMenuService) {
        this.ruMenuService = ruMenuService;
    }

    @Bean
    public Function<RuMenuDto, Object> saveMenu() {
        return input -> {
            try {
                System.out.println(input);
                return ruMenuService.saveRuMenu(input);
            } catch (Exception e) {
                e.printStackTrace();
                return "Error: " + e.getMessage();
            }
        };
    }
}
