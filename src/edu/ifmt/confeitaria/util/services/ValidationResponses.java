package edu.ifmt.confeitaria.util.services;

public enum ValidationResponses {
    VALID("Valid"),
    INVALID("The value is invalid"),
    ALREADY_EXISTS("The value already exists"),
    REQUIRED_FIELD("The value is required"),
    MAX_LENGTH_EXCEEDED("The value exceeds the maximum length"),
    MIN_LENGTH_NOT_REACHED("The value does not reach the minimum length"),
    MAX_VALUE_EXCEEDED("The value exceeds the maximum value"),
    BELOW_MIN_VALUE("The value is below the minimum value");

    private final String description;

    private ValidationResponses(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
