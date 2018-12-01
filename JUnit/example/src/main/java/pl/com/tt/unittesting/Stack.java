package pl.com.tt.unittesting;

public interface Stack {

	public class StackOverflow extends Exception {
	}

	public void push(Object object) throws StackOverflow;

	public Object pop();
}
