package info.dddeurope.lab.app.domain.UserAggregate;

import java.time.LocalDate;

import info.dddeurope.lab.app.domain.PostAggregate.Post;

public class User {

    String id;
    Profile profile;
    Wall wall;

    public User(String userId, String firstName, String lastName, String email, LocalDate dateOfBirth, String address) throws Exception {

        this.id = userId;

        this.profile = new Profile(
            firstName,
            lastName,
            email,
            dateOfBirth,
            address
        );

    }

    public void publishPost(Post post) throws Exception {

        if (!post.getAgeLimit().isUnder(this.profile.getAge())) {
            throw new Exception("The user is not allowed to publish this post due to age limitations");
        }
    }

    void sharePost(String postId) {

        // Validate business rules if there are any.

    }

    void becomeFriendsWith(String userId) {

        // Validate business rules if there are any.

    }



}
