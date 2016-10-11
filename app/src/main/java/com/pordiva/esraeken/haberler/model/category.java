package com.pordiva.esraeken.haberler.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by esraeken on 23/09/16.
 */
public class category extends RealmObject
{
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @PrimaryKey
    public String id;
    public String name;
    public String alias;
}

