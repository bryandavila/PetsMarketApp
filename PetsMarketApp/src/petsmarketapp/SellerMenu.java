package petsmarketapp;

import javax.swing.JOptionPane;

public class SellerMenu {
    public static void showSellerMenu(User user) {
        boolean exit = false;
        
        while (!exit) {
            String option = showMenu(user);
            
            switch (option) {
                case "1":
                    // Mostrar ventas del vendedor
                    break;
                case "2":
                    exit = true;
                    JOptionPane.showMessageDialog(null, "Sesión cerrada. Hasta luego, " + user.getName() + "!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }
    
    private static String showMenu(User user) {
        String[] options = { "Ver ventas", "Cerrar sesión" };
        return (String) JOptionPane.showInputDialog(
            null,
            "Bienvenido(a), " + user.getName() + ". Seleccione una opción:",
            "Menú del Vendedor",
            JOptionPane.PLAIN_MESSAGE,
            null,
            options,
            options[0]
        );
    }
}
