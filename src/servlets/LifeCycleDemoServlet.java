package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LifeCycleDemoServlet extends HttpServlet {
	private int counter = 0;
	private String title;
    public LifeCycleDemoServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
		title = config.getInitParameter("title");
	}

	public void destroy() {
		System.out.println("destroy()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		counter ++;
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println(String.format("<h2>%d Count  of %s</h2>",counter,title));
		
		//  String title = getServletConfig().getInitParameter("title");

	}

}
