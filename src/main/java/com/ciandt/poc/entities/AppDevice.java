package com.ciandt.poc.entities;

import com.wlu.orm.hbase.annotation.DatabaseField;
import com.wlu.orm.hbase.annotation.DatabaseTable;

/**
 * Created by lucasarruda on 8/11/16.
 */
@DatabaseTable(tableName = "AppDevice")
public class AppDevice {
    // Make sure the object has an empty construction function with
    // no parameters and getter&setter functions for each member variable.
    @DatabaseField(id = true)
    private String rowKey;
    
    @DatabaseField(familyName = "family_name")
    private String name;
    
    @DatabaseField(familyName = "family_email")
    private String email;
    
    @DatabaseField(familyName = "family_ssn")
    private String ssn;

    public AppDevice() {
    }

}
