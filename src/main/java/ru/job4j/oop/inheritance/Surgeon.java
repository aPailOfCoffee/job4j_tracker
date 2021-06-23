package ru.job4j.oop.inheritance;

public class Surgeon extends Doctor {

    private boolean surgeonLicence;

    public Surgeon(String name,
                   String surname,
                   boolean education,
                   String birthday,
                   String university,
                   boolean surgeonLicence) {
        super(name, surname, education, birthday, university);
        this.surgeonLicence = surgeonLicence;
    }

    public boolean getSurgeonLicence() {
        return surgeonLicence;
    }

    public void chiropractic(Pacient pacient, Diagnosis diagnosis) {
    }
}
