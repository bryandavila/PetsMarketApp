package petsmarketapp;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Sales {
    private static List<Sale> sales = new ArrayList<>();

    private static List<Customer> customers = new ArrayList<>(); // Lista para almacenar los clientes registrados

    public static void makeSale(User user) {
        String cedula = JOptionPane.showInputDialog(null, "Ingrese la cédula del cliente:");

        Customer customer = getCustomerByCedula(cedula);

        if (customer == null) {
            // El cliente no está registrado, se procede a registrarlo
            String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente:");
            String apellidos = JOptionPane.showInputDialog(null, "Ingrese los apellidos del cliente:");

            customer = new Customer(nombre, apellidos, cedula);
            addCustomer(customer);
        }
        
        String[] options = { "Alimentos", "Artículos", "Medicamentos" };
        String area = (String) JOptionPane.showInputDialog(
            null,
            "Seleccione un área:",
            "Selección de área",
            JOptionPane.PLAIN_MESSAGE,
            null,
            options,
            options[0]
        );
        
        if (area != null) {
            List<Product> areaProducts = Inventory.getProductsByArea(area);
            
            if (areaProducts.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay productos disponibles en el área seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Product selectedProduct = selectProduct(areaProducts);
            
            if (selectedProduct != null) {
                int quantity = selectQuantity(selectedProduct);
                
                if (quantity > selectedProduct.getQuantity()) {
                    JOptionPane.showMessageDialog(null, "No hay suficiente stock del producto seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    double totalPrice = calculateTotalPrice(selectedProduct.getPrice(), quantity);
                    double totalWithIVA = applyIVA(totalPrice);
                    
                    addToCart(customer, selectedProduct, quantity, totalWithIVA);
                    
                    JOptionPane.showMessageDialog(null, "¡Venta realizada exitosamente!\nTotal a pagar (con IVA): $" + totalWithIVA, "Venta Exitosa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
    
        private static Customer getCustomerByCedula(String cedula) {
        for (Customer customer : customers) {
            if (customer.getCedula().equals(cedula)) {
                return customer;
            }
        }
        return null;
    }

    private static void addCustomer(Customer customer) {
        customers.add(customer);
    }
   
    private static Product selectProduct(List<Product> products) {
        String[] productNames = new String[products.size()];
        
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            productNames[i] = product.getName() + " - Cantidad: " + product.getQuantity();
        }
        
        String selectedProduct = (String) JOptionPane.showInputDialog(
            null,
            "Seleccione un producto:",
            "Selección de producto",
            JOptionPane.PLAIN_MESSAGE,
            null,
            productNames,
            productNames[0]
        );
        
        if (selectedProduct != null) {
            int selectedIndex = findProductIndex(selectedProduct, productNames);
            
            if (selectedIndex != -1) {
                return products.get(selectedIndex);
            }
        }
        
        return null;
    }
    
    private static int selectQuantity(Product product) {
        int maxQuantity = product.getQuantity();
        String quantityStr = JOptionPane.showInputDialog(null, "Ingrese la cantidad a comprar (máximo " + maxQuantity + "):");
        
        if (quantityStr != null) {
            try {
                int quantity = Integer.parseInt(quantityStr);
                
                if (quantity > 0 && quantity <= maxQuantity) {
                    return quantity;
                }
            } catch (NumberFormatException e) {
                // Ignorar y continuar al flujo de error
            }
        }
        
        JOptionPane.showMessageDialog(null, "Cantidad inválida.", "Error", JOptionPane.ERROR_MESSAGE);
        return selectQuantity(product);
    }
    
    private static int findProductIndex(String productName, String[] productNames) {
        for (int i = 0; i < productNames.length; i++) {
            if (productNames[i].equals(productName)) {
                return i;
            }
        }
        
        return -1;
    }
    
    private static double calculateTotalPrice(double price, int quantity) {
        return price * quantity;
    }
    
    private static double applyIVA(double totalPrice) {
        return totalPrice * 1.13;
    }
    
    private static void addToCart(Customer customer, Product product, int quantity, double totalWithIVA) {
        Sale sale = new Sale(customer, product, quantity, totalWithIVA);
        sales.add(sale);
        
        // Actualizar la cantidad de productos en el inventario
        product.setQuantity(product.getQuantity() - quantity);
    }
}
