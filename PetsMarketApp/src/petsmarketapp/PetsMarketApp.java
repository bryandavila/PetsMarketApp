
package petsmarketapp;

import javax.swing.JOptionPane;

public class PetsMarketApp {

    public static void main(String[] args) {
        User user = new User("Nombre", "Apellido", "ID", "Rol");
        UserDatabase.addUser(user);

        boolean exit = false;
        
        while (!exit) {
            String option = showMenu();
            
            switch (option) {
                case "1":
                    login();
                    break;
                case "2":
                    exit = true;
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar PetsMarket! Hasta luego.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }
    
    private static String showMenu() {
        String[] options = { "Iniciar sesión", "Salir" };
        return (String) JOptionPane.showInputDialog(
            null,
            "Bienvenido a PetsMarket. Seleccione una opción:",
            "PetsMarket",
            JOptionPane.PLAIN_MESSAGE,
            null,
            options,
            options[0]
        );
    }
    
    private static void login() {
        String username = JOptionPane.showInputDialog(null, "Ingrese su nombre de usuario:");
        String password = JOptionPane.showInputDialog(null, "Ingrese su contraseña:");
    
        // Validar el usuario y su rol
        User user = UserDatabase.getUser(username, password);
    
        if (user != null) {
            if (user.getRole().equals("Vendedor")) {
                SellerMenu.showSellerMenu(user);
            } else if (user.getRole().equals("Gerente")) {
                ManagerMenu.showManagerMenu(user);
              }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos. Por favor, intente nuevamente.");
        }
    }
}
