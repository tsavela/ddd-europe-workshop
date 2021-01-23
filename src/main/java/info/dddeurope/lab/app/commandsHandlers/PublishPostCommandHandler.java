package info.dddeurope.lab.app.commandsHandlers;

import info.dddeurope.lab.app.commands.PublishPostCommand;
import info.dddeurope.lab.app.domain.PostAggregate.Post;
import info.dddeurope.lab.app.domain.UserAggregate.Age;
import info.dddeurope.lab.app.domain.UserAggregate.User;
import info.dddeurope.lab.app.dtos.PostDto;
import info.dddeurope.lab.app.repositories.PostRepository;
import info.dddeurope.lab.app.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PublishPostCommandHandler {
    
    PostRepository postRepository;
    UserRepository userRepository;

    public PostPublishedEvent handle(PublishPostCommand publishPostCommand) throws Exception {
        
        final String postId = publishPostCommand.getPostId();
        final PostDto postDto = publishPostCommand.getPostDto();

        Post post = new Post(postId, postDto.getPublisherId(), postDto.getTitle(), postDto.getBody(), new Age(postDto.getMinAge()));
        User publisher = userRepository.get(postDto.getPublisherId());

        publisher.publishPost(post);

        postRepository.set(postId, post);
        userRepository.set(postDto.getPublisherId(), publisher);

        return new PostPublishedEvent(postId, postDto); 
        
    } 

}
