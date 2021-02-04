using NodaTime;

namespace App.DTOs
{
    public record UserDto(string FirstName, string LastName, string Email, LocalDate DateOfBirth, string Address);
}
