package inOut;

import db.ProductsConnector;
import entity.Products;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ProductReader {

    public static  List<Products> read(){
        List<Products> result=new ArrayList<>();
        try (BufferedReader reader=new BufferedReader(new FileReader(IoConstant.FILENAME))){
            reader.readLine();
            String scvString;
            while ((scvString=reader.readLine())!=null){
             Products products=toObject(scvString);
             result.add(products);
             ProductsConnector.Add(products);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;

    }
    private static Products toObject(String scvString) throws ParseException {
        String[] fields=scvString.split(IoConstant.DELIMITER);
        String productName=fields[0];
        String producerName=fields[1];
        double price=Double.parseDouble(fields[2]);
        Date createdAt =Date.valueOf(fields[3]);
        Date updatedAt=null;
        try{
            updatedAt =Date.valueOf(fields[4]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int volumeId=Integer.parseInt(fields[5]);
        return new Products(productName,producerName,price,createdAt,updatedAt,volumeId);
    }


}
