package ru.job4j.oop.inheritance;

public class Profession {
    private String name, surname, birthday;
    private boolean education;

    public Profession(String name, String surname, boolean education, String birthday) {

        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean getEducation() {
        return  education;
    }

    public String getBirthday() {
        return birthday;
    }
}
