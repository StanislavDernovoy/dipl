package db;

import java.util.Date;

public class CurrentDateUtil {
    public static long currentUnixTimestamp(){
        Date now=new Date();
        return now.getTime();
    }
}
