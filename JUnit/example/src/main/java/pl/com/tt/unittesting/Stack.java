package pl.com.tt.unittesting;

public interface Stack {

	public class StackOverflow extends Exception {
		private static final long serialVersionUID = 2890383968559680079L;
	}

	public void push(Object object) throws StackOverflow;

	public Object pop();

}
