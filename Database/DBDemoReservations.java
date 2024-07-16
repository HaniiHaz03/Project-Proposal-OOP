public class DBDemo
{
    // instance variables - replace the example below with your own
   
    public DBDemo()
    {
     
    }  
    
   public static void main(String[] args) {
        SqlDB db = new SqlDB("sql12.freesqldatabase.com", "sql12720115", "iEmWcdsfk2");
        db.init();
        //db.insert("John Doe", "1234567890", "john@example.com", "2024-07-16", "14:00", "Haircut", "Jane Smith");
        db.query();
    }
}
