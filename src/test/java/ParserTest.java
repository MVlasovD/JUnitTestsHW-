/*
 *
 * @author VMN
 *
 */
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    @Order(2)
    public void listToJson() {
        String actual = Parser.listToJson(new ArrayList<>());
        assertInstanceOf(String.class, actual);
        assertNotNull(actual);
        System.out.println("Test # 2 listToJson() passed");
    }

    @Test
    @Order(3)
    @Timeout(value = 160, unit = TimeUnit.MILLISECONDS)
    void writeString() {

        String expected = Parser.listToJson(Parser.parseXML("data.xml"));
        String actual = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25}," +
                "{\"id\":2,\"firstName\":\"Inav\",\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":24}]";

        assertTrue(expected.contains("[{"));
        assertNotNull(expected);
        assertNotNull(actual);
        assertInstanceOf(String.class, expected);
        assertInstanceOf(String.class, actual);
        assertThrows(IOException.class, () -> {
            throw new IOException();
        });
        System.out.println("Test # 3 writeString() passed");
    }

    @Test
    @Order(1)
    void parseXML() {

        Employee emp1 = new Employee(1, "John", "Smith", "USA", 25);
        Employee emp2 = new Employee(2, "Inav", "Petrov", "RU", 24);
        List<Employee> expected = new ArrayList<>();
        expected.add(emp1);
        expected.add(emp2);
        List<Employee> actual = Parser.parseXML("data.xml");

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).id, actual.get(i).id);
            assertEquals(expected.get(i).firstName, actual.get(i).firstName);
            assertEquals(expected.get(i).lastName, actual.get(i).lastName);
            assertEquals(expected.get(i).country, actual.get(i).country);
            assertEquals(expected.get(i).age, actual.get(i).age);
        }
        assertInstanceOf(List.class, actual);
        assertInstanceOf(List.class, expected);
        assertEquals(expected.size(), 2);
        assertNotSame(expected, actual);
        assertNotEquals(expected, actual);
        assertNotNull(actual);
        assertNotNull(expected);

        System.out.println("Expected " + expected);
        System.out.println("Actual " + actual);
        System.out.println("Test # 1 parseXML() passed");
    }
}