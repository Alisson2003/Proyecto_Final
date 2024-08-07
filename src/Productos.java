import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Productos extends JDialog{
    private JPanel productosPanel;
    private JButton REGRESARButton;
    private JButton SIGUIENTEButton;

    public Productos(JFrame parent) {
        super(parent);
        setTitle("Productos");
        setContentPane(productosPanel);
        setMinimumSize(new Dimension(800, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        REGRESARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login(parent);
                login.setVisible(true);
            }
        });
        SIGUIENTEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Compra compra = new Compra(parent);
                compra.setVisible(true);
            }
        });
        setVisible(true);
    }
}
