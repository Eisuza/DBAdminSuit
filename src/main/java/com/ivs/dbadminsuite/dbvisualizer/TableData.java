package com.ivs.dbadminsuite.dbvisualizer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TableData {
    private final StringProperty tableName;
    private final StringProperty attributes;

    public TableData(String tableName, String attributes) {
        this.tableName = new SimpleStringProperty(tableName);
        this.attributes = new SimpleStringProperty(attributes);
    }

    public StringProperty tableNameProperty() {
        return tableName;
    }

    public StringProperty attributesProperty() {
        return attributes;
    }

    public String getTableName() {
        return tableName.get();
    }

    public String getAttributes() {
        return attributes.get();
    }
}

