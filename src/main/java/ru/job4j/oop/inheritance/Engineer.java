package ru.job4j.oop.inheritance;

public class Engineer extends Profession {

    private String industry;

    public Engineer(String name,
                    String surname,
                    boolean education,
                    String birthday,
                    String industry) {
        super(name, surname, education, birthday);
        this.industry = industry;
    }

    public String getIndustry() {
        return industry;
    }

    public String analysis(Project project) {
        return "";
    }
}
