package inOut;

import entity.Products;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProductsWrite {
    private static final String[] headers={"Название товара","Производиткль","Цена","Создано","Оновлено","ID"};

    private static String renderHeaders(){
        return String.join(IoConstant.DELIMITER,headers)+"\n";
    }
    private static String toCsvString(Products products){
        return products.getProductName()+IoConstant.DELIMITER+
               products.getProducerName()+IoConstant.DELIMITER+
               products.getPrice()+IoConstant.DELIMITER+
               products.getCreatedAt()+IoConstant.DELIMITER+
               products.getUpdatedAt()+IoConstant.DELIMITER+
               products.getVolumeId()+"\n";
    }

    public static void write(List<Products> products){
        String headersString=renderHeaders();
        try (FileWriter writer=new FileWriter(IoConstant.FILENAME))
        {writer.write(headersString);
            for(Products products1:products){
                String productsScv=toCsvString(products1);
                writer.write(productsScv);
            }
            System.out.println("Документ успешно создан");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
