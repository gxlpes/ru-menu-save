package com.ru.menu.save;

import com.ru.menu.save.config.MySecretsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.function.Function;

@SpringBootApplication
@ComponentScan(basePackages = "com.ru.menu.save")
public class ScraperApplication {
    private final RuMenuService ruMenuService;

    public ScraperApplication(RuMenuService ruMenuService) {
        this.ruMenuService = ruMenuService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ScraperApplication.class, args);
    }

    @Bean
    public Function<RuMenuDto, Object> saveMenu() {
        return input -> {
            try {
                return ruMenuService.saveRuMenu(input);
            } catch (Exception e) {
                e.printStackTrace();
                return "Error: " + e.getMessage();
            }
        };
    }
}
