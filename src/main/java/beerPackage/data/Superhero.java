package beerPackage.data;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="hero_sequence", initialValue=1, allocationSize=100)
public class Superhero {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="hero_sequence")
    private int id;
    private String name;
    private String superPower;
    @OneToOne
    private SuperVillain archnemesis;

    public SuperVillain getArchnemesis() {
        return archnemesis;
    }

    public void setArchnemesis(SuperVillain archnemesis) {
        this.archnemesis = archnemesis;
    }

    public Superhero() {
    }

    public Superhero(String name, String superPower) {
        this.name = name;
        this.superPower = superPower;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", superPower='" + superPower + '\'' +
                '}';
    }
}
