
package project2;


public class Node<T> {
   
	public T data;
	public Node<T> next;
   
//constructors
	public Node () {
		data = null;
		next = null;
	}

	public Node (T val) {
		data = val;
		next = null;
	}

//setters and getters
	public void setData(T data){
            this.data=data;
        }
        public void setNext( Node<T> next){
            this.next=next;
        }
        
        public T getData(){
            return data;
        }
        
        public Node<T> getNext(){
            return next;
        }
        

}
