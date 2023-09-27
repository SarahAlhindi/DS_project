
package phonebook;


public class EventNode<T> {
   
	public T data;
	public EventNode<T> next;

	public EventNode () {
		data = null;
		next = null;
	}

	public EventNode (T val) {
		data = val;
		next = null;
	}
        

}
