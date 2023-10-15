package project2;
import java.util.*;






public class Phonebook {
	
	public static Scanner input = new Scanner(System.in);
	private  LinkedList<Contact> contacts ;
	private  LinkedList<Event> events ;
	
	
	


	public Phonebook(LinkedList<Contact> contacts, LinkedList<Event> events) {
		this.contacts = contacts;
		this.events = events;
	}
	
	
	




	public void addContact() {
		
		System.out.println("Enter the contact's name:");
		String contactName=input.nextLine();

		System.out.println("Enter the contact's phone number:");
		String contactPhone=input.nextLine();

		System.out.println("Enter the contact's email address:");
		String contactEmail=input.nextLine();

		System.out.println("Enter the contact's address:");
		String contactAddress=input.nextLine();

		System.out.println("Enter the contact's birthday:");
		String contactDob=input.nextLine();

		System.out.println("Enter any notes for the contact:");
		String contactNotes=input.nextLine();




		Contact contact = new Contact(contactName, contactPhone, contactEmail, contactAddress, contactDob, contactNotes);


		
		//if contact list is empty, insert directly//
		
		if(contacts.empty()) {
			if(contacts.insert(contact))
				System.out.println("Contact added successfully");
			
			return;
				
		}//end if
		
		/////////////////////////////////////////////
		
		
		
		//Check if contact exists///////////////////

		contacts.findFirst();
		while(true) {
			if((contact.getName()).equalsIgnoreCase(contacts.retrieve().getName()) || (contact.getPhone_number()).equalsIgnoreCase(contacts.retrieve().getPhone_number()) ) {
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

	public void searchContact()   {
		int choice=-1;
		String value=null;
		do {
			try {
				System.out.println("\nEnter search criteria:\r\n"
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
					System.out.print("Enter the contact's name:");break;
				case 2: 
					System.out.print("Enter the contact's phone number:");break;
				case 3: 
					System.out.print("Enter the contact's Email Address:");break;
				case 4: 
					System.out.print("Enter the contact's Address:");break;
				case 5: 
					System.out.print("Enter the contact's Birthday:");break;

				}//end switch
				value = input.nextLine();
				break;

			}//end try
			catch(Exception e) {
				input.nextLine();
				System.out.println("\nerror in input. Please try again\n\n");
			}//end catch
			
		}//end do
		while(true);
		
		
		
		
		
		System.out.println();
		
		String criteria=null;;
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
	public void deleteContact() {
		
		System.out.print("Enter the name of the contact:");
		String contactName=input.next();
		input.nextLine();
		
		if(contacts.empty()) {
			System.out.println("No such contact");
			return;
		}
		
		
		boolean found=false;
		
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
		
		if(contacts.retrieve().getName().equalsIgnoreCase(contactName)) {
			contacts.remove();
			System.out.println("Contact deleted successfully");
			found=true;
			}
		
		
		
		if(!found) {
			System.out.println("No contact with such name");
			return;
			}
		
		
		
		if(events.empty())
			return;
		
		
		boolean eventRemoved=false;
		
		
		events.findFirst();
		while (true){
			eventRemoved=false;
			if(events.retrieve().getContact().getName().equalsIgnoreCase(contactName)) {
				events.remove();
				eventRemoved=true;
				}
			
			
			if(events.empty() || (events.last() && !eventRemoved)) // !eventRemoved is for the case when the last element is reached because the previous event was deleted
				
				break;
			else if(!eventRemoved)
				events.findNext();
			
			
		}//end while
			
	}//end deleteContact method
		
		
		
		

	public void ScheduleEvent() {
		
		System.out.print("Enter event title:");
		String eventTitle=input.nextLine();

		System.out.print("Enter Contact name:");
		String contactName=input.nextLine();

	

		Contact contact=null;
		contacts.findFirst();
		if(!contacts.empty()) {
		while (!contacts.last())
			if(contacts.retrieve().getName().equals(contactName)){
				contact=contacts.retrieve();
				break;
				}
		        else
				contacts.findNext();
		
		
		if(contacts.retrieve().getName().equalsIgnoreCase(contactName))
			contact=contacts.retrieve();
		
		}//end if not empty
		

		System.out.print("Enter event date (MM/DD/YYYY):");
		String eventDate=input.nextLine();
		
		System.out.print("Enter eventtime (HH:MM):");
		String eventTime=input.nextLine();

		System.out.print("Enter event location:");
		String eventLocation=input.nextLine();

		if(contact!=null){
		        Event event = new Event(eventTitle , eventDate, eventTime,eventLocation, contact);
		        
		        
		        
		        if(!events.empty()) {
			events.findFirst();
			while(!events.last())
				if(events.retrieve().getContact().getName().equalsIgnoreCase(contact.getName()) && events.retrieve().getTime().equals(event.getTime()) && events.retrieve().getDate().equals(event.getDate())){
					System.out.println("Can't add event, there is a conflict");
					return;}
				
			        else
					events.findNext();
			
			
			
			if(events.retrieve().getContact().getName().equalsIgnoreCase(contact.getName()) && events.retrieve().getTime().equals(event.getTime()) && events.retrieve().getDate().equals(event.getDate())){
				System.out.println("Can't add event, there is a conflict");
				return;}
			
		        }//end if events not empty
			
			
			events.insert(event);
			System.out.println("\nEvent Added successfuly");
			




			
		}// end if contact !=null
		else
			System.out.println("Invalid contact name");
		


	}//end ScheduleEvent method

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
				System.out.println("\nerror in input. Please try again\n\n");
			}//end catch
		}//end do
		while(true);

		
		input.nextLine();
		if (choice==1)
		{ 
			System.out.println("Enter contact's name:");
			String ContactName=input.nextLine();
			input.nextLine();
			
			
			if(contacts.empty()) {
				System.out.println("No saved contacts");
				return;
			}
			
			int numOfMatchingEvents=0;
			
			events.findFirst();
			while(!events.last()) {
				if(events.retrieve().getContact().getName().equalsIgnoreCase(ContactName)) {
					System.out.println(events.retrieve().toString()); //toString returns current info
					numOfMatchingEvents++;
					}
					events.findNext();
				}//while
			
			
			if(events.retrieve().getContact().getName().equalsIgnoreCase(ContactName)) {
				System.out.println(events.retrieve().toString()); //toString returns current info
				numOfMatchingEvents++;
				}
				
			if(numOfMatchingEvents==0)
				System.out.println("There is no events for this contact");
			
		}//end if choice==1
		
		
			else
		{
		System.out.println("Enter the event's title");
			String EventTitle=input.nextLine();
			input.nextLine();
			
			
			int numOfMatchingEvents=0;
			events.findFirst();
			while(!events.last()) {
				if(events.retrieve().getTitle().equals(EventTitle)) {
					System.out.println(events.toString()); 
					numOfMatchingEvents++;
				}//toString returns current info
				
					events.findNext();
					
					}//end while
			
			
			if(events.retrieve().getTitle().equals(EventTitle)) {
				System.out.println(events.toString()); 
				numOfMatchingEvents++;
			}//toString returns current info
			
			
			
			
			if(numOfMatchingEvents==0)
				System.out.println("No such event");
			
			
				
		}
		}
			

		
		else
			System.out.println("No scheduled events");
			

	}//end printEventDetails method
	
	

	public void PrintContactsByFirstName() {
		System.out.print("Enter the first name:");
		String searchedFirstName= input.next();
		input.nextLine();

		//to count number of contact with this first name
		int counter=0;
		
		

		if(!contacts.empty() ) {


			contacts.findFirst();

			while(true ) {

				String name = contacts.retrieve().getName();
//				int spaceIndex=name.indexOf(" ");
				
				
				
				String nameParts[] = name.split(" ");
				
				String contactFirstName = nameParts[0];

//				if(spaceIndex!=-1)
//					contactFirstName= contactFirstName.substring(0,spaceIndex);

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
