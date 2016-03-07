package com.tinynote.seredasv.models.notes;

import com.tinynote.seredasv.models.categories.CategoriesModel;
import com.tinynote.seredasv.models.locations.LocationsModel;
import com.tinynote.seredasv.models.tags.TagsModel;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

import java.util.Date;

public class NotesModel extends RealmObject {
    @PrimaryKey
    private int id;

    @Index
    private String title;

    private String content;
    private Date date;
    private LocationsModel location;
    private CategoriesModel category;

    private RealmList<TagsModel> tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocationsModel getLocation() {
        return location;
    }

    public void setLocation(LocationsModel location) {
        this.location = location;
    }

    public RealmList<TagsModel> getTags() {
        return tags;
    }

    public void setTags(RealmList<TagsModel> tags) {
        this.tags = tags;
    }

    public CategoriesModel getCategory() {
        return category;
    }

    public void setCategory(CategoriesModel category) {
        this.category = category;
    }
}
