package project;
import java.util.*;


public class Phonebook {
	public static Scanner input = new Scanner(System.in);
	public static LinkedList<Contact> contacts = new LinkedList<Contact>();
	public static LinkedList<Event> contacts = new LinkedList<Event>();


	public static void main(String[] args) {
		//create contact linked list
		System.out.println("Welcome to the Linked Tree Phonebook!");
		int choice=-1;
		do {
			try {
				choice=-1;

				System.out.println(
						"\n\nPlease choose an option:\r\n"
								+ "1. Add a contact\r\n"
								+ "2. Search for a contact\r\n"
								+ "3. Delete a contact\r\n"
								+ "4. Schedule an event\r\n"
								+ "5. Print event details\r\n"
								+ "6. Print contacts by first name\r\n"
								+ "7. Print all events alphabetically\r\n"
								+ "8. Exit");


				System.out.print("Enter your choice:");
				choice = input.nextInt();


				if(choice>8 || choice<1)
					throw new Exception() ;

			}//end try
			catch(Exception e) {
				input.nextLine();
				System.out.println("\nerror in input. Please try again\n");
			}
			System.out.println();
			switch(choice) {
			case 1 :
				addContact(); break;
			case 2: 
				searchContact(); break;
			case 3 : 
				deleteContact(); break;
			case 4: 
				ScheduleEvent(); break;
			case 5: 
				printEventDetails(); break;
			case 6: 
				PrintContactsByFirstName(); break;
			case 8 :
				System.out.println("Goodbye!");



			}//end switch
		}//end do

		//TODO just to check contacts list contents. will be deleted later
		while(choice!=8);

		contacts.findFirst();
		while(!contacts.empty()) {
			System.out.println(contacts.retrieve());
			if(!contacts.last())
				contacts.findNext();
			else
				break;

		}


	}//main



	public static void addContact() {
		input.nextLine();
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


		if(contacts.empty()) {
			contacts.insert(contact);
			System.out.println("\nContact Added successfuly");
			return;

		}//end if

		contacts.findFirst();
		while(true) {
			if((contact.getName()).equalsIgnoreCase(contacts.retrieve().getName()) || (contact.getPhone_number()).equalsIgnoreCase(contacts.retrieve().getPhone_number()) ) {
				System.out.println("\nContact already exists!");
				return;
			}//if

			if(!contacts.last())
				contacts.findNext();
			else {
				break;
			}//end else


		}//end while




		contacts.findFirst();


		while(true) {

			if(contact.compareTo(contacts.retrieve()) <= 0 )  {
				//				System.out.println(contact.getName()+ " "+contacts.retrieve().getName()+"     "+contact.compareTo(contacts.retrieve()) );
				Contact tmp = contacts.retrieve();
				contacts.update(contact);
				contacts.insert(tmp);

				break;


			}//end if


			if(!contacts.last())
				contacts.findNext();
			else {

				contacts.insert(contact);
				break;
			}//end else


		}//end while


		System.out.println("\nContact Added successfuly");













	}//end addContact

	public static void searchContact() {
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
				System.out.println("\nerror in input. Please try again\n");
			}//end catch

		}//end do
		while(true);





		LinkedList<Contact> resultList= new LinkedList<Contact>();


		int criteria = choice;

		contacts.findFirst();
		while(!contacts.empty()) {

			switch(criteria ) {

			case 1 :
				if(contacts.retrieve().getName().equalsIgnoreCase(value))
					resultList.insert(contacts.retrieve());
				break;
			case 2 :
				if(contacts.retrieve().getPhone_number().equalsIgnoreCase(value))
					resultList.insert(contacts.retrieve());
				break;			case 3 :
					if(contacts.retrieve().getEmail().equalsIgnoreCase(value))
						resultList.insert(contacts.retrieve());
					break;
				case 4 :
					if(contacts.retrieve().getAddress().equalsIgnoreCase(value))
						resultList.insert(contacts.retrieve());
					break;
				case 5 :
					if(contacts.retrieve().getBirthday().equalsIgnoreCase(value))
						resultList.insert(contacts.retrieve());
					break;



			}//end switch

			if(!contacts.last()) 
				contacts.findNext();

			else 
				break;

		}//end while




		//TODO no need for null
		if(resultList==null || resultList.empty()) {
			System.out.println("No contact found");
			return;
		}//end if
		else {
			resultList.findFirst();

			while(!resultList.last()) {
				System.out.println(resultList.retrieve());
				resultList.findNext();
			}//end while
			System.out.println(resultList.retrieve()); 
		}//end else



	}//end searchcontact method

	public static void deleteContact() {
		System.out.print("Enter the name of the contact:");
		String contactName=input.next();
		//TODO add remove method 
	}//end deleteContact method

	public static void ScheduleEvent() {
		input.nextLine();
		System.out.print("Enter event title:");
		String eventTitle=input.nextLine();

		System.out.print("Enter Contact name:");
		String contactName=input.nextLine();

		System.out.print("Enter event date and time (MM/DD/YYYY HH:MM):");
		String eventDateTime=input.nextLine();

		System.out.print("Enter event location:");
		String eventLocation=input.nextLine();



		//		Events event = new Events(eventTitle, contactName, eventDateTime,eventLocation);


	}//end ScheduleEvent method

	public static void printEventDetails() {
		int choice=-1;
		do {
			try {
				System.out.println("Enter search criteria:\r\n"
						+ "1. contact name\r\n"
						+ "2. Event tittle\r\n");
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

		//TODO the rest here

	}//end printEventDetails method

	public static void PrintContactsByFirstName() {
		System.out.print("Enter the first name:");
		String searchedFirstName= input.next();

		int counter=0;

		if(!contacts.empty() ) {


			contacts.findFirst();

			while(true ) {

				String contactFirstName = contacts.retrieve().getName();
				int spaceIndex=contactFirstName.indexOf(" ");

				if(spaceIndex!=-1)
					contactFirstName= contactFirstName.substring(0,spaceIndex);

				if(contactFirstName.equalsIgnoreCase(searchedFirstName)) {
					System.out.println();
					System.out.println(contacts.retrieve());
					counter++;
				}//end if
				
				if(!contacts.last())
					contacts.findNext();
				else
					break;

			}//end while

			
			

		}//end if
		if(counter==0)
			System.out.println("No contact with such first name");

	}//end PrintContactsByFirstName method

	public static void PrintEventsAlphabetically() {

	}//end method PrintEventsAlphabetically




}//end class phonebook
