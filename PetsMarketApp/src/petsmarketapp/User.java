
package petsmarketapp;

public class User {
    private String name;
    private String lastName;
    private String id;
    private String role;
    private String username;
    private String password;
    
    public User(String name, String lastName, String id, String role) {
    this.name = name;
    this.lastName = lastName;
    this.id = id;
    this.role = role;
    this.username = ""; // Valor predeterminado para username
    this.password = ""; // Valor predeterminado para password
}
    
    // Getters y Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


