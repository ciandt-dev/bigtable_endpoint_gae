package com.ciandt.poc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ciandt.poc.BigtableORMHelper;
import com.ciandt.poc.entities.AppDevice;
import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.internal.LinkedTreeMap;
import com.google.common.reflect.TypeToken;
import com.wlu.orm.hbase.exceptions.HBaseOrmException;

/**
 * Created by famaral on 8/15/16.
 */
@WebServlet(name = "orm", urlPatterns = {"/orm/appdevice"} )
public class BigTableORMServlet<T> extends HttpServlet {

	private static final long serialVersionUID = 6253116304248759593L;

	/**
	 * Servlet responsible to get a table
	 * curl 'http://localhost:8080/orm/appdevice?rowkey=1234' \
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		if(req.getRequestURI().equals("/favicon.ico"))
			return;
		String pathInfo = req.getPathInfo();
		String rowkey = pathInfo.split("/")[1];
		resp.setContentType("text/plain");
		PrintWriter pw = resp.getWriter();
		String row = "";
		try {
			row = new BigtableORMHelper<AppDevice>(AppDevice.class).getRowByKey(rowkey);
			pw.println("Row found: \n  " + row );
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("Error trying to getRowByKey" );
		}
		pw.close();
	}

	/**
	 *  Servlet responsible to create a new table on BigTable
	 *  usage:
	 *  curl 'http://localhost:8080/bigtable?tablename=mytable' \
	 *  -X POST -H 'Content-Type: application/json' \
	 *   --data-binary $"{'row_key':'mykey','field1':'value1'}"
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getRequestURI().equals("/favicon.ico"))
			return;
		String body = req.getReader().lines()
				.reduce("", (accumulator, actual) -> accumulator + actual);
		LinkedTreeMap<String, Object> list = new Gson().fromJson(
				body, new TypeToken<LinkedTreeMap<String, Object>>() {}.getType());
		resp.setContentType("text/plain");
		PrintWriter pw = resp.getWriter();
		AppDevice appDevice = new AppDevice();
		//TODO Add fields from appdevice post body
		try {
			String result = new BigtableORMHelper<AppDevice>(AppDevice.class).insert(appDevice);
			pw.println("Inserted: " + result);
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("Error trying to insert" );
		}
		pw.close();
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getRequestURI().equals("/favicon.ico"))
			return;
		String tableName = req.getParameter("tablename");
		String body = req.getReader().lines()
				.reduce("", (accumulator, actual) -> accumulator + actual);
		LinkedTreeMap<String, Object> list = new Gson().fromJson(
				body, new TypeToken<LinkedTreeMap<String, Object>>() {}.getType());
		resp.setContentType("text/plain");
		PrintWriter pw = resp.getWriter();
		AppDevice appDevice = new AppDevice();
		//TODO Add fields from appdevice post body
		try {
			String result = new BigtableORMHelper<AppDevice>(AppDevice.class).update(appDevice);
			pw.println("Updated: " + result);
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("Error trying to update" );
		}
		pw.close();
	}
}
