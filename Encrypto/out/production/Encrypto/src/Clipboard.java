import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;

public class Clipboard {
    private String tf1,tf2,tf3,tf4;
    private String plaintext;
    Clipboard(String t) {
        this.plaintext=t;
    }
    Clipboard(String tf1,String tf2,String tf3,String tf4) {
        this.tf1=tf1;
        this.tf2=tf2;
        this.tf3=tf3;
        this.tf4=tf4;
    }
    public void viewClipboard() {
        JFrame frame=new JFrame("Clipboard");
        JTextField tf_field1=new JTextField();
        JTextField tf_field2=new JTextField();
        JTextField tf_field3=new JTextField();
        JTextField tf_field4=new JTextField();

        tf_field1.setText(tf1);
        tf_field2.setText(tf2);
        tf_field3.setText(tf3);
        tf_field4.setText(tf4);

        frame.add(tf_field1);
        frame.add(tf_field2);
        frame.add(tf_field3);
        frame.add(tf_field4);
        frame.setSize(400,400);
        frame.setLayout(new GridLayout(4,1));
        frame.setVisible(true);
        frame.setResizable(false);
    }
    public void viewClipboard2() {
        JFrame frame=new JFrame("Clipboard");
        JTextField tf_field1=new JTextField(plaintext);

        frame.add(tf_field1);
        frame.setSize(400,400);
        frame.setLayout(new GridLayout(1,1));
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
