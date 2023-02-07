package AopTest;

import com.kuang.AOP.AopAnno.TargetInterface1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-anno.xml")
public class AopAnnoTest {

    @Autowired
    private TargetInterface1 interface1;

    @Test
    public void test1(){
        interface1.save();
    }
}


