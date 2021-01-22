package info.dddeurope.lab.app.commands;

import info.dddeurope.lab.app.common.Command;
import info.dddeurope.lab.app.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RegisterUserCommand extends Command {
    private String userId;
    private UserDto userDto;

}