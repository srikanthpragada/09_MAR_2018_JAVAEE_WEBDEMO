package jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloBean {

	// Property message
	public String getMessage() {
		return "JSF Demo";
	}
}
