import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstScreen {
    FirstScreen() {
        JFrame frame=new JFrame("Encrypto");
        JPanel panel_top=new JPanel();
        JPanel panel_bottom=new JPanel();

        JLabel label_banner=new JLabel(new ImageIcon("H:\\Java\\Projects\\Encrypto\\src\\Encrypto_welcome.png"));
        JButton butt_encryption=new JButton(new ImageIcon("H:\\Java\\Projects\\Encrypto\\src\\Lock_ency_icon.png"));
        JButton butt_decryption=new JButton(new ImageIcon("H:\\Java\\Projects\\Encrypto\\src\\Unlock_decr_icon.png"));

        label_banner.setBounds(0,100,500,40);
        panel_top.add(label_banner);
        panel_top.setLayout(null);
        panel_top.setBackground(Color.decode("#92ED2C"));

        butt_encryption.setBounds(50,50,200,85);
        butt_decryption.setBounds(50,150,200,85);

        butt_encryption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new SecondPage();
            }
        });
        butt_decryption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new DecrPage();
            }
        });

        panel_bottom.add(butt_encryption);
        panel_bottom.add(butt_decryption);
        panel_bottom.setLayout(null);
        panel_bottom.setBackground(Color.white);

        panel_top.setBounds(0,0,530,200);
        panel_bottom.setBounds(0,200,530,300);

        frame.add(panel_top);frame.add(panel_bottom);
        frame.setSize(530,500);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new FirstScreen();
    }
}
