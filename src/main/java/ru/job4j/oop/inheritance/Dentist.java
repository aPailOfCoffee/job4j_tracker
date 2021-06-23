package ru.job4j.oop.inheritance;

public class Dentist extends Doctor {

    private boolean dentistLicense;

    public Dentist(String name,
                   String surname,
                   boolean education,
                   String birthday,
                   String university,
                   boolean dentistLicense) {
        super(name, surname, education, birthday, university);
        this.dentistLicense = dentistLicense;
    }

    public boolean getDentistLicense() {
        return  dentistLicense;
    }

    public void cleanTeeth(Pacient pacient) {
    }

    public void drillTeeth(Pacient pacient, Diagnosis diagnosis) {
    }
}
