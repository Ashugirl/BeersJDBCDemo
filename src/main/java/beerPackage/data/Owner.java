package beerPackage.data;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

@RequiredArgsConstructor
@Entity
public class Owner {

    @Id
    @GeneratedValue
    private @Getter @Setter int id;
    @NonNull
    private @Getter @Setter String name;
    @OneToMany(mappedBy = "ownerThatOwnsDog")
    private @Getter @Setter List<Dog> dogs;

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
