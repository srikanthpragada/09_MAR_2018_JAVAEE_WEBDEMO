package rest;

import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.sql.rowset.CachedRowSet;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import oracle.jdbc.rowset.OracleCachedRowSet;

@Path("/jobs")
public class JobsService {
	@GET
	public String getAllJobs() {
		try {
			CachedRowSet rs = new OracleCachedRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from jobs");
			rs.execute();

			JsonArrayBuilder jobs = Json.createArrayBuilder();
			while (rs.next()) {
				JsonObjectBuilder job = Json.createObjectBuilder();
				job.add("id", rs.getString("job_id"));
				job.add("title", rs.getString("job_title"));
				job.add("min", rs.getString("min_salary"));
				job.add("max", rs.getString("max_salary"));
				jobs.add(job.build());
			}
			rs.close();
			return jobs.build().toString();
		} catch (Exception ex) {
			throw new  InternalServerErrorException();
		}

	}
	
	@GET
	@Path("/{id}")
	public String getJob(@PathParam("id") String id) {
		try {
			CachedRowSet rs = new OracleCachedRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from jobs where job_id = ?");
			rs.setString(1, id);
			rs.execute();
			if (rs.next()) {
				JsonObjectBuilder job = Json.createObjectBuilder();
				job.add("id", rs.getString("job_id"));
				job.add("title", rs.getString("job_title"));
				job.add("min", rs.getString("min_salary"));
				job.add("max", rs.getString("max_salary"));
				return job.build().toString();
			}
			else
				throw new NotFoundException();
		} catch (SQLException ex) {
			throw new  InternalServerErrorException();
		}

	}

	@DELETE
	public void deleteJobs() {

	}

}
