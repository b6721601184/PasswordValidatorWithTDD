package lib;

public class PasswordValidatorTest {

    /**
     * Runs a series of assertion-style test cases to validate the logic of the
     * PasswordValidator class, specifically the getPasswordStrength() method.
     * Each test case prints out a message indicating whether the test passed
     * or failed, along with the expected and actual results.
     */
    public static void run() {

        System.out.println("==== Running Password Validator Tests ====");

        // 1. Strong password
        String p1 = "MyStrongP@ssw0rd!"; // Should be STRONG
        PasswordStrength s1 = PasswordValidator.validate.getPasswordStrength(p1);
        if (s1 == PasswordStrength.STRONG) {
            System.out.println("Test Case 1 Passed: '" + p1 + "' is STRONG.");
        } else {
            System.out.println("Test Case 1 FAILED: Expected STRONG but got " + s1);
        }

        // 2. Too short, simple => INVALID
        String p2 = "weak";
        PasswordStrength s2 = PasswordValidator.validate.getPasswordStrength(p2);
        if (s2 == PasswordStrength.INVALID) {
            System.out.println("Test Case 2 Passed: '" + p2 + "' is INVALID.");
        } else {
            System.out.println("Test Case 2 FAILED: Expected INVALID but got " + s2);
        }

        // 3. Medium password: good length, but missing special char
        String p3 = "MediumPass1";
        PasswordStrength s3 = PasswordValidator.validate.getPasswordStrength(p3);
        if (s3 == PasswordStrength.MEDIUM) {
            System.out.println("Test Case 3 Passed: '" + p3 + "' is MEDIUM.");
        } else {
            System.out.println("Test Case 3 FAILED: Expected MEDIUM but got " + s3);
        }

        // 4. Weak password: contains common word
        String p4 = "user123password";
        PasswordStrength s4 = PasswordValidator.validate.getPasswordStrength(p4);
        if (s4 == PasswordStrength.WEAK) {
            System.out.println("Test Case 4 Passed: '" + p4 + "' is WEAK.");
        } else {
            System.out.println("Test Case 4 FAILED: Expected WEAK but got " + s4);
        }

        // 5. WEAK, may look medium at first but contains common word
        String p5 = "abcDEF123"; 
        PasswordStrength s5 = PasswordValidator.validate.getPasswordStrength(p5);
        if (s5 == PasswordStrength.WEAK) {
        System.out.println("Test Case 5 Passed: '" + p5 + "' is WEAK.");
        } else {
        System.out.println("Test Case 5 FAILED: Expected WEAK but got " + s5);
        }

        // 6. Common numeric => INVALID
        String p6 = "12345678";
        PasswordStrength s6 = PasswordValidator.validate.getPasswordStrength(p6);
        if (s6 == PasswordStrength.INVALID) {
            System.out.println("Test Case 6 Passed: '" + p6 + "' is INVALID.");
        } else {
            System.out.println("Test Case 6 FAILED: Expected INVALID but got " + s6);
        }

        // 7. Very strong password: long, mixed chars, special chars
        String p7 = "AlphaOmegaDelta!9ZuluXray7";
        PasswordStrength s7 = PasswordValidator.validate.getPasswordStrength(p7);
        if (s7 == PasswordStrength.STRONG) {
            System.out.println("Test Case 7 Passed: '" + p7 + "' is STRONG.");
        } else {
            System.out.println("Test Case 7 FAILED: Expected STRONG but got " + s7);
        }

        // 8. Edge case: null input => INVALID
        String p8 = null;
        PasswordStrength s8 = PasswordValidator.validate.getPasswordStrength(p8);
        if (s8 == PasswordStrength.INVALID) {
            System.out.println("Test Case 8 Passed: null password is INVALID.");
        } else {
            System.out.println("Test Case 8 FAILED: Expected INVALID but got " + s8);
        }

        // 9. Edge case: empty string => INVALID
        String p9 = "";
        PasswordStrength s9 = PasswordValidator.validate.getPasswordStrength(p9);
        if (s9 == PasswordStrength.INVALID) {
            System.out.println("Test Case 9 Passed: empty password is INVALID.");
        } else {
            System.out.println("Test Case 9 FAILED: Expected INVALID but got " + s9);
        }

        System.out.println("--------------------------------");
    }
}
