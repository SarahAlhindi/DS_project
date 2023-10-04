
package phonebook;

import java.time.*;
public class Event {
    public String title;
    public LocalDate date;
    public LocalTime time;
    // or use (LocalDateTime) data type to merge the time and date variables
    //or use "Date" data type from util package
    public String location;
    LinkedList <Contact> contacts;
    
    
    
    public Event(){
        title="";
        date=null;
        time=null;
        location="";
        contacts=new LinkedList <Contact>();
        
        
        
    }
    public Event(String title, LocalDate date,LocalTime time,String location, Contact contact){
        
        
      this.title=title; 
      this.date=date;
      this.time=time;
      this.location=location;
      contacts=new LinkedList <Contact>();
      contacts.insert(contact);
    }
    
    
    
    
   
    
    
    
    
}
