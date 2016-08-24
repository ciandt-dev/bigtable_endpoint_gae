package com.ciandt.poc.orm;

import java.io.Closeable;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

import com.ciandt.poc.entities.AppDevice;
import com.ciandt.poc.entities.AppDeviceLocaleInfo;
import com.ciandt.poc.entities.AppDeviceSessionData;
import com.ciandt.poc.entities.AppDeviceUserInfo;
import com.wlu.orm.hbase.dao.Dao;
import com.wlu.orm.hbase.dao.DaoImpl;
import com.wlu.orm.hbase.exceptions.HBaseOrmException;
import com.wlu.orm.hbase.schema.value.StringValue;

/**
 * Created by lucasarruda on 8/11/16
 * and by famaral on 8/17/16.
 */
public class BigtableORMHelper<T> extends BigTableConnectionHbase implements Closeable{

	private static final Logger log = Logger.getLogger(BigtableORMHelper.class.getName());

	protected Dao<T> dao;

	public BigtableORMHelper(Class<T> clazz) throws Exception {
		super();
		try {
			this.dao = new DaoImpl<T>(clazz, hBaseConnection);
		} catch (Exception e) {
			// Deal with it...
			log.severe("Connection to BigTable failed.");
			throw e;
		}
	}

	public String createTable() {
		try {
			dao.createTableIfNotExist();
			log.info("Talbe created or table already exists");
		} catch (IOException e) {
			log.severe("CreateTable failed.");
			e.printStackTrace();
			return e.getMessage();
		}
		return "Table created successfully!";
	}

	public String update(T t){
		try {
			dao.insert(t);
			log.info("Inserted successfuly");
			return "Inserted successfuly";
		} catch (HBaseOrmException e) {
			log.severe("CreateTable failed.");
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public String insert(T t){

		try {
			dao.update(t);
			log.info("Updated successfuly");
			return "Updated successfuly";
		} catch (HBaseOrmException e) {
			log.severe("Insert failed.");
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public T getRowByKey(String key) throws IOException {
		try {
			T queryWithFilter = dao.queryById(new StringValue(key));
			return queryWithFilter;
		} catch (HBaseOrmException e) {
			log.severe("GetRowByKey failed.");
			e.printStackTrace();
			throw new IOException(e);
		}
	}

	@Override
	public void close() throws IOException {
		this.hBaseConnection.getConnection().close();
	}

	public static void main(String[] args) throws Exception {
		try(BigtableORMHelper<AppDevice> orm = 
				new BigtableORMHelper<AppDevice>(AppDevice.class)){
			AppDevice app = new AppDevice();
			app.setApp("myid-0101010");
			app.setAnomaly(123123);
			app.setCreated(new Date());
			app.setToken("sometoken");
			app.setVersion(1);

			AppDeviceSessionData data = new AppDeviceSessionData();
			data.setCurrentSession("mysession0000000001");
			data.setSessionClosed(false);
			app.setData(data);

			AppDeviceLocaleInfo locale = new AppDeviceLocaleInfo();
			locale.setCity("SaoPaulo");
			locale.setCountry("BR");
			app.setLocaleInfo(locale);

			AppDeviceUserInfo info = new AppDeviceUserInfo();
			info.setUserId("myuserId");
			app.setUserInfo(info);

			orm.insert(app);
			System.exit(0);
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
