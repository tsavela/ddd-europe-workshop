using App.Commands;
using App.CommandsHandlers;
using App.DTOs;
using App.EventHandlers;
using App.Queries;
using App.QueryHandlers;
using App.Repositories;
using App.Views;
using FluentAssertions;
using NodaTime;
using Xunit;

namespace App.Tests
{
    public class ApplicationUnitTest
    {
        // Write Model repositories
        private readonly UserRepository _userRepository;
        private readonly PostRepository _postRepository;

        // Read Model datastores (denormalized views)
        private readonly SocialGraph _socialGraph;
        private readonly PostsIndex _postsIndex;
        private readonly SharingMap _sharingMap;

        public ApplicationUnitTest()
        {
            _userRepository = new UserRepository();
            _postRepository = new PostRepository();

            _socialGraph = new SocialGraph();
            _postsIndex = new PostsIndex();
            _sharingMap = new SharingMap();

            // Create a command
            var registerUserCommand = new RegisterUserCommand("enatan",
                new UserDto(
                    "Eliran",
                    "Natan",
                    "eliran.natan.87@gmail.com",
                    new LocalDate(1987, 8, 10),
                    "Loenen aan de Vecht")
            );

            // Send the command to the corresponding command handler
            var registerUserCommandHandler = new RegisterUserCommandHandler(_userRepository);
            var userRegisteredEvent = registerUserCommandHandler.Handle(registerUserCommand);

            // Send the event to the corresponding event handler
            var userRegisteredEventHandler = new UserRegisteredEventHandler(_socialGraph);
            userRegisteredEventHandler.Handle(userRegisteredEvent);
        }

        [Fact]
        public void ShouldPublishPost()
        {
            // Create a command
            var publishPostCommand = new PublishPostCommand("6174897",
                new PostDto("enatan", "Event Sourcing with Java", "This is a post about event sourcing", 8));

            // Send the command to the corresponding command handler
            var publishPostCommandHandler = new PublishPostCommandHandler(_postRepository, _userRepository);
            var postPublishedEvent = publishPostCommandHandler.Handle(publishPostCommand);

            // Send the event to the corresponding event handler
            var postPublishedEventHandler = new PostPublishedEventHandler(_postsIndex);
            postPublishedEventHandler.Handle(postPublishedEvent);

            // Send a text search query to find the new post
            var searchPostByTextQuery = new SearchPostByTextQuery("event");
            var searchPostByTextQueryHandler = new SearchPostByTextQueryHandler(_postsIndex);
            var posts = searchPostByTextQueryHandler.Handle(searchPostByTextQuery);

            posts[0].Get("id").Should().Be("6174897");
            posts[0].Get("publisherId").Should().Be("enatan");
        }

        [Fact]
        public void ShouldSharePost()
        {
        }

        [Fact]
        public void ShouldMakeUsersFriends()
        {
        }
    }
}