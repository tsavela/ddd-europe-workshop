using System;
using NodaTime;

namespace App.Domain.UserAggregate
{
    public class Profile
    {
        public string FirstName { get; }
        public string LastName { get; }
        public string Email { get; }
        public LocalDate DateOfBirth { get; }
        public string Address { get; }

        public Profile(string firstName, string lastName, string email, LocalDate dateOfBirth, string address)
        {
            FirstName = firstName;
            LastName = lastName;
            Email = email;

            if (ComputeAge(dateOfBirth) < 12)
            {
                throw new Exception("User must be at least 12 years old");
            }

            DateOfBirth = dateOfBirth;
            Address = address;
        }

        public Age GetAge()
        {
            return new Age(ComputeAge(this.DateOfBirth));
        }

        private int ComputeAge(LocalDate dateOfBirth)
        {
            return Period.Between(dateOfBirth, LocalDate.FromDateTime(DateTime.Now)).Years;
        }
    }
}