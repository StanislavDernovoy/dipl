package db;

import entity.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsConnector {
    private static final String SELECT_ALL="SELECT*FROM products";
    private static final String SELECT_ALL_BY_STRING="SELECT*FROM products WHERE product_name LIKE ? ";
    private static final String SELECT_ID_BY_STRING="SELECT p.volume_id FROM products p WHERE p.product_name  LIKE ?";
    private static final String DELETE="DELETE FROM products WHERE product_name LIKE ? ";
    private static final String ADD="INSERT INTO products(product_name,producer_name,price,volume_id) VALUES(?,?,?,?)";
    private static final String UPDATE="UPDATE products SET producer_name=?,price=?,updated_at=?,volume_id=? WHERE product_name LIKE ?";


    public static List<Products>getAll(){
        List<Products> result=new ArrayList<>();
        Connection connection=DbConnector.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){

                String productName=resultSet.getString("product_name");
                String producerName=resultSet.getString("producer_name");
                double price=resultSet.getDouble("price");
                Date createdAt=resultSet.getDate("created_at");
                Date updatedAt=resultSet.getDate("updated_at");
                int volumeId=resultSet.getInt("volume_id");
                Products products=new Products(productName,producerName,price,createdAt,updatedAt,volumeId);
                result.add(products);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
    public static void Add(Products products) {
        List<Products> result = new ArrayList<>();
        Connection connection = DbConnector.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(ADD);
            String productName = products.getProductName();
            String producerName = products.getProducerName();
            double price = products.getPrice();
            int volumeId = products.getVolumeId();
            statement.setString(1, productName);
            statement.setString(2, producerName);
            statement.setDouble(3, price);
            statement.setInt(4, volumeId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public static void update(Products products) {
        Connection connection = DbConnector.getConnection();


        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {


            statement.setString(1, products.getProducerName());
            statement.setDouble(2, products.getPrice());
            statement.setDate(3,new Date(CurrentDateUtil.currentUnixTimestamp()));
            statement.setInt(4,products.getVolumeId());
            statement.setString(5,products.getProductName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Products getByString(String productName)throws SQLException {
        Connection connection=DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BY_STRING)

        ){
            statement.setString(1,productName);
            ResultSet resultSet=statement.executeQuery();
            resultSet.next();
            Products products=ProductsUtil.toObject(resultSet);
            resultSet.close();
            return products;
        }

    }
    public static void deleteByString(String productName)throws SQLException {
        Connection connection=DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE)
        ){
            statement.setString(1,productName);
            statement.executeUpdate();
        }

    }

    public static int getIdByString(String productName)throws SQLException {
        Connection connection=DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ID_BY_STRING)

        ){
            statement.setString(1,productName);
            ResultSet resultSet=statement.executeQuery();
            resultSet.next();
            int volumeId=resultSet.getInt("volume_id");

            resultSet.close();
            int d=volumeId;
            return  d;

        }

    }



}

