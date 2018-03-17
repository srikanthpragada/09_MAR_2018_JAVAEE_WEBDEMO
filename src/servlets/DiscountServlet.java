package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/discount")
public class DiscountServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Read data from client
		double amount = Double.parseDouble(request.getParameter("amount"));
		double rate = Double.parseDouble(request.getParameter("disrate"));
		double discount = amount * rate / 100;

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.append(String.format("<h1>Discount = %8.2f</h1>", discount));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
