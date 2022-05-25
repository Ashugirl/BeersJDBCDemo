package beerPackage.repositories;

import beerPackage.data.Beers;
import beerPackage.data.Categories;
import jdk.jfr.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesRepository {
    private Connection connection = ConnectionFactory.getConnection();

    public CategoriesRepository() throws SQLException {
    }

    public void createOne(Categories categories) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO Categories(Id, Category VALUES(?, ?);");
        preparedStatement.setInt(1, categories.getId());
        preparedStatement.setString(2, categories.getCategory());
        preparedStatement.executeUpdate();

    }

    public Categories findOneById(int Id) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM Categories WHERE Id =" + Id;
        ResultSet resultSet = statement.executeQuery(query);
        Categories categories = null;
        while(resultSet.next()){
            categories = new Categories(resultSet.getInt("Id"), resultSet.getString("Category"));
        }
        return categories;
    }

    public List<Categories> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM Categories";
        ResultSet resultSet = statement.executeQuery(query);
        List<Categories> categoriesList = new ArrayList<>();
        while(resultSet.next()){
            categoriesList.add(new Categories(resultSet.getInt("Id"), resultSet.getString("Category")));
        }
        return categoriesList;
    }

    public void updateOne(Categories categories, int id) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("UPDATE Categories SET Id=?, Category=? WHERE Id = ?);");
        preparedStatement.setInt(1, categories.getId());
        preparedStatement.setString(2, categories.getCategory());
        preparedStatement.setInt(3, id);
        preparedStatement.executeUpdate();
    }

    public void deleteOne(int id) throws SQLException { //delete method
        Statement statement = connection.createStatement();
        String query = "DELETE FROM Categories WHERE Id=" +id+";";
        statement.executeUpdate(query);
    }

}
