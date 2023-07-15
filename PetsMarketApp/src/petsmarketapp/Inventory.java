package petsmarketapp;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private static List<Product> products = new ArrayList<>();
    
    public static void addProduct(Product product) {
        products.add(product);
    }
    
    public static void updateProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCode().equals(product.getCode())) {
                products.set(i, product);
                break;
            }
        }
    }
    
    public static void removeProduct(Product product) {
        products.remove(product);
    }
    
    public static Product getProductByCode(String code) {
        for (Product product : products) {
            if (product.getCode().equals(code)) {
                return product;
            }
        }
        return null;
    }
    
    public static String[] getAreaOptions() {
        String[] areas = { "Alimentos", "Artículos", "Medicamentos" };
        return areas;
    }
    
    public static void showProductMenu() {
        String area = (String) JOptionPane.showInputDialog(
            null,
            "Seleccione un área:",
            "Selección de área",
            JOptionPane.PLAIN_MESSAGE,
            null,
            getAreaOptions(),
            getAreaOptions()[0]
        );
        
        if (area != null) {
            List<Product> areaProducts = getProductsByArea(area);
            showProducts(areaProducts);
        }
    }
    
    public static List<Product> getProductsByArea(String area) {
        List<Product> areaProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.getArea().equalsIgnoreCase(area)) {
                areaProducts.add(product);
            }
        }

        return areaProducts;
    }
    
    private static void showProducts(List<Product> products) {
        StringBuilder sb = new StringBuilder();
        
        for (Product product : products) {
            sb.append("Código: ").append(product.getCode()).append("\n");
            sb.append("Nombre: ").append(product.getName()).append("\n");
            sb.append("Tipo de animal: ").append(product.getAnimalType()).append("\n");
            sb.append("Precio: ").append(product.getPrice()).append("\n");
            sb.append("Cantidad: ").append(product.getQuantity()).append("\n");
            sb.append("--------------------------\n");
        }
        
        JOptionPane.showMessageDialog(null, sb.toString(), "Productos Disponibles", JOptionPane.PLAIN_MESSAGE);
    }
}
