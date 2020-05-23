package db;

import entity.Volume;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VolumeConnector {
    private static final String SELECT_ALL_V="SELECT*FROM volume";
    private static final String SELECT_BY_ID="SELECT * FROM volume WHERE id = ? ";
    private static final String DELETE_BY_ID="DELETE FROM volume  WHERE id =  ? ";
    private static final String ADD_V="INSERT INTO volume(id,product_volume,sold,ordered) VALUES(?,?,?,?)";
    private static final String UPDATE="UPDATE volume SET id=?, product_volume=?,sold=?,ordered=?,updated_at_v=? WHERE id = ?";
    public static void AddV(Volume volume) {
        List<Volume> result = new ArrayList<>();
        Connection connection = DbConnector.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(ADD_V);
            int id = volume.getId();
            int productVolume = volume.getProductVolume();
            int sold = volume.getSold();
            int ordered = volume.getOrdered();
            statement.setInt(1, id);
            statement.setInt(2, productVolume);
            statement.setInt(3, sold);
            statement.setInt(4, ordered);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static List<Volume> getAllV(){
        List<Volume> result1=new ArrayList<>();
        Connection connection=DbConnector.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_V);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){


                int id=resultSet.getInt("id");
                int productVolume=resultSet.getInt("product_volume");
                int sold=resultSet.getInt("sold");
                int ordered=resultSet.getInt("ordered");
                Date createdAt=resultSet.getDate("created_at_v");
                Date updatedAt=resultSet.getDate("updated_at_v");
                Volume volume=new Volume(id,productVolume,sold,ordered,createdAt,updatedAt);
                result1.add(volume);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result1;

    }
    public static void deleteById(int id)throws SQLException {
        Connection connection=DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)
        ){
            statement.setInt(1,id);
            statement.executeUpdate();
        }

    }
    public static void updateV(Volume volume) {
        Connection connection = DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setInt(1,volume.getId());
            statement.setInt(2,volume.getProductVolume());
            statement.setInt(3,volume.getSold());
            statement.setInt(4,volume.getOrdered());
            statement.setDate(5,new Date(CurrentDateUtil.currentUnixTimestamp()));
            statement.setInt(6,volume.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Volume getById(int id)throws SQLException {
        Connection connection = DbConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)

        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Volume volume = VolumeUtil.toObject(resultSet);
            resultSet.close();
            return volume;
        }
    }
}
