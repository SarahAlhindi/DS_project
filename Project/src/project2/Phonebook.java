package project2;
import java.util.*;


public class Phonebook {
	
	public static Scanner input = new Scanner(System.in);
	private  LinkedList<Contact> contacts ;
	private  LinkedList<Event> events ;
	
	
	

//constructor
	public Phonebook(LinkedList<Contact> contacts, LinkedList<Event> events) {
		this.contacts = contacts;
		this.events = events;
	}
	
	
/**
 * This method adds a contact to the contacts LinkedList.
 * */

	public void addContact() {
   
//get contact info
		System.out.println("Enter the contact's name (FirstName LastName):");
		String contactName=input.nextLine();

		System.out.println("Enter the contact's phone number (05xxxxxxxx):");
		String contactPhone=input.nextLine();

		System.out.println("Enter the contact's email address(e.g. example@example.com):");
		String contactEmail=input.nextLine();

		System.out.println("Enter the contact's address :");
		String contactAddress=input.nextLine();

		System.out.println("Enter the contact's birthday (DD/MM/YYYY):");
		String contactDob=input.nextLine();

		System.out.println("Enter any notes for the contact:");
		String contactNotes=input.nextLine();



//create contact object
		Contact contact = new Contact(contactName, contactPhone, contactEmail, contactAddress, contactDob, contactNotes);


		
//if contact list is empty, insert directly//
		
		if(contacts.empty()) {
			if(contacts.insert(contact))
				System.out.println("Contact added successfully");
			
			return;
				
		}//end if
		
/////////////////////////////////////////////
		
		
		
//Check if contact exists

		contacts.findFirst();
		while(true) {
			if((contact.getName()).equalsIgnoreCase(contacts.retrieve().getName()) || (contact.getPhone_number()).equals(contacts.retrieve().getPhone_number()) ) {
				System.out.println("Contact already exists!");
				return;
			}//if

			if(!contacts.last())
				contacts.findNext();
			else {
				break;
			}//end else
			


		}//end while
		
////////////////////////////////////////////////
		
		
		
		
		if(contacts.insert(contact))
			System.out.println("Contact added successfully");

		
		



}//end addContact

/**
 * This method searches for contacts based on a criteria.
 * */
	
	
	public void searchContact()   {
		int choice=-1;
		String value=null;
		do {
			try {
				System.out.println("\n Enter search criteria:\r\n"
						+ "1. Name\r\n"
						+ "2. Phone Number\r\n"
						+ "3. Email Address\r\n"
						+ "4. Address\r\n"
						+ "5. Birthday");
				System.out.print("Enter your choice:");
				choice = input.nextInt();
				//		System.out.println();
				if(choice>5 || choice<1)
					throw new Exception() ;


				input.nextLine();
				
				switch(choice) {
				case 1: 
					System.out.print("Enter the contact's name:");
               break;
				case 2: 
					System.out.print("Enter the contact's phone number:");
               break;
				case 3: 
					System.out.print("Enter the contact's Email Address:");
               break;
				case 4: 
					System.out.print("Enter the contact's Address:");
               break;
				case 5: 
					System.out.print("Enter the contact's Birthday:");
               break;

				}//end switch
            
				value = input.nextLine();
				break;

			}//end try
			catch(Exception e) {
				input.nextLine();
				System.out.println("\n error in input. Please try again \n\n");
			}//end catch
			
		}//end do
		while(true);
		
		
		System.out.println();
		
		String criteria=null;
      
		switch(choice) {
		case 1:
			criteria="name";break;
		case 2:
			criteria="phone_number";break;
		case 3:
			criteria="email";break;
		case 4:
			criteria="address";break;
		case 5:
			criteria="birthday";break;
		
			
			
		}//switch
	
 
//search for contact
		LinkedList<Contact> resultList= contacts.search(criteria, value);
		
		
		
	 
		if(resultList==null || resultList.empty()) {
			System.out.println("No contact found");
			return;
		}//end if
		
		else {
			resultList.findFirst();

			while(!resultList.last()) {
				System.out.println(resultList.retrieve()+"\n\n");
				resultList.findNext();
			}//end while
			
			System.out.println(resultList.retrieve()); 
		}//end else
		
		
	}//end searchcontact method
   
   
	/**
	 *This method removes a contact and any associated events if any. 
	 * */
	
	public void deleteContact() {
		
		System.out.print("Enter the name of the contact:");
		String contactName=input.next();
		input.nextLine();
		
		if(contacts.empty()) {
			System.out.println("No such contact");
			return;
		}
		
		
		boolean found=false;

//find and delete the specified contact
		contacts.findFirst();
		while(!contacts.last())
			if(contacts.retrieve().getName().equalsIgnoreCase(contactName)) {
				contacts.remove();
				System.out.println("Contact deleted successfully");
				found=true;
				break;
				}//end if
		        else
				contacts.findNext();
		
		if(!found && contacts.retrieve().getName().equalsIgnoreCase(contactName)) {
			contacts.remove();
			System.out.println("Contact deleted successfully");
			found=true;
			}
		
		
// if the specified contact doesn't exist
		if(!found) {
			System.out.println("No contact with such name");
			return;
			}
		
		
// deleting events related to the contact deleted		
		if(events.empty())
			return;
		

		boolean eventRemoved=false;
		
		
		events.findFirst();
		while (true){
			eventRemoved=false;
			if(events.retrieve().getContact().getName().equalsIgnoreCase(contactName)) {
				
				if(events.last()) {
				events.remove();
				break;
				}//end if
				else
					events.remove();
				
				
				eventRemoved=true;
				}
			
			
			if(events.empty() || (events.last() && !eventRemoved)) // !eventRemoved is for the case when the last element is reached because the previous event was deleted
				
				break;
			
			else if(!eventRemoved)
				events.findNext();
			
			
		}//end while
			
	}//end deleteContact method
		
		
		
		
/**
 * This method schedules an event with a contact.
 * */
	public void ScheduleEvent() {
		
		System.out.print("Enter event title:");
		String eventTitle=input.nextLine();

		System.out.print("Enter Contact name:");
		String contactName=input.nextLine();

	
boolean found=false;
		Contact contact=null;
		contacts.findFirst();
		if(!contacts.empty()) {
		while (!contacts.last())
			if(contacts.retrieve().getName().equalsIgnoreCase(contactName)){
				contact=contacts.retrieve();
				found=true;
				break;
				}
		        else
				contacts.findNext();
		
//checking the last contact in list	
		if(!found && contacts.retrieve().getName().equalsIgnoreCase(contactName))
			contact=contacts.retrieve();
		
		}//end if not empty
		

		System.out.print("Enter event date (MM/DD/YYYY):");
		String eventDate=input.nextLine();
		
		System.out.print("Enter event time (HH:MM):");
		String eventTime=input.nextLine();

		System.out.print("Enter event location:");
		String eventLocation=input.nextLine();

		if(contact!=null){
		        Event event = new Event(eventTitle , eventDate, eventTime,eventLocation, contact);
		        
		        Event currentEvent;
		        
		        if(!events.empty()) {
			events.findFirst();
			while(!events.last()) {
				currentEvent=events.retrieve();
				if(currentEvent.getContact().getName().equalsIgnoreCase(contactName) && currentEvent.getTime().equals(event.getTime()) && currentEvent.getDate().equals(event.getDate())){
					System.out.println("Can't add event, there is a conflict");
					return;}
				
			        else
					events.findNext();
				
			}//end while
			
			
			currentEvent=events.retrieve();
			if(currentEvent.getContact().getName().equalsIgnoreCase(contactName) && currentEvent.getTime().equals(event.getTime()) && currentEvent.getDate().equals(event.getDate())){
				System.out.println("Can't add event, there is a conflict");
				return;}
			
		        }//end if events not empty
			
			
			events.insert(event);
			System.out.println("\nEvent Added successfuly");
			




			
		}// end if contact !=null
      

//if specified contact doesn't exist     
		else
			System.out.println("Invalid contact name");
		


	}//end ScheduleEvent method

	/**
	 * This method searches for events based on a criteria.
	 * */
	
	public void printEventDetails() {
		if(!events.empty()){
		
		int choice=-1;
		do {
			try {
				System.out.println("Enter search criteria:\r\n"
						+ "1. contact name\r\n"
						+ "2. Event title\r\n");
				System.out.print("Enter your choice:");
				choice=input.nextInt();
				

				if(choice!=2 && choice!=1)
					throw new Exception();
				break;
			}//end try
			catch(Exception e) {
				input.nextLine();
				System.out.println("\n error in input. Please try again\n\n");
			}//end catch
		}//end do
		while(true);

		
		input.nextLine();
		if (choice==1)
		{ 
			
			System.out.println("Enter contact's name:");
			String ContactName=input.nextLine();
			
			
			
			if(contacts.empty()) {
				System.out.println("No saved contacts");
				return;
			}
			
			int numOfMatchingEvents=0;
			
			events.findFirst();
			while(!events.last()) {
				if(events.retrieve().getContact().getName().equalsIgnoreCase(ContactName)) {
					System.out.println(events.retrieve().toString()); //return current info
					numOfMatchingEvents++;
					}
					events.findNext();
				}//while
			
//check the last event	
			if(events.retrieve().getContact().getName().equalsIgnoreCase(ContactName)) {
				System.out.println(events.retrieve().toString()); //return current info
				numOfMatchingEvents++;
				}
				
			if(numOfMatchingEvents==0)
				System.out.println("There is no events for this contact");
			
		}//end if choice==1
		
		
			else
		{
		System.out.println("Enter the event's title");
			String EventTitle = input.nextLine();
			
			

			LinkedList<Event> resultList= events.search("title", EventTitle);

			
			
			
			 
			if(resultList==null || resultList.empty()) {
				System.out.println("No Events found");
				return;
			}//end if
			
			else {
				resultList.findFirst();

				while(!resultList.last()) {
					System.out.println(resultList.retrieve()+"\n\n");
					resultList.findNext();
				}//end while
				
				System.out.println(resultList.retrieve()); 
			}//end else
			
		}
		}// end event not empty
		else
			System.out.println("No scheduled events");
		
	}//end printEventDetails method
	
	
	/**
	 * This method prints contacts that share the specified first name.
	 */

	public void PrintContactsByFirstName() {
		System.out.print("Enter the first name:");
		String searchedFirstName= input.next();
		System.out.println();
		input.nextLine();

		//to count number of contact with this first name
		int counter=0;
		
		if(!contacts.empty() ) {

			contacts.findFirst();

			while(true) {

				String name = contacts.retrieve().getName();
						
				
				String nameParts[] = name.split(" ");
				
				String contactFirstName = nameParts[0];


				if(contactFirstName.equalsIgnoreCase(searchedFirstName)) {
					System.out.println(contacts.retrieve());
					counter++;
				}//end if

				if(contacts.last())
					break;
				else
					contacts.findNext();
				
				

			}//end while


			

		}//end if
		
		
		if(counter==0)
			System.out.println("No contact with such first name");

	}//end PrintContactsByFirstName method
   
	
	/**
	 * This method prints all events alphabetically.
	 */
	 

	public void PrintEventsAlphabetically() {

		if(events.empty()) {
			System.out.println("No events");
			return;
		}
		
		
		events.findFirst();
		
		while(true) {
			
			
			System.out.println(events.retrieve()+"\n\n");
			
			if(events.last())
				break;
			else
				events.findNext();
		}//end while
		
		
		
	}//end method PrintEventsAlphabetically




}//end class phonebook


