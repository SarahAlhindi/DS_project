package project2;

import java.util.Scanner;


public class Main {

	public static Scanner input = new Scanner(System.in);	
	
		public static void main(String[] args) {
			
			Phonebook phonebook = new Phonebook(new LinkedList<Contact>(),new LinkedList<Event>() );
			
			
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
					System.out.println("\n error in input. Please try again\n\n");
				}
				System.out.println();
				switch(choice) {
				case 1 :
					phonebook.addContact(); 
               break;
				case 2: 
					phonebook.searchContact(); 
               break;
				case 3 : 
					phonebook.deleteContact(); 
               break;
				case 4: 
					phonebook.ScheduleEvent(); 
               break;
				case 5: 
					phonebook.printEventDetails(); 
               break;
				case 6: 
					phonebook.PrintContactsByFirstName(); 
               break;
				case 7: 
					phonebook.PrintEventsAlphabetically(); 
               break;
				case 8 :
					System.out.println("Goodbye!");



				}//end switch
			}//end do
			while(choice!=8);

	}

}// end Main class
