package info.dddeurope.lab.app.events;

import info.dddeurope.lab.app.common.Event;
import info.dddeurope.lab.app.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserRegisteredEvent extends Event {
    private String userId;
    private UserDto userDto;
}