package db;

import entity.VoPr;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoPrConnector {
    private static final String SELECT_ALL_VP = "SELECT * FROM products p LEFT JOIN volume v ON p.volume_id = v.id";
    private static final String SELECT_BY_STRING="SELECT p.product_name, p.producer_name, p.price ,p.created_at,p.updated_at,\n" +
            "v.product_volume,v.sold,v.ordered,v.created_at_v,v.updated_at_v  \n" +
            "FROM products p  INNER JOIN volume v  ON p.volume_id = v.id where p.product_name LIKE ?";
    public static List<VoPr> getAllVP() {
        List<VoPr> result = new ArrayList<>();
        Connection connection = DbConnector.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_VP);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                String productName = resultSet.getString("product_name");
                String producerName = resultSet.getString("producer_name");
                double price = resultSet.getDouble("price");
                Date createdAt = resultSet.getDate("created_at");
                Date updatedAt = resultSet.getDate("updated_at");
                int volumeId = resultSet.getInt("volume_id");
                int id = resultSet.getInt("id");
                int productVolume = resultSet.getInt("product_volume");
                int sold = resultSet.getInt("sold");
                int ordered = resultSet.getInt("ordered");
                Date createdAtV = resultSet.getDate("created_at_v");
                Date updatedAtV = resultSet.getDate("updated_at_v");
                VoPr voPr = new VoPr(productName, producerName, price, createdAt,
                        updatedAt, volumeId, id, productVolume, sold, ordered, createdAtV,
                        updatedAtV);
                result.add(voPr);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
    public static VoPr getByStringV(String productName)throws SQLException {
        Connection connection=DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_STRING)

        ){
            statement.setString(1,productName);
            ResultSet resultSet=statement.executeQuery();
            resultSet.next();
            VoPr vopr=VoPrUtil.toObjectV(resultSet);
            resultSet.close();
            return vopr;
        }

    }
}