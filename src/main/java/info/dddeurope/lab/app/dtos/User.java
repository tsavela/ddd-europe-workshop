package info.dddeurope.lab.app.dtos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    String firstName;
    String lastName;
    String email;
    Date dateOfBirth;
    String address;
}
