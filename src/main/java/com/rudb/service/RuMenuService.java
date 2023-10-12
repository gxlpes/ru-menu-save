package com.rudb.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.rudb.entity.response.RuMenuDto;
import com.rudb.repository.RuMenuRepository;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class RuMenuService {

    private final RuMenuRepository ruMenuRepository;
    private final DynamoDBMapper dynamoDBMapper;

    public RuMenuService(RuMenuRepository ruMenuRepository, DynamoDBMapper dynamoDBMapper) {
        this.ruMenuRepository = ruMenuRepository;
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public RuMenuDto saveRuMenu(RuMenuDto ruMenuDto) {
        ruMenuDto.setSortId(ZonedDateTime.parse(ruMenuDto.getDate()).toLocalDate().toString() + "-" + ruMenuDto.getRuCode());

        DynamoDBMapperConfig mapperConfig = DynamoDBMapperConfig.builder()
                .withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement(ruMenuDto.getRuCode()))
                .build();

        return ruMenuRepository.save(ruMenuDto, mapperConfig);
    }
}
