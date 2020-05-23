package db;

import entity.VoPr;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoPrUtil {
    public static VoPr toObjectV(ResultSet resultSet)throws SQLException {

        String productName = resultSet.getString("product_name");
        String producerName = resultSet.getString("producer_name");
        double price = resultSet.getDouble("price");
        Date createdAt = resultSet.getDate("created_at");
        Date updatedAt = resultSet.getDate("updated_at");

        int productVolume = resultSet.getInt("product_volume");
        int sold = resultSet.getInt("sold");
        int ordered = resultSet.getInt("ordered");
        Date createdAtV = resultSet.getDate("created_at_v");
        Date updatedAtV = resultSet.getDate("updated_at_v");
        return new VoPr(productName, producerName, price, createdAt,
                updatedAt,  productVolume, sold, ordered, createdAtV,
                updatedAtV);

    }
}
