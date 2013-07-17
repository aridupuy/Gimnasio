/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class DescontarDias implements Runnable {
BdPostgresql psql = new BdPostgresql();
 boolean modificado=false; 
@Override
    public void run() {
       
     while (true){
        
         Calendar cal= Calendar.getInstance();
     int hora = cal.get(Calendar.HOUR_OF_DAY);
     int minutos=cal.get(Calendar.MINUTE);
     int segundos=cal.get(Calendar.SECOND);
     Time time = new Time(hora, minutos, segundos);
         
     try {
              
                if (((time.getHours()==23)&&(time.getMinutes()==14))&&(modificado==false)){
                    System.out.println("modificando....");
                Statement stmt = psql.conectar().createStatement();
                ResultSet rs =stmt.executeQuery("SELECT dias,id_cliente from cliente");
                while(rs.next()){
                int dias=rs.getInt("dias");
                int id=rs.getInt("id_cliente");
                Statement stmt2=psql.conectar().createStatement();
                stmt2.execute("UPDATE cliente SET dias='"+(dias-1)+"' WHERE id_cliente='"+id+"';");
                
                }
                modificado=true;
                }
               
                
     
      } catch (SQLException ex) {
                Logger.getLogger(DescontarDias.class.getName()).log(Level.SEVERE, null, ex);
            }
     
     }
    
    }
    
}
