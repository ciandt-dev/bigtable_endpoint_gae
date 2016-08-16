package com.ciandt.poc;

import java.util.LinkedHashMap;
import java.util.List;

import com.ciandt.poc.beans.Response;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiClass;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.google.appengine.repackaged.com.google.gson.internal.LinkedTreeMap;

@Api(name = "poc", version = "v1", clientIds = { Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID })
@ApiClass(resource = "sample")
public class BigtableAPI {

//	private static final Logger log = Logger.getLogger(BigtableAPI.class.getName());

	

	@ApiMethod(httpMethod = HttpMethod.POST, path = "sample/create")
	public Object createTable(@Nullable @Named("tableName") String tableName,
			@Nullable LinkedTreeMap<String, Object> column) {

		return new Response(new BigtableHelper().createTable(tableName, column));
	}
	
	@ApiMethod(httpMethod = HttpMethod.POST, path = "sample/upInsert")
	public Object upInsertData(@Nullable @Named("tableName") String tableName,
			@Nullable LinkedTreeMap<String, Object> column) {

		return new Response(new BigtableHelper().upInsertData(tableName, column));
	}
	
	@ApiMethod(httpMethod = HttpMethod.POST, path = "sample/delete")
	public Object deleteTable(@Nullable @Named("tableName") String tableName) {

		return new Response(new BigtableHelper().deleteTable(tableName));
	}
	
	@ApiMethod(httpMethod = HttpMethod.POST, path = "sample/allTask")
	public Object allTask() {

		return new Response(new BigtableHelper().allTasksBigtable());
	}

	@ApiMethod(httpMethod = HttpMethod.POST, path = "sample/update")
	public Object updatateTable(@Nullable @Named("tableName") String tableName,
			@Nullable LinkedHashMap<String, Object> column) {

		return new Response("Hello world");
	}

	@ApiMethod(httpMethod = HttpMethod.GET, path = "sample/findAll")
	public List<String> findAllKeys(@Nullable @Named("table") String table) {
		return new BigtableHelper().findAllKey(table);
	}

	@ApiMethod(httpMethod = HttpMethod.GET, path = "sample/findByKey")
	public Response findByKey(@Nullable @Named("name") String name) {
		return new Response("Hello " + (name != null ? name : "world"));
	}

	// ORM methods:

	@ApiMethod(httpMethod = HttpMethod.POST, path = "orm/createTable")
	public Response createTableWithORM(@Nullable @Named("tableName") String tableName) {
		return new Response(new BigtableORMHelper().createTable());
	}
	
	@ApiMethod(httpMethod = HttpMethod.GET, path = "appDevice/findAll")
	public List<String> findAllKeysAppDevice(@Nullable @Named("table") String table) {
		return new AppDeviceHelper().findAllKey(table);
	}
	
	@ApiMethod(httpMethod = HttpMethod.GET, path = "appDevice/findByKey")
	public String findByKeyAppDevice(@Nullable @Named("name") String name) {
		return new AppDeviceHelper().findByKey(name);
	}

}
