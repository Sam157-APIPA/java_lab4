package org.example;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Утилитный класс для чтения информации о людях из CSV-файла.
 * <p>
 * Файл должен находиться в ресурсах проекта и использовать в качестве разделителя символ ';'.
 * Каждая строка CSV ожидается в формате:
 * <pre>
 * ID;Имя;Пол;НазваниеПодразделения;Зарплата;ДатаРождения(yyyy-MM-dd)
 * </pre>
 * Для каждого уникального подразделения генерируется свой ID вида D1, D2, ….
 * </p>
 */
public class CsvReader {

    /**
     * Считывает список людей из CSV-файла и возвращает его в виде {@link List} объектов {@link Person}.
     * <p>
     * Каждая запись CSV преобразуется в объект {@code Person}, а для каждого подразделения создаётся
     * объект {@code Department} с автоматически генерируемым ID.
     * </p>
     *
     * @param csvFilePath относительный путь к CSV-файлу в ресурсах (например, "people.csv")
     * @return список объектов {@link Person}, прочитанных из файла
     * @throws FileNotFoundException      если ресурс по указанному пути не найден
     * @throws IOException                при ошибках ввода-вывода при чтении файла
     * @throws CsvValidationException     если строка CSV не соответствует ожидаемому формату
     * @throws ParseException             если не удалось распарсить дату рождения
     */
    public static List<Person> readPeopleFromCsv(String csvFilePath)
            throws IOException, CsvValidationException, ParseException {
        InputStream in = CsvReader.class.getClassLoader().getResourceAsStream(csvFilePath);
        if (in == null) {
            throw new FileNotFoundException("Не найден ресурс: " + csvFilePath);
        }

        CSVParser parser = new CSVParserBuilder()
                .withSeparator(';')
                .build();

        List<Person> peopleList = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int departmentCounter = 1;

        try (CSVReader reader = new CSVReaderBuilder(new InputStreamReader(in))
                .withCSVParser(parser)
                .build()) {

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String personId    = nextLine[0];
                String name        = nextLine[1];
                String gender      = nextLine[2];
                String deptName    = nextLine[3];
                double salary      = Double.parseDouble(nextLine[4]);
                Date birthDate     = dateFormat.parse(nextLine[5]);

                // Генерируем уникальный ID подразделения
                Department dept = new Department("D" + (departmentCounter++), deptName);
                Person p = new Person(personId, name, gender, dept, salary, birthDate);
                peopleList.add(p);
            }
        }

        return peopleList;
    }
}
