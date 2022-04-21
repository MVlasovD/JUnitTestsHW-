/*
 *
 * @author VMN
 *
 */

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Employee> listXML = Parser.parseXML("data.xml");
        String fileNameJson = "data2.json";
        String json = Parser.listToJson(listXML);
        Parser.writeString(json, fileNameJson);
    }
}