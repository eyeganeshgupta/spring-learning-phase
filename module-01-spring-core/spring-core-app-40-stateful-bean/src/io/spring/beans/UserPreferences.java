package io.spring.beans;

// In this example, UserPreferences is a stateful bean because it maintains user-specific settings like theme and language.

public class UserPreferences {
    // Properties
    private String theme;
    private String language;

    // Constructor
    public  UserPreferences() {
        System.out.println("UserPreferences bean created.");
    }

    public UserPreferences(String theme, String language) {
        this.theme = theme;
        this.language = language;
    }

    // Getters and Setters
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    // Method to display UserPreferences properties in a decorative manner
    public void displayDetails() {
        String border = "*********************************";
        String header = String.format("%-15s : %s", "User Preferences", "");
        String line1 = String.format("%-15s : %s", "Theme", theme);
        String line2 = String.format("%-15s : %s", "Language", language);

        System.out.println(border);
        System.out.println(header);
        System.out.println(border);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(border);
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "UserPreferences{" +
                "theme='" + theme + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
