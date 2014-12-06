package ua.artcode.week4.aplet_ex;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

/**
 *
 */
public class SimpleFormApplet extends Applet {

    private JLabel label;
    private JTextField field;
    private JButton okButton;

    public void init(){
        System.out.println("INIT OF APPLET");

        setLayout(new GridLayout(3,1));
        label = new JLabel("First applet");
        add(label);

        field = new JTextField("Input name");
        add(field);

        okButton = new JButton("Send some");
        add(okButton);
    }



}
