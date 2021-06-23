package ru.job4j.oop.inheritance;

public class Builder extends Engineer {

    private boolean allowance;

    public Builder(String name,
                    String surname,
                    boolean education,
                    String birthday,
                    String industry,
                    boolean allowance) {
        super(name, surname, education, birthday, industry);
        this.allowance = allowance;
    }

    public  boolean getAllowance() {
        return allowance;
    }

    public void readDocumentation(Project project) {
    }

    public void build() {
    }
}
