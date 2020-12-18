package info.dddeurope.lab.app.repositories;

import java.util.HashMap;
import java.util.Map;

import info.dddeurope.lab.app.domain.PostAggregate.Post;

/*

    Here we use a simple in-meomory key-map value to represent a document-based database.
    In real-world, you would instead use a real database, such as MongoDB.

*/

public class PostRepository {

    Map<String, Post> posts;
    
    public PostRepository() {
        this.posts = new HashMap<>();
    }

    void set(String postId, Post post) {
        this.posts.put(postId, post);
    }

    Post get(String postId) {
        return this.posts.get(postId);
    }

}

