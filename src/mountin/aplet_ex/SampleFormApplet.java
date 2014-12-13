package mountin.aplet_ex;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by mountin on 6/12/2014.
 */
public class SampleFormApplet extends Applet
{

    private JLabel label;
    private JButton okButton;
    private JTextField fields1;

    public void init(){
        setLayout( new GridLayout(3,2));
        JLabel label = new JLabel("First applet");
        fields1 = new JTextField("input name");

        add(fields1);
        okButton = new JButton("test button");
                add(okButton);



    }


}
