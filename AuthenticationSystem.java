import java.util.HashMap;
import java.util.Map;

public class AuthenticationSystem {
    private Map<String, User> users;
    
    public AuthenticationSystem() {
        users = new HashMap<>();
        // Pre-register some demo users
        registerUser("admin", "admin123");
        registerUser("user1", "password123");
    }
    
    public boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; // User already exists
        }
        users.put(username, new User(username, password));
        return true;
    }
    
    public boolean signIn(String username, String password) {
        User user = users.get(username);
        if (user == null) {
            return false; // User not found
        }
        return user.authenticate(password);
    }
    
    public boolean userExists(String username) {
        return users.containsKey(username);
    }
}
