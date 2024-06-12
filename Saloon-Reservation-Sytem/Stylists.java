/* DANIA ADRIANA BINTI MOHD FAIZAL*/
/* 22006373 */
/* PROGRAM : COMPUTER SCIENCE */

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
