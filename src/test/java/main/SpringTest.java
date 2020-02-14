package main;

import dao.FunctionMapper;
import entity.Function;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {

    @Autowired
    ApplicationContext ioc;

    @Autowired
    FunctionMapper functionMapper;

    @Test
    public void functionMapperTest() {
        Function f = functionMapper.searchByID(3);
        System.out.println(f);
    }

    @Test
    public void testHelloService() {
        boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }

}
