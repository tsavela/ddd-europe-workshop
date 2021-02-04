using App.Commands;
using App.Domain.PostAggregate;
using App.Domain.UserAggregate;
using App.Events;
using App.Repositories;

namespace App.CommandsHandlers
{
    public class PublishPostCommandHandler
    {
        readonly PostRepository _postRepository;
        readonly UserRepository _userRepository;

        public PublishPostCommandHandler(PostRepository postRepository, UserRepository userRepository)
        {
            _postRepository = postRepository;
            _userRepository = userRepository;
        }

        public PostPublishedEvent Handle(PublishPostCommand publishPostCommand)
        {
            var postId = publishPostCommand.PostId;
            var postDto = publishPostCommand.PostDto;

            var post = new Post(postId, postDto.PublisherId, postDto.Title, postDto.Body, new Age(postDto.MinAge));
            var publisher = _userRepository.Get(postDto.PublisherId);

            publisher.PublishPost(post);

            _postRepository.Set(postId, post);
            _userRepository.Set(postDto.PublisherId, publisher);

            return new PostPublishedEvent(postId, postDto);
        }
    }
}