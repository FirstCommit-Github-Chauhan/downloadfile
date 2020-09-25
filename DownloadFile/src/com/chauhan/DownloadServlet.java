package com.chauhan;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
		
		PrintWriter out = resp.getWriter();
		String filename = "hello.java";
		String filepath = "C:\\Users\\tunnu\\workspace\\";
		resp.setContentType("APPLICATION/OCTET-STREAM");
		resp.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");
		
		FileInputStream fileInputStream = new FileInputStream(filepath+filename);
		
		int i;
		while((i = fileInputStream.read())!=-1){
			out.write(i);
		}
		fileInputStream.close();
		out.close();
	}
}
