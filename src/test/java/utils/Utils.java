package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Utils {
    public static void scroll(WebDriver driver, int height){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, "+height+")");
    }

    public static void scrollBottom(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public static void pageZoom(WebDriver driver, int percentage) {
        if (percentage < 10 || percentage > 500) {
            throw new IllegalArgumentException("Zoom level must be between 10 and 500%");
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='" + percentage + "%'");
    }

    public static String generateRandomPhoneNumber() {
        Random random = new Random();
        String fixedPrefix = "0171"; // Fixed first four digits
        // Generate the remaining 7 digits
        int remainingDigits = 1000000 + random.nextInt(9000000); // Ensures it's between 1000000 and 9999999

        return fixedPrefix+remainingDigits;
    }

    public static String generateRandomPassword() {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String numeric = "0123456789";
        String specialChar = "!@#$%^&*/";
        String allChar = upperCase + lowerCase + numeric + specialChar;

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        // Ensure at least one character from each group
        password.append(upperCase.charAt(random.nextInt(upperCase.length())));
        password.append(lowerCase.charAt(random.nextInt(lowerCase.length())));
        password.append(numeric.charAt(random.nextInt(numeric.length())));
        password.append(specialChar.charAt(random.nextInt(specialChar.length())));

        // Add remaining characters from allChar to make it 10 total
        for (int i = 4; i < 10; i++) {
            password.append(allChar.charAt(random.nextInt(allChar.length())));
        }

        // Shuffle to avoid predictable character position
        List<Character> chars = new ArrayList<>();
        for (char c : password.toString().toCharArray()) {
            chars.add(c);
        }
        Collections.shuffle(chars);

        StringBuilder finalPassword = new StringBuilder();
        for (char c : chars) {
            finalPassword.append(c);
        }

        return finalPassword.toString();
    }

}