package View;

import Controller.ContactosDAO;
import Model.Contactos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;

public class GUIAgregar {
    private JPanel main;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton agregarButton;
    private JButton cancelarButton;
    ContactosDAO contactosDAO = new ContactosDAO();
    private ContactosGUI contactosGUI;



    public GUIAgregar(ContactosGUI contactosGUI) {
        this.contactosGUI = contactosGUI;
        agregarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        LocalDate today = LocalDate.now();
        textField4.setText(today.toString());
        textField4.setEditable(false);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textField1.getText();
                String telefono = textField2.getText();
                String correo = textField3.getText();
                String fecha = textField4.getText();


                Contactos contactos = new Contactos(0, nombre,telefono,correo,fecha);
                contactosDAO.agregar(contactos);
                contactosGUI.listaContacto();
                limpiar();

            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((JFrame) SwingUtilities.getWindowAncestor(cancelarButton)).dispose();

            }
        });
    }


    public void limpiar(){
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
    }




    public void ejecutar(){

        JFrame frame = new JFrame("Data Base Contact");

        frame.setContentPane(this.main);
//          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(390,320);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
