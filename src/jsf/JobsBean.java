package jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

@ManagedBean
public class JobsBean {

	public RowSet getJobs() {
		try {
			CachedRowSet rs = new OracleCachedRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from jobs");
			rs.execute();
			return rs;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	
	public List<Job> getJobObjects() {
		try {
			ArrayList<Job> jobs = new ArrayList<>();
			CachedRowSet rs = new OracleCachedRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from jobs");
			rs.execute();
			while(rs.next()) {
				Job j = new Job();
				j.setId( rs.getString("job_id"));
				j.setTitle( rs.getString("job_title"));
				j.setMin( rs.getString("min_salary"));
				j.setMax( rs.getString("max_salary"));
				jobs.add(j);
			}
			return jobs;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}
