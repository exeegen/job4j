package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String hospital;


    public String getHospital() {
        return hospital;
    }

    private String diagnose() {
        return "diagnose";
    }

    public String getCash() {
        return diagnose();
    }
}
