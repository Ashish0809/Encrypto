import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ThirdScreen {
    ThirdScreen(String enc) {
        JFrame frame = new JFrame("Encrypt Your Text");
        JPanel panel_top = new JPanel();
        JPanel panel_middle = new JPanel();
        JPanel panel_down = new JPanel();

        JLabel label_desc = new JLabel("Input your text and Click on encrypt to begin encrption");
        JLabel label_TEXT = new JLabel("TEXT");
        JTextField tf_text = new JTextField();
        JLabel label_KEY = new JLabel("KEY");
        JLabel label_key = new JLabel();
        JLabel label_CIPHER = new JLabel("CIPHER TEXT");
        JLabel label_ctext = new JLabel();

        JButton butt_clear = new JButton("Clear");
        JButton butt_back = new JButton("Back");
        JButton butt_encrypt = new JButton("Encrypt");

        JPopupMenu jpmenu = new JPopupMenu("Copy Menu");
        JMenuItem m_copy_cipherText = new JMenuItem("Copy Cipher Text");
        JMenuItem m_copy_Key = new JMenuItem("Copy Key");

        jpmenu.add(m_copy_Key);
        jpmenu.add(m_copy_cipherText);

        label_desc.setBounds(100, 100, 500, 50);
        panel_top.add(label_desc);
        panel_top.setLayout(null);
        panel_top.setBackground(Color.decode("#92ED2C"));

        label_TEXT.setBounds(50, 50, 100, 50);
        tf_text.setBounds(150, 50, 500, 50);
        label_KEY.setBounds(50, 100, 100, 50);
        label_key.setBounds(150, 100, 500, 50);
        label_CIPHER.setBounds(50, 150, 100, 50);
        label_ctext.setBounds(150, 150, 500, 50);

        panel_middle.add(label_TEXT);
        panel_middle.add(tf_text);
        panel_middle.add(label_KEY);
        panel_middle.add(label_key);
        panel_middle.add(label_CIPHER);
        panel_middle.add(label_ctext);
        panel_middle.setLayout(null);
        panel_middle.setBackground(Color.white);

        butt_back.setBounds(50, 50, 80, 30);
        butt_clear.setBounds(250, 50, 80, 30);
        butt_encrypt.setBounds(700, 50, 80, 30);

        butt_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new SecondPage();
            }
        });
        butt_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf_text.setText("");
                label_ctext.setText("");
                label_key.setText("");
            }
        });
        butt_encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tf_text.getText().trim().equals(""))
                    JOptionPane.showMessageDialog(null, "Please enter text first.", "Error", JOptionPane.ERROR_MESSAGE);

                else {
                    if (enc.equals("Blowfish")) {
                        JOptionPane.showMessageDialog(null, "Encrypting using Blowfish");
                        label_ctext.setText("Blowfish cipher");
                        label_key.setText("blowfish key");
                    }
                    if (enc.equals("AES")) {
                        JOptionPane.showMessageDialog(null, "Encrypting using AES");
                        label_ctext.setText("AES CIPHER");
                        label_key.setText("AES KEY");
                    }
                    if (enc.equals("3DES")) {
                        JOptionPane.showMessageDialog(null, "Encrypting using DES");
                        label_ctext.setText("DES CIPHER");
                        label_key.setText("DES KEY");
                    }
                    if (enc.equals("MD5")) {
                        JOptionPane.showMessageDialog(null, "Encrypting using md5");
                        label_ctext.setText("MD5 cipher");
                        label_key.setText("Md5 key");
                    }
                    if (enc.equals("SHA")) {
                        JOptionPane.showMessageDialog(null, "Encrypting using sha256");
                        label_ctext.setText("SHA CIPHER");
                        label_key.setText("SHA key");
                    }
                }
            }
        });

        panel_down.add(butt_back);
        panel_down.add(butt_clear);
        panel_down.add(butt_encrypt);
        panel_down.setBackground(Color.white);

        panel_top.setBounds(0, 0, 800, 200);
        panel_middle.setBounds(0, 200, 800, 300);
        panel_down.setBounds(0, 500, 800, 100);

        frame.add(panel_top);
        frame.add(panel_middle);
        frame.add(panel_down);
        frame.add(jpmenu);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jpmenu.show(frame,e.getX(),e.getY());
            }
        });
        m_copy_cipherText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Cipher Text Copied");
            }
        });
        m_copy_Key.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Key copied");
            }
        });

    }

}
