

import com.opencsv.exceptions.CsvValidationException;
import org.example.CsvReader;
import org.example.Person;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link CsvReader}.
 * <p>
 * - people_test.csv (валидные данные)
 * - people_invalid_date.csv (строки с некорректной датой)
 * </p>
 */
public class CsvReaderTest {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    void testReadPeopleFromCsv_success() throws IOException, CsvValidationException, ParseException {
        List<Person> people = CsvReader.readPeopleFromCsv("people_test.csv");
        assertEquals(3, people.size(), "Ожидается 3 записи в файле");

        Person first = people.get(0);
        assertEquals("1", first.getId());
        assertEquals("John Doe", first.getName());
        assertEquals("Male", first.getGender());
        assertEquals("HR", first.getDepartment().getName());
        assertEquals(5000.0, first.getSalary(), 0.01);
        assertEquals(DATE_FORMAT.parse("1985-03-15"), first.getBirthDate());
    }

    @Test
    void testReadPeopleFromCsv_fileNotFound() {
        assertThrows(FileNotFoundException.class, () ->
                        CsvReader.readPeopleFromCsv("nonexistent.csv"),
                "Должно выбрасываться FileNotFoundException при отсутствии файла");
    }

    @Test
    void testReadPeopleFromCsv_invalidDate() {
        assertThrows(ParseException.class, () ->
                        CsvReader.readPeopleFromCsv("people_invalid_date.csv"),
                "Должно выбрасываться ParseException при некорректном формате даты");
    }
}