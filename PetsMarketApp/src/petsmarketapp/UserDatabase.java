
package petsmarketapp;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private static List<User> users = new ArrayList<>();
    
    public static void addUser(User user) {
        users.add(user);
    }
    
    public static void updateUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(user.getUsername())) {
                users.set(i, user);
                break;
            }
        }
    }
    
    public static void deleteUser(User user) {
        users.remove(user);
    }
    
    public static User getUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        
        return null;
    }
    
    public static User getUserByCedula(String cedula) {
    for (User user : users) {
        if (user.getId().equals(cedula)) {
            return user;
        }
    }
    
    return null;
}
    
}
