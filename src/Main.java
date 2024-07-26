import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Login login = new Login(null);
        User user = login.user;
        if(user != null){
            System.out.println("Inicio exitoso: "+ user.getUsuario());
        }else{
            System.out.println("Iniciado Fallido");
        }
    }
}