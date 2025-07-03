package lib;
import java.util.regex.Pattern;

public class PasswordValidator {
    public static class validate {
        
        private static final String HAS_UPPERCASE_REGEX = ".*[A-Z].*";
        private static final String HAS_LOWERCASE_REGEX = ".*[a-z].*";
        private static final String HAS_DIGIT_REGEX = ".*\\d.*";
        private static final String HAS_SPECIAL_CHAR_REGEX = ".*[^a-zA-Z0-9].*";

        private static final int MIN_LENGTH = 8;
        private static final int MAX_LENGTH = 64;
        
        /**
         * Determine the strength of a given password string, based on the criteria
         * listed below. This method will return one of four possible enum values
         * indicating the strength of the password.
         *
         * Criteria:
         *
         * 1. Length: Password must be at least 8 characters long and at most 64
         * characters long. Bonus points for longer passwords.
         *
         * 2. Character types: Password must contain at least one of each of the
         * following types of characters:
         *
         * a. Uppercase letter
         * b. Lowercase letter
         * c. Digit
         * d. Special character
         *
         * 3. Common patterns: Password cannot contain any of the following common
         * patterns:
         *
         * a. "password"
         * b. "123456"
         * c. "abcdef"
         *
         * The final strength is determined by the following score system:
         *
         * 5 points or higher: STRONG
         * 3-4 points: MEDIUM
         * 1-2 points: WEAK
         * 0 points or fewer: INVALID
         *
         * @param password The password string to evaluate.
         * @return One of four PasswordStrength enum values, indicating the strength
         * of the given password.
         * @author 6721601184 || TANAKORN TRONGKINGTON
         */
        public static PasswordStrength getPasswordStrength(String password) {
        if (password == null || password.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        // Initialize score
        int score = 0;

        // 1. Length validation
        if (password.length() < MIN_LENGTH || password.length() > MAX_LENGTH) {
            return PasswordStrength.INVALID;
        } else if (password.length() >= MIN_LENGTH && password.length() <= MAX_LENGTH) {
            score += 1; // Basic length requirement met
            if (password.length() >= 12) { // Bonus for longer passwords
                score += 1;
            }
        }

        // 2. Character type validation and scoring
        if (Pattern.matches(HAS_UPPERCASE_REGEX, password)) {
            score += 1;
        }
        if (Pattern.matches(HAS_LOWERCASE_REGEX, password)) {
            score += 1;
        }
        if (Pattern.matches(HAS_DIGIT_REGEX, password)) {
            score += 1;
        }
        if (Pattern.matches(HAS_SPECIAL_CHAR_REGEX, password)) {
            score += 1;
        }

        // 3. Deductions for common patterns 
        if (password.toLowerCase().contains("password") ||
            password.toLowerCase().contains("123456") ||
            password.toLowerCase().contains("abcdef")) {
            score -= 2; 
        }

        // Ensure score doesn't go below zero
        if (score < 0) {
            score = 0;
        }

        // Determine strength based on score
        if (score >= 5) { 
            return PasswordStrength.STRONG;
        } else if (score >= 3) {
            return PasswordStrength.MEDIUM;
        } else if (score >= 1) { 
            return PasswordStrength.WEAK;
        } else {
            return PasswordStrength.INVALID;
        }
    }

        /**
        * A utility method to check if a password meets the absolute minimum
        * requirements to be considered "valid" (i.e., not INVALID).
        * This can be used for initial submission checks.
        * @param password The password string to check.
        * @return true if the password is not of INVALID strength, false otherwise.
        */
        public static boolean isValidForSubmission(String password) {
            return getPasswordStrength(password) != PasswordStrength.INVALID;
        }
    
    }
}