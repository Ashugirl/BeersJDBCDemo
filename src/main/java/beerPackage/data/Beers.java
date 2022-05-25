package beerPackage.data;

public class Beers {

    private int Id;
    private String Name;
    private int BrewerId;
    private int CategoryId;


    public Beers(){

    }

    public Beers(int id, String name, int brewerId, int categoryId) {
        Id = id;
        Name = name;
        BrewerId = brewerId;
        CategoryId = categoryId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getBrewerId() {
        return BrewerId;
    }

    public void setBrewerId(int brewerId) {
        BrewerId = brewerId;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Beers{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", BrewerId=" + BrewerId +
                ", CategoryId=" + CategoryId +
                '}';
    }
}
