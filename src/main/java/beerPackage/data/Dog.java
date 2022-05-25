package beerPackage.data;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString

@Entity
public class Dog {

    @Id
    private @Getter @Setter int id;
    @NonNull
    private @Getter @Setter String name;
    private @Getter @Setter
    @OneToOne
    Owner ownerThatOwnsDog;
}
