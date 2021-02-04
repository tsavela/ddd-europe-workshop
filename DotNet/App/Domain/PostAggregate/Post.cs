using App.Domain.UserAggregate;

namespace App.Domain.PostAggregate
{
    public class Post
    {
        public string Id { get; }
        public string PublisherId { get; }
        public string PostTitle { get; }
        public string PostBody { get; }
        public Age AgeLimit { get; }

        public Post(string id, string publisherId, string postTitle, string postBody, Age ageLimit)
        {
            Id = id;
            PublisherId = publisherId;
            PostTitle = postTitle;
            PostBody = postBody;
            AgeLimit = ageLimit;
        }
    }
}