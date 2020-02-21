package main;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class ListTest {

    @Test
    public void TestList() {
        List<Integer> days = new LinkedList<>();

        days.add(0, 12);
        days.add(0, 19);
        days.set(0, 18);

        System.out.println(days);
    }

    @Test
    public void TestJSON() {
        class Inner {
            List<String> days;

            Inner() {
                days = new LinkedList<>();
            }
        }

        Inner inner = new Inner();
        inner.days.add("202020");

        System.out.println(JSON.toJSONString(inner));
        System.out.println(JSON.toJSONString(inner.days));
    }
}
