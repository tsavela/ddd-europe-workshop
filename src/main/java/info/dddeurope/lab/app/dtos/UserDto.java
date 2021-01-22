package info.dddeurope.lab.app.dtos;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    String firstName;
    String lastName;
    String email;
    LocalDate dateOfBirth;
    String address;
}
