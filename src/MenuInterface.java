import db.ProductsConnector;
import db.VoPrConnector;
import db.VolumeConnector;
import entity.Products;
import entity.Volume;
import inOut.ProductsWrite;
import inOut.VolumeWriter;

import java.sql.SQLException;

import static db.ProductsConnector.getAll;
import static db.VolumeConnector.getAllV;


public class MenuInterface
{
    public static void showMenu(){
            System.out.println("1.Показать информацию о всех товарах");
            System.out.println("2.Добавить товар");
            System.out.println("3.Удалить товар");
            System.out.println("4.Обновить информацию о товаре");
            System.out.println("5.Выход");
            System.out.println("6.Вывод товара по названию:");
            System.out.println("7.Создать файл:");
            System.out.println("8.Загрузить данные из файла:");

    }

    public static void addAction() throws SQLException {
        String productName= CommandReader.readString("Введите название продукта:");
        String producerName= CommandReader.readString("Введите страну производителя:");
        double price = CommandReader.readDoubleNumber("Введите цену:");
        int volumeId=getAll().size()+1;
        Products products=new Products(productName,producerName,price,volumeId );
        ProductsConnector.Add(products);
        int id=getAll().size();
        int productVolume = CommandReader.readNumber("Введите колличество продукта на складе:");
        int sold = CommandReader.readNumber("Введите колличество реализованного продукта:");
        int ordered = CommandReader.readNumber("Введите колличество заказанного продукта:");
        Volume volume =new Volume(id,productVolume,sold,ordered );
        VolumeConnector.AddV(volume);
        System.out.println(VoPrConnector.getByStringV(productName));
    }
    public static void getByStringAction() throws SQLException {
        String productName= CommandReader.readString("Введите название продукта:");
       VoPrConnector.getByStringV(productName);
       System.out.println(VoPrConnector.getByStringV(productName));
    }
    public static void deleteAction() throws SQLException {
        String productName= CommandReader.readString("Введите название продукта для удаления:");
        VolumeConnector.deleteById(ProductsConnector.getIdByString( productName));
        ProductsConnector.deleteByString(productName);
        System.out.println(getAll());
    }
    public static void updateAction() throws SQLException {
        String productName= CommandReader.readString("Введите название продукта для обновления:");
        Products products=ProductsConnector.getByString(productName);
        Volume volume=VolumeConnector.getById(ProductsConnector.getIdByString(productName));
        products.setProducerName(CommandReader.readString("Введите страну производителя:"));
        products.setPrice(CommandReader.readDoubleNumber("Введите цену:"));
        products.setVolumeId(CommandReader.readNumber("Введите ID товара:"));


        volume.setId(CommandReader.readNumber("Введите ID ведомости:"));
        volume.setProductVolume(CommandReader.readNumber("Введите фактический объем товара:"));
        volume.setSold(CommandReader.readNumber("Введите объем проданного товара:"));
        volume.setOrdered(CommandReader.readNumber("Введите объем заказанного товара:"));
        volume.setId(ProductsConnector.getIdByString(productName));
        VolumeConnector.updateV(volume);
        ProductsConnector.update(products);
        System.out.println(VoPrConnector.getAllVP());
    }

    public static void writeAction()throws SQLException{
        ProductsWrite.write(getAll());
        VolumeWriter.write(getAllV());
    }

}
