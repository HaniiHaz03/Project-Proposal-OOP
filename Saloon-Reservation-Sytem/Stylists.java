/* DANIA ADRIANA BINTI MOHD FAIZAL*/
/* 22006373 */
/* PROGRAM : COMPUTER SCIENCE */

import java.util.Scanner;
public class Main
{
	public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
        Stylists lists = new Stylists();                // lists is the object
        boolean run = true;

        while (run) {                               // using loop to continuously prompt the user for actions
            System.out.println("1. Add Stylist");
            System.out.println("2. Remove Stylist");
            System.out.println("3. Print Stylists");
            System.out.println("4. Find Stylist");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter stylist name to add: ");
                    String addName = scanner.nextLine();            
                    lists.addStylist(addName);                   // method to call the class with object
                    break;
                case 2:
                    System.out.print("Enter stylist name to remove: ");
                    String removeName = scanner.nextLine();         
                    lists.removeStylist(removeName);             // method to call the class with object
                    break;
                case 3:
                    lists.printStylist();                        // method to call the class with object
                    break;
                case 4:
                    System.out.print("Enter stylist name to find: ");
                    String findName = scanner.nextLine();
                    lists.findStylist(findName);                 // method to call the class with object
                    break;
                case 5:
                    run = false;
                    break;
                default:
                    System.out.print("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
import java.util.ArrayList;
public class Stylists
{
    // we dont want the data to be accessible to the public, so we set it to private 
    private ArrayList <String> styLists;
    
    //constructor
    public Stylists () {
        styLists = new ArrayList <String>();
    }
    
    // getter method to access list of stylists information
    public ArrayList<String> getStyLists() {
        return styLists;
    }
    
    //setter method to access list of stylists information
    public void setStyList(ArrayList<String> styLists) {
        this.styLists = styLists;
    }
    
    // ACTIONS 
    public void addStylist(String lists)           // to add new stylist into the list  
    {         
        styLists.add(lists);
        System.out.println('\n' + "Stylist " + lists + " added." + '\n');
    }
    
    public void removeStylist(String lists)         // to remove stylist into the list  
    {
        if (styLists.remove(lists)) {
            System.out.println('\n' + "Stylist " + lists + " removed." + '\n');
        } else {
            System.out.println('\n' + "Stylist " + lists + " not found." + '\n');
        }
    }
    
    public void printStylist()              // to print the list of stylists available   
    {
        System.out.println('\n');
        System.out.println("List of Stylists:");
        
        for (String lists : styLists) {
            System.out.println(lists);  
        }
        System.out.println('\n');
    }
    
   public boolean findStylist(String lists) {           // to find the name of a specific stylist from the list  
        boolean found = styLists.contains(lists);
        if (found) {
            System.out.println('\n' + "Stylist " + lists + " found." + '\n');
        } else {
            System.out.println("Stylist " + lists + " not found." + '\n');
        }
        return found;
    }
    
}
