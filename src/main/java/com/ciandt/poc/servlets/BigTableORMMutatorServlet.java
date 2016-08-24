package com.ciandt.poc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hadoop.util.ToolRunner;

import com.ciandt.poc.orm.BufferedMutatorORM;

/**
 * Created by famaral on 8/24/16.
 */
@WebServlet(name = "orm-mutator", urlPatterns = {"/orm/job"} )
public class BigTableORMMutatorServlet extends HttpServlet {

	private static final long serialVersionUID = -8272810117084647513L;

	/**
	 *  Servlet responsible to create a new table on BigTable
	 *  usage:
	 *  curl 'http://localhost:8080/orm/appdevice/runjob' -X POST
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		try {
			ToolRunner.run(new BufferedMutatorORM(), null);
			pw.println("BufferedMutatorORM run sucessfully!");
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("BufferedMutatorORM error"+ e.getMessage());
		}
		pw.close();
	}
}
