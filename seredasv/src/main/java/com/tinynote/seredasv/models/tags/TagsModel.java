package com.tinynote.seredasv.models.tags;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class TagsModel extends RealmObject {
    @PrimaryKey
    private int id;

    @Index
    @Required
    private String name;

    public TagsModel() {
    }

    public TagsModel(int id, String name) {
        this.id = id;
        this.name = name;
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
}
