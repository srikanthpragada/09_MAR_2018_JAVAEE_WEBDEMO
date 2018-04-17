package jsf;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ManagedBean
public class UserBean {
	private String uname, password, message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Size(min=4, message = "Must be atleast of 4 chars")
	@Pattern( regexp="[a-zA-Z]+", message="Only letters are allowed")
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Size(min=6,message = "Must be atleast of 6 chars")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Action controller
	public String login() {
		if (uname.equals("admin") && password.equals("admin"))
			return "home"; // home.xhtml
		else {
			message = "Sorry! Invalid Login!";
			return "login";
		}

	}
}
