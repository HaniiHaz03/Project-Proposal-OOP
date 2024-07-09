import java.util.*;
/**
 * Write a description of class Clients here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Clients
{
    private ArrayList<Client> clients = new ArrayList<>();
    
    public Clients()
    {
        
    }
    
    public void addClient(Client client) {
        
        clients.add(client);
    }
    
     public void removeClient(String name) {
        clients.removeIf(client -> client.getName().equals(name));
    }

    public Client findClient(String name) {
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }
    
    public ArrayList<Client> getClients(){
        return clients;
    }

    public void printClients() {
        System.out.println("Client list:");
        for (Client client : clients) {
            System.out.println(client);
        }
    }
