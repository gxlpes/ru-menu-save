package com.ru.menu.save;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuMenuDto {

    public RuMenuDto() {
        this.served = new ArrayList<>();
        this.meals = new HashMap<>();
    }

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String menuId;

    @DynamoDBRangeKey
    private String sortId;

    @DynamoDBAttribute
    private String ruCode;

    @DynamoDBAttribute
    private String date;

    @DynamoDBAttribute
    private List<String> served;

    @DynamoDBAttribute
    private Map<String, List<MealOption>> meals;

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getRuCode() {
        return ruCode;
    }

    public void setRuCode(String ruCode) {
        this.ruCode = ruCode;
    }

    public List<String> getServed() {
        return served;
    }

    public void setServed(List<String> served) {
        this.served = served;
    }

    public void addServed(String meal) {
        served.add(meal);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, List<MealOption>> getMeals() {
        return meals;
    }

    public void setMeals(Map<String, List<MealOption>> meals) {
        this.meals = meals;
    }
}