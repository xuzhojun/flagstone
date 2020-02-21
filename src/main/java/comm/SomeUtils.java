package comm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SomeUtils {

    public static String getNowTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    /**
     * 获取list中存放的最后一个元素
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T getLastElement(List<T> list) {
        return list.size() == 0 ? null : list.get(list.size() - 1);
    }

    public static String getDate(String dateTime) {
        return dateTime.split(" ")[0];
    }

}
