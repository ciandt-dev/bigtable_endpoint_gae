package com.ciandt.poc;

import java.io.IOException;
import java.util.logging.Logger;

import com.ciandt.poc.entities.EntityTable;
import com.google.cloud.bigtable.hbase.BigtableConfiguration;
import com.wlu.orm.hbase.connection.HBaseConnection;
import com.wlu.orm.hbase.dao.Dao;
import com.wlu.orm.hbase.dao.DaoImpl;
import com.wlu.orm.hbase.exceptions.HBaseOrmException;
import com.wlu.orm.hbase.schema.value.StringValue;

/**
 * Created by lucasarruda on 8/11/16.
 * Created by famaral on 8/17/16.
 */
public class BigtableORMHelper {

	private static final Logger log = Logger.getLogger(BigtableHelper.class.getName());
	private static String PROJECT_ID = "googl-cit-gcp";
	private static String INSTANCE_ID = "poc-study";
	private HBaseConnection hBaseConnection;

	public BigtableORMHelper() {
		try {
			this.hBaseConnection = new HBaseConnection(
					BigtableConfiguration.connect(PROJECT_ID, INSTANCE_ID));//new BigTableConnection();
		}
		catch (IOException e) {
			log.severe("Connection to BigTable failed.");
			// Deal with it...
		}
	}

	public String createTable() {
		try {
			Dao<EntityTable> dao = new DaoImpl<EntityTable>(EntityTable.class, hBaseConnection);

			dao.createTableIfNotExist();
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
		return "Table created successfully!";
	}

	public String update(EntityTable entityTable){

		try {
			Dao<EntityTable> dao = new DaoImpl<EntityTable>(EntityTable.class, hBaseConnection);
			dao.insert(entityTable);
			return "";
		} catch (HBaseOrmException e) {
			e.printStackTrace();
			return e.toString();
		}
	}

	public String insert(EntityTable entityTable){

		try {
			Dao<EntityTable> dao = new DaoImpl<EntityTable>(EntityTable.class, hBaseConnection);
			dao.update(entityTable);
			return "";
		} catch (HBaseOrmException e) {
			e.printStackTrace();
			return e.toString();
		}
	}
	
	public String getRowByKey(String key) {
		try {
			Dao<EntityTable> dao = new DaoImpl<EntityTable>(EntityTable.class, hBaseConnection);
			EntityTable queryWithFilter = dao.queryById(new StringValue(key));
			return queryWithFilter.toString();
		} catch (HBaseOrmException e) {
			e.printStackTrace();
			return e.toString();
		}
	}
}
