package company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private final static Map<UUID, Post> posts = new HashMap<>();

    public static void main(String[] args) throws IOException{
        Path filePath = Path.of("D:\\Программирование\\Java\\PostCards\\text.txt");
        File file = new File(String.valueOf(filePath));
        String regexString2 = "(\n*firstName: )(.+)(\nlastName: )(.+)(\ndescription: )(.*)(\ncharacteristics: )(.+)(\npostId: )(.+)";
        String regexString1 = "(.+\n.+\n.+\n.+\n.+)";
        List<Employee> employees = new ArrayList<>(parse(read(file, regexString1), regexString2));
        print(employees);
        setPosts(employees);
    }

    public static List<String> read(File file, String regexString) throws IOException {

        List<String> stringList = Files.readAllLines(file.toPath());
        stringList.removeIf(str -> str.equals(""+""));
        StringBuilder stringBuilder = new StringBuilder();
        for(String str : stringList){
            stringBuilder.append(str + "\n");
        }

        stringList.removeAll(stringList);
        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(stringBuilder);
        while(matcher.find()){
            stringList.add(matcher.group(1));
        }

        return stringList;
    }

    public static List<Employee> parse(List<String> employees, String regexString){
        Pattern pattern = Pattern.compile(regexString);
        List<Employee> employeesList = new ArrayList<>();

        for(String str : employees){
            Matcher matcher = pattern.matcher(str);
            while(matcher.find()){
                employeesList.add(Employee.builder()
                                .firstName(matcher.group(2))
                                .lastName(matcher.group(4))
                                .description(matcher.group(6))
                                .characteristics(matcher.group(8))
                                .post(Post.builder()
                                        .id(UUID.fromString(matcher.group(10)))
                                        .name(matcher.group(2))
                                        .build())
                        .build());
            }
        }
        return employeesList;
    }

    public static void print(List<Employee> employees){
        employees.forEach(emp -> System.out.println(emp.toString()));
    }

    public static void setPosts(List<Employee> employees){
        for(Employee emp : employees){
            posts.put(emp.getPost().getId(),emp.getPost());
        }
    }
}