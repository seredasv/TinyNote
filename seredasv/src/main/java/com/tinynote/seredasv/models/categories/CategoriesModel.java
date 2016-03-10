package com.tinynote.seredasv.models.categories;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class CategoriesModel extends RealmObject {
    @PrimaryKey
    private int id;

    @Index
    @Required
    private String name;

    private String color;

    public CategoriesModel() {
    }

    public CategoriesModel(int id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
