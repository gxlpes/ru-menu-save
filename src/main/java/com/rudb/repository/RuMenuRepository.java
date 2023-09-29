package com.rudb.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.rudb.entity.response.RuMenuDto;
import com.rudb.entity.ru.Ru;
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

    public RuMenuDto getMenuById(String ruMenuId) {
        return dynamoDBMapper.load(RuMenuDto.class, ruMenuId);
    }

    public String delete(String ruMenuId) {
        RuMenuDto emp = dynamoDBMapper.load(RuMenuDto.class, ruMenuId);
        dynamoDBMapper.delete(emp);
        return "Employee Deleted!";
    }

    public String update(String ruMenuId, RuMenuDto ruMenuDto) {
        dynamoDBMapper.save(ruMenuDto,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("ruMenuId",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(ruMenuId)
                                )));
        return ruMenuId;
    }
}