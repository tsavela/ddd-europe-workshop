using App.Common;
using App.DTOs;

namespace App.Commands
{
    public record RegisterUserCommand(string UserId, UserDto UserDto) : ICommand;
}