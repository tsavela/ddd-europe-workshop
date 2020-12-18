package info.dddeurope.lab.app.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BecomeFriendOfUserCommand {
    private String sourceUserId;
    private String targetUserId;
}
