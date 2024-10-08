package com.ems.enums;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private final String displayValue;

    Gender(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    @Override
    public String toString() {
        return displayValue;
    }

    public static Gender fromDisplayValue(String displayValue) {
        for (Gender gender : Gender.values()) {
            if (gender.getDisplayValue().equalsIgnoreCase(displayValue)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("No enum constant for value: " + displayValue);
    }
}
