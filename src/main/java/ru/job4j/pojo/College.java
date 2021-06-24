package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student ivan = new Student();
        ivan.setFullName("Ivan Ivanov");
        ivan.setGroup(174);
        ivan.setAdmissionDate(new Date());
        String info = "Name: " + ivan.getFullName()
                + System.lineSeparator()
                + "Group: " + ivan.getGroup()
                + System.lineSeparator()
                + "Admission Date :" + ivan.getAdmissionDate()
                + System.lineSeparator();

        System.out.println(info);
    }
}
