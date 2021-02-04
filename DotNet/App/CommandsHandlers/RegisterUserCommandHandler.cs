using App.Commands;
using App.Domain.UserAggregate;
using App.Events;
using App.Repositories;

namespace App.CommandsHandlers
{
    public class RegisterUserCommandHandler
    {
        readonly UserRepository _userRepository;

        public RegisterUserCommandHandler(UserRepository userRepository)
        {
            _userRepository = userRepository;
        }

        public UserRegisteredEvent Handle(RegisterUserCommand registerUserCommand)
        {
            var userId = registerUserCommand.UserId;
            var userDto = registerUserCommand.UserDto;

            var user = new User(userId,
                userDto.FirstName,
                userDto.LastName,
                userDto.Email,
                userDto.DateOfBirth,
                userDto.Address);

            _userRepository.Set(userId, user);
            return new UserRegisteredEvent(userId, userDto);
        }
    }
}