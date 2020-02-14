package comm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SomeUtils {

    public static String getNowTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }
}
