package db;

import entity.Products;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductsUtil {




    public static Products toObject(ResultSet resultSet)throws SQLException {

        String productName=resultSet.getString("product_name");
        String producerName=resultSet.getString("producer_name");
        double price=resultSet.getDouble("price");
        Date createdAt=resultSet.getDate("created_at");
        Date updatedAt=resultSet.getDate("updated_at");
        int volumeId=resultSet.getInt("volume_id");
        return new Products(productName,producerName,price,createdAt,updatedAt,volumeId);

    }
}
