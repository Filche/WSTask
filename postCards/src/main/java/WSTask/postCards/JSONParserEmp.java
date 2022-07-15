package WSTask.postCards;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JSONParserEmp {

    public List<Employee> parse() throws IOException, ParseException {

        List<Employee> employeeList = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        FileReader fileReader = new FileReader("D:/Программирование/Java/PostCards/postCards/src/main/resources/cardsInfo.json");
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
            JSONArray jsonArrayEmployees = (JSONArray) jsonObject.get("employees");
            for(Object obj : jsonArrayEmployees){
                JSONObject employee = (JSONObject) obj;
                JSONObject post = (JSONObject) employee.get("post");

                Object[] strings = {employee.get("firstName"),
                        employee.get("lastName"),
                        employee.get("description"),
                        employee.get("characteristics"),
                        post.get("id"),
                        post.get("name")};

                employeeList.add(Employee.builder()
                                .firstName((String) strings[0])
                                .lastName((String) strings[1])
                                .description((String) strings[2])
                                .characteristics((String) strings[3])
                                .post(new Post(UUID.fromString((String) strings[4]), (String) strings[5]))
                        .build());
            }
        return employeeList;
    }
}
