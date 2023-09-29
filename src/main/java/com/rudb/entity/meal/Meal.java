package com.rudb.entity.meal;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.util.ArrayList;
import java.util.List;

@DynamoDBDocument
public class Meal {
    @DynamoDBAttribute
    private String title;

    @DynamoDBAttribute
    private List<MealOption> options;

    public Meal() {
        this.options = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MealOption> getOptions() {
        return options;
    }

    public void setOptions(List<MealOption> options) {
        this.options = options;
    }

    public void addMealOption (MealOption mealOption) {
        options.add(mealOption);
    }

}
