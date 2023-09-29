package com.rudb.entity.response;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.rudb.entity.meal.Meal;
import com.rudb.entity.ru.Ru;

import java.util.ArrayList;
import java.util.List;

@DynamoDBTable(tableName = "ruMenus")
public class RuMenuDto {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String ruMenuId;

    @DynamoDBAttribute
    private Ru ru;

    @DynamoDBAttribute
    private String date;

    @DynamoDBAttribute
    private List<String> served;

    @DynamoDBAttribute
    private List<Meal> meals;

    @DynamoDBRangeKey
    private String sortId;

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public RuMenuDto() {
        this.served = new ArrayList<>();
        this.meals = new ArrayList<>();
    }

    public String getRuMenuId() {
        return ruMenuId;
    }

    public void setRuMenuId(String ruMenuId) {
        this.ruMenuId = ruMenuId;
    }

    public Ru getRu() {
        return ru;
    }

    public void setRu(Ru ru) {
        this.ru = ru;
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

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

}