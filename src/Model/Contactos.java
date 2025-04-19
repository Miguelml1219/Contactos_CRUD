package Model;

import java.time.LocalDateTime;
import java.util.Date;

public class Contactos {
    //atributos

    int id_contacto;
    String nombre, telefono, correo;
    Date fecha_creacion;

    public int getId_contacto() {
        return id_contacto;
    }

    public void setId_contacto(int id_contacto) {
        this.id_contacto = id_contacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecha_creacio() {
        return fecha_creacion;
    }

    public void setFecha_creacio(Date fecha_creacio) {
        this.fecha_creacion = fecha_creacio;
    }

    public Contactos(int id_contacto, String nombre, String telefono, String correo, Date fecha_creacion) {
        this.id_contacto = id_contacto;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.fecha_creacion = fecha_creacion;

    }
}
