public class DBDemo
{

    /**
     * Constructor for objects of class DBDemo
     */
    public DBDemo()
    {
        
    }

    public static void main(String[] args) {
        
        SqlDB db = new SqlDB("sql12.freesqldatabase.com", "sql12720141", "wUGaWRv62A");
        db.init();
        db.query();
    }

}