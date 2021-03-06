package com.ciandt.poc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ciandt.poc.entities.AppDevice;
import com.ciandt.poc.orm.BigtableORMHelper;
import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.internal.LinkedTreeMap;
import com.google.common.reflect.TypeToken;

/**
 * Created by famaral on 8/15/16.
 */
@WebServlet(name = "orm", urlPatterns = {"/orm/appdevice"} )
public class BigTableORMServlet extends HttpServlet {

	private static final long serialVersionUID = 6253116304248759593L;

	/**
	 * Servlet responsible to get a table
	 * curl 'http://localhost:8080/orm/appdevice?rowkey=1234' \
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if(req.getRequestURI().equals("/favicon.ico"))
			return;
		String pathInfo = req.getParameter("rowkey");
		resp.setContentType("text/plain");
		PrintWriter pw = resp.getWriter();
		try(BigtableORMHelper<AppDevice> orm = 
				new BigtableORMHelper<AppDevice>(AppDevice.class)) {
			AppDevice row = orm.getRowByKey(pathInfo);
			pw.println("Row found: \n  " +  row);
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
		try(BigtableORMHelper<AppDevice> orm = 
				new BigtableORMHelper<AppDevice>(AppDevice.class)) {
			String result = orm.insert(appDevice);
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
		String body = req.getReader().lines()
				.reduce("", (accumulator, actual) -> accumulator + actual);
		LinkedTreeMap<String, Object> list = new Gson().fromJson(
				body, new TypeToken<LinkedTreeMap<String, Object>>() {}.getType());
		resp.setContentType("text/plain");
		PrintWriter pw = resp.getWriter();
		AppDevice appDevice = new AppDevice();
		//TODO Add fields from appdevice post body
		try(BigtableORMHelper<AppDevice> orm = 
				new BigtableORMHelper<AppDevice>(AppDevice.class)) {
			String result = orm.update(appDevice);
			pw.println("Updated: " + result);
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("Error trying to update" );
		}
		pw.close();
	}
}

