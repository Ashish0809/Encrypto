import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TripleDes_decryptView {
    TripleDes_decryptView() {
        JFrame frame = new JFrame("Decrypt Your Text from TripleDES");
        JPanel panel_top = new JPanel();
        JPanel panel_middle = new JPanel();
        JPanel panel_down = new JPanel();

        JLabel label_desc = new JLabel("Input your text and Click on decrypt to begin decryption");
        JLabel label_TEXT = new JLabel("Cipher TEXT");
        JTextField tf_text = new JTextField();
        JLabel label_KEY = new JLabel("KEY-1");
        JTextField label_key = new JTextField();
        JLabel label_KEY2= new JLabel("KEY-2");
        JTextField label_key2=new JTextField();
        JLabel label_KEY3 = new JLabel("KEY-3");
        JTextField label_key3 = new JTextField();

        JLabel label_CIPHER = new JLabel("Plain TEXT");
        JLabel label_ctext = new JLabel();

        JButton butt_clear = new JButton("Clear");
        JButton butt_back = new JButton("Back");
        JButton butt_encrypt = new JButton("decrypt");

        JPopupMenu jpmenu = new JPopupMenu("Copy Menu");
        JMenuItem m_copy_cipherText = new JMenuItem("Copy Plain Text");

        jpmenu.add(m_copy_cipherText);

        label_desc.setBounds(100, 100, 500, 50);
        panel_top.add(label_desc);
        panel_top.setLayout(null);
        panel_top.setBackground(Color.decode("#92ED2C"));

        label_TEXT.setBounds(50, 50, 100, 50);
        tf_text.setBounds(150, 50, 500, 50);
        label_KEY.setBounds(50, 100, 100, 50);
        label_key.setBounds(150, 100, 500, 50);
        label_KEY2.setBounds(50,150,100,50);
        label_key2.setBounds(150,150,500,50);
        label_KEY3.setBounds(50,200,100,50);
        label_key3.setBounds(150,200,500,50);
        label_CIPHER.setBounds(50, 250, 100, 50);
        label_ctext.setBounds(150, 250, 500, 50);

        panel_middle.add(label_TEXT);
        panel_middle.add(tf_text);
        panel_middle.add(label_KEY);
        panel_middle.add(label_key);
        panel_middle.add(label_KEY2);
        panel_middle.add(label_key2);
        panel_middle.add(label_KEY3);
        panel_middle.add(label_key3);
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
                label_key2.setText("");
                label_key3.setText("");
            }
        });
        butt_encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tf_text.getText().trim().equals("") || label_key.getText().equals("") || label_key2.getText().equals("") || label_key3.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Please enter text and all the keys first.", "Error", JOptionPane.ERROR_MESSAGE);

                else {
                    String key1=label_key.getText();
                    String key2=label_key2.getText();
                    String key3=label_key3.getText();

                    TripleDES_backend_decryption ob=new TripleDES_backend_decryption(key1,key2,key3);

                    try {
                        //ob.readData();
                       // ob.readCipher(tf_text.getText());
                        ob.readData();
                        ob.decrypt();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null,"Error occured during decryption","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    label_ctext.setText("Hello there looks fine!");
                    JOptionPane.showMessageDialog(null,"Decrypted from 3DES");
                }
            }
        });

        panel_down.add(butt_back);
        panel_down.add(butt_clear);
        panel_down.add(butt_encrypt);
        panel_down.setBackground(Color.white);

        panel_top.setBounds(0, 0, 800, 100);
        panel_middle.setBounds(0, 100, 800, 400);
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
                JOptionPane.showMessageDialog(null,"Opening Clipboard");
                Clipboard ob=new Clipboard(tf_text.getText());
                ob.viewClipboard2();
            }
        });

    }

}
