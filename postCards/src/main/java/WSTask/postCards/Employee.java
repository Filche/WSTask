package WSTask.postCards;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Employee {

    private String firstName;
    private String lastName;
    private String description;
    private String characteristics;
    private Post post;
}
