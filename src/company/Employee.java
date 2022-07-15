package company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Employee implements Serializable {
    private String firstName;
    private String lastName;
    private String description;
    private String characteristics;
    private Post post;

    @Override
    public String toString(){
        return "Employee( firstName = " + firstName + ", lastName = " + lastName +
                ", description = " + description + ", characteristics = " + characteristics +
                ", postId = " + post.getId() + ")";
    }
}
