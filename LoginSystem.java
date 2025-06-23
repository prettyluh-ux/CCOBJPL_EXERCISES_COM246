import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }
}

public class LoginSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Step 1: Get user input
        System.out.print("Enter username: ");
        String enteredUsername = input.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = input.nextLine();

        // Step 2: Create User object from input
        User user = new User(enteredUsername, enteredPassword);

        // Step 3: Check against accounts.txt
        boolean isAuthenticated = false;

        try {
            File file = new File("accounts.txt");
            Scanner fileScanner = new Scanner(file);

            // Step 4: Read each line of the file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 2) {
                    String fileUsername = parts[0].trim();
                    String filePassword = parts[1].trim();

                    // Check if input matches any line
                    if (fileUsername.equals(user.getUsername()) &&
                        filePassword.equals(user.getPassword())) {
                        isAuthenticated = true;
                        break;
                    }
                }
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("accounts.txt file not found.");
            return;
        }

        // Step 5: Display result
        if (isAuthenticated) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }

        input.close();
    }
}