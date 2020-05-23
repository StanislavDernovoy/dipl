package db;

import entity.Volume;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VolumeUtil {
    public static Volume toObject(ResultSet resultSet)throws SQLException {
        int id=resultSet.getInt("id");
        int productVolume=resultSet.getInt("product_volume");
        int sold=resultSet.getInt("sold");
        int ordered=resultSet.getInt("ordered");
        Date createdAt=resultSet.getDate("created_at_v");
        Date updatedAt=resultSet.getDate("updated_at_v");

        return new Volume(id,productVolume,sold,ordered,createdAt,updatedAt);

    }
}
