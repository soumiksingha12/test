import java.util.Scanner;

public class SignInApp {
    private static AuthenticationSystem authSystem = new AuthenticationSystem();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("   Welcome to Sign-In System");
        System.out.println("=================================\n");
        
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    signIn();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("\nThank you for using the Sign-In System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.\n");
            }
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("Please select an option:");
        System.out.println("1. Sign In");
        System.out.println("2. Register New User");
        System.out.println("3. Exit");
        System.out.print("\nEnter your choice (1-3): ");
    }
    
    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void signIn() {
        System.out.println("\n--- Sign In ---");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        if (authSystem.signIn(username, password)) {
            System.out.println("\n✓ Sign-in successful! Welcome, " + username + "!\n");
        } else {
            System.out.println("\n✗ Sign-in failed. Invalid username or password.\n");
        }
    }
    
    private static void register() {
        System.out.println("\n--- Register New User ---");
        System.out.print("Choose a username: ");
        String username = scanner.nextLine();
        
        if (authSystem.userExists(username)) {
            System.out.println("\n✗ Username already exists. Please choose a different username.\n");
            return;
        }
        
        System.out.print("Choose a password: ");
        String password = scanner.nextLine();
        
        if (password.length() < 6) {
            System.out.println("\n✗ Password must be at least 6 characters long.\n");
            return;
        }
        
        if (authSystem.registerUser(username, password)) {
            System.out.println("\n✓ Registration successful! You can now sign in.\n");
        } else {
            System.out.println("\n✗ Registration failed. Please try again.\n");
        }
    }
}
