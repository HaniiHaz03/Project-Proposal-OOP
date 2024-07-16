

public class DBDemo
{
    // instance variables - replace the example below with your own
   
    public DBDemo()
    {
     
    }  
    
    
    public static void main(String[] args) {
        //write test code
        SqlDB db = new SqlDB("sql12.freesqldatabase.com", "sql12719544", "jqCwnHARDb");
        db.init();
        
        //db.insert("Adriana", 80.00, "Facial");
        db.query();
    
    } 

}



