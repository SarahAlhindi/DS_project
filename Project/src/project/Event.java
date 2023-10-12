
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
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LinkedList<Contact> getContacts() {   
            
        return contacts;
    }

    public void setContacts(LinkedList<Contact> contacts) {
        this.contacts = contacts;
    }
    
    
    @Override
    public String toString() {
        return "title:" + title + "\n contact name:" + contacts + "\n date:" + date + 
                "\n time:" + time + "\n location:" + location ;
    }
   
    
    
    
    
}
