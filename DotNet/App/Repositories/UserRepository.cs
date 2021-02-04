using System.Collections.Generic;
using App.Domain.UserAggregate;

namespace App.Repositories
{
    /*
        Here we use a simple in-memory key-map value to represent a document-based database.
        In real-world, you would instead use a real database, such as MongoDB.
    */

    public class UserRepository
    {
        readonly Dictionary<string, User> _users;

        public UserRepository()
        {
            _users = new Dictionary<string, User>();
        }

        public void Set(string userId, User user)
        {
            _users[userId] = user;
        }

        public User Get(string userId)
        {
            return _users.TryGetValue(userId, out var value) ? value : null;
        }
    }
}
