package info.dddeurope.lab.app.domain.UserAggregate;

import java.util.ArrayList;

import info.dddeurope.lab.app.domain.PostAggregate.Post;

public class Wall {

    ArrayList<Post> posts;

    public Wall() {
        this.posts = new ArrayList<Post>();
    }

    public void push(Post post) {
        this.posts.add(post);
    }
    
}
