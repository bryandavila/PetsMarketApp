
package petsmarketapp;


public class Sale {
    private Customer customer;
    private Product product;
    private int quantity;
    private double totalWithIVA;

    public Sale(Customer customer, Product product, int quantity, double totalWithIVA) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.totalWithIVA = totalWithIVA;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalWithIVA() {
        return totalWithIVA;
    }

    public void setTotalWithIVA(double totalWithIVA) {
        this.totalWithIVA = totalWithIVA;
    }
    
}
