package info.dddeurope.lab.app.domain.UserAggregate;

import java.time.LocalDate;
import java.time.Period;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Profile {

    String firstName;
    String lastName;
    String email;
    LocalDate dateOfBirth;
    String address;

    public Profile(String firstName, String lastName, String email, LocalDate dateOfBirth, String address)
            throws Exception {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        if (getAge(dateOfBirth) < 12) {
            throw new Exception("User must be at least 12 years old");
        }

        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }    
    
    private int getAge(LocalDate dateOfBirth) {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
     
}
