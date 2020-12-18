package info.dddeurope.lab.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
    String id;
    String publisherId;
    String title; 
    String body;
}
