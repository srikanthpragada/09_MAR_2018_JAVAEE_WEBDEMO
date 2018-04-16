package jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

@ManagedBean
public class WishBean {
	private String name, message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void wish(ActionEvent evt) {
		message = "Welcomt " + name + " to JSF";
	}

}
