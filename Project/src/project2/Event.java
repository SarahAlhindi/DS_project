
package project2;



public class Event implements Comparable<Event>{
    public String title;
    public String date;
    public String time;
    public String location;
    public Contact contact;
    
    
//constructors
    public Event(){
        title="";
        date="";
        time="";
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
    

//setters and getters
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
        return "title:" + title + "\n contact name:" + contact.getName() + "\n date:" + date + 
                "\n time:" + time + "\n location:" + location ;
    }
   
	
	
	@Override
	public int compareTo(Event e) {
		return this.title.compareTo(e.title);
	}
	
    
    
    
    
}// end Event class
