package info.dddeurope.lab.app.domain.UserAggregate;

import info.dddeurope.lab.app.dtos.UserDto;

public class User {

    String id;
    Profile profile;
    Wall wall;

    public User(String userId, UserDto userDto) throws Exception {

        this.id = userId;

        this.profile = new Profile(
            userDto.getFirstName(), 
            userDto.getLastName(), 
            userDto.getEmail(), 
            userDto.getDateOfBirth(), 
            userDto.getAddress()
        );

    }

    void publishPost(String postId) {

    }

    void sharePost(String postId) {

        // Validate business rules if there are any.

    }

    void becomeFriendsWith(String userId) {

        // Validate business rules if there are any.

    }



}
