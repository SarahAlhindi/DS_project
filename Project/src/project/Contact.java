package project;

/**
 *
 * @author shaha
 */
public class Contact implements Comparable<Contact>  {
    
    private String name;
    private String phone_number;
    private String email;
    private String address;
    private String birthday;
    private String notes;

    public Contact() {
        name = "";
        phone_number = "";
        email = "";
        address = "";
        birthday = "";
        notes = "";
    }
    
    

    public Contact(String name, String phone_number, String email, String address, String birthday, String notes) {
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
    }

    @Override
    public int compareTo(Contact c) {
        return this.name.compareTo(c.name);
    }
    
     

    public void setName(String name) {
        this.name = name;
    }
    
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    

    public String getEmail() {
        return email;
    }

    

    public String getAddress() {
        return address;
    }

    

    public String getBirthday() {
        return birthday;
    }

    

    public String getNotes() {
        return notes;
    }
    
    @Override
    public String toString() {
        return  "name:" + name + "\n phone_number:" + phone_number +
                "\n email:" + email + "\n address:" + address + "\n birthday:" 
                + birthday + "\n notes:" + notes ;
    }

      
} // end class
