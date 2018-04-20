package jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

@ManagedBean 
public class AddBean {
    private int first, second, result;

    public void add(ActionEvent evt) {
    	result= first + second;
    }
	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
   
	
}
