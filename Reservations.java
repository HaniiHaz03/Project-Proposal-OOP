//NAME : RAILYNN NISHALIA BINTI RHYMEI
//ID : 22005979 
//Bachelor of Computer Engineering with Honour

public class Main
{
	public static void main(String[] args)
	{
	    Reservations waiters = new Reservations();       //primary object: waiters(males)
	    waiters.addReservations();                     //methods to call on subjects stated
	    waiters.removeReservations();
	    waiters.printReservations();
	    waiters.findReservations();
	    
	    Reservations waitresses = new Reservations();         //secondary object: waitresses(females)
	    waitresses.addReservations();
	    waitresses.removeReservations();
	    waitresses.printReservations();
	    waitresses.findReservations();
	
	}
}
//CLASS FOR RESERVATIONS

public class Reservations
{
    // private data, inaccessible for public to reach the data
    private String reservations;
            // a sequence of characters
            
    // ACTIONS 
    public void addReservations() { 
            //a reserved type used mainly to specify that a method does not return any data type
    }
    
    public void removeReservations() {
        
    }
    
    public void printReservations()  {
        
    }
    
    public void findReservations() {
        
    }
    
}
