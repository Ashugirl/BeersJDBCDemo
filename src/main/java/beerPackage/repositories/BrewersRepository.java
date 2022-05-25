package beerPackage.repositories;

import beerPackage.data.Beers;
import beerPackage.data.Brewers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrewersRepository {
    private Connection connection = ConnectionFactory.getConnection();

    public BrewersRepository() throws SQLException {
    }

    public void createOne(Brewers brewers) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO Brewers(Id, Name) VALUES(?, ?);");
        preparedStatement.setInt(1, brewers.getId());
        preparedStatement.setString(2, brewers.getName());
        preparedStatement.executeUpdate();

    }

    public Brewers findOneById(int Id) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM Brewers WHERE Id =" + Id;
        ResultSet resultSet = statement.executeQuery(query);
        Brewers brewers = null;
        while(resultSet.next()){
            brewers = new Brewers(resultSet.getInt("Id"), resultSet.getString("Name"));
        }
        return brewers;
    }

    public List<Brewers> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM Brewers";
        ResultSet resultSet = statement.executeQuery(query);
        List<Brewers> brewersList = new ArrayList<>();
        while(resultSet.next()){
            brewersList.add(new Brewers(resultSet.getInt("Id"), resultSet.getString("Name")));
        }
        return brewersList;
    }

    public void updateOne(Brewers brewers, int id) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("UPDATE Brewers SET Id=?, Name=? WHERE Id = ?);");
        preparedStatement.setInt(1, brewers.getId());
        preparedStatement.setString(2, brewers.getName());
        preparedStatement.setInt(3, id);
        preparedStatement.executeUpdate();
    }

    public void deleteOne(int id) throws SQLException { //delete method
        Statement statement = connection.createStatement();
        String query = "DELETE FROM Brewers WHERE Id=" +id+";";
        statement.executeUpdate(query);
    }

}
