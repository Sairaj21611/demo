import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER_CHAR = "!@#$%&*()_+-=[]|,./?><";

    private static final String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;
    private static final SecureRandom secureRandom = new SecureRandom();

    public static void main(String[] args) {
        int passwordLength = 12;
        System.out.println("Generated Password: " + generatePassword(passwordLength));
    }

    public static String generatePassword(int length) {
        if (length < 4) {
            throw new IllegalArgumentException("Password length must be at least 4 characters.");
        }

        StringBuilder password = new StringBuilder(length);
        password.append(CHAR_LOWER.charAt(secureRandom.nextInt(CHAR_LOWER.length())));
        password.append(CHAR_UPPER.charAt(secureRandom.nextInt(CHAR_UPPER.length())));
        password.append(NUMBER.charAt(secureRandom.nextInt(NUMBER.length())));
        password.append(OTHER_CHAR.charAt(secureRandom.nextInt(OTHER_CHAR.length())));

        for (int i = 0; i < length - 4; i++) {
            int randomCharIndex = secureRandom.nextInt(PASSWORD_ALLOW_BASE.length());
            password.append(PASSWORD_ALLOW_BASE.charAt(randomCharIndex));
        }

        return shuffleString(password.toString());
    }

    // Implementing Fisher-Yates shuffle
    public static String shuffleString(String input) {
        char[] charArray = input.toCharArray();
        for (int i = charArray.length - 1; i > 0; i--) {
            int index = secureRandom.nextInt(i + 1);
            char temp = charArray[index];
            charArray[index] = charArray[i];
            charArray[i] = temp;
        }
        return new String(charArray);
    }
}

