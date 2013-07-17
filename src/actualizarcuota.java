/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasio;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DayDV;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class actualizarcuota implements Runnable{
    BdPostgresql psql = new BdPostgresql();
    public void run(){
        System.out.println("iniciado");
    Connection conn = psql.conectar();
    int deuda=0;
    Date fecha;
    Date pago;
    java.util.Date hoy;
        hoy = new java.util.Date();
        
        Statement stmt;
        ResultSet rs;
   
        int id_cliente=0;
        ResultSet rs2;
        int precio=0;
        try {
            rs2 = psql.consulta("SELECT precio FROM clase WHERE id_clase='8';");
               while(rs2.next()){
                       precio=rs2.getInt("precio");}
        } catch (SQLException ex) {
            Logger.getLogger(actualizarcuota.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
        while(true){
        try {
        
            stmt=conn.createStatement();
            
            rs= stmt.executeQuery("SELECT * FROM cliente WHERE fec_deuda < '"+hoy+"';");
       
            
            
               while(rs.next()){
                    DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
                    id_cliente=rs.getInt("id_cliente");
                    fecha=rs.getDate("fec_deuda");
                    pago=rs.getDate("fec_pago");
                    deuda=rs.getInt("deuda");
                   
                    if ((fecha.getMonth() < hoy.getMonth()+1)&&(fecha.getDate()==hoy.getDate())){
                
                     System.out.println("actualizando "+id_cliente);
                        deuda=deuda+precio;               
                     Statement stmt1=conn.createStatement();
                stmt1.execute("UPDATE cliente SET deuda='"+deuda+"' where id_cliente='"+id_cliente+"';");
                stmt1.execute("UPDATE cliente SET fec_deuda='"+format.format(hoy)+"' WHERE id_cliente='"+id_cliente+"';");
                System.out.println("actualizacion correcta "+id_cliente+" deuda "+deuda);
            
            }
               Thread.sleep(600);
                 
         
            }
    }       catch (InterruptedException ex) {
                Logger.getLogger(actualizarcuota.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (SQLException ex) {    
            Logger.getLogger(actualizarcuota.class.getName()).log(Level.SEVERE, null, ex);
        }  
        }
}}
    
