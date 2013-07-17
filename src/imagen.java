/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasio;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.DefaultListModel;

public class imagen {
Foto1 img=new Foto1();    

 public Image ConvertirImagen(byte[] bytes) throws IOException {
    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
    Iterator readers = ImageIO.getImageReadersByFormatName("jpg");    
    ImageReader reader = (ImageReader) readers.next();
    Object source = bis;
    ImageInputStream iis = ImageIO.createImageInputStream(source);
    reader.setInput(iis, true);
    ImageReadParam param = reader.getDefaultReadParam();
    return reader.read(0, param);
 }

    BdPostgresql psql=new BdPostgresql();
    public DefaultListModel Lista_Imagenes()
    {
        DefaultListModel dml = new DefaultListModel();
        try {
            Connection con=psql.conectar();
           Statement statement = con.createStatement();
           ResultSet resultSet = statement.executeQuery("SELECT id,nombre,archivo FROM imagen " );
          while (resultSet.next())
          {  //se crea un objeto CITA y se le van agregando los datos
             
             try { //antes de agregar el campo imagen, realiza la conversion de bytes a JPG
                 img.setArchivo(ConvertirImagen(resultSet.getBytes("archivo")));
             } catch (IOException ex) {
                System.err.println(ex.getMessage());
             }
             //por ultimo añade el objeto imagen:img al DefaultListModel
            dml.addElement(img);
          }
       }
       catch (SQLException ex) {
          System.err.println(ex.getMessage());
       }
       return dml;
    }

}

