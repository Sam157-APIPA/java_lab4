package org.example;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // просто передаём строку с путём к файлу
            List<Person> people = CsvReader.readPeopleFromCsv("people.csv");

            System.out.println("Прочитано: " + people.size() + " человек");
            for (Person p : people) {
                System.out.printf("%s, %s, %s, %s, %.2f, %s%n",
                        p.getId(),
                        p.getName(),
                        p.getGender(),
                        p.getDepartment().getName(),
                        p.getSalary(),
                        p.getBirthDate());
            }
        } catch (IOException | CsvValidationException | ParseException e) {
            e.printStackTrace();
        }
    }
}