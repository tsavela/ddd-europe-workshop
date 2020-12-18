package info.dddeurope.lab.app.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UsersBecameFriendsEvent {
    private String userA;
    private String userB;    
}
