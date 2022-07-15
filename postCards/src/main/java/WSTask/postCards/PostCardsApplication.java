package WSTask.postCards;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class PostCardsApplication {

	public static void main(String[] args) throws IOException, ParseException {
		//SpringApplication.run(PostCardsApplication.class, args);

		JSONParserEmp jsonParserEmp = new JSONParserEmp();
		List<Employee> employeeList = jsonParserEmp.parse();

		employeeList.forEach(System.out::println);
		
	}

}
