package Controller;

import Model.Contactos;
import Connection.ConnectionC;
import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactosDAO {



    // metodo agregar


    public boolean agregar(Contactos contactos) {


        Connection con = ConnectionC.getConnection();
        String query = "INSERT INTO contactos( nombre, telefono, correo, fecha_creacion) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, contactos.getNombre());
            pst.setString(2, contactos.getTelefono());
            pst.setString(3, contactos.getCorreo());
            pst.setDate(4, contactos.getFecha_creacio());

            int resultado = pst.executeUpdate();
            return resultado > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // metodo actualizar

    public void actualizar(int id_contacto, String nombre, String telefono, String correo ) {


        String query = "UPDATE contactos SET nombre = ?, telefono = ?, correo = ? WHERE id_contacto = ?";
        Connection con = ConnectionC.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, nombre);
            stmt.setString(2, telefono);
            stmt.setString(3, correo);
            stmt.setInt(5, id_contacto);

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Contacto actualizado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el Contacto.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
// metodo eliminar
    public void eliminar(int id) {
        Connection con = ConnectionC.getConnection();
        String query = "DELETE FROM contactos WHERE id_contacto = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Contacto eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el Contacto.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }






}
