package com.ru.menu.save;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import org.springframework.stereotype.Repository;

@Repository
public class RuMenuRepository {

    final DynamoDBMapper dynamoDBMapper;

    public RuMenuRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public RuMenuDto save(RuMenuDto ruMenuDto, DynamoDBMapperConfig mapperConfig) {
        dynamoDBMapper.save(ruMenuDto, mapperConfig);
        return ruMenuDto;
    }

}
