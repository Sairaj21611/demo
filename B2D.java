import java.util.Scanner;

public class B2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a binary number: ");
        String binaryString = scanner.nextLine();

        // Checking if the input is a valid binary number
        if (!isValidBinary(binaryString)) {
            System.out.println("Invalid binary number.");
            return;
        }

        // Converting binary to decimal
        int decimal = binaryToDecimal(binaryString);
        System.out.println("Decimal equivalent: " + decimal);

        scanner.close();
    }

    // Method to check if the input string is a valid binary number
    public static boolean isValidBinary(String binary) {
        for (char c : binary.toCharArray()) {
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }

    // Method to convert binary to decimal
    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        int power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return decimal;
    }
}

