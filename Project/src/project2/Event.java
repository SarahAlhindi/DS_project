
package project2;

import java.time.*;




public class Event implements Comparable<Event>{
    public String title;
    public String date;
    public String time;
    // or use (StringTime) data type to merge the time and date variables
    //or use "Date" data type from util package
    public String location;
    Contact contact;
    
    
    
    public Event(){
        title="";
        date=null;
        time=null;
        location="";
        contact=null;;
        
        
        
    }
    public Event(String title, String date,String time,String location, Contact contact){
        
        
      this.title=title; 
      this.date=date;
      this.time=time;
      this.location=location;
     this.contact=contact;
    }
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    

    
    
    
    public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	@Override
    public String toString() {
        return "title:" + title + "\ncontact name:" + contact.getName() + "\ndate:" + date + 
                "\ntime:" + time + "\nlocation:" + location ;
    }
   
	
	
	@Override
	public int compareTo(Event e) {
		return this.title.compareTo(e.title);
	}
	
    
    
    
    
}
