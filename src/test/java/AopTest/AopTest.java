package AopTest;


import com.kuang.AOP.aop_xml.TargetInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AopTest {
    @Autowired
    private TargetInterface targetInterface;

    @Test
    public void test1(){
        targetInterface.save();
    }
}
