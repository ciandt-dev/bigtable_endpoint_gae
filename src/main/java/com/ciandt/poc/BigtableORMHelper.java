package com.ciandt.poc;

import com.ciandt.poc.entities.EntityTable;
import com.ciandt.poc.orm.BigTableConnection;
import com.wlu.orm.hbase.connection.HBaseConnection;
import com.wlu.orm.hbase.dao.DaoImpl;
import com.wlu.orm.hbase.dao.Dao;
import com.wlu.orm.hbase.exceptions.HBaseOrmException;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by lucasarruda on 8/11/16.
 */
public class BigtableORMHelper {

    private static final Logger log = Logger.getLogger(BigtableHelper.class.getName());
    private static HBaseConnection connection;

    public BigtableORMHelper() {
        try {
            this.connection = new BigTableConnection();
        }
        catch (IOException e) {
            log.severe("Connection to BigTable failed.");
            // Deal with it...
        }
    }

    public String createTable() throws HBaseOrmException, IOException {
        try {
            Dao<EntityTable> dao = new DaoImpl<EntityTable>(EntityTable.class, connection);
            dao.createTableIfNotExist();
        } catch (Exception e) {
            return e.toString();
        }
    }
}
