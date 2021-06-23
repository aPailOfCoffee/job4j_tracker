package ru.job4j.oop.inheritance;

public class Doctor extends Profession {

    private String university;

    public Doctor(String name,
                  String surname,
                  boolean education,
                  String birthday,
                  String university) {
        super(name, surname, education, birthday);
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }

    public Diagnosis heal(Pacient pacient) {
        Diagnosis diagnosis = new Diagnosis();
        return  diagnosis;
    }

    public String medication(Pacient pacient, Diagnosis diagnosis) {
        return "";
    }
}
