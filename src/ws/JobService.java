package ws;

import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.sql.rowset.CachedRowSet;

@WebService
public class JobService {

	@WebMethod
	public Job[] getJobs() {
		try {
			CachedRowSet rs = new oracle.jdbc.rowset.OracleCachedRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from jobs");
			rs.execute();

			ArrayList<Job> jobs = new ArrayList<>();
			while (rs.next()) {
				Job j = new Job();
				j.setId(rs.getString("job_id"));
				j.setTitle(rs.getString("job_title"));
				jobs.add(j);
			}

			rs.close();

			// Convert ArrayList to Array
			Job[] jobsArray = new Job[jobs.size()];
			jobs.toArray(jobsArray);
			return jobsArray;

		} catch (Exception ex) {
			System.out.println("Error : " + ex);
			return null;
		}

	}

	@WebMethod
	public Job getJob(String id) {
		try {
			CachedRowSet rs = new oracle.jdbc.rowset.OracleCachedRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from jobs where upper(job_id) = ?");
			rs.setString(1, id.toUpperCase());
			rs.execute();

			if (rs.next()) {
				Job j = new Job();
				j.setId(rs.getString("job_id"));
				j.setTitle(rs.getString("job_title"));
				return j;
			} else
				return null;

		} catch (Exception ex) {
			System.out.println("Error : " + ex);
			return null;
		}
	}
	
	public boolean addJob(Job job) {
		return true; 
	}
}
