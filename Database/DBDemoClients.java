


public class DBDemo
{

    /**
     * Constructor for objects of class DBDemo
     */
    public DBDemo()
    {
        
    }

    public static void main(String[] args) {
        
        SqlDB db = new SqlDB("sql12.freesqldatabase.com", "sql12719044", "PQUSjvXBEP");
        db.init();
        //db.insert("Zulaikha", "019 1234567", "zulaikha@gmail.com");
        db.query();
    }

}
