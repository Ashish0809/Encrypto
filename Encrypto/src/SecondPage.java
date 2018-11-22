import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SecondPage {
    SecondPage() {
        JFrame frame=new JFrame("Encryption");
        JPanel panel_top=new JPanel();
        JPanel panel_down=new JPanel();

        JLabel label_show=new JLabel("Choose your encryption!");
        JButton butt_des=new JButton(" SDES");
        JButton butt_3des=new JButton(new ImageIcon("H:\\Java\\Projects\\Encrypto\\src\\des_icon.png"));
        JButton butt_blowfish=new JButton(new ImageIcon("H:\\Java\\Projects\\Encrypto\\src\\Blowfish_icon.jpg"));
        JButton butt_back=new JButton(new ImageIcon("H:\\Java\\Projects\\Encrypto\\src\\Back_icon.png"));
        JButton butt_image=new JButton("Steganography");

        butt_blowfish.setBackground(Color.white);
        butt_3des.setBackground(Color.white);
        butt_des.setBackground(Color.white);
        butt_back.setBackground(Color.white);
        butt_image.setBackground(Color.white);

        butt_blowfish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new ThirdScreen("Blowfish");

            }
        });
        butt_3des.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new TripleDesView();

            }
        });
        butt_des.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame.setVisible(false);
                new ThirdScreen("AES");

            }
        });
        butt_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                FirstScreen.main(null);
            }
        });
        butt_image.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.setVisible(false);

            }
        });
        label_show.setBounds(10,10,200,30);
        panel_top.setBackground(Color.decode("#92ED2C"));
        panel_top.add(label_show);
        panel_top.setLayout(null);
        panel_top.setSize(400,50);
        panel_top.setBounds(0,0,400,50);

        panel_down.add(butt_des);
        panel_down.add(butt_3des);
        panel_down.add(butt_blowfish);
        panel_down.add(butt_back);
        panel_down.add(butt_image);
        panel_down.setSize(400,300);

        panel_down.setBackground(Color.LIGHT_GRAY);
        panel_down.setLayout(new GridLayout(2,2));
        panel_down.setBounds(0,50,400,300);

        frame.add(panel_top);frame.add(panel_down);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MouseListener ml=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)) {

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
    }

    public static void main (String as[]) {
        new SecondPage();
    }
}
