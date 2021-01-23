package info.dddeurope.lab.app.eventHandlers;

import info.dddeurope.lab.app.dtos.PostDto;
import info.dddeurope.lab.app.events.PostPublishedEvent;
import info.dddeurope.lab.app.views.PostsIndex;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostPublishedEventHandler {

    PostsIndex index;

    public void handle(PostPublishedEvent event) throws Exception {
        final PostDto postDto = event.getPostDto();
        index.indexPost(event.getPostId(), postDto.getTitle(), postDto.getBody(), postDto.getPublisherId());
    }
}
