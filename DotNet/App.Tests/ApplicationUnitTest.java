package info.dddeurope.lab.app;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

//import info.dddeurope.lab.app.commands.PublishPostCommand;
//import info.dddeurope.lab.app.commands.RegisterUserCommand;
//import info.dddeurope.lab.app.commandsHandlers.PublishPostCommandHandler;
//import info.dddeurope.lab.app.commandsHandlers.RegisterUserCommandHandler;
//import info.dddeurope.lab.app.dtos.PostDto;
//import info.dddeurope.lab.app.dtos.UserDto;
//import info.dddeurope.lab.app.eventHandlers.PostPublishedEventHandler;
//import info.dddeurope.lab.app.eventHandlers.UserRegisteredEventHandler;
//import info.dddeurope.lab.app.events.PostPublishedEvent;
//import info.dddeurope.lab.app.events.UserRegisteredEvent;
//import info.dddeurope.lab.app.queries.SearchPostByTextQuery;
//import info.dddeurope.lab.app.queryHandlers.SearchPostByTextQueryHandler;
//import info.dddeurope.lab.app.repositories.PostRepository;
//import info.dddeurope.lab.app.repositories.UserRepository;
//import info.dddeurope.lab.app.views.PostsIndex;
//import info.dddeurope.lab.app.views.SharingMap;
//import info.dddeurope.lab.app.views.SocialGraph;
import org.apache.lucene.document.Document;

public class ApplicationUnitTest {

    // Write Model repositories
    private UserRepository userRepository;
    private PostRepository postRepository;

    // Read Model datastores (denormalized views)
    private SocialGraph socialGraph;
    private PostsIndex postsIndex;
    private SharingMap sharingMap;

    @Before
    public void setUp() throws Exception {

        userRepository = new UserRepository();
        postRepository = new PostRepository();

        socialGraph = new SocialGraph();
        postsIndex = new PostsIndex();
        sharingMap = new SharingMap();

        // Create a command
        RegisterUserCommand registerUserCommand = new RegisterUserCommand("enatan", 
            new UserDto(
                "Eliran",
                "Natan",
                "eliran.natan.87@gmail.com",
                LocalDate.of(1987, 8, 10),
                "Loenen aan de Vecht")
        );
        
        // Send the command to the corresponding command handler
        RegisterUserCommandHandler registerUserCommandHandler = new RegisterUserCommandHandler(userRepository);
        UserRegisteredEvent userRegisteredEvent = registerUserCommandHandler.handle(registerUserCommand);

        // Send the event to the corresponding event handler
        UserRegisteredEventHandler userRegisteredEventHandler = new UserRegisteredEventHandler(socialGraph);
        userRegisteredEventHandler.handle(userRegisteredEvent);        

    }


    @Test
    public void shouldPublishPost() throws Exception {

        // Create a command
        PublishPostCommand publishPostCommand = new PublishPostCommand("6174897", new PostDto("enatan", "Event Sourcing with Java", "This is a post about event sourcing", 8));
        
        // Send the command to the corresponding command handler
        PublishPostCommandHandler publishPostCommandHandler = new PublishPostCommandHandler(postRepository, userRepository);
        PostPublishedEvent postPublishedEvent = publishPostCommandHandler.handle(publishPostCommand);

        // Send the event to the corresponding event handler
        PostPublishedEventHandler postPublishedEventHandler = new PostPublishedEventHandler(postsIndex);
        postPublishedEventHandler.handle(postPublishedEvent);
 
        // Send a text search query to find the new post
        SearchPostByTextQuery searchPostByTextQuery = new SearchPostByTextQuery("event");
        SearchPostByTextQueryHandler searchPostByTextQueryHandler = new SearchPostByTextQueryHandler(postsIndex);
        List<Document> posts = searchPostByTextQueryHandler.handle(searchPostByTextQuery);

        assertEquals("6174897", posts.get(0).get("id"));
        assertEquals("enatan", posts.get(0).get("publisherId"));

    }

    @Test
    public void shouldSharePost() throws Exception {}   
    
    @Test
    public void shouldMakeUsersFriends() throws Exception {}   

}



