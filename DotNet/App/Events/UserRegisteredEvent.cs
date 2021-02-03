using App.Common;
using App.DTOs;

namespace App.Events
{
    public record UserRegisteredEvent(string UserId, UserDto UserDto) : IEvent;
}