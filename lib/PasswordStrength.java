package lib;
public enum PasswordStrength {
    INVALID("Password does not meet minimum requirements."),
    WEAK("Password is too weak. Consider adding more complexity."),
    MEDIUM("Password is of medium strength. Could be stronger."),
    STRONG("Password is strong!");

    private final String message;

    PasswordStrength(String message) {
        this.message = message;
    }

    /**
     * Returns the message associated with this PasswordStrength. The message
     * describes the strength of the password in a human-readable way.
     * @return The message associated with this PasswordStrength.
     */
    public String getMessage() {
        return message;
    }
}