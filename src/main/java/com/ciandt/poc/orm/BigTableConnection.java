package com.ciandt.poc.orm;

import com.google.cloud.bigtable.hbase.BigtableConfiguration;
import com.wlu.orm.hbase.connection.HBaseConnection;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;

/**
 * Created by lucasarruda on 8/11/16.
 */
public class BigTableConnection extends HBaseConnection {

    private static String PROJECT_ID = "googl-cit-gcp";
    private static String INSTANCE_ID = "poc-study";

    private static Connection connection;
    private static Admin admin;

    public BigTableConnection() throws IOException {
        this.connection = BigtableConfiguration.connect(PROJECT_ID, INSTANCE_ID);
        this.admin = connection.getAdmin();
    }

}
