package com.pordiva.esraeken.haberler.model;

/**
 * Created by esraeken on 23/09/16.
 */
public class category
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

    public String id;
    public String name;
    public String alias;
}

