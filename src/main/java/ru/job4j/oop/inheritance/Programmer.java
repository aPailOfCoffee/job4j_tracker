package ru.job4j.oop.inheritance;

public class Programmer extends Engineer {

    private String programingLanguage;
    private String level;

    public Programmer(String name,
                      String surname,
                      boolean education,
                      String birthday,
                      String industry,
                      String programingLanguage,
                      String level) {
        super(name, surname, education, birthday, industry);
        this.programingLanguage = programingLanguage;
        this.level = level;
    }

    public String getProgramingLanguage() {
        return programingLanguage;
    }

    public String getLevel() {
        return level;
    }

    public void code(Project project) {
    }
}
