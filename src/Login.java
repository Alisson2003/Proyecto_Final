import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JDialog {
    private JTextField Usuario;
    private JPasswordField Password;
    private JButton OK;
    private JButton cancelar;
    public JPanel loginPanel;

    public Login(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(475, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = Usuario.getText();
                String password = String.valueOf(Password.getPassword());

                user = getAuthenticatedUser(usuario, password);

                if(user != null){
                    dispose();
                    Productos productos = new Productos(parent);
                    productos.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(Login.this,
                            "Usuario o Password incorrecto",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
    public User user;
    private User getAuthenticatedUser(String usuario, String password){
        User user = null;

        String URL = "jdbc:mysql://localhost:3306/productos";
        String USER = "root";
        String PASSWORD = "";
        try{
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);

            String sql = "SELECT * FROM USUARIO WHERE username =? AND password =? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,usuario);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                user = new User();
                user.setUsuario(resultSet.getString("username"));
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
