package yaroslav.superChat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Администратор on 03.12.2014.
 */
public class ClienForm extends JFrame{
    private JPanel rootPanel;
    protected JButton send;
    private JTextArea monitor;
    private JPanel inputPanel;
    protected JTextField textField;


    public ClienForm (){
        super("SuperChat Client");
        setContentPane(rootPanel);
        setSize(500,800);
        monitor.setLineWrap(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }



    public void showMessage(String s){
        monitor.setText(monitor.getText() + "\n" + s);
    }
}
