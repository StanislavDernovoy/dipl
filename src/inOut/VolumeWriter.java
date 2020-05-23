package inOut;

import entity.Volume;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class VolumeWriter {
    private static final String[] headers={"ID","Товар в наличии","Проданый товар","Всего заказано","Создано","Обновлено"};

    private static String renderHeaders(){
        return String.join(IoConstant.DELIMITER,headers)+"\n";
    }
    private static String toCsvString(Volume volume){
        return volume.getId()+IoConstant.DELIMITER+
                volume.getProductVolume()+IoConstant.DELIMITER+
                volume.getSold()+IoConstant.DELIMITER+
                volume.getOrdered()+IoConstant.DELIMITER+
                volume.getCreatedAt()+IoConstant.DELIMITER+
               volume.getUpdatedAt()+"\n";
    }

    public static void write(List<Volume> volume){
        String headersString=renderHeaders();
        try (FileWriter writer=new FileWriter(IoConstant.FILENAME_FOR_V))
        {writer.write(headersString);
            for(Volume volume1:volume){
                String volumeScv=toCsvString(volume1);
                writer.write(volumeScv);
            }
            System.out.println("Документ успешно создан");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
