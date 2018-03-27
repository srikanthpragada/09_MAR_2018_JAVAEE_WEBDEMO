package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class Jobs2Handler extends SimpleTagSupport {
	private String title;
	private int salary=1000;
	
	// title attribute 
	public void setTitle(String title) {
		this.title = title;
	}
	// salary attribute 
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		try {
			OracleCachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs where upper(job_title) like ?  and ? between min_salary and max_salary");
   		    crs.setString(1, "%" + title.toUpperCase() + "%");
			crs.setInt(2, salary);
			crs.execute();

			out.println(
					"<table border='1' width='100%'><tr><th>Title</th><th>Min Salary</th><th>Max Salary</th></tr>");

			while (crs.next()) {
				out.println(String.format("<tr><td>%s</td><td>%d</td><td>%d</td></tr>",
						crs.getString("job_title"),
						crs.getInt("min_salary"), 
						crs.getInt("max_salary")));
			}
			
			out.println("</table>");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
