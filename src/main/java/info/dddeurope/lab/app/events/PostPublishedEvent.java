package info.dddeurope.lab.app.events;

import info.dddeurope.lab.app.dtos.PostDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostPublishedEvent {
    String postId;
    PostDto postDto;
}
