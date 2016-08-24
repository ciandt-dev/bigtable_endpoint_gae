package com.ciandt.poc.orm;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.BufferedMutator;
import org.apache.hadoop.hbase.client.BufferedMutatorParams;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.RetriesExhaustedWithDetailsException;

import com.ciandt.poc.orm.BigTableConnectionHbase;
import com.wlu.orm.hbase.exceptions.HBaseOrmException;
import com.wlu.orm.hbase.schema.DataMapper;
import com.wlu.orm.hbase.schema.DataMapperFacory;
import com.wlu.orm.hbase.schema.FamilytoQualifersAndValues;
import com.wlu.orm.hbase.schema.value.Value;
import com.wlu.orm.hbase.schema.value.ValueFactory;
import com.wlu.orm.hbase.util.util;

/**
 * Created by lucasarruda on 8/11/16
 * and by famaral on 8/17/16.
 */
public class BigtableORMMutatorHelper<T> extends BigTableConnectionHbase implements Closeable{

	private static final Logger log = Logger.getLogger(BigtableORMMutatorHelper.class.getName());

	private BufferedMutator bufferedMutator;

	private DataMapperFacory<T> dataMapperFactory;

	private BufferedMutatorParams params;
			
	public BigtableORMMutatorHelper(Class<T> clazz) throws Exception {
		super();
		try {
			params = new BufferedMutatorParams(
					TableName.valueOf(clazz.getSimpleName())).listener(listener);
			this.bufferedMutator = this.hBaseConnection.getConnection()
					.getBufferedMutator(params);
			 dataMapperFactory = new DataMapperFacory<T>(clazz);
		} catch (Exception e) {
			// Deal with it...
			log.severe("Connection to BigTable failed.");
			throw e;
		}
	}

	/** a callback invoked when an asynchronous write fails. */ 
	final BufferedMutator.ExceptionListener listener = new BufferedMutator.ExceptionListener() { 
		@Override 
		public void onException(RetriesExhaustedWithDetailsException e, BufferedMutator mutator) { 
			for (int i = 0; i < e.getNumExceptions(); i++) { 
				log.info("Failed to sent put " + e.getRow(i) + "."); 
				e.printStackTrace();
			} 
		} 
	};

	 

	public void mutate(T obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, HBaseOrmException, IOException {
		DataMapper<T> dataMapper = dataMapperFactory.Create(obj);
		Value row = ValueFactory.Create(util.GetFromField(obj, dataMapper.rowkeyField));
		Put put = new Put(row.toBytes());
        Map<Field, FamilytoQualifersAndValues> dataFields = dataMapper.getDatafieldsToFamilyQualifierValue();
		for (Field field : dataFields.keySet()) {
			dataFields.get(field).AddToPut(put);
        }
		bufferedMutator.mutate(put);
	}

	@Override
	public void close() throws IOException {
		bufferedMutator.close();
		super.close(); //this.hBaseConnection.getConnection().close();
	}

}
