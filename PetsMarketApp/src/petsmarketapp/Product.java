package petsmarketapp;


public class Product {
    private String code;
    private String name;
    private String animalType;
    private double price;
    private int quantity;
    private String area;
    
    public Product(String code, String name, String animalType, double price, int quantity, String area) {
        this.code = code;
        this.name = name;
        this.animalType = animalType;
        this.price = price;
        this.quantity = quantity;
        this.area = area;
    }
    
    // Getters y Setters
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAnimalType() {
        return animalType;
    }
    
    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getArea() {
        return area;
    }
    
    public void setArea(String area) {
        this.area = area;
    }
}

