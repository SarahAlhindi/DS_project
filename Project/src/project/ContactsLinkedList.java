package project;

public class ContactsLinkedList {

	private Node<Contact> head;
	private Node<Contact> current;
	
	
	public ContactsLinkedList() {
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
        
   public Contact retrieve () {
            return current.data;
        }
        
   public void update (Contact val) {
            current.data = val;
        }
        
	
	
   public void insert(Contact contact) {
	   Node<Contact> tmp;
		if (empty()) {
		current = head = new Node<Contact> (contact);
		}
		else {
		tmp = current.next;
		current.next = new Node<Contact> (contact);
		current = current.next;
		current.next = tmp;
		}

	}//end insert method
	
		
   
	
} // end class
