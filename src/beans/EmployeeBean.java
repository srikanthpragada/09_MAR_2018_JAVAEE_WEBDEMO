package beans;

import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class EmployeeBean {

	private int id, salary;
	private String name, job;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		// get details of employee with the given id
		try (CachedRowSet rs = new OracleCachedRowSet()) {
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from employees where employee_id = ?");
			rs.setInt(1, id);
			rs.execute();
			if (rs.next())  {
				name = rs.getString("first_name");
				salary = rs.getInt("salary");
				job = rs.getString("job_id");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
