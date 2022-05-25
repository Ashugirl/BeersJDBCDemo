package beerPackage.data;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

@Entity
public class Owner {

    @Id
    @GeneratedValue
    private @Getter @Setter int id;
    private @Getter @Setter String name;
    @OneToOne(mappedBy = "ownerThatOwnsDog")
    private @Getter @Setter Dog dog;

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
