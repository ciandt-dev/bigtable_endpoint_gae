package com.ciandt.poc.entities;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import com.wlu.orm.hbase.annotation.DatabaseField;
import com.wlu.orm.hbase.annotation.DatabaseTable;

/**
 * Created by lucasarruda on 8/11/16.
 */
@DatabaseTable()
public class EntityTable {
    // Make sure the object has an empty construction function with
    // no parameters and getter&setter functions for each member variable.

    @DatabaseField()
    private String name;
    @DatabaseField()
    private String email;
    @DatabaseField()
    private Long ssn;

    public EntityTable() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getSsn() {
        return ssn;
    }

    public void setSsn(Long ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Table schema: ...";
    }
}
