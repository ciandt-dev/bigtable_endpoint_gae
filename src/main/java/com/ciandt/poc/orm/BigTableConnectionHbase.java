package com.ciandt.poc.orm;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Logger;

import com.google.cloud.bigtable.hbase.BigtableConfiguration;
import com.wlu.orm.hbase.connection.HBaseConnection;

public class BigTableConnectionHbase implements Closeable {

	private static final Logger log = Logger.getLogger(BigTableConnectionHbase.class.getName());

	private static String PROJECT_ID = "leanplum-staging";

	private static String INSTANCE_ID = "cit-test";

	protected HBaseConnection hBaseConnection;

	public BigTableConnectionHbase() throws Exception {
		try {
			this.hBaseConnection = new HBaseConnection(
					BigtableConfiguration.connect(PROJECT_ID, INSTANCE_ID));
		} catch (Exception e) {
			// Deal with it...
			log.severe("Connection to BigTable failed.");
			throw e;
		}

	}

	@Override
	public void close() throws IOException {
		hBaseConnection.getConnection().close();		
	}
}
