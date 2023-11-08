package com.ru.menu.save;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class RuMenuService {
    private final RuMenuRepository ruMenuRepository;

    public RuMenuService(RuMenuRepository ruMenuRepository) {
        this.ruMenuRepository = ruMenuRepository;
    }

    public RuMenuDto saveRuMenu(RuMenuDto ruMenuDto) {
        ruMenuDto.setSortId(ZonedDateTime.parse(ruMenuDto.getDate()).toLocalDate().toString() + "-" + ruMenuDto.getRuCode());

        DynamoDBMapperConfig mapperConfig = DynamoDBMapperConfig.builder()
                .withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement(ruMenuDto.getRuCode()))
                .build();

        return ruMenuRepository.save(ruMenuDto, mapperConfig);
    }
}
