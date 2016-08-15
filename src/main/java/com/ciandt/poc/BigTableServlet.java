package com.ciandt.poc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.common.reflect.TypeToken;

/**
 * Created by famaral on 8/15/16.
 */
@WebServlet(name = "bigtable", urlPatterns = {"/bigtable"} )
public class BigTableServlet extends HttpServlet {

	private static final long serialVersionUID = 6253116304248759593L;

	/**
	 * Servlet responsible to get a table
	 * curl 'http://localhost:8080/bigtable?tablename=mytable' \
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		if(req.getRequestURI().equals("/favicon.ico"))
			return;
		String table = req.getParameter("tablename");

		resp.setContentType("text/plain");
		PrintWriter pw = resp.getWriter();
		pw.println("Keys found: \n  " + new BigtableHelper().findAllKey(table));
		pw.close();
	}

	/**
	 *  Servlet responsible to create a new table on BigTable
	 *  usage:
	 *  curl 'http://localhost:8080/bigtable?tablename=mytable' \
	 *  -X POST -H 'Content-Type: application/json' \
	 *   --data-binary $"{'row_key':'mykey','field1':'value1'}"
	 */
	@SuppressWarnings("serial")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getRequestURI().equals("/favicon.ico"))
			return;
		String tableName = req.getParameter("tablename");
		String body = req.getReader().lines()
				.reduce("", (accumulator, actual) -> accumulator + actual);
		LinkedHashMap<String, Object> list = new Gson().fromJson(
				body, new TypeToken<LinkedHashMap<String, Object>>() {}.getType());
		resp.setContentType("text/plain");
		PrintWriter pw = resp.getWriter();
		pw.println("Table created in " + new BigtableHelper().createTable(tableName, list));
		pw.close();
	}
}
