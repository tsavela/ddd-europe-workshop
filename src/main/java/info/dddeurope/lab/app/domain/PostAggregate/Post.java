package info.dddeurope.lab.app.domain.PostAggregate;

import info.dddeurope.lab.app.domain.UserAggregate.Age;
import lombok.Data;

@Data
public class Post {

    String id;
    String publisherId;
    String title; 
    String body;
    Age ageLimit;

    public Post(String id, String publisherId, String postTitle, String postBody, Age ageLimit) {
        this.id = id;
        this.publisherId = publisherId;
        this.title = postTitle;
        this.body = postBody;
        this.ageLimit = ageLimit;
    }

}
