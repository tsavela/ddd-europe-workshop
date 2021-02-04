using System.Collections.Generic;
using App.Domain.PostAggregate;

namespace App.Repositories
{
    /*
        Here we use a simple in-memory key-map value to represent a document-based database.
        In real-world, you would instead use a real database, such as MongoDB.
    */

    public class PostRepository
    {
        readonly Dictionary<string, Post> _posts;

        public PostRepository()
        {
            _posts = new Dictionary<string, Post>();
        }

        public void Set(string postId, Post post)
        {
            _posts[postId] = post;
        }

        Post Get(string postId)
        {
            return _posts.TryGetValue(postId, out var value) ? value : null;
        }
    }
}