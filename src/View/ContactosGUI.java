package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Connection.ConnectionC;
import Model.Contactos;


public class ContactosGUI {



    private JPanel main;
    private JTable table1;
    private JButton agregar;
    private JButton buscar;
    private ConnectionC connectionC = new ConnectionC();


    public ContactosGUI()
    {
        listaContacto();

        agregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        table1.setCursor(new Cursor(Cursor.HAND_CURSOR));


        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GUIAgregar guiAgregar = new GUIAgregar(ContactosGUI.this);
                guiAgregar.ejecutar();


            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2 && table1.getSelectedRow()!= -1)
                {
                    int selectedRow = table1.getSelectedRow();
                    String name = (String) table1.getValueAt(selectedRow,1);

                    ListaContactoGUI listaContactoGUI = new ListaContactoGUI(name);
                    listaContactoGUI.runDetail();
                }
            }
        });
    }

    public void listaContacto()
    {
        NonEditableTableModel modeloa = new NonEditableTableModel();
        table1.setDefaultEditor(Object.class, null);


        modeloa.addColumn("id_contacto");
        modeloa.addColumn("");
        modeloa.addColumn("Telefono");
        modeloa.addColumn("Correo");
        modeloa.addColumn("Fecha Creación");

        table1.setModel(modeloa);
        table1.setRowHeight(30); // Altura de las filas

        String[] dato = new String[5];

        Connection con = connectionC.getConnection();

        try
        {
            table1.getColumnModel().getColumn(0).setMinWidth(0);
            table1.getColumnModel().getColumn(0).setMaxWidth(0);
            table1.getColumnModel().getColumn(0).setWidth(0);

            table1.getColumnModel().getColumn(2).setMinWidth(0);
            table1.getColumnModel().getColumn(2).setMaxWidth(0);
            table1.getColumnModel().getColumn(2).setWidth(0);

            table1.getColumnModel().getColumn(3).setMinWidth(0);
            table1.getColumnModel().getColumn(3).setMaxWidth(0);
            table1.getColumnModel().getColumn(3).setWidth(0);

            table1.getColumnModel().getColumn(4).setMinWidth(0);
            table1.getColumnModel().getColumn(4).setMaxWidth(0);
            table1.getColumnModel().getColumn(4).setWidth(0);


            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM contactos");


            while (rs.next())
            {

                dato[0] = rs.getString(1);
                dato[1] = rs.getString(2);
                dato[2] = rs.getString(3);
                dato[3] = rs.getString(4);
                dato[4] = rs.getString(5);

                modeloa.addRow(dato);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public class NonEditableTableModel extends DefaultTableModel {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }



    public static void main(String[] args) {

        JFrame frame = new JFrame("Data Base Contact");
        ContactosGUI contactosGUI = new ContactosGUI(); // Se pasa el frame al constructor de Menu
        frame.setContentPane(contactosGUI.main);
//          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500,600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }


}
