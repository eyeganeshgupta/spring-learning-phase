package io.spring.beans;

public class Programmer {
    // Properties
    private String name;
    private String language;
    private int experience;
    private String favoriteEditor;
    private int projectsCompleted;
    private String githubProfile;

    // Constructor
    public Programmer() {
        System.out.println("Programmer object created!");
    }

    public Programmer(String name, String language, int experience, String favoriteEditor, int projectsCompleted, String githubProfile) {
        this.name = name;
        this.language = language;
        this.experience = experience;
        this.favoriteEditor = favoriteEditor;
        this.projectsCompleted = projectsCompleted;
        this.githubProfile = githubProfile;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getFavoriteEditor() {
        return favoriteEditor;
    }

    public void setFavoriteEditor(String favoriteEditor) {
        this.favoriteEditor = favoriteEditor;
    }

    public int getProjectsCompleted() {
        return projectsCompleted;
    }

    public void setProjectsCompleted(int projectsCompleted) {
        this.projectsCompleted = projectsCompleted;
    }

    public String getGithubProfile() {
        return githubProfile;
    }

    public void setGithubProfile(String githubProfile) {
        this.githubProfile = githubProfile;
    }

    // Method to display programmer details in an impressive manner
    public void displayDetails() {
        String border = "=========================================";
        String header = String.format("%-20s : %s", "Programmer Details", "");
        String line1 = String.format("%-20s : %s", "Name", name);
        String line2 = String.format("%-20s : %s", "Language", language);
        String line3 = String.format("%-20s : %d", "Experience (years)", experience);
        String line4 = String.format("%-20s : %s", "Favorite Editor", favoriteEditor);
        String line5 = String.format("%-20s : %d", "Projects Completed", projectsCompleted);
        String line6 = String.format("%-20s : %s", "GitHub Profile", githubProfile);

        System.out.println(border);
        System.out.println(header);
        System.out.println(border);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
        System.out.println(line6);
        System.out.println(border);
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Programmer{" +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", experience=" + experience +
                ", favoriteEditor='" + favoriteEditor + '\'' +
                ", projectsCompleted=" + projectsCompleted +
                ", githubProfile='" + githubProfile + '\'' +
                '}';
    }
}
