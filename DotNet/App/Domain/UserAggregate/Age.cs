namespace App.Domain.UserAggregate
{
    public class Age
    {
        public int AgeInYears { get; }

        public Age(int ageInYears)
        {
            AgeInYears = ageInYears;
        }

        public bool IsUnder(Age age)
        {
            return this.AgeInYears < age.AgeInYears;
        }
    }
}