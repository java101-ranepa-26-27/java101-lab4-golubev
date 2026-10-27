package ru.ranepa;

public class Main {
    public static void main(String[] args) {
        University university = new University();
        Student anna = university.enroll("Анна");
        Teacher victor = university.hire("Виктор", "история");
        Student boris = university.enroll("Борис");

        university.grade(anna.getId(), 4);
        university.grade(anna.getId(), 5);
        university.grade(anna.getId(), 3);

        for (Person person : university.all()) {
            System.out.println(person.report());
        }

        try {
            university.grade(victor.getId(), 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Отказ: " + e.getMessage());
        }

        Person found = university.findByName("Виктор");
        System.out.println("Найден: " + found.report());

        try {
            university.findByName("Иван");
        } catch (IllegalArgumentException e) {
            System.out.println("Отказ: " + e.getMessage());
        }

        System.out.println("Средний балл Анны: " + university.average(anna.getId()));
    }
}