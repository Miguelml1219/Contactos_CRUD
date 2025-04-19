package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

import Connection.ConnectionC;

public class ListaContactoGUI {

    private JFrame frame;
    private JPanel main;
    private JTable table1;
    private ConnectionC connectionC = new ConnectionC();


    public ListaContactoGUI(String name)
    {

        showdata();

    }


    public void showdata()
    {
        ListaContactoGUI.NonEditableTableModel modelo = new ListaContactoGUI.NonEditableTableModel();

        modelo.addColumn("id_contacto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Telefono");
        modelo.addColumn("Correo");
        modelo.addColumn("Creado");

        table1.setModel(modelo);

        String[] dato = new String[5];
        Connection con = connectionC.getConnection();

        try
        {
            table1.getColumnModel().getColumn(0).setMinWidth(0);
            table1.getColumnModel().getColumn(0).setMaxWidth(0);
            table1.getColumnModel().getColumn(0).setWidth(0);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM contactos");


            while (rs.next())
            {
                dato[0] = rs.getString(1);
                dato[1] = rs.getString(2);
                dato[2] = rs.getString(3);
                dato[3] = rs.getString(4);
                dato[4] = rs.getString(5);

                modelo.addRow(dato);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Clase para definir un modelo de tabla no editable.
     */

    public class NonEditableTableModel extends DefaultTableModel {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    /**
     * Ejecuta la ventana de detalles del pedido.
     */

    public void runDetail() {

        frame = new JFrame("Data Base Contact");
        frame.setContentPane(this.main);
//          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400,300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
