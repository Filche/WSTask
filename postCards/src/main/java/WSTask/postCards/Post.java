package WSTask.postCards;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@ToString
public class Post {

    private UUID id;
    private String name;
}
