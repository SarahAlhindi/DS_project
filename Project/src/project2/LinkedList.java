package project2;

import java.lang.reflect.Field;





public class LinkedList<T extends Comparable<T>> {

	private Node<T> head;
	private Node<T> current;
	
	
	public LinkedList() {
		head=null;
		current=null;
	}
	
	public boolean empty () {
            return head == null; 
        }
        
   public boolean last () { 
            return current.next == null;
        }
        
   public boolean full () {
            return false;
        }
        
   public void findFirst () {
            current = head;
        }
	
	public void findNext () {
            current = current.next;
        }
        
   public T retrieve () {
            return current.data;
        }
        
   public void update (T val) {
            current.data = val;
        }
        
	
	
   public boolean insert(T val) {
		

		
		
		
		
		
		
		Node<T> tmp = new Node<T>(val);

		
		

		if(empty() || val.compareTo(head.data)<=0 ) {
			tmp.next=head;
			head=tmp;
		}//end if

		else {
			Node<T> p = head;
			Node<T> q = null;


			while((p != null) && (val.compareTo(p.data)>0) ) {

				q = p;
				p = p.next;
			}
			tmp.next = p;
			q.next = tmp;


		}//else
		current=tmp;

		
		return true;

	}//end insert method
	
		
   

   
   public void remove () {
            if (current == head) {
                head = head.next; 
            }
            else {
                Node<T> tmp = head;
                while (tmp.next != current)
                    tmp = tmp.next;
                
                tmp.next = current.next;
            }
            
            if (current.next == null)
                current = head;
            else 
                current = current.next; 
        } // end 
   
   
   
   public LinkedList<T> search( String criteria , Object val) {
		
		
		if(empty())
			return null;


		LinkedList<T> resultList=new LinkedList<T>();

		findFirst();
		while(current!=null) {
			
			
			
			Field attribute = null;
			try {
				attribute = current.data.getClass().getDeclaredField(criteria);
				attribute.setAccessible(true);
				if(attribute.get(current.data).equals(val))
				resultList.insert(current.data);
				
			
				
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			
			
			if(!last()) 
			findNext();
		
		else 
			break;
			
		}//end while
		
		return resultList;
		
		
	}//search2

	
} // end class
