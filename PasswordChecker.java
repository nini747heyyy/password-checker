import java.util.Scanner;
public class PasswordChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Password Strength Checker");
        System.out.println("============================\n");

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        if(password.length() < 8) {
            System.out.println("Too short! Minimum 8 characters required.");
            scanner.close();
            return;
        }

        for(char c : password.toCharArray()) {
            if(Character.isUpperCase(c)) hasUppercase = true;
            else if(Character.isLowerCase(c)) hasLowercase = true;
            else if(Character.isDigit(c)) hasDigit = true;
            else if(!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        System.out.println("\n Password Analysis:");
        System.out.println("Length: " + password.length() + " characters");
        System.out.println("Uppercase letters: " + (hasUppercase ? "✅" : "❌"));
        System.out.println("Lowercase letters: " + (hasLowercase ? "✅" : "❌"));
        System.out.println("Digits: " + (hasDigit ? "✅" : "❌"));
        System.out.println("Special characters: " + (hasSpecial ? "✅" : "❌"));

        int score = 0;
        if(hasUppercase) score++;
        if(hasLowercase) score++;
        if(hasDigit) score++;
        if(hasSpecial) score++;
        if(password.length() >= 12) score++;

        System.out.println("\n💪 Strength: " + getStrength(score));

        scanner.close();
    }

    static String getStrength(int score) {
        switch(score) {
            case 5: return "VERY STRONG 💪";
            case 4: return "STRONG 👍";
            case 3: return "GOOD 😊";
            case 2: return "WEAK 👎";
            default: return "VERY WEAK 💔";
        }
    }
}
