package beerPackage.data;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
@Entity
public class Dog {

    @Id
    @GeneratedValue
    private @Getter @Setter int id;
    @NonNull
    private @Getter @Setter String name;
    @NonNull
    @ManyToOne(cascade = CascadeType.REMOVE)
    private @Getter @Setter Owner ownerThatOwnsDog;
}
