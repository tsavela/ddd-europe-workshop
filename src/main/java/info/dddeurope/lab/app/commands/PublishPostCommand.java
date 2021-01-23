package info.dddeurope.lab.app.commands;

import info.dddeurope.lab.app.dtos.PostDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PublishPostCommand {
    String postId;
    PostDto postDto;    
}
