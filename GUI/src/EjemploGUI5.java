import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EjemploGUI5 extends JFrame {

    public EjemploGUI5() {
        setTitle("Ejemplo de BorderLayout"); 
        
        setLocation(300, 500);
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout()); 

        JPanel panel1, panel2, panel3, panel4, panel5;

        panel1 = new JPanel();
        panel1.add(new JLabel("Panel 1"));

        panel2 = new JPanel();
        panel2.add(new JLabel("Panel 2"));

        panel3 = new JPanel();
        panel3.add(new JLabel("Panel 3"));

        panel4 = new JPanel();
        panel4.add(new JLabel("Panel 4"));

        panel5 = new JPanel();
        panel5.add(new JLabel("Panel 5"));

        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.SOUTH);
        add(panel3, BorderLayout.EAST);
        add(panel4, BorderLayout.WEST);
        add(panel5, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploGUI5();
    }
}