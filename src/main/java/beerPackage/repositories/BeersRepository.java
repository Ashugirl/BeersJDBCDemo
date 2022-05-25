package beerPackage.repositories;

import beerPackage.data.Beers;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BeersRepository {


    private Connection connection = ConnectionFactory.getConnection();

    public BeersRepository() throws SQLException {
    }

    public void createOne(Beers beers) throws SQLException { //create method
        /*Statement statement = connection.createStatement();
        String query = "INSERT INTO Beers(Id, Name, BrewerId, CategoryId) VALUES ("
                +beers.getId()+ ", '" + beers.getName() + "', " + beers.getBrewerId()+ " , " + beers.getCategoryId();
        statement.executeUpdate(query);

         */
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO Beers(Id, Name, BrewerId, CategoryId) VALUES(?, ?, ?, ?);");
        preparedStatement.setInt(1, beers.getId());
        preparedStatement.setString(2, beers.getName());
        preparedStatement.setInt(3, beers.getBrewerId());
        preparedStatement.setInt(4, beers.getCategoryId());
        preparedStatement.executeUpdate();

    }

    public Beers findOneById(int Id) throws SQLException { //read one method
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM Beers WHERE Id =" + Id;
        ResultSet resultSet = statement.executeQuery(query);
        Beers beers = null;
        while(resultSet.next()){
            beers = new Beers(resultSet.getInt("Id"), resultSet.getString("Name"), resultSet.getInt("BrewerId"), resultSet.getInt("CategoryId"));
        }
        return beers;
    }

    public List<Beers> findAll() throws SQLException { //read all method
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM Beers";
        ResultSet resultSet = statement.executeQuery(query);
        List<Beers> beersList = new ArrayList<>();
        while(resultSet.next()){
            beersList.add(new Beers(resultSet.getInt("Id"), resultSet.getString("Name"), resultSet.getInt("BrewerId"), resultSet.getInt("CategoryId")));
        }
        return beersList;
    }

    public void updateOne(Beers beers, int id) throws SQLException { // update method
        PreparedStatement preparedStatement =
                connection.prepareStatement("UPDATE Beers SET Id=?, Name=?, BrewerId=?, CategoryID =? WHERE Id = ?);");
        preparedStatement.setInt(1, beers.getId());
        preparedStatement.setString(2, beers.getName());
        preparedStatement.setInt(3, beers.getBrewerId());
        preparedStatement.setInt(4, beers.getCategoryId());
        preparedStatement.setInt(5, id);
        preparedStatement.executeUpdate();
    }

    public void deleteOne(int id) throws SQLException { //delete method
        Statement statement = connection.createStatement();
        String query = "DELETE FROM Beers WHERE Id=" +id+";";
        statement.executeUpdate(query);
    }

}
