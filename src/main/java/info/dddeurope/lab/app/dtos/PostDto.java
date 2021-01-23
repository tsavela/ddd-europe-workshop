package info.dddeurope.lab.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostDto {
    String publisherId;
    String title; 
    String body;
    int minAge;
}
