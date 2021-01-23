package info.dddeurope.lab.app.domain.UserAggregate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Age {
    int age;
    
    boolean isUnder(Age age) {
        return this.getAge() < age.getAge();
    }
}
