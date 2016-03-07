package com.tinynote.seredasv.models.settings;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SettingsModel extends RealmObject {
    @PrimaryKey
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
