import entity.VoPr;
import inOut.ProductReader;
import inOut.VolumeReader;

import java.sql.SQLException;
import java.util.List;

import static db.VoPrConnector.getAllVP;

public class Main {
    public static void main(String[] args) throws SQLException {

        boolean continueLoop = true;
        while (continueLoop) {
            MenuInterface.showMenu();
                int command = CommandReader.readNumber("Введите команду: ");
                switch (command) {
                    case 1:
                        List<VoPr> result = getAllVP();
                        for (VoPr voPr: result) {
                            System.out.println(voPr);
                        }
                        break;
                    case 2:
                        MenuInterface.addAction();
                        break;
                    case 3:
                        MenuInterface.deleteAction();
                        break;
                    case 4:
                       MenuInterface.updateAction();
                       break;
                    case 5:
                        continueLoop=false;
                        break;
                    case 6:
                            MenuInterface.getByStringAction();
                        break;
                    case 7:
                       MenuInterface.writeAction();
                       break;
                    case 8:
                        ProductReader.read();
                        VolumeReader.read();
                        break;

                    default:
                        System.out.println("Введенная команда не существует или не реализована");
                }
        }
        System.out.println("Программа завершена");
    }
}