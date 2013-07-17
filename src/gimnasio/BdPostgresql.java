package gimnasio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BdPostgresql {
Connection conn;
    public Connection conectar (){
    String driver = "org.postgresql.Driver";
    String connectString = "jdbc:postgresql://localhost:5432/PowerGim&fitness";
    String user = "postgres";
    String pass="34551848";
    try{
        Class.forName(driver);
        conn=DriverManager.getConnection(connectString,user,pass);
       
        return conn;
        }catch(Exception e){
            System.out.println("Error de conexion");
            }
    return conn;
}
    
public void cerrar () throws SQLException{
conn.close();
}
public ResultSet consulta(String consulta) throws SQLException{
BdPostgresql psql = new BdPostgresql();
        Connection conn = psql.conectar();
           ResultSet rs=null;
        
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      rs = stmt.executeQuery(consulta);
        
    
return rs;
}
}
