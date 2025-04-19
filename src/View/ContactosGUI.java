package View;

import javax.swing.*;

public class ContactosGUI {



    private JPanel main;

    public ContactosGUI(JFrame frame)
    {






    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Data Base Contact");
        ContactosGUI contactosGUI = new ContactosGUI(frame); // Se pasa el frame al constructor de Menu
        frame.setContentPane(contactosGUI.main);
//          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(320,210);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }


}
