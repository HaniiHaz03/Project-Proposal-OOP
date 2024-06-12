//NAME: ZULAIKHA BINTI MOHD AZAHR
//ID: 24000918
//PROGRAM: BACHELOR OF COMPUTER SCIENCE

import java.util.*;

public class Clients {
    
    ArrayList<Clients> clients = new ArrayList<Clients>(); //an array to store client's data
    Scanner scanner = new Scanner(System.in);
    
    private String name, phone; //private attributes that can only be accessed within the class
    
    public Clients (String name, String phone) { //constructor
        setName(name);
        setPhone(phone);
    }

    public void setName(String name) { //setter method for name
        this.name = name;
    }
    
    public String getName() { //getter method for name
        return this.name;
    }
    
    public void setPhone(String phone) { //setter method for phone number
        this.phone = phone;
    }
    
    public String getPhone() { //getter method for phone number
        return phone;
    }
    
    //ACTIONS: 
    
    public void addClients() { //action to add clients
        System.out.println("Enter client name to add: ");
        String name = scanner.next();
        System.out.println("Enter client phone to add: ");
        String phone = scanner.next();
        
        clients.add(new Clients(name, phone));
        
        System.out.println("Client Successfully Added!");
    }
    
    public void removeClients() { //action to remove clients
        System.out.println("Enter client name to remove: ");
        String name = scanner.next();
        
        int i = findClientIndex();
        
        if (i != -1) {
            clients.remove(i);
        } else {
            System.out.println("Client not found!");
        }
        
    }
    
    public void printClients() { //action to print all clients
        if (clients.isEmpty()) {
            System.out.println("No clients.");
        } else {
            System.out.println("List of Clients: ");
            for(Clients c : clients) {
            System.out.println("Name: " + c.getName() + ", Phone Number: " + c.getPhone());
            }
        }
    }
    
    public void findClients() { //action to find a client
        System.out.println("Enter client name to find: ");
        String name = scanner.next();
        
        int i = findClientIndex();
        
        if (i != -1) {
            Clients client = clients.get(i);
            System.out.println("Name: " + client.getName() + ", Phone Number: " + client.getPhone() + "\n");
        } else {
            System.out.println("Client not found!\n");
        }
        
    }
    
    public int findClientIndex() { //an additional method to find the index of the client
        
        for (int i = 0; i < clients.size(); i++){
            if(clients.get(i).getName().equals(name)) {
                return i;
            } 
        } 
        return -1;
    }
}
