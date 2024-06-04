package com.ivs.dbadminsuite.dbvisualizer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ForeignKeyData {
    private final StringProperty tableName;
    private final StringProperty foreignKey;

    public ForeignKeyData(String tableName, String foreignKey) {
        this.tableName = new SimpleStringProperty(tableName);
        this.foreignKey = new SimpleStringProperty(foreignKey);
    }

    public StringProperty tableNameProperty() {
        return tableName;
    }

    public StringProperty foreignKeyProperty() {
        return foreignKey;
    }

    public String getTableName() {
        return tableName.get();
    }

    public String getForeignKey() {
        return foreignKey.get();
    }
}
