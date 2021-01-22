package info.dddeurope.lab.app.repositories;

import java.util.HashMap;
import java.util.Map;

import info.dddeurope.lab.app.domain.UserAggregate.User;

/*

    Here we use a simple in-meomory key-map value to represent a document-based database.
    In real-world, you would instead use a real database, such as MongoDB.

*/

public class UserRepository {

    Map<String, User> users;
    
    public UserRepository() {
        this.users = new HashMap<>();
    }

    public void set(String userId, User user) {
        this.users.put(userId, user);
    }

    public User get(String userId) {
        return this.users.get(userId);
    }

}
