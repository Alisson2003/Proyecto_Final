import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Compra extends JDialog {
    private JTextField nombre;
    private JTextField apellido;
    private JTextField cedula;
    private JTextField codigo;
    private JButton REGISTRARButton;
    private JTextField codigoBorrar;
    private JButton MODIFICARButton;
    private JButton ELIMINARButton;
    private JButton LIMPIARButton;
    private JTextArea textArea1;
    private JPanel compraPanel;

    public Compra(JFrame parent) {
        super(parent);
        setTitle("---- Registro de Compra -----");
        setContentPane(compraPanel);
        setMinimumSize(new Dimension(900, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        REGISTRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nombre = nombre.getText();
                String Apellido = apellido.getText();
                String Cedula = cedula.getText();
                String Codigo = codigo.getText();

                String URL = "jdbc:mysql://localhost:3306/productos";
                String USER = "root";
                String PASSWORD = "";

                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String sql = "INSERT INTO CLIENTE (nombre, apellido, cedula, codigo) VALUES (?,?,?,?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        preparedStatement.setString(1, Nombre);
                        preparedStatement.setString(2, Apellido);
                        preparedStatement.setString(3, Cedula);
                        preparedStatement.setString(4, Codigo);

                        preparedStatement.executeUpdate();
                        JOptionPane.showMessageDialog(null, " Conexion exitosa");

                        String notaVenta = generarnotaVenta(Nombre,Apellido,Cedula,Codigo);
                        textArea1.setText(notaVenta);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Error al registrar la compra" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        MODIFICARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Codigo = codigo.getText();
                String Nombre = nombre.getText();
                String Apellido = apellido.getText();
                String Cedula = cedula.getText();

                String URL = "jdbc:mysql://localhost:3306/productos";
                String USER = "root";
                String PASSWORD = "";

                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String sql = "UPDATE cliente SET nombre =?, apellido =?, cedula=? WHERE codigo =?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        preparedStatement.setString(1, Nombre);
                        preparedStatement.setString(2, Apellido);
                        preparedStatement.setString(3, Cedula);
                        preparedStatement.setString(4, Codigo);

                        preparedStatement.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Sus datos han sido modificados exitosamente");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Datos no modificados" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        ELIMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String CodigoBorrar = codigoBorrar.getText();

                String URL = "jdbc:mysql://localhost:3306/productos";
                String USER = "root";
                String PASSWORD = "";

                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String sql = "DELETE FROM cliente WHERE codigo =?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        preparedStatement.setString(1, CodigoBorrar);

                        int statement = preparedStatement.executeUpdate();
                        if (statement > 0) {
                            JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al eliminar el producto");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Error al eliminar los datos" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        LIMPIARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombre.setText("");
                apellido.setText("");
                cedula.setText("");
                codigo.setText("");
                codigoBorrar.setText("");
                textArea1.setText("");
            }
        });
    }

    private String generarnotaVenta(String nombre, String apellido, String cedula, String codigo) {
        return "\n ---------- REPUESTOS AUTOMOTRIZ ----------" +
                "\n ------- NOTA DE VENTA -------" +
                "\n  ---- SISTEMA DE FACTURACION ----" +
                "\n " +
                "\n Nombre: " + nombre +
                "\n Apellido: " + apellido +
                "\n Cedula: " + cedula +
                "\n Codigo: " + codigo +
                "\n FECHA: " + new java.util.Date() +
                "\n ----- GRACIAS POR SU COMPRA -----" +
                "\n ----- SOMOS UNICOS EN CALIDAD Y SERVICIO -----" +
                "\n ----- EXCELENTE DIA :) -----";
    }
}