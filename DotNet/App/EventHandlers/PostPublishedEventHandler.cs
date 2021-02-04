using App.Events;
using App.Views;

namespace App.EventHandlers
{
    public class PostPublishedEventHandler
    {
        readonly PostsIndex _index;

        public PostPublishedEventHandler(PostsIndex index)
        {
            _index = index;
        }

        public void Handle(PostPublishedEvent evt)
        {
            var postDto = evt.PostDto;
            _index.IndexPost(evt.PostId, postDto.Title, postDto.Body, postDto.PublisherId);
        }
    }
}