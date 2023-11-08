package com.ru.menu.save;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.util.ArrayList;
import java.util.List;

@DynamoDBDocument
public class MealOption {
    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private List<String> icons;

    public MealOption() {
        this.icons = new ArrayList<>(); // Initialize the icons list in the constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIcons() {
        return icons;
    }

    public void setIcons(List<String> icons) {
        this.icons = icons;
    }

    public void addIcon(String icon) {
        icons.add(icon);
    }
}
