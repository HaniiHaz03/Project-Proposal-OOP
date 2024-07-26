
public class Client
{
    protected String name;
    protected String phoneNumber;
    protected String email;
    
    public Client(String name, String phoneNumber, String email)
    {
         this.name = name;
         this.phoneNumber = phoneNumber;
         this.email = email;
    }
    
    // Getter methods to access client information
  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmail() {
    return email;
  }
  
  @Override
    public String toString() {
        return "Name: " + getName() + "  " + "Phone Number:" + getPhoneNumber() + "  " + "Email:" + getEmail() + " ";
    }
    
}
