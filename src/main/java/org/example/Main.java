package org.example;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Главный класс приложения для чтения и отображения списка людей из CSV-файла.
 * <p>
 * Использует {@link CsvReader} для загрузки данных и выводит их в консоль.
 * Поддерживаются обработка ошибок ввода-вывода, валидации CSV и разбора дат.
 * </p>
 */
public class Main {

    /**
     * Точка входа в приложение.
     * <p>
     * Считывает данные о людях из CSV-файла, находящегося в ресурсах под именем "people.csv",
     * и выводит в консоль количество прочитанных записей и подробную информацию о каждом человеке.
     * В случае ошибок при чтении или парсинге выводит стек трейс.
     * </p>
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        try {
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