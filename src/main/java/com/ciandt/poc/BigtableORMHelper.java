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
 * Created by lucasarruda on 8/11/16
 * and by famaral on 8/17/16.
 */
public class BigtableORMHelper<T> {

	private static final Logger log = Logger.getLogger(BigtableHelper.class.getName());

	private static String PROJECT_ID = "googl-cit-gcp";

	private static String INSTANCE_ID = "poc-study";

	private HBaseConnection hBaseConnection;

	private Dao<T> dao;

	public BigtableORMHelper(Class<T> clazz) {
		try {
			this.hBaseConnection = new HBaseConnection(
					BigtableConfiguration.connect(PROJECT_ID, INSTANCE_ID));
			this.dao = new DaoImpl<T>(clazz, hBaseConnection);
		} catch (IOException e) {
			log.severe("Connection to BigTable failed.");
			e.printStackTrace();
			// Deal with it...
		} catch (HBaseOrmException e) {
			// TODO Auto-generated catch block
			log.severe("Dao Creation failed.");
			e.printStackTrace();
		}
	}

	public String createTable() {
		try {
			dao.createTableIfNotExist();
		} catch (IOException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return "Table created successfully!";
	}

	public String update(T t){
		try {
			dao.insert(t);
			return "";
		} catch (HBaseOrmException e) {
			e.printStackTrace();
			return e.toString();
		}
	}

	public String insert(T t){

		try {
			dao.update(t);
			return "";
		} catch (HBaseOrmException e) {
			e.printStackTrace();
			return e.toString();
		}
	}

	public String getRowByKey(String key) {
		try {
			T queryWithFilter = dao.queryById(new StringValue(key));
			return queryWithFilter.toString();
		} catch (HBaseOrmException e) {
			e.printStackTrace();
			return e.toString();
		}
	}
	
	public static void main(String[] args) {
		new BigtableORMHelper<EntityTable>(EntityTable.class).createTable();
	}
}
