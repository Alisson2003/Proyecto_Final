import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JDialog {
    private JPanel menuPanel;
    private JButton cajero;
    private JButton administrador;

    public Menu(JFrame parent) {
        super(parent);
        setTitle("Login Principal");
        setContentPane(menuPanel);
        setMinimumSize(new Dimension(500, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        administrador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            dispose();
            Login login = new Login(parent);
            login.setVisible(true);
            }
        });

        cajero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login(parent);
                login.setVisible(true);
            }
        });
        setVisible(true);
    }
}
