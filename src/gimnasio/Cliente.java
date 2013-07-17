package gimnasio;

import com.sun.org.apache.bcel.internal.util.JavaWrapper;
import java.sql.Date;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageInputStreamImpl;

public class Cliente {
String nombre;
String apellido;
java.sql.Date fecnac;
String direccion;
int dni;
String localidad;
int cp;
int telefono;
int deuda;
java.sql.Date fec_ins;
String correoe;
java.sql.Date fecpago;
ImageInputStream image;


    public Cliente(String nombre, String apellido, Date fecnac, String direccion, int dni, String localidad, int cp, int telefono, int deuda, Date fec_ins, String correoe, Date fecpago, ImageInputStream image) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecnac = fecnac;
        this.direccion = direccion;
        this.dni = dni;
        this.localidad = localidad;
        this.cp = cp;
        this.telefono = telefono;
        this.deuda = deuda;
        this.fec_ins = fec_ins;
        this.correoe = correoe;
        this.fecpago = fecpago;
        this.image = image;
        
    }


public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecnac() {
        return fecnac;
    }

    public void setFecnac(Date fecnac) {
        this.fecnac = fecnac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getDeuda() {
        return deuda;
    }

    public void setDeuda(int deuda) {
        this.deuda = deuda;
    }

    public Date getFec_ins() {
        return fec_ins;
    }

    public void setFec_ins(Date fec_ins) {
        this.fec_ins = fec_ins;
    }

    public String getCorreoe() {
        return correoe;
    }

    public void setCorreoe(String correoe) {
        this.correoe = correoe;
    }

    public Date getFecpago() {
        return fecpago;
    }

    public void setFecpago(Date fecpago) {
        this.fecpago = fecpago;
    }

    public ImageInputStream getImage() {
        return image;
    }

    public void setImage(ImageInputStream image) {
        this.image = image;
    }

    


}
