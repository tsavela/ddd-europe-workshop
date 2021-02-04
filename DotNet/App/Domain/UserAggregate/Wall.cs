using System.Collections.Generic;
using App.Domain.PostAggregate;

namespace App.Domain.UserAggregate
{
    public class Wall
    {
        private readonly List<Post> _posts;

        public Post[] Posts => _posts.ToArray();

        public Wall()
        {
            _posts = new List<Post>();
        }

        public void Push(Post post)
        {
            _posts.Add(post);
        }
    }
}