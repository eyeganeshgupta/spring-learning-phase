package com.ems.enums;

public enum EmploymentStatus {
    FULL_TIME("Full-time"),
    PART_TIME("Part-time"),
    CONTRACT("Contract"),
    INTERN("Intern");

    private final String displayValue;

    EmploymentStatus(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    @Override
    public String toString() {
        return displayValue;
    }

    public static EmploymentStatus fromDisplayValue(String displayValue) {
        for (EmploymentStatus status : EmploymentStatus.values()) {
            if (status.getDisplayValue().equalsIgnoreCase(displayValue)) {
                return status;
            }
        }
        throw new IllegalArgumentException("No enum constant for value: " + displayValue);
    }
}
