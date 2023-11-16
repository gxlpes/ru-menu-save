package com.ru.menu.save;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ru.menu.save.config.MySecretsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Map;
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
    public Function<Map<String, Object>, Object> saveMenu() {
        return input -> {
            try {
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> payload = (Map<String, Object>) input.get("responsePayload");
                System.out.println("Received in the service method " + payload);
                RuMenuDto ruMenuDto = mapper.convertValue(payload, RuMenuDto.class);
                return ruMenuService.saveRuMenu( ruMenuDto);
            } catch (Exception e) {
                e.printStackTrace();
                return "Error: " + e.getMessage();
            }
        };
    }
}
