package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("ivan");
        student.setSecondName("ivanovich");
        student.setFamilyName("ivanov");
        student.setEntry("01/09/2019");
        student.setGroup("123f");

        System.out.println(student.getName() + " " + student.getSecondName() + " " + student.getFamilyName()
                + " " + student.getGroup() + " " + student.getEntry());
    }
}
