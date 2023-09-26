package project;

public class ContactsLinkedList {

	private Node<Contacts> head;
	private Node<Contacts> current;
	
	
	public ContactsLinkedList() {
		head=null;
		current=null;
	}
	
	
	public void insert(Contacts val) {
		Node<Contacts> tmp = new Node<Contacts>(val);

		//TODO choose between these two ways
		
		findFirst();
		
		//		while(current!=null) {
		//			if((val.getName()).equalsIgnoreCase(retrieve().getName()) || (val.getPhoneNumber()).equalsIgnoreCase(retrieve().getPhoneNumber()) ) {
		//				System.out.println("Already exists");
		//				return;
		//			}//if

		while(current!=null) {
			if(!(search(1,val.getName()).empty()) || !(search(2,val.getPhoneNumber()).empty()) ) {
				System.out.println("Contact already exists"); 
				return;
			}//if


			if(!last())
				findNext();
			else {
				System.out.println("else in insert");
				break;
				}
		}//while

		if(empty() || val.compareTo(head.data)<=0 ) {
			tmp.next=head;
			head=tmp;
		}//end if

		else {
			Node<Contacts> p = head;
			Node<Contacts> q = null;


			while((p != null) && (val.compareTo(p.data)>=0) ) {

				q = p;
				p = p.next;
			}
			tmp.next = p;
			q.next = tmp;


		}//else
		current=tmp;

	}//end insert method
	
	
	
public  ContactsLinkedList search( int criteria , String val) {
		
		if(empty())
			return null;


		ContactsLinkedList resultList=new ContactsLinkedList();

		findFirst();
		while(current!=null) {
			switch(criteria ) {

			case 1 :
				if(current.getData().getName().equalsIgnoreCase(val))
					resultList.insert(current.data);
				break;
			case 2 :
				if(current.getData().getPhoneNumber().equalsIgnoreCase(val))
					resultList.insert(current.data);
				break;
			case 3 :
				if(current.getData().getEmail().equalsIgnoreCase(val))
					resultList.insert(current.data);
				break;
			case 4 :
				if(current.getData().getAddress().equalsIgnoreCase(val))
					resultList.insert(current.data);
				break;
			case 5 :
				if(current.getData().getBirthday().equalsIgnoreCase(val))
					resultList.insert(current.data);
				break;

			}//end switch	
			if(!last()) 
				findNext();
			
			else 
				break;
				
				
		}//end while


		return resultList;
	}//end 
	
}
