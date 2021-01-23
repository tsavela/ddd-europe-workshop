package info.dddeurope.lab.app.commandsHandlers;

import info.dddeurope.lab.app.commands.RegisterUserCommand;
import info.dddeurope.lab.app.domain.UserAggregate.User;
import info.dddeurope.lab.app.dtos.UserDto;
import info.dddeurope.lab.app.events.UserRegisteredEvent;
import info.dddeurope.lab.app.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterUserCommandHandler {

    UserRepository userRepository;

    public UserRegisteredEvent handle(RegisterUserCommand registerUserCommand) throws Exception {
        
        final String userId = registerUserCommand.getUserId();
        final UserDto userDto = registerUserCommand.getUserDto();

        User user = new User(userId,
            userDto.getFirstName(),
            userDto.getLastName(),
            userDto.getEmail(),
            userDto.getDateOfBirth(),
            userDto.getAddress());

        this.userRepository.set(userId, user);
        return new UserRegisteredEvent(userId, userDto); 
        
    }   

}