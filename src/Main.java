import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Login login = new Login(null);
        login.setVisible(true);

        if (login.user != null){
            System.out.println("Inicio de sesion correctamente" + login.user.getUsuario());

            Menu menu = new Menu(null);
            menu.setVisible(true);

            Compra compra = new Compra(null);
            compra.setVisible(true);

            Productos productos = new Productos(null);
            productos.setVisible(true);

        }else {
            System.out.println("Inicio de sesion incorrecta");

            System.exit(0);
        }
    }

}