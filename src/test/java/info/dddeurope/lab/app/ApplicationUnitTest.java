package info.dddeurope.lab.app;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import info.dddeurope.lab.app.commands.PublishPostCommand;
import info.dddeurope.lab.app.commands.RegisterUserCommand;
import info.dddeurope.lab.app.commandsHandlers.PublishPostCommandHandler;
import info.dddeurope.lab.app.commandsHandlers.RegisterUserCommandHandler;
import info.dddeurope.lab.app.dtos.User;
import info.dddeurope.lab.app.eventHandlers.UserRegisteredEventHandler;
import info.dddeurope.lab.app.events.UserRegisteredEvent;
import info.dddeurope.lab.app.repositories.PostRepository;
import info.dddeurope.lab.app.repositories.UserRepository;
import info.dddeurope.lab.app.views.PostsIndex;
import info.dddeurope.lab.app.views.SharingMap;
import info.dddeurope.lab.app.views.SocialGraph;

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
        RegisterUserCommand registerUserCommand = new RegisterUserCommand("eliranna", new User("Eliran", "Natan", "eliran.natan.87@gmail.com", new GregorianCalendar(1987, 8, 10).getTime(), "Loenen aan de Vecht"));
        
        // Send the command to the corresponding command handler
        RegisterUserCommandHandler registerUserCommandHandler = new RegisterUserCommandHandler();
        UserRegisteredEvent userRegisteredEvent = registerUserCommandHandler.handle(registerUserCommand);

        // Send the event to the corresponding event handler
        UserRegisteredEventHandler userRegisteredEventHandler = new UserRegisteredEventHandler(socialGraph);
        userRegisteredEventHandler.handle(userRegisteredEvent);        

    }

    @Test
    public void shouldPublishPost() throws Exception {

        // Create a command
        PublishPostCommand publishPostCommand = new PublishPostCommand(/* add fields */);
        
        // Send the command to the corresponding command handler
        PublishPostCommandHandler publishPostCommandHandler = new PublishPostCommandHandler();
        PostPublishedEvent postPublishedEvent = publishPostCommandHandler.handle(publishPostCommand);

        // Send the event to the corresponding event handler
        PostPublishedEventHandler postPublishedEventHandler = new PostPublishedEventHandler(postsIndex);
        postPublishedEventHandler.handle(postPublishedEvent);

        // Send a text search query to find the new post
        SearchPostByTextQuery searchPostByTextQuery = new SearchPostByTextQuery(/* add fields */);
        Post[] posts = new searchPostByTextQueryHandler(postsIndex).handle(searchPostByTextQuery);

        // assertEquals...

    }

    @Test
    public void shouldSharePost() throws Exception {}   
    
    @Test
    public void shouldMakeUsersFriends() throws Exception {}   

}


