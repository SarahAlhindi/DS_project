
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

	public void setData(T data){
            this.data=data;
        }
        public void setNext( EventNode next){
            this.next=next;
        }
        
        public T getData(){
            return data;
        }
        
        public EventNode getNext(){
            return next;
        }
        

}
