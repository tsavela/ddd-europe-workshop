using System;
using App.Domain.PostAggregate;
using NodaTime;

namespace App.Domain.UserAggregate
{
    public class User
    {
        public string UserId { get; }
        public Profile Profile { get; }

        public User(string userId, string firstName, string lastName, string email, LocalDate dateOfBirth, string address)
        {
            UserId = userId;

            Profile = new Profile(
                firstName,
                lastName,
                email,
                dateOfBirth,
                address
            );
        }

        public void PublishPost(Post post)
        {

            if (!post.AgeLimit.IsUnder(Profile.GetAge()))
            {
                throw new Exception("The user is not allowed to publish this post due to age limitations");
            }
        }

        void SharePost(string postId)
        {
            // Validate business rules if there are any.
        }

        void BecomeFriendsWith(string userId)
        {
            // Validate business rules if there are any.
        }
    }
}
