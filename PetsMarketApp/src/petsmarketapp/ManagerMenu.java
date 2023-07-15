package petsmarketapp;

import javax.swing.JOptionPane;

public class ManagerMenu {
    public static void showManagerMenu(User user) {
        boolean exit = false;
        
        while (!exit) {
            String option = showMenu(user);
            
            switch (option) {
                case "1":
                    controlUsuarios();
                    break;
                case "2":
                    ventas(user);
                    break;
                case "3":
                    inventario();
                    break;
                case "4":
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
        String[] options = { "Control de usuarios", "Ventas", "Inventario", "Cerrar sesión" };
        return (String) JOptionPane.showInputDialog(
            null,
            "Bienvenido(a), " + user.getName() + ". Seleccione una opción:",
            "Menú del Gerente",
            JOptionPane.PLAIN_MESSAGE,
            null,
            options,
            options[0]
        );
    }
    
    private static void controlUsuarios() {
        boolean exit = false;
        
        while (!exit) {
            String option = showControlUsuariosMenu();
            
            switch (option) {
                case "1":
                    registrarUsuario();
                    break;
                case "2":
                    modificarUsuario();
                    break;
                case "3":
                    eliminarUsuario();
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }
    
    private static String showControlUsuariosMenu() {
        String[] options = { "Registrar usuario", "Modificar usuario", "Eliminar usuario", "Volver" };
        return (String) JOptionPane.showInputDialog(
            null,
            "Control de Usuarios\nSeleccione una opción:",
            "Control de Usuarios",
            JOptionPane.PLAIN_MESSAGE,
            null,
            options,
            options[0]
        );
    }
    
    private static void registrarUsuario() {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del usuario:");
        String apellidos = JOptionPane.showInputDialog(null, "Ingrese los apellidos del usuario:");
        String cedula = JOptionPane.showInputDialog(null, "Ingrese la cédula del usuario:");
        String rol = JOptionPane.showInputDialog(null, "Ingrese el rol del usuario:");
        
        User newUser = new User(nombre, apellidos, cedula, rol);
        UserDatabase.addUser(newUser);
        
        JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private static void modificarUsuario() {
        String cedula = JOptionPane.showInputDialog(null, "Ingrese la cédula del usuario a modificar:");
        User user = UserDatabase.getUserByCedula(cedula);
        
        if (user != null) {
            String nombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre del usuario:");
            String apellidos = JOptionPane.showInputDialog(null, "Ingrese los nuevos apellidos del usuario:");
            String rol = JOptionPane.showInputDialog(null, "Ingrese el nuevo rol del usuario:");
            
            user.setName(nombre);
            user.setLastName(apellidos);
            user.setRole(rol);
            
            JOptionPane.showMessageDialog(null, "Usuario modificado exitosamente.", "Modificación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private static void eliminarUsuario() {
        String cedula = JOptionPane.showInputDialog(null, "Ingrese la cédula del usuario a eliminar:");
        User user = UserDatabase.getUserByCedula(cedula);
        
        if (user != null) {
            UserDatabase.deleteUser(user);
            JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente.", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private static void ventas(User user) {
        Sales.makeSale(user);
    }
    
    private static void inventario() {
        boolean exit = false;
        
        while (!exit) {
            String option = showInventarioMenu();
            
            switch (option) {
                case "1":
                    mostrarProductos();
                    break;
                case "2":
                    agregarProducto();
                    break;
                case "3":
                    modificarProducto();
                    break;
                case "4":
                    eliminarProducto();
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }
    
    private static String showInventarioMenu() {
        String[] options = { "Mostrar productos", "Agregar producto", "Modificar producto", "Eliminar producto", "Volver" };
        return (String) JOptionPane.showInputDialog(
            null,
            "Inventario\nSeleccione una opción:",
            "Inventario",
            JOptionPane.PLAIN_MESSAGE,
            null,
            options,
            options[0]
        );
    }
    
    private static void mostrarProductos() {
        Inventory.showProductMenu();
    }
    
    private static void agregarProducto() {
        String codigo = JOptionPane.showInputDialog(null, "Ingrese el código del producto:");
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto:");
        String tipoAnimal = JOptionPane.showInputDialog(null, "Ingrese el tipo de animal del producto:");

        double precio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el precio del producto:"));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad del producto:"));
        String area = JOptionPane.showInputDialog(null, "Ingrese el área del producto:");

        Product newProduct = new Product(codigo, nombre, tipoAnimal, precio, cantidad, area);
        Inventory.addProduct(newProduct);

        JOptionPane.showMessageDialog(null, "Producto agregado exitosamente.", "Agregación Exitosa", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void modificarProducto() {
        String codigo = JOptionPane.showInputDialog(null, "Ingrese el código del producto a modificar:");
        Product product = Inventory.getProductByCode(codigo);

        if (product != null) {
            String nombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre del producto:");
            String tipoAnimal = JOptionPane.showInputDialog(null, "Ingrese el nuevo tipo de animal del producto:");
            double precio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el nuevo precio del producto:"));
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la nueva cantidad del producto:"));
            String area = JOptionPane.showInputDialog(null, "Ingrese el nueva área del producto:");

            product.setName(nombre);
            product.setAnimalType(tipoAnimal);
            product.setPrice(precio);
            product.setQuantity(cantidad);
            product.setArea(area);

            JOptionPane.showMessageDialog(null, "Producto modificado exitosamente.", "Modificación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void eliminarProducto() {
        String codigo = JOptionPane.showInputDialog(null, "Ingrese el código del producto a eliminar:");
        Product product = Inventory.getProductByCode(codigo);

        if (product != null) {
            Inventory.removeProduct(product);
            JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente.", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}