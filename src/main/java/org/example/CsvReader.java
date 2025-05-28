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

public class CsvReader {
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
                String personId     = nextLine[0];
                String name         = nextLine[1];
                String gender       = nextLine[2];
                String deptName     = nextLine[3];
                double salary       = Double.parseDouble(nextLine[4]);
                Date birthDate      = dateFormat.parse(nextLine[5]);

                Department dept = new Department("D" + (departmentCounter++), deptName);
                Person p = new Person(personId, name, gender, dept, salary, birthDate);
                peopleList.add(p);
            }
        }

        return peopleList;
    }
}