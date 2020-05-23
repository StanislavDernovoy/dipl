package inOut;

import db.VolumeConnector;
import entity.Volume;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class VolumeReader {
    public static List<Volume> read(){
        List<Volume> result=new ArrayList<>();
        try (BufferedReader reader=new BufferedReader(new FileReader(IoConstant.FILENAME_FOR_V))){
            reader.readLine();
            String scvString;
            while ((scvString=reader.readLine())!=null){
                Volume volume=toObjectV(scvString);
                result.add(volume);
                VolumeConnector.AddV(volume);
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
    private static Volume toObjectV(String scvString) throws ParseException {
        String[] fields=scvString.split(IoConstant.DELIMITER);
        int id=Integer.parseInt(fields[0]);
        int productVolume=Integer.parseInt(fields[1]);
        int sold=Integer.parseInt(fields[2]);
        int ordered =Integer.parseInt(fields[3]);
        Date createdAt=null;
        try{
            createdAt =Date.valueOf(fields[4]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Date updatedAt=null;
        try{
            updatedAt =Date.valueOf(fields[5]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Volume(id,productVolume,sold,ordered,createdAt,updatedAt);
    }}
